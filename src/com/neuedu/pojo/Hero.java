package com.neuedu.pojo;

import com.neuedu.utils.GameUtil;
import com.neuedu.utils.ImgUtil;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Hero {
    private Image image;
    private int x;
    private int y;
    private int height;
    private int speed=10;
    private boolean left,right;
    private Direction dir;

    public Hero(){
        this.image= ImgUtil.getImage("hero_right_stand");
        this.x=300;
        this.height=image.getHeight(null);
        this.y=Constant.GAME_HEIGHT-height-182 ;
        this.dir=Direction.RIGHT;

    }

    public void draw(Graphics g){
        switch (this.dir){
            case RIGHT:
                g.drawImage(image,x,y,null);
                break;
            case LEFT:
                g.drawImage(ImgUtil.getImage("hero_left_stand"),x,y,null);
                break;
        }
        move();
    }

    public void move(){
        if (right){
            this.dir=Direction.RIGHT;
            x+=speed;
        }else if (left){
            this.dir=Direction.LEFT;
            x-=speed;
        }

    }

    public void keyPress(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_D:
                right=true;

            case KeyEvent.VK_A:
                left=true;

        }
    }

    public void keyRelease(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_D:
                right=false;
            case KeyEvent.VK_A:
                left=false;
        }
    }

}
