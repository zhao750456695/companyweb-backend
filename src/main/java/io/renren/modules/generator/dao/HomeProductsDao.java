package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.HomeProductsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-14 21:42:08
 */
@Mapper
public interface HomeProductsDao extends BaseMapper<HomeProductsEntity> {
	void insertOnDuplicate(@Param("label")String label, @Param("products")String products, @Param("category")Integer category);

	List<HomeProductsEntity> getAll();
}
