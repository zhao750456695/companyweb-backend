package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.GoodsParamsEnEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-06-23 11:22:47
 */
public interface GoodsParamsEnService extends IService<GoodsParamsEnEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

