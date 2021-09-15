package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.GoodsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 商品管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-16 15:01:20
 */
@Mapper
public interface GoodsDao extends BaseMapper<GoodsEntity> {
    void insertOnDuplicate(@Param("goodsCode") String goodsCode, @Param("goodsName") String goodsName, @Param("goodscategoryId") String goodscategoryId, @Param("goodsTitle") String goodsTitle, @Param("updated") Date updated, @Param("params") String params, @Param("brilliant") String brilliant, @Param("category") Integer category, @Param("listImage") String listImage, @Param("showInIndex") Integer showInIndex);

    List<GoodsEntity> selectGoodsByCode(@Param("goodsCode") String goodsCode);

    List<GoodsEntity> queryGoodsInCatIDs(@Param("list") List<String> cat);

    List<GoodsEntity> queryGoodsInCatIDsREGEXP(@Param("idString") String idString);
    List<GoodsEntity> queryAllGoods();
}
