package io.renren.modules.generator.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class GoodsVO {
    private String goodsName;
    private String goodsCode;
    private String goodsTitle;
    private String updated;
    private List<String> headImage;
    private List<String> detailImage;
    private List<String> listImage;
    private List<Integer> category;
    private List<String> pars;
    private List<String> brill;
    private Integer showInIndex;
}
