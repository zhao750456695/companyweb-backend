package io.renren.modules.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.generator.dao.FilterBindingsDao;
import io.renren.modules.generator.entity.FilterBindingsEntity;
import io.renren.modules.generator.service.FilterBindingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("filterBindingsService")
public class FilterBindingsServiceImpl extends ServiceImpl<FilterBindingsDao, FilterBindingsEntity> implements FilterBindingsService {

    @Autowired
    private FilterBindingsDao filterBindingsDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FilterBindingsEntity> page = this.page(
                new Query<FilterBindingsEntity>().getPage(params),
                new QueryWrapper<FilterBindingsEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void insertOnDuplicate(Integer categoryId, String filterIds) {
        filterBindingsDao.insertOnDuplicate(categoryId, filterIds);
    }

    @Override
    public void insertOnDuplicateEN(Integer categoryId, String filterIds) {
        filterBindingsDao.insertOnDuplicateEN(categoryId, filterIds);
    }

    @Override
    public List<FilterBindingsEntity> queryFilterBindingList() {
        return filterBindingsDao.queryFilterBindingList();
    }

    @Override
    public List<FilterBindingsEntity> queryFilterBindingListEN() {
        return filterBindingsDao.queryFilterBindingListEN();
    }

    @Override
    public List<FilterBindingsEntity> queryFilterListByCateId(String categoryId) {
        return filterBindingsDao.queryFilterListByCateId(categoryId);
    }

}