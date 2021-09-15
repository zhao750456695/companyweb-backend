package io.renren.modules.generator.service.impl;

import io.renren.modules.generator.entity.GoodsimagesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.GoodsimagesEnDao;
import io.renren.modules.generator.entity.GoodsimagesEnEntity;
import io.renren.modules.generator.service.GoodsimagesEnService;


@Service("goodsimagesEnService")
public class GoodsimagesEnServiceImpl extends ServiceImpl<GoodsimagesEnDao, GoodsimagesEnEntity> implements GoodsimagesEnService {

    @Autowired
    private GoodsimagesEnDao goodsimagesEnDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsimagesEnEntity> page = this.page(
                new Query<GoodsimagesEnEntity>().getPage(params),
                new QueryWrapper<GoodsimagesEnEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<GoodsimagesEnEntity> selectGoodsImageByGoodsCode(String goodsCode) {
        return goodsimagesEnDao.selectGoodsImageByGoodsCode(goodsCode);
    }

    @Override
    public void deleteGoodsImageByGoodsCode(String goodsCode) {
        goodsimagesEnDao.deleteGoodsImageByGoodsCode(goodsCode);
    }

}