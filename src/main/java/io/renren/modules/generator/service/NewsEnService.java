package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.NewsEnEntity;
import io.renren.modules.generator.entity.NewsEntity;


import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-10 21:40:24
 */
public interface NewsEnService extends IService<NewsEnEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

