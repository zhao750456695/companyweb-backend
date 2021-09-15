package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.ShowimageEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-09 18:45:26
 */
public interface ShowimageService extends IService<ShowimageEntity> {

    PageUtils queryPage(Map<String, Object> params);
    void insertOnDuplicate(Integer showId, String url);
    List<ShowimageEntity> getByShowId(Integer id);
    void delImageByShowId(Integer showId);
}

