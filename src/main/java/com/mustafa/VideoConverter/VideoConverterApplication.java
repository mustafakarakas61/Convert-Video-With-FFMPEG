package com.mustafa.VideoConverter;

import com.mustafa.VideoConverter.controller.ConvertController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class VideoConverterApplication {


	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(VideoConverterApplication.class, args);
	}

}
