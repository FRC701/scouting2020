package com.vandenrobotics.tyr2018.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.vandenrobotics.tyr2018.R;

import java.util.ArrayList;

/**
 * Created by Diego Andrade on 9/22/2016.
 */

public class DrawableView extends View {

    private Paint mPaint;
    private Bitmap  mBitmap;
    private Canvas  mCanvas;
    private Path    mPath;
    private Paint   mBitmapPaint;
    private ArrayList<Path> paths = new ArrayList<>();
    private ArrayList<Path> undonePaths = new ArrayList<>();
    private ArrayList<Paint> paints = new ArrayList<>();
    private ArrayList<Paint> undonePaints = new ArrayList<>();

    private float mX, mY;
    private static final float TOUCH_TOLERANCE = 4;
    private TypedArray a;


    public DrawableView(Context context, AttributeSet attributeSet) {

        super(context, attributeSet);
        a = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.DrawableView, 0, 0);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(a.getInteger(R.styleable.DrawableView_StrokeColor, Color.BLACK));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(a.getInteger(R.styleable.DrawableView_StrokeSize, 5));
        paints.add(mPaint);

        mPath = new Path();
        paths.add(mPath);

        mBitmapPaint = new Paint();
        mBitmapPaint.setColor(a.getInteger(R.styleable.DrawableView_BackgroundColor, Color.WHITE));

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
        if(!a.getBoolean(R.styleable.DrawableView_Transparent, false))
            mCanvas.drawRect(0,0,mBitmap.getWidth(),mBitmap.getHeight(), mBitmapPaint);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
        for (int i = 0; i < paths.size(); i++) {
            canvas.drawPath(paths.get(i),paints.get(i));
        }
        canvas.drawPath(mPath, mPaint);
    }

    private void touch_start(float x, float y) {
        undonePaths.clear();
        mPath.reset();
        mPath.moveTo(x, y);
        mX = x;
        mY = y;
    }

    private void touch_move(float x, float y) {

        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);
        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
            mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
            mX = x;
            mY = y;
        }
    }

    private void touch_up() {

        mPath.lineTo(mX, mY);

        // commit the path to our offscreen
        mCanvas.drawPath(mPath, mPaint);
        paths.add(mPath);
        paints.add(mPaint);


        // kill this so we don't double draw
        mPath = new Path();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(paints.get(paints.size()-1).getColor());
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(a.getInteger(R.styleable.DrawableView_StrokeSize, 5));
        mPath= new Path();
    }
    public void onClickUndo(){

        if (paths.size()>0){
            if (paints.size()>0) {
                undonePaints.add(paints.remove(paints.size() - 1));
                undonePaths.add(paths.remove(paths.size() - 1));
                invalidate();
            }
        }
        else {
            Log.d("DrawableView", "Failed to undo");
        }
    }
    public void onClickRedo() {
        if (undonePaths.size() > 0) {
            paints.add(undonePaints.remove(undonePaints.size() - 1));
            paths.add(undonePaths.remove(undonePaths.size() - 1));
            invalidate();
        } else {
            Log.d("DrawableView", "Failed to redo");
        }
    }

    public void onClickClear(){
        if (paths.size() > 0){
            paths.clear();
            paints.clear();
            undonePaints.clear();
            undonePaths.clear();
            invalidate();
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touch_start(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                touch_move(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                touch_up();
                invalidate();
                break;
        }
        return true;
    }

    public void setDrawColor(int color){
        mPaint.setColor(color);
    }


}

