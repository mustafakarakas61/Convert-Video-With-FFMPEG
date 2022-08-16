package com.mustafa.VideoConverter.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.StringJoiner;

@Service
public class ConvertService {

    //ffmpeg -i C:\MediaFiles\Video.mpeg -vsync vfr output.mp4

     StringJoiner stringJoiner = new StringJoiner(" ");

    String mpeg = ".mpeg";
    String mp4 = ".mp4";

    public boolean mpegTomp4(String videoPath, String videoName) throws IOException, InterruptedException {//mpeg uzantılı konumla aynı yere çıkarılacak
        stringJoiner.add("C:\\ffmpeg\\bin\\ffmpeg");
        stringJoiner.add("-i");
        stringJoiner.add(videoPath + "\\" + videoName + mpeg);
        stringJoiner.add("-vsync");
        stringJoiner.add("vfr");
        stringJoiner.add(videoPath + "\\" + "JAVA_" + videoName + mp4);

        String ffcommand = stringJoiner.toString();



        System.out.println(ffcommand);

        Process process = Runtime.getRuntime().exec(ffcommand);


        return process.waitFor() == 0;

    }
}
