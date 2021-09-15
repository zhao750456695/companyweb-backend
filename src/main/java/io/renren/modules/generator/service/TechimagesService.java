package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.TechimagesEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-26 09:49:22
 */
public interface TechimagesService extends IService<TechimagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

