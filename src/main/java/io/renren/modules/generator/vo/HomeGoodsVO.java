/**
 * projectName: renren-fast
 * fileName: HomeGoodsVO.java
 * packageName: io.renren.modules.generator.vo
 * date: 2021-09-12 12:07
 * copyright(c) 2017-2020 xxx公司
 */
package io.renren.modules.generator.vo;

import io.renren.modules.generator.entity.FilterEntity;
import io.renren.modules.generator.entity.GoodsEntity;
import lombok.Data;

import java.util.List;

@Data
public class HomeGoodsVO {
    private FilterEntity filter;
    private List<GoodsEntity> goodsList;
}
