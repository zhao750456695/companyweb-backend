package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.ParamGroupEnEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-06-23 11:17:51
 */
public interface ParamGroupEnService extends IService<ParamGroupEnEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

