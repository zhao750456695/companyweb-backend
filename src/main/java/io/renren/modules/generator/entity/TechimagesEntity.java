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
 * @date 2021-04-26 09:49:22
 */
@Data
@TableName("tb_techimages")
public class TechimagesEntity implements Serializable {
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
	private String descri;
	/**
	 * 
	 */
	private String url;
	/**
	 * 
	 */
	private Date updated;
	/**
	 * 
	 */
	private Integer category;

	private Integer iorder;

}
