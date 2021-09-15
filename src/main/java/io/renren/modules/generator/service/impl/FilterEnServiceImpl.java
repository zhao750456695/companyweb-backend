package io.renren.modules.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.generator.dao.FilterEnDao;
import io.renren.modules.generator.entity.FilterEnEntity;
import io.renren.modules.generator.service.FilterEnService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("filterEnService")
public class FilterEnServiceImpl extends ServiceImpl<FilterEnDao, FilterEnEntity> implements FilterEnService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FilterEnEntity> page = this.page(
                new Query<FilterEnEntity>().getPage(params),
                new QueryWrapper<FilterEnEntity>()
        );

        return new PageUtils(page);
    }

}