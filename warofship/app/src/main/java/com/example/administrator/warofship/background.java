package com.example.administrator.warofship;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */

public class background implements gameimage{
    private Bitmap background;
    private Bitmap phoneimage=null;
    private int screenwidth;
    private int screenheight;
    private int height=0;
    private List<gameimage> gameimageList = new ArrayList<gameimage>();
    public background(Bitmap background){
        this.background=background;
        phoneimage=Bitmap.createBitmap(screenwidth,screenheight, Bitmap.Config.ARGB_8888);
    }

    public float getX(){
        return 0;

    }
    public float getY(){
        return 0;

    }
    public Bitmap getBitmap(){
        Paint P = new Paint();
        Canvas c = new Canvas(phoneimage);
        c.drawBitmap(background,new Rect(0,0,background.getWidth(),background.getHeight()),new Rect(0,height,screenwidth,screenheight),P);
        c.drawBitmap(background,new Rect(0,0,background.getWidth(),background.getHeight()),new Rect(0,-screenheight+height,screenwidth,height),P);
        height++;
        return phoneimage;

    }
}
