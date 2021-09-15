package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-11 08:40:03
 */
@Data
@TableName("tb_goods_en")
public class GoodsEnEntity implements Serializable {
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
	/**
	 * 参数
	 */
	private String params;
	/**
	 * 亮点
	 */
	private String brilliant;
	/**
	 * 商品列表图片
	 */
	private String listImage;
	/**
	 * 是否在首页展示
	 */
	private Integer showInIndex;
	/**
	 * 
	 */
	private Integer category;

}
