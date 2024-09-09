package com.postgresql.ytdemo.controller;

import com.postgresql.ytdemo.entity.BuildDetails;
import com.postgresql.ytdemo.service.BuildService;
import com.postgresql.ytdemo.utility.ExcelGenerator;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class BuildController {
    @Autowired
    private BuildService buildService;

    @GetMapping("/export-to-excel")
    public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=failedBuilds" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<BuildDetails> listOfStudents = buildService.getRecentBuildsBelow95Percent();
        ExcelGenerator generator = new ExcelGenerator(listOfStudents);
        generator.generateExcelFile(response);
    }
}
