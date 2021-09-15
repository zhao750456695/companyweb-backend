package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-03 18:38:37
 */
@Data
@TableName("tb_customerinfo")
public class CustomerinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String iname;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private String phone;
	/**
	 * 
	 */
	private String content;
	/**
	 * 
	 */
	private Date dt;
	/**
	 * 
	 */
	private Boolean isread;

}
