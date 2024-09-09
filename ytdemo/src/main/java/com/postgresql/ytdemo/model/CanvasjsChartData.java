package com.postgresql.ytdemo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanvasjsChartData {

    private final int buildPercentLessThan95;
    private final int buildPercentMoreThan95;
    private final List<Map<String, Object>> dataPoints;

    public CanvasjsChartData(int buildPercentLessThan95, int buildPercentMoreThan95) {
        this.buildPercentLessThan95 = buildPercentLessThan95;
        this.buildPercentMoreThan95 = buildPercentMoreThan95;
        this.dataPoints = new ArrayList<>();

        initializeDataPoints();
    }
    private void initializeDataPoints() {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("label", "Build percentage of less than 95% in the last 4 hours.");
        map1.put("y", buildPercentLessThan95);
        dataPoints.add(map1);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("label", "Build percentage of more than 95% in the last 4 hours.");
        map2.put("y", buildPercentMoreThan95);
        dataPoints.add(map2);
    }

    public List<Map<String, Object>> getCanvasjsDataList() {
        return new ArrayList<>(dataPoints);
    }
}
