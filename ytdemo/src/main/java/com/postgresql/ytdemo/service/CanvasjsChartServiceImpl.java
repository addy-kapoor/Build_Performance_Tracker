package com.postgresql.ytdemo.service;

import com.postgresql.ytdemo.dao.CanvasjsChartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CanvasjsChartServiceImpl implements CanvasjsChartService{
    private CanvasjsChartDao canvasjsChartDao;

    CanvasjsChartServiceImpl(CanvasjsChartDao canvasjsChartDao){
        this.canvasjsChartDao = canvasjsChartDao;
    }

    public void setCanvasjsChartDao(CanvasjsChartDao canvasjsChartDao) {
        this.canvasjsChartDao = canvasjsChartDao;
    }

    @Override
    public List<Map<String, Object>> getCanvasjsChartData() {
        return canvasjsChartDao.getCanvasjsChartData();
    }
}
