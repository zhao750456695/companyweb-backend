package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.CompanyEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-24 12:32:19
 */
@Mapper
public interface CompanyDao extends BaseMapper<CompanyEntity> {
    void insertOnDuplicate(@Param("category")Integer category, @Param("content")String content);
    void insertOnDuplicateEN(@Param("category")Integer category, @Param("content")String content);
}
