package io.renren.modules.generator.service.impl;

import io.renren.modules.generator.entity.WebimagesEnEntity;
import io.renren.modules.generator.entity.WebimagesEntity;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.WebimagesEnDao;
import io.renren.modules.generator.service.WebimagesEnService;


@Service("webimagesEnService")
public class WebimagesEnServiceImpl extends ServiceImpl<WebimagesEnDao, WebimagesEnEntity> implements WebimagesEnService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WebimagesEnEntity> page = this.page(
                new Query<WebimagesEnEntity>().getPage(params),
                new QueryWrapper<WebimagesEnEntity>()
        );

        return new PageUtils(page);
    }

}