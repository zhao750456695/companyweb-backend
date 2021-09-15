package io.renren.modules.generator.service.impl;

import io.renren.modules.generator.entity.CompanyEnEntity;
import io.renren.modules.generator.entity.CompanyEntity;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.CompanyEnDao;
import io.renren.modules.generator.service.CompanyEnService;


@Service("companyEnService")
public class CompanyEnServiceImpl extends ServiceImpl<CompanyEnDao, CompanyEnEntity> implements CompanyEnService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CompanyEnEntity> page = this.page(
                new Query<CompanyEnEntity>().getPage(params),
                new QueryWrapper<CompanyEnEntity>()
        );

        return new PageUtils(page);
    }

}