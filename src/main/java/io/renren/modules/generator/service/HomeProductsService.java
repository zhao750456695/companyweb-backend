package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.HomeProductsEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-14 21:42:08
 */
public interface HomeProductsService extends IService<HomeProductsEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void insertOnDuplicate(HomeProductsEntity homeProductsEntity);

    List<HomeProductsEntity> getAll();
}

