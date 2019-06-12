package com.neuedu.pojo;

import com.neuedu.utils.GameUtil;

import java.awt.*;

public class BackGround {
    private Image image;
    private int x;
    private int y;
    private int height;


    public BackGround(){
        this.image= GameUtil.getImg("com/neuedu/img/bgimg.jpg");
        this.x=0;
        this.height=image.getHeight(null);
        this.y=Constant.GAME_HEIGHT-height;

    }

    public void draw(Graphics g){
        g.drawImage(this.image,x,y,null);
    }

}
