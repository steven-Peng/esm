package net.esm.modules.api.controller;

import net.esm.common.utils.JSONUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        String data = "101 0 +0004.000|102 0 +0004.200|103 0 +0004.280|104 0 +0003.540|105 0 +0005.140|106 0 +0003.520|107 0 +0004.219|108 0 +0000.000|";
        String[] sensorDatas = data.split("\\|");
        List<Sensor> sensorList =new ArrayList<>();
        for (String sensorData:sensorDatas){
            String[] datas = sensorData.split(" ");
            Sensor sensor = new Sensor();
            sensor.setSensorNum(datas[0]);
          //  sensor.setData(Double.parseDouble(datas[2]));
            sensorList.add(sensor);
        }
       // Map<String, List<Double>> stringListMap  = sensorList.stream().collect(Collectors.groupingBy(Sensor::getSensorNum,Collectors.mapping(i->i.getData(),Collectors.toList())));

       // System.out.println(JSONUtils.beanToJson(stringListMap));
    }
}
