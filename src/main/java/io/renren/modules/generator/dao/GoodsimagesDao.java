package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.GoodsimagesEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品图片管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-16 15:01:20
 */
@Mapper
public interface GoodsimagesDao extends BaseMapper<GoodsimagesEntity> {
	List<GoodsimagesEntity> selectGoodsImageByGoodsCode(@Param("code") String goodsCode);

	void deleteGoodsImageByGoodsCode(@Param("code") String goodsCode);
}
