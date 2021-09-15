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

import io.renren.modules.generator.dao.GoodsCategoryDao;
import io.renren.modules.generator.entity.GoodsCategoryEntity;
import io.renren.modules.generator.service.GoodsCategoryService;


@Service("goodsCategoryService")
public class GoodsCategoryServiceImpl extends ServiceImpl<GoodsCategoryDao, GoodsCategoryEntity> implements GoodsCategoryService {

    @Autowired
    private GoodsCategoryDao goodsCategoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsCategoryEntity> page = this.page(
                new Query<GoodsCategoryEntity>().getPage(params),
                new QueryWrapper<GoodsCategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<GoodsCategoryEntity> queryGoodsCategoryList() {
        return goodsCategoryDao.queryCategoryList();
    }

    @Override
    public List<GoodsCategoryEntity> queryGoodsCategoryListEN() {
            return goodsCategoryDao.queryCategoryListEN();
    }

    @Override
    public void removeAll() {
        goodsCategoryDao.removeAll();
    }

}