package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.GoodsCategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-19 09:51:16
 */
@Mapper
public interface GoodsCategoryDao extends BaseMapper<GoodsCategoryEntity> {
    List<GoodsCategoryEntity> queryCategoryList();
    List<GoodsCategoryEntity> queryCategoryListEN();
    void removeAll();
}
