package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.CustomerinfoDao;
import io.renren.modules.generator.entity.CustomerinfoEntity;
import io.renren.modules.generator.service.CustomerinfoService;


@Service("customerinfoService")
public class CustomerinfoServiceImpl extends ServiceImpl<CustomerinfoDao, CustomerinfoEntity> implements CustomerinfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CustomerinfoEntity> page = this.page(
                new Query<CustomerinfoEntity>().getPage(params),
                new QueryWrapper<CustomerinfoEntity>()
        );

        return new PageUtils(page);
    }

}