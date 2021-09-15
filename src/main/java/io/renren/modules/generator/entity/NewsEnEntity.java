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
 * @date 2021-05-10 21:40:24
 */
@Data
@TableName("tb_news_en")
public class NewsEnEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ddd
	 */
	private String title;
	/**
	 * 发布日期
	 */
	private Date updated;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 描述
	 */
	private String descri;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String cover;

}
