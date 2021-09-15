package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;

import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.IndexEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-06 09:05:25
 */
public interface IndexService extends IService<IndexEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void insertOnDuplicate(IndexEntity index);

    void insertOnDuplicateEN(IndexEntity index);

    IndexEntity selectAbout();

    IndexEntity selectAboutEN();

    List<IndexEntity> selectAboutItems();

    List<IndexEntity> selectAboutItemsEN();

    List<IndexEntity> selectAboutNums();

    List<IndexEntity> selectAboutNumsEN();

    IndexEntity selectNews();

    IndexEntity selectNewsEN();

    IndexEntity selectProduct();

    IndexEntity selectProductEN();

    IndexEntity selectTech();

    IndexEntity selectTechEN();
}

