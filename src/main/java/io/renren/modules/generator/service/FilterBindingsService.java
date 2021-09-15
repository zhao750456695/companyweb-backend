package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.FilterBindingsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-06-17 10:31:41
 */
public interface FilterBindingsService extends IService<FilterBindingsEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void insertOnDuplicate(Integer categoryId, String filterIds);
    void insertOnDuplicateEN(Integer categoryId, String filterIds);
    List<FilterBindingsEntity> queryFilterBindingList();

    List<FilterBindingsEntity> queryFilterBindingListEN();

    List<FilterBindingsEntity> queryFilterListByCateId(String categoryId);
}

