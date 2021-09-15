package io.renren.modules.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.generator.dao.GoodsParamsDao;
import io.renren.modules.generator.entity.GoodsParamsEntity;
import io.renren.modules.generator.service.GoodsParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("goodsParamsService")
public class GoodsParamsServiceImpl extends ServiceImpl<GoodsParamsDao, GoodsParamsEntity> implements GoodsParamsService {

    @Autowired
    private GoodsParamsDao goodsParamsDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsParamsEntity> page = this.page(
                new Query<GoodsParamsEntity>().getPage(params),
                new QueryWrapper<GoodsParamsEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<GoodsParamsEntity> queryParamsList() {
        return goodsParamsDao.queryParamsList();
    }

    @Override
    public List<GoodsParamsEntity> queryParamsListByPGId(Long paramGroupId) {
        return goodsParamsDao.queryParamsListByPGId(paramGroupId);
    }

    @Override
    public List<GoodsParamsEntity> queryParamsListByPGIdEN(Long paramGroupId) {
        return goodsParamsDao.queryParamsListByPGIdEN(paramGroupId);
    }

    @Override
    public void removeAll() {
        goodsParamsDao.removeAll();
    }

}