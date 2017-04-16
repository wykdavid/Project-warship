package com.example.administrator.warofship;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.content.Context;
import java.lang.Runnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/4/9.
 */

public class GameView extends SurfaceView implements Runnable,SurfaceHolder.Callback{
    private Bitmap background;
    private Bitmap bullet;
    private  Bitmap boom;
    private Bitmap player;
    private Bitmap boss;
    private Bitmap drawboard;
    private int screenwidth;
    private int screenheight;
    private List<gameimage> gameimageList = new ArrayList<gameimage>();

    public GameView(Context context){
        super(context);
        getHolder().addCallback(this);


    }
    public void init(){
        background= BitmapFactory.decodeResource(getResources(),R.drawable.background);
        bullet=BitmapFactory.decodeResource(getResources(),R.drawable.bullet);
        drawboard=Bitmap.createBitmap(screenwidth,screenheight, Bitmap.Config.ARGB_8888);
        gameimageList.add(new background(background));

    }
    private boolean state=false;
    private SurfaceHolder holder;
    ;
    public void run(){
        Paint paint= new Paint();
        try{
            while(state) {
                Canvas canvasdraw=new Canvas(drawboard);
                for(gameimage image:gameimageList){
                    canvasdraw.drawBitmap(image.getBitmap(),image.getX(),image.getY(),paint);

                }
                Canvas canvas=holder.lockCanvas();
                canvasdraw.drawBitmap(drawboard,0,0,paint);

                holder.unlockCanvasAndPost(canvas);
                Thread.sleep(1000);
            }
        }catch(Exception e){

            }


    }


    //inform project when creating surface
    public void surfaceCreated(SurfaceHolder holder){
        this.holder=holder;
        state=true;
        new Thread(this).start();


    }
    //inform project when  surface changed
    public void  surfaceChanged(SurfaceHolder holder,int format,int width,int height){

        screenwidth=width;
        screenheight=height;
        init();


    }
    //inform project when destroying surface
    public void surfaceDestroyed(SurfaceHolder holder){
        state=false;

    }



}
