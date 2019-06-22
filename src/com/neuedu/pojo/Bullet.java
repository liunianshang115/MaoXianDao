package com.neuedu.pojo;

import com.neuedu.client.MaoXianClient;
import com.neuedu.utils.ImgUtil;

import java.awt.*;
import java.util.List;

public class Bullet {
    private Image image;
    private int x;
    private int y;
    private int speed;
    private int width;
    private int height;
    private Direction dir;
    private MaoXianClient mxc;
    private boolean live=true;

    public Bullet(int x, int y, Direction dir, MaoXianClient mxc){
        this.mxc=mxc;
        this.dir=dir;
        this.x=x;
        this.y=y;
        if (this.dir==Direction.RIGHT){
            this.image= ImgUtil.getImage("bullet_right");
        }else if (this.dir==Direction.LEFT){
            this.image= ImgUtil.getImage("bullet_left");
        }
        /*this.y=Constant.GAME_HEIGHT-182;*/
        this.speed=100;
        this.width=image.getWidth(null);
        this.height=image.getHeight(null);

    }

    public void draw(Graphics g){
        if (!live){
            this.mxc.bullets.remove(this);
        }
        g.drawImage(this.image,x,y,null);
        move();
    }

    public  void move(){
        if (this.dir==Direction.RIGHT){
            x+=speed;
        }else if (this.dir==Direction.LEFT){
            x-=speed;
        }


    }

    //获取子弹图片的矩形
    public Rectangle getRectangle(){
        return new Rectangle(x,y,width,height);
    }

    public boolean hit(Mob mob){
        if (this.getRectangle().intersects(mob.getRectangle())){
            this.live=false;

            mob.hp-=20;
            if (mob.hp<=0){
                mob.live=false;
                MobDie mobDie=new MobDie(mob.x,mxc);
                this.mxc.mobDies.add(mobDie);
            }


        }
        return false;
    }

    public boolean hit(List<Mob> mobs){
        for (int i=0;i<mobs.size();i++){
            if (hit(mobs.get(i))){
                return true;
            }
        }
        return false;
    }
}
