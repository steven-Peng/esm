package net.esm.modules.business.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author pyl<>
 */
@Data
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
}
