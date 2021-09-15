package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.GoodsCategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-19 09:51:16
 */
public interface GoodsCategoryService extends IService<GoodsCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<GoodsCategoryEntity> queryGoodsCategoryList();

    List<GoodsCategoryEntity> queryGoodsCategoryListEN();

    void removeAll();
}

