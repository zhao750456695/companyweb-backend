package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.IndexEnDao;
import io.renren.modules.generator.entity.IndexEnEntity;
import io.renren.modules.generator.service.IndexEnService;


@Service("indexEnService")
public class IndexEnServiceImpl extends ServiceImpl<IndexEnDao, IndexEnEntity> implements IndexEnService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<IndexEnEntity> page = this.page(
                new Query<IndexEnEntity>().getPage(params),
                new QueryWrapper<IndexEnEntity>()
        );

        return new PageUtils(page);
    }

}