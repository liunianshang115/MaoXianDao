package com.neuedu.pojo;

import com.neuedu.utils.GameUtil;

import java.awt.*;

public class Hero {
    private Image image;
    private int x;
    private int y;
    private int height;

    public Hero(){
        this.image= GameUtil.getImg("com/neuedu/img/hero/walk_r/walk1_0.png");
        this.x=300;
        this.height=image.getHeight(null);
        this.y=Constant.GAME_HEIGHT-height-182 ;
    }

    public void draw(Graphics g){
        g.drawImage(image,x,y,null);
    }
}
