package com.neuedu.pojo;

import com.neuedu.utils.GameUtil;

import java.awt.*;

public class bgimg2 {

    private Image image;
    private int x;
    private int y;
    private int height;


    public bgimg2(){
        this.image= GameUtil.getImg("com/neuedu/img/bg12.png");
        this.x=670;
        this.height=image.getHeight(null);
        this.y=441;

    }

    public void draw(Graphics g){
        g.drawImage(this.image,x,y,null);
    }
}
