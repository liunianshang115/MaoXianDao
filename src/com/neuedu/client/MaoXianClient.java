package com.neuedu.client;

import com.neuedu.pojo.BackGround;
import com.neuedu.pojo.Constant;
import com.neuedu.pojo.Hero;
import com.neuedu.utils.FrameUtil;
import com.neuedu.utils.GameUtil;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MaoXianClient extends FrameUtil {

    private BackGround bg=new BackGround();
    private Hero hero=new Hero();

    //加载窗口
    @Override
    public void loadFrame(){
        super.loadFrame();
        this.addKeyListener(new KeyAdapter() {
            //按下事件
            @Override
            public void keyPressed(KeyEvent e) {
                hero.keyPress(e);
            }
            //抬起事件
            @Override
            public void keyReleased(KeyEvent e) {
                hero.keyRelease(e);
            }
        });
    }






    /*用来将图片画在窗口上*/
    @Override
    public void paint(Graphics g) {
        /*super.paint(g);*/
        /*g.drawImage(GameUtil.getImg("com/neuedu/img/bgimg.jpg"),0,0,null);*/
        bg.draw(g);
        hero.draw(g);
    }

    public static void main(String[] args) {
        new MaoXianClient().loadFrame();
    }



}
