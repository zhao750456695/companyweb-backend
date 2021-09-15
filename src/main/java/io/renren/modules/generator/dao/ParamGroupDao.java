package io.renren.modules.generator.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.generator.entity.ParamGroupEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-06-18 13:11:46
 */
@Mapper
public interface ParamGroupDao extends BaseMapper<ParamGroupEntity> {
	List<ParamGroupEntity> queryParamGroupList();
	List<ParamGroupEntity> queryParamGroupListEN();
}
