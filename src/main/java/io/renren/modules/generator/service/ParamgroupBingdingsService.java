package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.ParamgroupBingdingsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-06-18 18:30:43
 */
public interface ParamgroupBingdingsService extends IService<ParamgroupBingdingsEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ParamgroupBingdingsEntity> queryParamGroupBindingList();

    List<ParamgroupBingdingsEntity> queryParamGroupBindingListEN();

    void insertOnDuplicate(Long categoryId, Long paramGroupId);

    void insertOnDuplicateEN(Long categoryId, Long paramGroupId);

    ParamgroupBingdingsEntity getByCategoryId(Long categoryId);
}

