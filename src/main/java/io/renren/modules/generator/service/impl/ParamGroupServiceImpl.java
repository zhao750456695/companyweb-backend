package io.renren.modules.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.generator.dao.ParamGroupDao;
import io.renren.modules.generator.entity.ParamGroupEntity;
import io.renren.modules.generator.service.ParamGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("paramGroupService")
public class ParamGroupServiceImpl extends ServiceImpl<ParamGroupDao, ParamGroupEntity> implements ParamGroupService {

    @Autowired
    private ParamGroupDao paramGroupDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ParamGroupEntity> page = this.page(
                new Query<ParamGroupEntity>().getPage(params),
                new QueryWrapper<ParamGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<ParamGroupEntity> queryParamGroupList() {
        return paramGroupDao.queryParamGroupList();
    }

    @Override
    public List<ParamGroupEntity> queryParamGroupListEN() {
        return paramGroupDao.queryParamGroupListEN();
    }

}