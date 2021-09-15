package io.renren.modules.generator.service.impl;

import io.renren.modules.generator.entity.NewsEnEntity;
import io.renren.modules.generator.entity.NewsEntity;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.NewsEnDao;
import io.renren.modules.generator.service.NewsEnService;


@Service("newsEnService")
public class NewsEnServiceImpl extends ServiceImpl<NewsEnDao, NewsEnEntity> implements NewsEnService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NewsEnEntity> page = this.page(
                new Query<NewsEnEntity>().getPage(params),
                new QueryWrapper<NewsEnEntity>()
        );

        return new PageUtils(page);
    }

}