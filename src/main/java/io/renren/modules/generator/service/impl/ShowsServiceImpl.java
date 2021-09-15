package io.renren.modules.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.ShowsDao;
import io.renren.modules.generator.entity.ShowsEntity;
import io.renren.modules.generator.service.ShowsService;


@Service("showsService")
public class ShowsServiceImpl extends ServiceImpl<ShowsDao, ShowsEntity> implements ShowsService {

    @Autowired
    private ShowsDao showsDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ShowsEntity> page = this.page(
                new Query<ShowsEntity>().getPage(params),
                new QueryWrapper<ShowsEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void insertShowInfo(ShowsEntity show) {
        showsDao.insertShowInfo(show);
    }

    @Override
    public void updateShowById(ShowsEntity show) {
        showsDao.updateShowById(show);
    }

}