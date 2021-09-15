package io.renren.modules.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.CompanyDao;
import io.renren.modules.generator.entity.CompanyEntity;
import io.renren.modules.generator.service.CompanyService;


@Service("companyService")
public class CompanyServiceImpl extends ServiceImpl<CompanyDao, CompanyEntity> implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CompanyEntity> page = this.page(
                new Query<CompanyEntity>().getPage(params),
                new QueryWrapper<CompanyEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void insertOnDuplicate(Integer category, String content) {
        companyDao.insertOnDuplicate(category, content);
    }

    @Override
    public void insertOnDuplicateEN(Integer category, String content) {
            companyDao.insertOnDuplicateEN(category, content);
    }

}