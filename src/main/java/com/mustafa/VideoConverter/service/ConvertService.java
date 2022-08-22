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
        stringJoiner.add("C:\\ffmpeg\\bin\\ffmpeg.exe");
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
    public void cuttingVideoMp4(String videoPath, String videoName, String startHour, String startMinute, String startSecond, String howMuchHour, String howMuchMinute, String howMuchSecond, String async) throws IOException, InterruptedException {
        stringJoiner.add("C:\\ffmpeg\\bin\\ffmpeg.exe");
        stringJoiner.add("-i");
        stringJoiner.add(videoPath+"\\"+videoName+mp4);
        stringJoiner.add("-ss");

        stringJoiner.add(startHour+":"+startMinute+":"+startSecond);

        stringJoiner.add("-t");

        stringJoiner.add(howMuchHour+":"+howMuchMinute+":"+howMuchSecond);

        stringJoiner.add("-async");

        stringJoiner.add("-"+async);
        stringJoiner.add(videoPath+"\\"+"clip"+videoName+mp4);

        String ffcommand = stringJoiner.toString();
        //System.out.println(ffcommand);

        Runtime.getRuntime().exec(ffcommand);


    }
}
