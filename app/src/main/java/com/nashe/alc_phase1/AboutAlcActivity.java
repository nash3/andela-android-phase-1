package com.nashe.alc_phase1;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

public class AboutAlcActivity extends AppCompatActivity {

    private WebView aboutAndela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setTitle("About ALC");

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(11, 69, 161)));

        aboutAndela = findViewById(R.id.about_andela);
        aboutAndela.setWebViewClient(new WebViewClient() {@Override public void onReceivedSslError(WebView v, SslErrorHandler handler, SslError er){ handler.proceed(); }});
        final String url = "https://andela.com/alc/";
        WebSettings webSettings = aboutAndela.getSettings();
        webSettings.setJavaScriptEnabled(true);
        aboutAndela.loadUrl(url);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Write your logic here
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        if (aboutAndela.canGoBack()) {
            aboutAndela.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
