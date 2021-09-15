package io.renren.modules.generator.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.generator.entity.CompanyEnEntity;
import io.renren.modules.generator.entity.CompanyEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-10 21:56:12
 */
@Mapper
public interface CompanyEnDao extends BaseMapper<CompanyEnEntity> {
	
}
