package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.FilterEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-06-15 16:24:22
 */
public interface FilterService extends IService<FilterEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<FilterEntity> queryFilterList();

    List<FilterEntity> queryFilterListEN();

    FilterEntity queryFilterById(String id);

    List<FilterEntity> queryFilterByParentId(String parentId);

    void insertParentFilter(FilterEntity parentFilter);

    void deleteFilterItems(Long parentId);

    void updateParentFilter(Long parentId, String label, Long id);

    void deleteFilterById(Long id);
}

