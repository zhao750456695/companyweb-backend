package io.renren.modules.generator.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.generator.entity.FilterBindingsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-06-17 10:31:41
 */
@Mapper
public interface FilterBindingsDao extends BaseMapper<FilterBindingsEntity> {
    void insertOnDuplicate(@Param("categoryId")Integer categoryId, @Param("filterIds")String filterIds);
    void insertOnDuplicateEN(@Param("categoryId")Integer categoryId, @Param("filterIds")String filterIds);
    List<FilterBindingsEntity> queryFilterBindingList();
    List<FilterBindingsEntity> queryFilterBindingListEN();
    List<FilterBindingsEntity> queryFilterListByCateId(@Param("cateId")String categoryId);
}
