package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.WebimagesEnEntity;
import io.renren.modules.generator.entity.WebimagesEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-10 21:03:42
 */
public interface WebimagesEnService extends IService<WebimagesEnEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

