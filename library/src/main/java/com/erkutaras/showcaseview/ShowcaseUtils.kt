package com.erkutaras.showcaseview

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.graphics.Rect
import android.util.Log
import android.util.TypedValue
import android.webkit.ValueCallback
import android.webkit.WebView
import com.google.gson.Gson
import com.google.gson.GsonBuilder

/**
 * Created by erkutaras on 25.02.2018.
 */

class ShowcaseUtils {

    companion object {

        @JvmStatic
        fun convertDpToPx(dp: Float): Float {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().displayMetrics)
        }

        @JvmStatic
        fun isNonNull(o: Any?): Boolean {
            return o != null
        }

        @JvmStatic
        fun isNull(o: Any?): Boolean {
            return o == null
        }

        @JvmStatic
        fun isNotZero(f: Float): Boolean {
            return f != 0f
        }

        @JvmStatic
        fun getWebJQueryRects(webView: WebView, queries: List<String>, callback: (rects: List<Rect>) -> Unit) {
            var serializedQueries = Gson().toJson(queries);
            var js: String = "(function(){" +
                    "var results = [];" +
                    "for (var query of $serializedQueries) {" +
                    "console.log(\$(query));" +
                    "results.push(\$(query)[0].getBoundingClientRect());" +
                    "}" +
                    "console.log(JSON.stringify({'rects':results}));" +
                    "return JSON.stringify({'rects':results});" +
                    "})()";
            getWebRects(webView,js,callback)
        }

        @JvmStatic
        fun getWebIDRects(webView: WebView, queries: List<String>, callback: (rects: List<Rect>) -> Unit) {
            var serializedQueries = Gson().toJson(queries);
            var js: String = "(function(){" +
                    "var results = [];" +
                    "for (var query of $serializedQueries) {" +
                    "console.log(query);" +
                    "results.push(document.getElementById(query).getBoundingClientRect());" +
                    "}" +
                    "console.log(JSON.stringify({'rects':results}));" +
                    "return JSON.stringify({'rects':results});" +
                    "})()";
            getWebRects(webView,js,callback)
        }

        @JvmStatic
        fun getWebTagRects(webView: WebView, queries: List<String>, callback: (rects: List<Rect>) -> Unit) {
            var serializedQueries = Gson().toJson(queries);
            var js: String = "(function(){\n" +
                    "var results = [];\n" +
                    "for (var query of $serializedQueries) {\n" +
                    "console.log(query);\n" +
                    "var divs = document.getElementsByTagName(query);\n" +
                    "console.log(divs);\n" +
                    "for (var div of divs)\n" +
                    "results.push(div.getBoundingClientRect());\n" +
                    "}\n" +
                    "console.log(JSON.stringify({'rects':results}));\n" +
                    "return JSON.stringify({'rects':results});\n" +
                    "})()\n";
            getWebRects(webView,js,callback)
        }

        @JvmStatic
        fun getWebClassRects(webView: WebView, queries: List<String>, callback: (rects: List<Rect>) -> Unit) {
            var serializedQueries = Gson().toJson(queries);
            var js: String = "(function(){\n" +
                    "var results = [];\n" +
                    "for (var query of $serializedQueries) {\n" +
                    "console.log(query);\n" +
                    "var divs = document.getElementsByClassName(query);\n" +
                    "for (var div of divs)\n" +
                    "results.push(div.getBoundingClientRect());\n" +
                    "}\n" +
                    "console.log(JSON.stringify({'rects':results}));\n" +
                    "return JSON.stringify({'rects':results});\n" +
                    "})()\n";
            getWebRects(webView,js,callback)
        }

        @JvmStatic
        private fun getWebRects(webView: WebView, js: String, callback: (rects: List<Rect>) -> Unit) {
            webView.evaluateJavascript(js,
                    object : ValueCallback<String> {
                        override fun onReceiveValue (value: String) {
                            val rects: ArrayList<Rect> = ArrayList();
                            val webViewRect = Rect();
                            webView.getGlobalVisibleRect(webViewRect)
                            val jsRects = GsonBuilder().setLenient().create().fromJson<JSRectList>(value.substring(1,value.length - 1).replace("\\",""), JSRectList::class.java)
                            for (jsRect in jsRects.rects) {
                                val rect = Rect(jsRect.left.toInt(),jsRect.top.toInt(),jsRect.right.toInt(),jsRect.bottom.toInt())
                                rect.offset(webViewRect.left,webViewRect.top)
                                rects.add(rect)
                            }
                            callback(rects)
                        }
                    });
        }

    }

    data class JSRectList(
        var rects: List<JSRect> ) {
    }

    data class JSRect(
            var x: Float = 0.0f,
            var y: Float = 0.0f,
            var width: Float = 0.0f,
            var height: Float = 0.0f,
            var top: Float = 0.0f,
            var bottom: Float = 0.0f,
            var left: Float = 0.0f,
            var right: Float = 0.0f) {
    }

    internal class ShowcaseSP @SuppressLint("CommitPrefEdits")
    private constructor(appContext: Context) {

        private val SHARED_PREF_NAME = "intro"

        private val sharedPreferences: SharedPreferences
        private val editor: SharedPreferences.Editor

        private val sp by lazy { ShowcaseSP(appContext) }

        init {
            this.sharedPreferences = appContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            this.editor = sharedPreferences.edit()
        }

        fun show(key: String) {
            editor.putBoolean(key, true)
            editor.commit()
        }

        fun getShowing(key: String): Boolean {
            return sharedPreferences.getBoolean(key, false)
        }

        companion object {

            @JvmStatic
            fun instance(appContext: Context): ShowcaseSP {
                return ShowcaseSP(appContext).sp
            }
        }
    }
}
