package com.neuedu.utils;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MusicUtil {

    public static void getMUsic(String musicPath){
        try {
            InputStream is=new FileInputStream(musicPath);
            AudioStream as=new AudioStream(is);
            AudioPlayer.player.start(as);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
