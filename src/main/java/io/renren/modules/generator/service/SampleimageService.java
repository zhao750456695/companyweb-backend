package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.SampleimageEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-25 17:25:57
 */
public interface SampleimageService extends IService<SampleimageEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void insertOnDuplicate(Integer category, String url);

    void removeByCat(Integer category);
}

