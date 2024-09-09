package com.postgresql.ytdemo.controller;

import com.postgresql.ytdemo.service.CanvasjsChartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class CanvasjsChartController {

    private final CanvasjsChartService canvasjsChartService;

    public CanvasjsChartController(CanvasjsChartService canvasjsChartService) {
        this.canvasjsChartService = canvasjsChartService;
    }

    @GetMapping("/canvasjschart")
    public String getCanvasjsChartData(Model model) {
        List<Map<String, Object>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData();
        model.addAttribute("dataPointsList", canvasjsDataList);
        System.out.println("dataPointsList "+canvasjsDataList);
        return "chart";
    }
}
