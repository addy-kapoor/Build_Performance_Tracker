package com.postgresql.ytdemo.dao;

import java.util.List;
import java.util.Map;

import com.postgresql.ytdemo.entity.BuildDetails;
import com.postgresql.ytdemo.model.CanvasjsChartData;
import com.postgresql.ytdemo.service.BuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CanvasjsChartDaoImpl implements CanvasjsChartDao {
    private final BuildService buildService;
    private CanvasjsChartData canvasjsChartData;
    @Autowired
    public CanvasjsChartDaoImpl(BuildService buildService) {
        this.buildService = buildService;
        initializeChartData();
    }
    private void initializeChartData() {
        List<BuildDetails> buildsBelow95 = buildService.getRecentBuildsBelow95Percent();
        List<BuildDetails> buildsAbove95 = buildService.getRecentBuildsAbove95Percent();
        canvasjsChartData = new CanvasjsChartData(buildsBelow95.size(), buildsAbove95.size());
    }
    @Override
    public List<Map<String, Object>> getCanvasjsChartData() {
        return canvasjsChartData.getCanvasjsDataList();
    }
}
