package io.renren.modules.generator.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import io.renren.modules.generator.entity.IndexEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-06 09:05:25
 */
@Mapper
public interface IndexDao extends BaseMapper<IndexEntity> {
    void insertOnDuplicate(@Param("h1")String h1, @Param("h2")String h2, @Param("category")Integer category, @Param("kid")Integer kid);

    void insertOnDuplicateEN(@Param("h1")String h1, @Param("h2")String h2, @Param("category")Integer category, @Param("kid")Integer kid);

    IndexEntity selectAbout();

    IndexEntity selectAboutEN();

    List<IndexEntity> selectAboutItems();

    List<IndexEntity> selectAboutNums();

    IndexEntity selectNews();

    IndexEntity selectProduct();

    IndexEntity selectTech();

    List<IndexEntity> selectAboutItemsEN();

    List<IndexEntity> selectAboutNumsEN();

    IndexEntity selectNewsEN();

    IndexEntity selectProductEN();

    IndexEntity selectTechEN();
}
