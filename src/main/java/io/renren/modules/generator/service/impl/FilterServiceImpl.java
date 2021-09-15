package io.renren.modules.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.generator.dao.FilterDao;
import io.renren.modules.generator.entity.FilterEntity;
import io.renren.modules.generator.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("filterService")
public class FilterServiceImpl extends ServiceImpl<FilterDao, FilterEntity> implements FilterService {

    @Autowired
    private FilterDao filterDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FilterEntity> page = this.page(
                new Query<FilterEntity>().getPage(params),
                new QueryWrapper<FilterEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<FilterEntity> queryFilterList() {
        return filterDao.queryFilterList();
    }

    @Override
    public List<FilterEntity> queryFilterListEN() {
        return filterDao.queryFilterListEN();
    }

    @Override
    public FilterEntity queryFilterById(String id) {
        return filterDao.queryFilterById(Integer.parseInt(id));
    }

    @Override
    public List<FilterEntity> queryFilterByParentId(String parentId) {
        return filterDao.queryFilterByParentId(Integer.parseInt(parentId));
    }

    @Override
    public void insertParentFilter(FilterEntity parentFilter) {
        filterDao.insertParentFilter(parentFilter);
    }

    @Override
    public void deleteFilterItems(Long parentId) {
        filterDao.deleteFilterItems(parentId);
    }

    @Override
    public void updateParentFilter(Long parentId, String label, Long id) {
        filterDao.updateParentFilter(parentId, label, id);
    }

    @Override
    public void deleteFilterById(Long id) {
        filterDao.deleteFilterById(id);
    }

}