package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.CompanyEnEntity;
import io.renren.modules.generator.entity.CompanyEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-10 21:56:12
 */
public interface CompanyEnService extends IService<CompanyEnEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

