package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.ShowimageEntity;
import io.renren.modules.generator.entity.ShowsEntity;
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
public interface ShowsDao extends BaseMapper<ShowsEntity> {
    void insertShowInfo(@Param("show")ShowsEntity show);
    void updateShowById(@Param("show")ShowsEntity show);
}
