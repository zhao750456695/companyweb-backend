package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.InfoEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-12 16:10:26
 */
public interface InfoService extends IService<InfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

