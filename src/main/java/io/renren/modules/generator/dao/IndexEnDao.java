package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.IndexEnEntity;
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
 * @date 2021-05-11 17:03:40
 */
@Mapper
public interface IndexEnDao extends BaseMapper<IndexEnEntity> {
    void insertOnDuplicate(@Param("h1")String h1, @Param("h2")String h2, @Param("category")Integer category, @Param("kid")Integer kid);

    void insertOnDuplicateEN(@Param("h1")String h1, @Param("h2")String h2, @Param("category")Integer category, @Param("kid")Integer kid);

    IndexEnEntity selectAbout();

    IndexEnEntity selectAboutEN();

    List<IndexEnEntity> selectAboutItems();

    List<IndexEnEntity> selectAboutNums();

    IndexEnEntity selectNews();

    IndexEnEntity selectProduct();

    IndexEnEntity selectTech();

    List<IndexEnEntity> selectAboutItemsEN();

    List<IndexEnEntity> selectAboutNumsEN();

    IndexEnEntity selectNewsEN();

    IndexEnEntity selectProductEN();

    IndexEnEntity selectTechEN();
}
