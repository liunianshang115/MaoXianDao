package com.neuedu.utils;

import com.neuedu.client.MaoXianClient;
import com.neuedu.pojo.Constant;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameUtil extends Frame {//Frame是一个标题和边框的顶级窗口

    // 解决图片闪烁的问题，用双缓冲方法解决闪烁问题
    Image backImg = null;

    // 重写update()方法，在窗口的里层添加一个虚拟的图片
    @Override
    public void update(Graphics g) {
        if (backImg == null) {
            // 如果虚拟图片不存在，创建一个和窗口一样大小的图片
            backImg = createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        }
        // 获取到虚拟图片的画笔
        Graphics backg = backImg.getGraphics();
        Color c = backg.getColor();
        backg.setColor(Color.CYAN);
        backg.fillRect(0, 0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        backg.setColor(c);
        // 调用虚拟图片的paint()方法，每50ms刷新一次
        paint(backg);
        g.drawImage(backImg, 0, 0, null);
    }


    /*多线程*/
    class MyThred extends Thread{
        @Override
        public void run() {
            for (;;){
                repaint();//调用paint方法
                /*时间延迟*/
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //加载窗口
    public void loadFrame(){
        this.setTitle("冒险岛");
        this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//大小
        this.setLocationRelativeTo(null);//居中
        this.setVisible(true);//是否显示
        /*this.setBackground(Color.CYAN);//背景颜色*/
        //添加窗口监听事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);//当前程序结束  关闭窗口
            }
        });
        //多线程启动
        new MyThred().start();

    }




}
