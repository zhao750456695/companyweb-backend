package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.GoodsimagesEnEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.generator.entity.GoodsimagesEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品图片管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-11 09:12:56
 */
@Mapper
public interface GoodsimagesEnDao extends BaseMapper<GoodsimagesEnEntity> {

    List<GoodsimagesEnEntity> selectGoodsImageByGoodsCode(@Param("code") String goodsCode);

    void deleteGoodsImageByGoodsCode(@Param("code") String goodsCode);

}