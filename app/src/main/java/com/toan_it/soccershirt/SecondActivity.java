package com.toan_it.soccershirt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    ImageView imgShow;
    TextView tvTenShow, tvNhanhieuSow, tvGiaShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        AnhXa();

        Intent intent = getIntent();
        imgShow.setImageResource(Integer.parseInt(intent.getStringExtra("image")));
        tvTenShow.setText(intent.getStringExtra("name"));
        tvNhanhieuSow.setText(intent.getStringExtra("brand"));
        tvGiaShow.setText(intent.getStringExtra("price"));
    }


    private void AnhXa() {
        imgShow = findViewById(R.id.showhinh);
        tvTenShow = findViewById(R.id.showtenhinh);
        tvNhanhieuSow = findViewById(R.id.shownhanhieu);
        tvGiaShow = findViewById(R.id.showgia);
    }
}
