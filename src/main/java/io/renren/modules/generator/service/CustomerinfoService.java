package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.CustomerinfoEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-03 18:38:37
 */
public interface CustomerinfoService extends IService<CustomerinfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

