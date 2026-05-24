package com.xilian.webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val webView = WebView(this)
        setContentView(webView)

        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            setSupportZoom(false)
            builtInZoomControls = false
            loadWithOverviewMode = true
            useWideViewPort = true
        }

        webView.webViewClient = object : WebViewClient() {
            override fun onReceivedError(
                view: WebView?, errorCode: Int, description: String?, failingUrl: String?
            ) {
                view?.loadData(
                    "<html><body style='background:#FFF5F8;display:flex;align-items:center;justify-content:center;height:100vh;font-family:sans-serif;color:#5E4B66;text-align:center'><div>昔涟还没醒来呢…<br><small>请在 Termux 里输入「昔涟」启动</small></div></body></html>",
                    "text/html", "UTF-8"
                )
            }
        }

        webView.loadUrl("http://127.0.0.1:8000")
    }

    override fun onBackPressed() {
        val webView = findViewById<WebView>(android.R.id.content)
        if (webView.canGoBack()) webView.goBack() else super.onBackPressed()
    }
}
