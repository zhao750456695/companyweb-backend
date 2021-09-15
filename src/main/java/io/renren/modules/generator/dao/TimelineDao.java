package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.TimelineEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-13 21:25:35
 */
@Mapper
public interface TimelineDao extends BaseMapper<TimelineEntity> {
    void insertOnDuplicate(@Param("tyear")String year, @Param("title")String title, @Param("content")String content, @Param("torder")Integer order);

    List<TimelineEntity> selectByOrder();
}
