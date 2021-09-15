package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.TechimagesDao;
import io.renren.modules.generator.entity.TechimagesEntity;
import io.renren.modules.generator.service.TechimagesService;


@Service("techimagesService")
public class TechimagesServiceImpl extends ServiceImpl<TechimagesDao, TechimagesEntity> implements TechimagesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TechimagesEntity> page = this.page(
                new Query<TechimagesEntity>().getPage(params),
                new QueryWrapper<TechimagesEntity>()
        );

        return new PageUtils(page);
    }

}