package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.GoodsimagesEnEntity;
import io.renren.modules.generator.entity.GoodsimagesEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品图片管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-11 09:12:56
 */
public interface GoodsimagesEnService extends IService<GoodsimagesEnEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<GoodsimagesEnEntity> selectGoodsImageByGoodsCode(String goodsCode);

    void deleteGoodsImageByGoodsCode(String goodsCode);
}

