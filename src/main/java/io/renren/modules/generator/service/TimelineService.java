package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.TimelineEntity;
import javafx.animation.Timeline;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-13 21:25:35
 */
public interface TimelineService extends IService<TimelineEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void insertOnDuplicate(TimelineEntity timelineEntity);

    List<TimelineEntity> selectByOrder();
}

