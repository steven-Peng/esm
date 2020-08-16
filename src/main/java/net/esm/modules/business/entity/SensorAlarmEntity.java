package net.esm.modules.business.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 预警表
 * @author pyl<>
 */
public class SensorAlarmEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * id
	 */
	private Integer id;
	
	/**
	 * 设备编码
	 */
	private String terminalNumber;
	
	/**
	 * 传感器编号
	 */
	private String sensorNumber;
	
	/**
	 * 下限值
	 */
	private Double lowValue;
	
	/**
	 * 上限值
	 */
	private Double highValue;
	
    /**
     * SensorAlarmEntity constructor
     */
	public SensorAlarmEntity() {
		super();
	}

    /**
     * setter for id
     * @param id
     */
	public void setId(Integer id) {
		this.id = id;
	}

    /**
     * getter for id
     */
	public Integer getId() {
		return id;
	}

    /**
     * setter for terminalNumber
     * @param terminalNumber
     */
	public void setTerminalNumber(String terminalNumber) {
		this.terminalNumber = terminalNumber;
	}

    /**
     * getter for terminalNumber
     */
	public String getTerminalNumber() {
		return terminalNumber;
	}

    /**
     * setter for sensorNumber
     * @param sensorNumber
     */
	public void setSensorNumber(String sensorNumber) {
		this.sensorNumber = sensorNumber;
	}

    /**
     * getter for sensorNumber
     */
	public String getSensorNumber() {
		return sensorNumber;
	}

    /**
     * setter for lowValue
     * @param lowValue
     */
	public void setLowValue(Double lowValue) {
		this.lowValue = lowValue;
	}

    /**
     * getter for lowValue
     */
	public Double getLowValue() {
		return lowValue;
	}

    /**
     * setter for highValue
     * @param highValue
     */
	public void setHighValue(Double highValue) {
		this.highValue = highValue;
	}

    /**
     * getter for highValue
     */
	public Double getHighValue() {
		return highValue;
	}

    /**
     * SensorAlarmEntity.toString()
     */
    @Override
    public String toString() {
        return "SensorAlarmEntity{" +
               "id='" + id + '\'' +
               ", terminalNumber='" + terminalNumber + '\'' +
               ", sensorNumber='" + sensorNumber + '\'' +
               ", lowValue='" + lowValue + '\'' +
               ", highValue='" + highValue + '\'' +
               '}';
    }

}
