package com.neuedu.client;

import com.neuedu.pojo.BackGround;
import com.neuedu.pojo.Hero;
import com.neuedu.utils.GameUtil;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MaoXianClient extends Frame {

    private BackGround bg=new BackGround();
    private Hero hero=new Hero();

    //加载窗口
    public void loadFram(){
        this.setTitle("冒险岛");
        this.setSize(1200,700);//大小
        this.setLocationRelativeTo(null);//居中
        this.setVisible(true);//是否显示
        this.setBackground(Color.BLACK);//背景颜色
        //添加窗口监听事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);//当前程序结束  关闭窗口
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
        new MaoXianClient().loadFram();
    }



}
