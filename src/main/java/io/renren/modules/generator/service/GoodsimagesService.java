package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.GoodsimagesEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品图片管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-16 15:01:20
 */
public interface GoodsimagesService extends IService<GoodsimagesEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<GoodsimagesEntity> selectGoodsImageByGoodsCode(String goodsCode);

    void deleteGoodsImageByGoodsCode(String goodsCode);
}

