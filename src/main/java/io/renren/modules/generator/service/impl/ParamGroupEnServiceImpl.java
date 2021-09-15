package io.renren.modules.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.generator.dao.ParamGroupEnDao;
import io.renren.modules.generator.entity.ParamGroupEnEntity;

import io.renren.modules.generator.service.ParamGroupEnService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("paramGroupEnService")
public class ParamGroupEnServiceImpl extends ServiceImpl<ParamGroupEnDao, ParamGroupEnEntity> implements ParamGroupEnService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ParamGroupEnEntity> page = this.page(
                new Query<ParamGroupEnEntity>().getPage(params),
                new QueryWrapper<ParamGroupEnEntity>()
        );

        return new PageUtils(page);
    }

}