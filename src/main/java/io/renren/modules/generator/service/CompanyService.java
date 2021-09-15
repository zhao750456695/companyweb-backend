package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.CompanyEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-24 12:32:19
 */
public interface CompanyService extends IService<CompanyEntity> {

    PageUtils queryPage(Map<String, Object> params);
    void insertOnDuplicate(Integer category, String content);
    void insertOnDuplicateEN(Integer category, String content);
}

