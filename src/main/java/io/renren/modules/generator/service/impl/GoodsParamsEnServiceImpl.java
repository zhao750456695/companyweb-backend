package io.renren.modules.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.generator.dao.GoodsParamsEnDao;
import io.renren.modules.generator.entity.GoodsParamsEnEntity;
import io.renren.modules.generator.service.GoodsParamsEnService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("goodsParamsEnService")
public class GoodsParamsEnServiceImpl extends ServiceImpl<GoodsParamsEnDao, GoodsParamsEnEntity> implements GoodsParamsEnService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsParamsEnEntity> page = this.page(
                new Query<GoodsParamsEnEntity>().getPage(params),
                new QueryWrapper<GoodsParamsEnEntity>()
        );

        return new PageUtils(page);
    }

}