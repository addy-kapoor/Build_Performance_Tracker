package com.postgresql.ytdemo.repository;

import com.postgresql.ytdemo.entity.BuildDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildRepository extends JpaRepository<BuildDetails, Integer> {
    @Query(value = """
       SELECT * FROM build 
       WHERE build_percentage < 95 
         AND to_timestamp(last_executed_time, 'YYYY-MM-DD HH24:MI:SS') >= NOW() - INTERVAL '4 HOURS'
       """, nativeQuery = true)
    List<BuildDetails> findBuildsBelow95PercentInLastFourHours();

    @Query(value = """
       SELECT * FROM build 
       WHERE build_percentage >= 95 
         AND to_timestamp(last_executed_time, 'YYYY-MM-DD HH24:MI:SS') >= NOW() - INTERVAL '4 HOURS'
       """, nativeQuery = true)
    List<BuildDetails> findBuildsAbove95PercentInLastFourHours();

}
