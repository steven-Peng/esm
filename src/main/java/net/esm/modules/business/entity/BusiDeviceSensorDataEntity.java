package net.esm.modules.business.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 设备传感器上传的数据
 * @author pyl<>
 */
public class BusiDeviceSensorDataEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * id
	 */
	private Integer id;
	
	/**
	 * 设备id
	 */
	private String deviceNumber;
	
	/**
	 * 设备传感器上传的数据
	 */
	private String sensorData;
	
	/**
	 * 入库时间
	 */
	private Date gmtCreate;
	
	/**
	 * 上传时间
	 */
	private Date gmtUpload;
	
	/**
	 * 是否删除 0:否，1:是
	 */
	private Integer isDelete;
	
    /**
     * BusiDeviceSensorDataEntity constructor
     */
	public BusiDeviceSensorDataEntity() {
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

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

    /**
     * setter for sensorData
     * @param sensorData
     */
	public void setSensorData(String sensorData) {
		this.sensorData = sensorData;
	}

    /**
     * getter for sensorData
     */
	public String getSensorData() {
		return sensorData;
	}

    /**
     * setter for gmtCreate
     * @param gmtCreate
     */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

    /**
     * getter for gmtCreate
     */
	public Date getGmtCreate() {
		return gmtCreate;
	}

    /**
     * setter for gmtUpload
     * @param gmtUpload
     */
	public void setGmtUpload(Date gmtUpload) {
		this.gmtUpload = gmtUpload;
	}

    /**
     * getter for gmtUpload
     */
	public Date getGmtUpload() {
		return gmtUpload;
	}

    /**
     * setter for isDelete
     * @param isDelete
     */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

    /**
     * getter for isDelete
     */
	public Integer getIsDelete() {
		return isDelete;
	}

    /**
     * BusiDeviceSensorDataEntity.toString()
     */
    @Override
    public String toString() {
        return "BusiDeviceSensorDataEntity{" +
               "id='" + id + '\'' +
               ", deviceNumber='" + deviceNumber + '\'' +
               ", sensorData='" + sensorData + '\'' +
               ", gmtCreate='" + gmtCreate + '\'' +
               ", gmtUpload='" + gmtUpload + '\'' +
               ", isDelete='" + isDelete + '\'' +
               '}';
    }

}
