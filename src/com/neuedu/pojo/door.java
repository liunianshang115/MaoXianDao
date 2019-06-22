package com.neuedu.pojo;

import com.neuedu.utils.ImgUtil;

import java.awt.*;


public class door {

    private static Image[] doorI = new Image[100];

    static {
        for (int i = 0 ; i <14 ; i++){
            doorI[i]=ImgUtil.getImage("door"+i);
        }
    }

    private int x;
    private int y;



    public door(int x,int y){
        this.x=x;
        this.y=y;

    }

    public int count=0;
    public void draw(Graphics g){

        if (count>13){
            count=0;
        }
        g.drawImage(doorI[count++],x,y,null);

    }
}
