package io.renren.modules.generator.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.generator.entity.ParamgroupBingdingsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-06-18 18:30:43
 */
@Mapper
public interface ParamgroupBingdingsDao extends BaseMapper<ParamgroupBingdingsEntity> {
	List<ParamgroupBingdingsEntity> queryParamGroupBindingList();

	List<ParamgroupBingdingsEntity> queryParamGroupBindingListEN();

	void insertOnDuplicate(@Param("categoryId")Long categoryId, @Param("paramGroupId")Long paramGroupId);

	void insertOnDuplicateEN(@Param("categoryId")Long categoryId, @Param("paramGroupId")Long paramGroupId);

	ParamgroupBingdingsEntity getByCategoryId(@Param("categoryId")Long categoryId);
}
