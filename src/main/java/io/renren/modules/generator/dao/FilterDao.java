package io.renren.modules.generator.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.generator.entity.FilterEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-06-15 16:24:22
 */
@Mapper
public interface FilterDao extends BaseMapper<FilterEntity> {
	List<FilterEntity> queryFilterList();

	List<FilterEntity> queryFilterListEN();

	FilterEntity queryFilterById(@Param("id")Integer id);

    List<FilterEntity> queryFilterByParentId(@Param("parentId")Integer parentId);

	void insertParentFilter(@Param("parentFilter")FilterEntity parentFilter);

	void deleteFilterItems(@Param("parentId")Long parentId);

	void updateParentFilter(@Param("parentId")Long parentId, @Param("label")String label, @Param("id")Long id);

	void deleteFilterById(@Param("id")Long id);
}
