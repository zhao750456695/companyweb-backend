package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.GoodsEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 商品管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-16 15:01:20
 */
public interface GoodsService extends IService<GoodsEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void insertOnDuplicate(String goodsCode, String goodsName, String goodscategoryId, String goodsTitle, Date updated, String params, String brilliant, Integer category, String listImage, Integer showInIndex);

    void insertOnDuplicate(GoodsEntity goodsEntity);

    List<GoodsEntity> selectGoodsByCode(String goodsCode);

    List<GoodsEntity> queryGoodsInCatIDs(List<String> cat);

    List<GoodsEntity> queryGoodsInCatIDsREGEXP(String idString);

    List<GoodsEntity> queryAllGoods();
}


