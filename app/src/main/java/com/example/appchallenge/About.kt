package com.example.appchallenge


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_about.*
import android.R.string.cancel
import android.content.DialogInterface
import android.net.http.SslError
import android.webkit.SslErrorHandler
import androidx.appcompat.app.AlertDialog


class About : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_about)
            setSupportActionBar(toolbar)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            val webpage: WebView = findViewById(R.id.about_page)
            webpage.settings.javaScriptEnabled = true
            webpage.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    view?.loadUrl(url)
                    return true
                }
            }
            webpage.loadUrl("https://andela.com/alc/")

        }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            if (item!!.itemId == android.R.id.home){
                finish()
            }
            return true
        }
    fun onReceivedSslError(view: WebView, handler: SslErrorHandler, error: SslError) {
        val builder = AlertDialog.Builder(this)
        var message = "SSL Certificate error."
        when (error.primaryError) {
            SslError.SSL_UNTRUSTED -> message = "The certificate authority is not trusted."
            SslError.SSL_EXPIRED -> message = "The certificate has expired."
            SslError.SSL_IDMISMATCH -> message = "The certificate Hostname mismatch."
            SslError.SSL_NOTYETVALID -> message = "The certificate is not yet valid."
        }
        message += " Do you want to continue anyway?"

        builder.setTitle("SSL Certificate Error")
        builder.setMessage(message)
        builder.setPositiveButton("continue",
            DialogInterface.OnClickListener { dialog, which -> handler.proceed() })
        builder.setNegativeButton("cancel",
            DialogInterface.OnClickListener { dialog, which -> handler.cancel() })
        val dialog = builder.create()
        dialog.show()
    }
    }