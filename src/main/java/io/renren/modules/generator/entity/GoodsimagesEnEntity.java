package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品图片管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-11 09:12:56
 */
@Data
@TableName("tb_goodsimages_en")
public class GoodsimagesEnEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品编号
	 */
	private String goodsCode;
	/**
	 * 
	 */
	@TableId
	private Long imageId;
	/**
	 * 图片名称
	 */
	private String imageName;
	/**
	 * 图片链接
	 */
	private String imageUrl;
	/**
	 * 图片种类
	 */
	private Integer imageCategory;
	/**
	 * 图片在该类中的展示顺序
	 */
	private Integer imageCategorySort;
	/**
	 * 上传时间
	 */
	private Date updated;

}
