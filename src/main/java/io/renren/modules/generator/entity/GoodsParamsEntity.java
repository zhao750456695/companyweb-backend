package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-06-18 13:11:46
 */
@Data
@TableName("tb_goods_params")
public class GoodsParamsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long parentId;
	/**
	 * 
	 */
	private String label;
	/**
	 * 
	 */
	private Long paramGroupId;

	private boolean showInGoods;

}
