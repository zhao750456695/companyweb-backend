package io.renren.modules.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.TimelineDao;
import io.renren.modules.generator.entity.TimelineEntity;
import io.renren.modules.generator.service.TimelineService;


@Service("timelineService")
public class TimelineServiceImpl extends ServiceImpl<TimelineDao, TimelineEntity> implements TimelineService {

    @Autowired
    private TimelineDao timelineDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TimelineEntity> page = this.page(
                new Query<TimelineEntity>().getPage(params),
                new QueryWrapper<TimelineEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void insertOnDuplicate(TimelineEntity timelineEntity) {
        timelineDao.insertOnDuplicate(timelineEntity.getTyear(), timelineEntity.getTitle(), timelineEntity.getContent(), timelineEntity.getTorder());
    }

    @Override
    public List<TimelineEntity> selectByOrder() {
        return timelineDao.selectByOrder();
    }


}