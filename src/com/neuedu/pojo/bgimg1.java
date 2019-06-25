package com.neuedu.pojo;

import com.neuedu.utils.GameUtil;

import java.awt.*;

public class bgimg1 {
    private Image image;
    private int x;
    private int y;
    private int height;


    public bgimg1(){
        this.image= GameUtil.getImg("com/neuedu/img/bg11.png");
        this.x=350;
        this.height=image.getHeight(null);
        this.y=600;

    }

    public void draw(Graphics g){
        g.drawImage(this.image,x,y,null);
    }


}
