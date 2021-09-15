package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * 商品管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-16 15:01:20
 */
@Data
@TableName("tb_goods")
public class GoodsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long goodsId;
	/**
	 * 商品名
	 */
	private String goodsName;
	/**
	 * 商品编号
	 */
	private String goodsCode;
	/**
	 * 种类id
	 */
	private String goodscategoryId;

	/**
	 * 商品宣传标题
	 */
	private String goodsTitle;
	/**
	 * 上传时间
	 */
	private Date updated;

	private String params;

	private String brilliant;

	private String listImage;

	private Integer showInIndex;

	private Integer category;
}
