package com.example.onlineshopping;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FullViewActivity extends AppCompatActivity {
    ImageView img;
    TextView name,price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_view);
        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.statusbarcolor));
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        img = findViewById(R.id.fullimage);
        name = findViewById(R.id.fullname);
        price = findViewById(R.id.fullprice);
        name.setText(getIntent().getStringExtra("fullname"));
        price.setText(getIntent().getStringExtra("fullprice"));
        Glide.with(this)
                .load(getIntent().getStringExtra("fullimage"))
                .into(img);
    }
}