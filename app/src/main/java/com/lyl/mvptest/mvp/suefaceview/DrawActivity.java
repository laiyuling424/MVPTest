package com.lyl.mvptest.mvp.suefaceview;


import android.app.Activity;
import android.os.Bundle;

import com.lyl.mvptest.R;
import com.lyl.mvptest.view.SurfaceViewL;

import butterknife.BindView;

public class DrawActivity extends Activity {

    @BindView(R.id.surfaceview)
    SurfaceViewL surfaceview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        surfaceview.isDrawing=false;
    }
}
