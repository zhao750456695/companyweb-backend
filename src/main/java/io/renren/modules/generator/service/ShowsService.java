package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.ShowsEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-09 18:45:26
 */
public interface ShowsService extends IService<ShowsEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void insertShowInfo(ShowsEntity show);

    void updateShowById(ShowsEntity show);
}

