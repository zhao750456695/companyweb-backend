package io.renren.modules.generator.service.impl;

import io.renren.modules.generator.entity.GoodsCategoryEnEntity;
import io.renren.modules.generator.entity.GoodsCategoryEntity;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.GoodsCategoryEnDao;
import io.renren.modules.generator.service.GoodsCategoryEnService;


@Service("goodsCategoryEnService")
public class GoodsCategoryEnServiceImpl extends ServiceImpl<GoodsCategoryEnDao, GoodsCategoryEnEntity> implements GoodsCategoryEnService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsCategoryEnEntity> page = this.page(
                new Query<GoodsCategoryEnEntity>().getPage(params),
                new QueryWrapper<GoodsCategoryEnEntity>()
        );

        return new PageUtils(page);
    }

}