package net.esm.modules.business.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 设备表
 * @author pyl<>
 */
public class BusiDeviceEntity implements Serializable {
	
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
	 * 远程IP端口
	 */
	private String remoteAddress;
	
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	
	/**
	 * 修改时间
	 */
	private Date gmtModified;
	
	/**
	 * 是否删除 0:否，1:是
	 */
	private Integer isDelete;
	
    /**
     * DeviceDataOutput constructor
     */
	public BusiDeviceEntity() {
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
     * setter for number
     * @param number
     */
	public void setNumber(String number) {
		this.number = number;
	}

    /**
     * getter for number
     */
	public String getNumber() {
		return number;
	}

    /**
     * setter for name
     * @param name
     */
	public void setName(String name) {
		this.name = name;
	}

    /**
     * getter for name
     */
	public String getName() {
		return name;
	}

    /**
     * setter for enable
     * @param enable
     */
	public void setEnable(Integer enable) {
		this.enable = enable;
	}

    /**
     * getter for enable
     */
	public Integer getEnable() {
		return enable;
	}

    /**
     * setter for status
     * @param status
     */
	public void setStatus(Integer status) {
		this.status = status;
	}

    /**
     * getter for status
     */
	public Integer getStatus() {
		return status;
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
     * setter for gmtModified
     * @param gmtModified
     */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

    /**
     * getter for gmtModified
     */
	public Date getGmtModified() {
		return gmtModified;
	}

	public String getRemoteAddress() {
		return remoteAddress;
	}

	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
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
     * DeviceDataOutput.toString()
     */
    @Override
    public String toString() {
        return "DeviceDataOutput{" +
               "id='" + id + '\'' +
               ", number='" + number + '\'' +
               ", name='" + name + '\'' +
               ", enable='" + enable + '\'' +
               ", status='" + status + '\'' +
               ", gmtCreate='" + gmtCreate + '\'' +
               ", gmtModified='" + gmtModified + '\'' +
               ", isDelete='" + isDelete + '\'' +
               '}';
    }

}
