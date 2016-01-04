package com.android.example.pathanimation;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CurvyPathAnimationActivity extends Activity {
    private Button mButton;
    private View mContainer;
    private View.OnClickListener onClickListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mButton = (Button) findViewById(R.id.button);
        mContainer = findViewById(R.id.container);


        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = (int) mButton.getX();
                int y = (int) mButton.getY();
                Point src = new Point(x, y);
                Point dest;
                if (x == 0) {
                    dest = new Point(400, 500);
                } else {
                    dest = new Point(0, 0);
                }


                final ObjectAnimator anim = ObjectAnimator.ofObject(
                        CurvyPathAnimationActivity.this,
                        "buttonLoc",
                        new PointCurveEvaluator().setControlPoint(new Point(src.x, dest.y)),
                        src,
                        dest);
                anim.setDuration(1000);
                anim.start();
            }
        };

        mContainer.setOnClickListener(onClickListener);
        mButton.setOnClickListener(onClickListener);

    }

    public void setButtonLoc(Point newLoc) {
        mButton.setTranslationX(newLoc.x);
        mButton.setTranslationY(newLoc.y);
    }
}