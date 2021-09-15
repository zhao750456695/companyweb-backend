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
 * @date 2021-05-11 17:03:40
 */
@Data
@TableName("tb_index_en")
public class IndexEnEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String h1;
	/**
	 * 
	 */
	private String h2;
	/**
	 * 
	 */
	private Integer category;
	/**
	 * 
	 */
	private Integer kid;

}
