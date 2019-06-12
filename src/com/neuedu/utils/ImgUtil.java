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
    }

    public static Image getImage(String key){
        return maps.get(key);
    }



}
