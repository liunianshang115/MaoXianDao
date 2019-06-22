package com.neuedu.utils;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ImgUtil {
    /*图片路径
    * Map
    *
    * */
    public static Map<String, Image> maps=new HashMap<>();
    static {
        maps.put("hero_right_stand",GameUtil.getImg("com/neuedu/img/hero/stand_r/stand1_0.png"));
        maps.put("hero_left_stand",GameUtil.getImg("com/neuedu/img/hero/stand_l/stand1_0.png"));
        //加载向右走的图片
        for (int i=0;i<=4;i++){
            maps.put("hero_right_walk"+i,GameUtil.getImg("com/neuedu/img/hero/walk_r/walk1_"+i+".png"));
        }
        //加载向左走的图片
        for (int i=0;i<=4;i++){
            maps.put("hero_left_walk"+i,GameUtil.getImg("com/neuedu/img/hero/walk_l/walk1_"+i+".png"));
        }
        /*加载向右射击的图片*/
        for (int i=0;i<=3;i++){
            maps.put("hero_right_shoot"+i,GameUtil.getImg("com/neuedu/img/hero/shoot_r/shoot1_"+i+".png"));
        }
        /*加载向左射击的图片*/
        for (int i=0;i<=3;i++){
            maps.put("hero_left_shoot"+i,GameUtil.getImg("com/neuedu/img/hero/shoot_l/shoot1_"+i+".png"));
        }
        /*加载跳的图片*/
        maps.put("hero_right_jump",GameUtil.getImg("com/neuedu/img/hero/jump/jump_r.png"));
        maps.put("hero_left_jump",GameUtil.getImg("com/neuedu/img/hero/jump/jump_l.png"));
        /*加载箭头*/
        maps.put("bullet_right",GameUtil.getImg("com/neuedu/img/right.png"));
        maps.put("bullet_left",GameUtil.getImg("com/neuedu/img/left.png"));
        /*加载怪物图片*/
        for (int i=0;i<=7;i++){
            maps.put("mob_left"+i,GameUtil.getImg("com/neuedu/img/mob/mob_left/0"+i+".png"));
        }
        /*加载怪物死亡图片*/
        for (int i=0;i<=13;i++){
            maps.put("mob_die"+i,GameUtil.getImg("com/neuedu/img/mob/die/"+i+".png"));
        }
        /*加载门*/
        /*for (int i=0;i<=14;i++){
            maps.put("door"+i,GameUtil.getImg("com/neuedu/img/door/"+i+".png"));
        }*/
    }

    public static Image getImage(String key){
        return maps.get(key);
    }



}
