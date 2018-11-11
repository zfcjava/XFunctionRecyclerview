package com.canjun.recyclerview.xfuntion.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.canjun.recyclerview.xfuntion.sample.xfuntionview.BasicSampleActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv_onclick);
        initLister();
    }

    private void initLister() {
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_onclick:
                Intent intent = new Intent(this, BasicSampleActivity.class);
                startActivity(intent);
                break;
        }
    }
}
