package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.GoodsCategoryEnEntity;
import io.renren.modules.generator.entity.GoodsCategoryEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-10 21:25:37
 */
public interface GoodsCategoryEnService extends IService<GoodsCategoryEnEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

