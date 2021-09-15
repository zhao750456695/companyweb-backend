package io.renren.modules.generator.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.generator.entity.GoodsParamsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-06-18 08:38:15
 */
@Mapper
public interface GoodsParamsDao extends BaseMapper<GoodsParamsEntity> {
	List<GoodsParamsEntity> queryParamsList();

	List<GoodsParamsEntity> queryParamsListByPGId(@Param("paramGroupId") Long paramGroupId);

	List<GoodsParamsEntity> queryParamsListByPGIdEN(@Param("paramGroupId") Long paramGroupId);
	void removeAll();
}
