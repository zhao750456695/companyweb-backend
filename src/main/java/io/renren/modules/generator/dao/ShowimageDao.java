package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.ShowimageEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-09 18:45:26
 */
@Mapper
public interface ShowimageDao extends BaseMapper<ShowimageEntity> {
    void insertOnDuplicate(@Param("showId")Integer showId, @Param("url")String url);
    List<ShowimageEntity> getByShowId(@Param("showId")Integer id);
    void delImageByShowId(@Param("showId") Integer showId);
}
