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
 * @date 2021-05-10 21:03:42
 */
@Data
@TableName("tb_webimages_en")
public class WebimagesEnEntity implements Serializable {
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
	private Integer category;
	/**
	 * 
	 */
	private String url;
	/**
	 * 
	 */
	private Integer iorder;
	/**
	 * 
	 */
	private String bigTitle;
	/**
	 * 
	 */
	private String smallTitle;
	/**
	 * 
	 */
	private String link;
	/**
	 * 
	 */
	private Date updated;

}
