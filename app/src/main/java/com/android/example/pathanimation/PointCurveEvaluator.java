package com.android.example.pathanimation;

import android.animation.TypeEvaluator;
import android.graphics.Point;

public class PointCurveEvaluator implements TypeEvaluator<Point> {

    private Point control;

    public PointCurveEvaluator setControlPoint(Point control) {
        this.control = control;
        return this;
    }

    @Override
    public Point evaluate(float t, Point startValue, Point endValue) {
        float x, y;
        float oneMinusT = 1 - t;

        // Quadratic bezier curve
        x = oneMinusT * oneMinusT * startValue.x +
                2 * oneMinusT * t * control.x +
                t * t * endValue.x;
        y = oneMinusT * oneMinusT * startValue.y +
                2 * oneMinusT * t * control.y +
                t * t * endValue.y;

        return new Point((int) x, (int)y);
    }
}
