package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.IndexEnEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-11 17:03:40
 */
public interface IndexEnService extends IService<IndexEnEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

