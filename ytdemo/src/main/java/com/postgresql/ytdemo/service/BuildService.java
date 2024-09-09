package com.postgresql.ytdemo.service;
import com.postgresql.ytdemo.entity.BuildDetails;
import com.postgresql.ytdemo.repository.BuildRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildService {
    private BuildRepository buildRepository;

    BuildService(BuildRepository buildRepository){
        this.buildRepository = buildRepository;
    }

    public List<BuildDetails> getRecentBuildsBelow95Percent() {
        return buildRepository.findBuildsBelow95PercentInLastFourHours();
    }

    public List<BuildDetails> getRecentBuildsAbove95Percent() {
        return buildRepository.findBuildsAbove95PercentInLastFourHours();
    }
}
