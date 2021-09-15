package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.ParamGroupEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-06-18 13:11:46
 */
public interface ParamGroupService extends IService<ParamGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ParamGroupEntity> queryParamGroupList();

    List<ParamGroupEntity> queryParamGroupListEN();
}

