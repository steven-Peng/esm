package net.esm.modules.business.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 * @author pyl<>
 */
public class DeviceDataOutput implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 设备id
	 */
	private Integer id;
	
	/**
	 * 设备编码
	 */
	private String number;
	
	/**
	 * 设备名称
	 */
	private String name;
	
	/**
	 * 是否可用 0:禁用，1:正常
	 */
	private Integer enable;
	
	/**
	 * 状态 0:掉线，1:在线
	 */
	private Integer status;
	
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	
	/**
	 * 修改时间
	 */
	private Date gmtModified;

	private String sensorData;

	private Date gmtUpload;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public String getSensorData() {
		return sensorData;
	}

	public void setSensorData(String sensorData) {
		this.sensorData = sensorData;
	}

	public Date getGmtUpload() {
		return gmtUpload;
	}

	public void setGmtUpload(Date gmtUpload) {
		this.gmtUpload = gmtUpload;
	}
}
