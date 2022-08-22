package com.mustafa.VideoConverter.controller;

import com.mustafa.VideoConverter.service.ConvertService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/convertApi")
public class ConvertController {

    ConvertService convertService;

    @Autowired
    public ConvertController(ConvertService convertService) {
        this.convertService = convertService;
    }
    //Video süresi ne kadar düşükse o kadar erken işlem biter.
    @PostMapping("/MpegToMp4")
    @ApiOperation(".mpeg uzantılı video dosyasını .mp4'e çevirmek için kullanılır(exp: videoPath= C:\\MediaFiles and videoName= Video)")
    public void convertMpegToMp4(@RequestParam String videoPath, @RequestParam String videoName) throws IOException, InterruptedException {

    //http://localhost:8080/convertApi/MpegToMp4?videoName=Video3&videoPath=c%3A%5CMediaFiles

    convertService.mpegTomp4(videoPath,videoName);

    /*
            long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        long estimatedTime = endTime - startTime;
        double seconds = (double) estimatedTime/1000; // saniyeye çevirmek için 1000'ee böldük.

        return "Video Dönüşümü Bitti Toplam geçen süre saniye cinsinden: " + seconds;
     */
    }

    @PostMapping("/cuttingVideoMp4")
    public void cuttingVideoMp4(@RequestParam String videoPath, @RequestParam String videName, @RequestParam String startHour, @RequestParam String startMinute, @RequestParam String startSecond, @RequestParam String howMuchHour, @RequestParam String howMuchMinute, @RequestParam String howMuchSecond, @RequestParam String async) throws IOException, InterruptedException {


        convertService.cuttingVideoMp4(videoPath,videName,startHour,startMinute,startSecond,howMuchHour,howMuchMinute,howMuchSecond,async);

    }
}
