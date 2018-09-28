package com.example.kshitiz.event1;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Kshitiz on 08/04/2018.
 */

public class Home extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Thread t1=new Thread(){
           public void run(){

               try{
                   sleep(5000);
           }catch (InterruptedException e){
                   e.printStackTrace();

               }finally {
  //                 Intent openHome=new Intent("com.example.kshitiz.event1.Home");
//                   startActivity(openHome);

               }
               }

        };
        t1.start();

    }
}
