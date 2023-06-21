package com.example.uasdraw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView mImgView;
    Bitmap mBitmap;
    Canvas mCanvas;
    private int mColorBackground;
    Paint mCirclePaint = new Paint();
    Paint mHeadPaint = new Paint();
    Rect mRect = new Rect();

    int vHeight;
    int vWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImgView = findViewById(R.id.my_img_view);


        mCirclePaint.setColor(getResources().getColor(R.color.black));
        mHeadPaint.setColor(getResources().getColor(R.color.white));

        mImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(mImgView, "alpha", 1);
                animator.setDuration(2000);
                animator.start();

                ObjectAnimator animator2 = ObjectAnimator.ofFloat(mImgView, "rotationY", 180);
                animator2.setStartDelay(2000);
                animator2.setDuration(2000);
                animator2.start();

                ObjectAnimator animator3 = ObjectAnimator.ofFloat(mImgView, "alpha", 0);
                animator3.setStartDelay(4000);
                animator3.setDuration(2000);
                animator3.start();
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        int vWidth = mImgView.getWidth();
        int vHeight = mImgView.getHeight();

        mBitmap = Bitmap.createBitmap(vWidth, vHeight, Bitmap.Config.ARGB_8888);
        mImgView.setImageBitmap(mBitmap);
        mColorBackground = ResourcesCompat.getColor(getResources(), R.color.yellow, null);
        mCanvas = new Canvas(mBitmap);
        mCanvas.drawColor(mColorBackground);


        //drawHead();
        mCanvas.drawOval(vWidth/2-300, vHeight/2-200, vWidth/2+300, vHeight/2+200, mHeadPaint );
        //        drawRightEye();
        mCanvas.drawCircle(vWidth/2+150, vHeight/2, 50, mCirclePaint);
        //        drawLeftEye();
        mCanvas.drawCircle(vWidth/2-150, vHeight/2, 50, mCirclePaint);
        //        drawEyeConnector();
        mRect.set(vWidth/2-150, vHeight/2-10, vWidth/2+150, vHeight/2+10);
        mCanvas.drawRect(mRect, mCirclePaint);
    }
}