package io.renren.modules.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.generator.dao.ParamgroupBingdingsDao;
import io.renren.modules.generator.entity.ParamgroupBingdingsEntity;
import io.renren.modules.generator.service.ParamgroupBingdingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("paramgroupBingdingsService")
public class ParamgroupBingdingsServiceImpl extends ServiceImpl<ParamgroupBingdingsDao, ParamgroupBingdingsEntity> implements ParamgroupBingdingsService {

    @Autowired
    private ParamgroupBingdingsDao paramgroupBingdingsDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ParamgroupBingdingsEntity> page = this.page(
                new Query<ParamgroupBingdingsEntity>().getPage(params),
                new QueryWrapper<ParamgroupBingdingsEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<ParamgroupBingdingsEntity> queryParamGroupBindingList() {
        return paramgroupBingdingsDao.queryParamGroupBindingList();
    }

    @Override
    public List<ParamgroupBingdingsEntity> queryParamGroupBindingListEN() {
        return paramgroupBingdingsDao.queryParamGroupBindingListEN();
    }

    @Override
    public void insertOnDuplicate(Long categoryId, Long paramGroupId) {
        paramgroupBingdingsDao.insertOnDuplicate(categoryId, paramGroupId);
    }

    @Override
    public void insertOnDuplicateEN(Long categoryId, Long paramGroupId) {
        paramgroupBingdingsDao.insertOnDuplicateEN(categoryId, paramGroupId);
    }

    @Override
    public ParamgroupBingdingsEntity getByCategoryId(Long categoryId) {
        return paramgroupBingdingsDao.getByCategoryId(categoryId);
    }

}