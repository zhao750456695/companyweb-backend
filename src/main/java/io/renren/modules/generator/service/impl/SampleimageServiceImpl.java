package io.renren.modules.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.SampleimageDao;
import io.renren.modules.generator.entity.SampleimageEntity;
import io.renren.modules.generator.service.SampleimageService;


@Service("sampleimageService")
public class SampleimageServiceImpl extends ServiceImpl<SampleimageDao, SampleimageEntity> implements SampleimageService {

    @Autowired
    private SampleimageDao sampleimageDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SampleimageEntity> page = this.page(
                new Query<SampleimageEntity>().getPage(params),
                new QueryWrapper<SampleimageEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void insertOnDuplicate(Integer category, String url) {
        sampleimageDao.insertOnDuplicate(category, url);
    }

    @Override
    public void removeByCat(Integer category) {
        sampleimageDao.removeByCat(category);
    }

}