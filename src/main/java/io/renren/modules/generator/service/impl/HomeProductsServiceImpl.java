package io.renren.modules.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.HomeProductsDao;
import io.renren.modules.generator.entity.HomeProductsEntity;
import io.renren.modules.generator.service.HomeProductsService;


@Service("homeProductsService")
public class HomeProductsServiceImpl extends ServiceImpl<HomeProductsDao, HomeProductsEntity> implements HomeProductsService {

    @Autowired
    private HomeProductsDao homeProductsDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HomeProductsEntity> page = this.page(
                new Query<HomeProductsEntity>().getPage(params),
                new QueryWrapper<HomeProductsEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void insertOnDuplicate(HomeProductsEntity homeProductsEntity) {
        homeProductsDao.insertOnDuplicate(homeProductsEntity.getLabel(), homeProductsEntity.getProducts(), homeProductsEntity.getCategory());
    }

    @Override
    public List<HomeProductsEntity> getAll() {
        return homeProductsDao.getAll();
    }

}