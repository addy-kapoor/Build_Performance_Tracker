package com.postgresql.ytdemo;

import com.postgresql.ytdemo.entity.BuildDetails;
import com.postgresql.ytdemo.model.CanvasjsChartData;
import com.postgresql.ytdemo.service.BuildService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class YtdemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(YtdemoApplication.class, args);
	}

}
