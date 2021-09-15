/**
 * projectName: renren-fast
 * fileName: GoodsBO.java
 * packageName: io.renren.modules.generator.bo
 * date: 2021-04-29 9:24
 * copyright(c) 2017-2020 xxx公司
 */
package io.renren.modules.generator.bo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class GoodsBO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
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

    private String[] params;

    private String[] brilliant;

    private String listImage;

    private Integer showInIndex;
}
