package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.GoodsEnEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.generator.entity.GoodsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 商品管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-11 08:40:03
 */
@Mapper
public interface GoodsEnDao extends BaseMapper<GoodsEnEntity> {
    void insertOnDuplicate(@Param("goodsCode") String goodsCode, @Param("goodsName") String goodsName, @Param("goodscategoryId") String goodscategoryId, @Param("goodsTitle") String goodsTitle, @Param("updated") Date updated, @Param("params") String params, @Param("brilliant") String brilliant, @Param("category") Integer category, @Param("listImage") String listImage, @Param("showInIndex") Integer showInIndex);

    List<GoodsEnEntity> selectGoodsByCode(@Param("goodsCode") String goodsCode);
}
