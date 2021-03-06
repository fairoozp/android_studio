 package com.android.seedrextension.ui.gallery

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.seedrextension.R

 class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
                ViewModelProvider(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        /*val textView: TextView = root.findViewById(R.id.text_gallery)
        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/



        val web_home : WebView = root.findViewById(R.id.web_home)

        web_home.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                var keyCode = null
                if (keyCode == KeyEvent.KEYCODE_BACK && web_home.canGoBack()) {
                    web_home.goBack()
                    return true
                }
                return false
            }
        })

        @JavascriptInterface
        fun showToast(toast: String) {
            var mContext = null
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show()
        }

        web_home.loadUrl("https://www.seedr.cc/files")

        web_home.webViewClient = WebViewClient()





        web_home.setScrollbarFadingEnabled(false);
        val newUA = "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.4) Gecko/20100101 Firefox/4.0"
        web_home.getSettings().setUserAgentString(newUA)

        web_home.evaluateJavascript("document.querySelector('meta[name=\"viewport\"]').setAttribute('content', 'width=1024px, initial-scale=' + (document.documentElement.clientWidth / 1024));", null);

        web_home.getSettings().setUserAgentString(newUA)
        web_home.getSettings().setJavaScriptEnabled(true);
        web_home.settings.javaScriptEnabled = true
        web_home.settings.loadWithOverviewMode = true
        web_home.settings.useWideViewPort = true
        web_home.settings.setSupportZoom(true)
        web_home.settings.builtInZoomControls = true
        web_home.settings.builtInZoomControls = true
        val webSettings = web_home.settings
        webSettings.domStorageEnabled = true
        //webSettings.setAppCacheEnabled(true)

        web_home.getSettings().setLoadWithOverviewMode(true);
        web_home.getSettings().setUseWideViewPort(true);

        web_home.getSettings().setSupportZoom(true);
        web_home.getSettings().setBuiltInZoomControls(true);
        web_home.getSettings().setDisplayZoomControls(false);

        return root
    }





}