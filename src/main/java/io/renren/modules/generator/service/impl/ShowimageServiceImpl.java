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

import io.renren.modules.generator.dao.ShowimageDao;
import io.renren.modules.generator.entity.ShowimageEntity;
import io.renren.modules.generator.service.ShowimageService;


@Service("showimageService")
public class ShowimageServiceImpl extends ServiceImpl<ShowimageDao, ShowimageEntity> implements ShowimageService {

    @Autowired
    private ShowimageDao showimageDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ShowimageEntity> page = this.page(
                new Query<ShowimageEntity>().getPage(params),
                new QueryWrapper<ShowimageEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void insertOnDuplicate(Integer showId, String url) {
        showimageDao.insertOnDuplicate(showId, url);
    }

    @Override
    public List<ShowimageEntity> getByShowId(Integer id) {
        return showimageDao.getByShowId(id);
    }

    @Override
    public void delImageByShowId(Integer showId) {
        showimageDao.delImageByShowId(showId);
    }

}