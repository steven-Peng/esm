package net.esm.modules.business.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 预警日志表
 * @author pyl<>
 */
public class AlarmLogEntity implements Serializable {
	
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
	 * 上报值
	 */
	private Double value;
	
	/**
	 * 上报时间
	 */
	private Date alarmTime;
	
    /**
     * AlarmLogEntity constructor
     */
	public AlarmLogEntity() {
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
     * setter for value
     * @param value
     */
	public void setValue(Double value) {
		this.value = value;
	}

    /**
     * getter for value
     */
	public Double getValue() {
		return value;
	}

    /**
     * setter for alarmTime
     * @param alarmTime
     */
	public void setAlarmTime(Date alarmTime) {
		this.alarmTime = alarmTime;
	}

    /**
     * getter for alarmTime
     */
	public Date getAlarmTime() {
		return alarmTime;
	}

    /**
     * AlarmLogEntity.toString()
     */
    @Override
    public String toString() {
        return "AlarmLogEntity{" +
               "id='" + id + '\'' +
               ", terminalNumber='" + terminalNumber + '\'' +
               ", sensorNumber='" + sensorNumber + '\'' +
               ", value='" + value + '\'' +
               ", alarmTime='" + alarmTime + '\'' +
               '}';
    }

}
