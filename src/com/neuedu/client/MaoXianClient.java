package com.neuedu.client;

import com.neuedu.pojo.*;
import com.neuedu.utils.FrameUtil;
import com.neuedu.utils.GameUtil;
import com.neuedu.utils.MusicUtil;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class MaoXianClient extends FrameUtil {

    private door door = new door(1150,200);
    private BackGround bg=new BackGround();
    private Hero hero=new Hero(this);
    private bgimg bg0=new bgimg();
    private bgimg1 bg1=new bgimg1();
    private bgimg2 bg2=new bgimg2();
    private bgimg3 bg3=new bgimg3();
    private bgimg4 bg4=new bgimg4();
    private MobDie mobDie=new MobDie();
    //加载多个子弹
    public List<Bullet> bullets=new ArrayList<>();
    public List<Mob> mobs=new ArrayList<>();
    public List<MobDie> mobDies=new ArrayList<>();




    //加载窗口
    @Override
    public void loadFrame(){
        MusicUtil.getMUsic("D:\\开发工具\\IDEA\\Maoxiandao\\src\\com\\neuedu\\img\\music.wav");
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
        for (int i=0;i<3;i++){
            mobs.add(new Mob(250+200*i,this));
        }

    }






    /*用来将图片画在窗口上*/
    @Override
    public void paint(Graphics g) {
        /*super.paint(g);*/
        /*g.drawImage(GameUtil.getImg("com/neuedu/img/bgimg.jpg"),0,0,null);*/
        bg.draw(g);
        bg0.draw(g);
        bg1.draw(g);
        bg2.draw(g);
        bg3.draw(g);
        bg4.draw(g);
//        g.drawImage(GameUtil.getImg("com/neuedu/img/bg11.png"),0,600,null);
//        g.drawImage(GameUtil.getImg("com/neuedu/img/bg11.png"),350,600,null);
//        g.drawImage(GameUtil.getImg("com/neuedu/img/bg12.png"),670,441,null);
//        g.drawImage(GameUtil.getImg("com/neuedu/img/bg12.png"),820,282,null);
//        g.drawImage(GameUtil.getImg("com/neuedu/img/bg13.png"),1085,282,null);
        hero.draw(g);
        for (int i=0;i<bullets.size();i++){
            Bullet bullet=bullets.get(i);
            bullet.draw(g);
            bullet.hit(mobs);
        }

        for (int i=0;i<mobs.size();i++){
            mobs.get(i).draw(g);
        }
        for (int i=0;i<mobDies.size();i++){
            mobDies.get(i).draw(g);
        }


    }

    public static void main(String[] args) {
        new MaoXianClient().loadFrame();
    }



}
