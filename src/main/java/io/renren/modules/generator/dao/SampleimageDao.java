package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.SampleimageEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-25 17:25:57
 */
@Mapper
public interface SampleimageDao extends BaseMapper<SampleimageEntity> {
	public void insertOnDuplicate(@Param("category")Integer category, @Param("url")String url);
	void removeByCat(@Param("cat")Integer category);
}
