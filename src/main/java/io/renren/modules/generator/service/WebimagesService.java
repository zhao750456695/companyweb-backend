package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.WebimagesEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-24 21:09:15
 */
public interface WebimagesService extends IService<WebimagesEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<WebimagesEntity> getPictureListByCategoryId(Integer categoryId);

    void deletePictureListByCategoryId(Integer categoryId);

    void insertOnDuplicate(String link, String url, Integer category);
}

