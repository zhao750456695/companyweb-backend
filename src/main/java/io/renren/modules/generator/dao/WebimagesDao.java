package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.WebimagesEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-24 21:09:15
 */
@Mapper
public interface WebimagesDao extends BaseMapper<WebimagesEntity> {
    List<WebimagesEntity> getPictureListByCategoryId(@Param("categoryId")Integer categoryId);
    void deletePictureListByCategoryId(@Param("categoryId")Integer categoryId);
    void insertOnDuplicate(@Param("link")String link, @Param("url")String url, @Param("category")Integer category);
}
