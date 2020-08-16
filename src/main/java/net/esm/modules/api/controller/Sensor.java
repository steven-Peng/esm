package net.esm.modules.api.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sensor {
    private String sensorNum;
    private List<Date> collectTime =new ArrayList<>();
    private List<Double> data = new ArrayList<>();

    public String getSensorNum() {
        return sensorNum;
    }

    public void setSensorNum(String sensorNum) {
        this.sensorNum = sensorNum;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "sensorNum='" + sensorNum + '\'' +
                ", collectTime=" + collectTime +
                ", data=" + data +
                '}';
    }

    public List<Date> getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(List<Date> collectTime) {
        this.collectTime = collectTime;
    }

    public List<Double> getData() {
        return data;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }
}
