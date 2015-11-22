package com.example.android.secure_me;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Defense extends AppCompatActivity {
    Intent i;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defense);
    }

    public void pep(View v)
    {
        url = "http://shopping.rediff.com/product/pepper-spray/12704693?sc_cid=browse  ";
        i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void stun (View v)
    {
        url = "http://shopping.rediff.com/product/rechargeable-high-voltage-self-defense-stun-gun-led-flash-light-torch/12996268?sc_cid=browse ";
        i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void knife (View v)
    {
        url = "http://shopping.rediff.com/product/hidden-pen-knife-for-self-defence/15097046?sc_cid=browse  ";
        i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void hidden (View v)
    {
        url ="http://shopping.rediff.com/product/hidden-blade-sword-cane-for-self-defence---02/15553636?sc_cid=browse";
        i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    public void onBackPressed() {

        startActivity(new Intent(Defense.this, MainActivity.class));
        finish();
    }
}
