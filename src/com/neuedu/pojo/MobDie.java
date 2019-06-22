package com.neuedu.pojo;

import com.neuedu.client.MaoXianClient;
import com.neuedu.utils.ImgUtil;

import java.awt.*;

public class MobDie {
    private static Image[] images=new Image[100];
    static {
        for (int i=0;i<=14;i++){
            images[i]= ImgUtil.getImage("mob_die"+i);
        }
    }
    private int x;
    private int y;
    private int width;
    private int height;
    public boolean live=true;
    private MaoXianClient mxc;


    public MobDie(int x, MaoXianClient mxc){
        this.x=x;
        this.mxc=mxc;
        this.height=images[0].getHeight(null);
        this.y=Constant.GAME_HEIGHT-182-height;
    }

    public int mobcount=0;
    public void draw(Graphics g){
        if (!live){
            return;
        }
        g.drawImage(images[mobcount++],x,y,null);
        if (mobcount>13){
            this.live=false;
        }

    }




}
