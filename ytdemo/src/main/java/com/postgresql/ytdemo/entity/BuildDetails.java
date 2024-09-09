package com.postgresql.ytdemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name= "build")
public class BuildDetails {

    @Id
    @Column(name = "sno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int SNo;

    @Column(name = "feature_name")
    private String feature_name;

    @Column(name = "build_number")
    private int build_number;

    @Column(name = "last_executed_time")
    private String last_executed_time;

    @Column(name = "build_percentage")
    private int build_percentage;

    public BuildDetails() {
    }

    public BuildDetails(String feature_name, int build_number, String last_executed_time, int build_percentage) {
        this.feature_name = feature_name;
        this.build_number = build_number;
        this.last_executed_time = last_executed_time;
        this.build_percentage = build_percentage;
    }

    public int getSNo() {
        return SNo;
    }

    public void setSNo(int SNo) {
        this.SNo = SNo;
    }

    public String getFeature_name() {
        return feature_name;
    }

    public void setFeature_name(String feature_name) {
        this.feature_name = feature_name;
    }

    public int getBuild_number() {
        return build_number;
    }

    public void setBuild_number(int build_number) {
        this.build_number = build_number;
    }

    public String getLast_executed_time() {
        return last_executed_time;
    }

    public void setLast_executed_time(String last_executed_time) {
        this.last_executed_time = last_executed_time;
    }

    public int getBuild_percentage() {
        return build_percentage;
    }

    public void setBuild_percentage(int build_percentage) {
        this.build_percentage = build_percentage;
    }

    @Override
    public String toString() {
        return "BuildDetails{" +
                "SNo=" + SNo +
                ", feature_name='" + feature_name + '\'' +
                ", build_number=" + build_number +
                ", last_executed_time='" + last_executed_time + '\'' +
                ", build_percentage=" + build_percentage +
                '}';
    }
}
