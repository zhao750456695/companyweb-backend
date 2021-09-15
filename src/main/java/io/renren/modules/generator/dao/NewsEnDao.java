package io.renren.modules.generator.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.generator.entity.NewsEnEntity;
import io.renren.modules.generator.entity.NewsEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-10 21:40:24
 */
@Mapper
public interface NewsEnDao extends BaseMapper<NewsEnEntity> {
	
}
