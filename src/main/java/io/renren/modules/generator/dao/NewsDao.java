package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.NewsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-20 19:52:16
 */
@Mapper
public interface NewsDao extends BaseMapper<NewsEntity> {
	
}
