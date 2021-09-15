package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.GoodsEnEntity;
import io.renren.modules.generator.entity.GoodsEntity;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 商品管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-11 08:40:03
 */
public interface GoodsEnService extends IService<GoodsEnEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void insertOnDuplicate(String goodsCode, String goodsName, String goodscategoryId, String goodsTitle, Date updated, String params, String brilliant, Integer category, String listImage, Integer showInIndex);

    void insertOnDuplicate(GoodsEnEntity goodsEntity);

    List<GoodsEnEntity> selectGoodsByCode(String goodsCode);
}

