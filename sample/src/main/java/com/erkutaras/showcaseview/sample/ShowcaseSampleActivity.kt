package com.erkutaras.showcaseview.sample

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Switch
import android.widget.Toast

import com.erkutaras.showcaseview.ShowcaseManager
import com.erkutaras.showcaseview.ShowcaseUtils
import java.util.*

/**
 * Created by erkut.aras on 23.02.2018.
 *
 * this is sample activity not used in prod
 */
class ShowcaseSampleActivity : AppCompatActivity() {

    lateinit var v1: View
    lateinit var v2: View
    lateinit var switchStatusBarVisibility: Switch
    lateinit var webView: WebView

    // default display
    private var listener = { v: View ->
        val builder = ShowcaseManager.Builder()
        builder.context(this@ShowcaseSampleActivity)
                .view(v)
                .descriptionImageRes(R.mipmap.ic_launcher_round)
                .descriptionTitle("LOREM IPSUM DOLOR")
                .descriptionText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.")
                .buttonText("DONE")
                .key("TEST")
                .developerMode(true)
                .marginFocusArea(0)
                .gradientFocusEnabled(true)
                .add().build()
                .show()
    }

    // different background color and alpha
    private var listener1 = { v: View ->
        val builder = ShowcaseManager.Builder()
        builder.context(this@ShowcaseSampleActivity)
                .view(v)
                .descriptionImageRes(R.mipmap.ic_launcher)
                .descriptionTitle("LOREM IPSUM DOLOR")
                .descriptionText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
                .buttonText("DONE")
                .key("TEST")
                .developerMode(true)
                .colorBackground(Color.GREEN)
                .alphaBackground(80)
                .marginFocusArea(10)
                .add().build()
                .show()
    }

    // different background and text color for button
    private var listener2 = { v: View ->
        val builder = ShowcaseManager.Builder()
        builder.context(this@ShowcaseSampleActivity)
                .view(v)
                .descriptionImageRes(R.mipmap.ic_launcher)
                .descriptionTitle("LOREM IPSUM DOLOR")
                .descriptionText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
                .buttonText("DONE")
                .key("TEST")
                .developerMode(true)
                .colorButtonBackground(Color.BLUE)
                .colorButtonText(Color.YELLOW)
                .marginFocusArea(20)
                .circle()
                .add().build()
                .show()
    }

    // different text color for title and description
    private var listener3 = { v: View ->
        val builder = ShowcaseManager.Builder()
        builder.context(this@ShowcaseSampleActivity)
                .view(v)
                .descriptionImageRes(R.mipmap.ic_launcher)
                .descriptionTitle("LOREM IPSUM DOLOR")
                .descriptionText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
                .buttonText("DONE")
                .key("TEST")
                .developerMode(true)
                .colorDescText(Color.GREEN)
                .colorDescTitle(Color.RED)
                .marginFocusArea(10)
                .roundedRectangle()
                .moveButtonsVisibility(true)
                .add().build()
                .show()
    }

    // different focus area color
    private var listener4 = { v: View ->
        val builder = ShowcaseManager.Builder()
        builder.context(this@ShowcaseSampleActivity)
                .view(v)
                .useFocus(false)
                .descriptionImageRes(R.mipmap.ic_launcher)
                .descriptionTitle("LOREM IPSUM DOLOR")
                .descriptionText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
                .buttonText("DONE")
                .key("TEST")
                .developerMode(true)
                .colorFocusArea(Color.CYAN)
                .alphaBackground(204)
                .marginFocusArea(10)
                .rectangle()
                .gradientFocusEnabled(true)
                .add()
                .view(v)
                .descriptionImageRes(R.mipmap.ic_launcher)
                .descriptionTitle("LOREM IPSUM DOLOR")
                .descriptionText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
                .buttonText("DONE")
                .key("TEST")
                .developerMode(true)
                .colorBackground(Color.BLUE)
                .colorFocusArea(Color.BLUE)
                .marginFocusArea(10)
                .rectangle()
                .gradientFocusEnabled(false)
                .add()
//                .view(v)
                .descriptionImageRes(R.mipmap.ic_launcher)
                .descriptionTitle("LOREM IPSUM DOLOR")
                .descriptionText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
                .buttonText("DONE")
                .key("TEST")
                .useFocus(true)
//                .useViewAsFocus(false)
                .circle()
//                .circleCenterX(250.0f)
//                .circleCenterY(250.0f)
//                .circleCenterRadius(25.0f)
                .view(Rect(200,200,300,300))
                .developerMode(true)
                .colorFocusArea(Color.CYAN)
                .colorBackground(Color.BLACK)
                .marginFocusArea(10)
                .circle()
                .gradientFocusEnabled(true)
                .add()
                .rectangle()
                .view(Rect(200,200,400,300))
//                .circleCenterX(350.0f)
//                .rectWidth(150.0f)
//                .rectHeight(50.0f)
                .descriptionDeltaX(400.0f)
                .add()
                .build()
                .show()
    }

    // multiple display
    private var listener5 = { v: View ->
        val builder = ShowcaseManager.Builder()
        builder.context(this@ShowcaseSampleActivity)
                .key("TEST")
                .developerMode(true)
                .marginFocusArea(10)
                // first view
                .view(v2)
                .descriptionImageRes(R.mipmap.ic_launcher)
                .descriptionTitle("LOREM IPSUM DOLOR-1")
                .descriptionText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
                .buttonText("Done")
                .cancelButtonColor(Color.RED)
                .buttonVisibility(false)//To hide button
                .cancelButtonVisibility(true)//To hide cancel button
                .moveButtonsVisibility(true)
                .add()
                // second view
                .view(v1)
                .descriptionImageRes(R.mipmap.ic_launcher_round)
                .descriptionTitle("LOREM IPSUM DOLOR-2")
                .descriptionText("Consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
                .buttonText("Cancel")
                .marginFocusArea(20)
                .cancelButtonColor(Color.GREEN)
                .selectedMoveButtonColor(Color.GREEN)
                .unSelectedMoveButtonColor(Color.RED)
                .buttonVisibility(true)//To show button
                .cancelButtonVisibility(true)//To show cancel button
                .moveButtonsVisibility(true)
                .add()
                .build()
                .show()
    }

    private var listener6 = { v: View ->
        ShowcaseUtils.getWebTagRects(webView, Arrays.asList("div")){ rects: List<Rect> ->
                run {
                val builder = ShowcaseManager.Builder()
                builder.context(this@ShowcaseSampleActivity)
                        .key("TEST")
                        .developerMode(true)
                        .rectangle()
                        .useGravity(true)
                        .setGravity(Gravity.END)
                        .view(rects[0])
                        .descriptionImageRes(R.mipmap.ic_launcher)
                        .descriptionTitle("LOREM IPSUM DOLOR-1")
                        .descriptionText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
                        .buttonText("Done")
                        .cancelButtonColor(Color.RED)
                        .buttonVisibility(true)//To hide button
                        .cancelButtonVisibility(true)
                        .moveButtonsVisibility(true)
                        .add()
                        .view(rects[1])
                        .add()
                        .build()
                        .show()
            }
        }
//        webView.evaluateJavascript("JSON.stringify(\$(\"header\")[0].getBoundingClientRect())",
//                object : ValueCallback<String> {
//                    override fun onReceiveValue (value: String) {
//                        val rect = GsonBuilder().setLenient().create().fromJson<JSRect>(value.substring(1,value.length - 1).replace("\\",""), JSRect::class.java)
//                        val builder = ShowcaseManager.Builder()
//                        val baseRect = Rect()
//                        val divRect = Rect(rect.left,rect.top,rect.right,rect.bottom)
//                        webView.getGlobalVisibleRect(baseRect)
//                        divRect.offset(baseRect.left,baseRect.top)
//                        builder.context(this@ShowcaseSampleActivity)
//                                .key("TEST")
//                                .developerMode(true)
//                                .rectangle()
//                                .view(divRect)
//                                .descriptionImageRes(R.mipmap.ic_launcher)
//                                .descriptionTitle("LOREM IPSUM DOLOR-1")
//                                .descriptionText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
//                                .buttonText("Done")
//                                .cancelButtonColor(Color.RED)
//                                .buttonVisibility(false)//To hide button
//                                .cancelButtonVisibility(true)//To hide cancel button
//                                .moveButtonsVisibility(true)
//                                .add()
//                                .build()
//                                .show()
//                    }
//                }
//        )

    }

    data class JSRect(
            var x: Int = 0,
            var y: Int = 0,
            var width: Int = 0,
            var height: Int = 0,
            var top: Int = 0,
            var bottom: Int = 0,
            var left: Int = 0,
            var right: Int = 0) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showcase_sample)

        switchStatusBarVisibility = findViewById(R.id.switch1)
        initSwitch()
        findViewById<View>(R.id.progressBar2).setOnClickListener(listener)
        findViewById<View>(R.id.progressBar).setOnClickListener(listener1)
        findViewById<View>(R.id.textView).setOnClickListener(listener2)
        findViewById<View>(R.id.checkBox).setOnClickListener(listener3)
        findViewById<View>(R.id.button).setOnClickListener(listener4)
        v1 = findViewById(R.id.checkedTextView)
        v1.setOnClickListener(listener5)
        v2 = findViewById(R.id.radioButton)
        v2.setOnClickListener(listener5)

        webView = findViewById<WebView>(R.id.web_view_select)
        webView.loadUrl("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_default");
        webView.settings.javaScriptEnabled = true
        findViewById<View>(R.id.button_webview).setOnClickListener(listener6)
//        webView.webViewClient = object: WebViewClient() {
//            override fun onPageFinished(view: WebView?, url: String?) {
//                super.onPageFinished(view, url)
//                ShowcaseUtils.getWebJQueryRects(webView, Arrays.asList("header",".w90","#search")) { rects: List<Rect> ->
//                    run {
//                        rects.forEach() { rect: Rect ->
//                            run {
//                                Log.e("RECT", rect.toString());
//                            }
//                        }
//                    }
//                }
//            }
//        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ShowcaseManager.REQUEST_CODE_SHOWCASE && resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, "All showcases are closed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setStatusBarVisibility(statusBarVisibility: Boolean) {
        val decorView = window.decorView
        val uiOptions: Int = if (statusBarVisibility) {
            View.SYSTEM_UI_FLAG_VISIBLE
        } else {
            View.SYSTEM_UI_FLAG_FULLSCREEN
        }
        decorView.systemUiVisibility = uiOptions
    }

    private fun initSwitch() {
        switchStatusBarVisibility.isChecked = window.decorView.systemUiVisibility == View.VISIBLE
        switchStatusBarVisibility.setOnCheckedChangeListener { buttonView, isChecked -> setStatusBarVisibility(isChecked) }
    }
}
