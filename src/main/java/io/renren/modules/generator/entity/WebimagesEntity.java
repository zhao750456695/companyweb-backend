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
 * @date 2021-04-24 21:09:15
 */
@Data
@TableName("tb_webimages")
public class WebimagesEntity implements Serializable {
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

	private String bigTitle;

	private String smallTitle;

	private Integer iorder;

	private Date updated;

	private String link;
}
