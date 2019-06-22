package com.neuedu.pojo;

import com.neuedu.client.MaoXianClient;
import com.neuedu.utils.ImgUtil;

import java.awt.*;

public class Mob {
    private static Image[] images=new Image[100];
    static {
        for (int i=0;i<=7;i++){
            images[i]= ImgUtil.getImage("mob_left"+i);
        }
    }
    public int x;
    private int y;
    private int height;
    private int width;
    public boolean live=true;
    private MaoXianClient mxc;
    public BloodBar bb;
    public int hp=Constant.MPB_HP;


    public Mob(int x, MaoXianClient mxc){
        this.mxc=mxc;
        this.x=x;
        this.height=images[0].getHeight(null);
        this.width=images[0].getWidth(null);
        this.y=Constant.GAME_HEIGHT-120-height;
        this.bb=new BloodBar(this.x,this.y,this.width);

    }

    public int count=0;
    public void draw(Graphics g){

        if (count>7){
            count=0;
        }
        g.drawImage(images[count++],x,y,null);
        bb.draw(g);
        if (!live){
            this.mxc.mobs.remove(this);
        }

    }


    public Rectangle getRectangle(){
        return new Rectangle(x,y,width,height);
    }

    class BloodBar{
        int x;
        int y;
        int width;

        public BloodBar(int x,int y,int width){
            this.x=x;
            this.y=y;
            this.width=width;
        }
        public void draw(Graphics g){
            g.setColor(Color.red);
            g.drawRect(x,y,width,10);
            g.setColor(Color.green);
            g.fillRect(x,y,width*(hp/100),10);
        }

    }



}
