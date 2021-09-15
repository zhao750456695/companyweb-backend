package io.renren.modules.generator.service.impl;

import io.renren.modules.generator.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.GoodsEnDao;
import io.renren.modules.generator.entity.GoodsEnEntity;
import io.renren.modules.generator.service.GoodsEnService;


@Service("goodsEnService")
public class GoodsEnServiceImpl extends ServiceImpl<GoodsEnDao, GoodsEnEntity> implements GoodsEnService {

    @Autowired
    private GoodsEnDao goodsDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsEnEntity> page = this.page(
                new Query<GoodsEnEntity>().getPage(params),
                new QueryWrapper<GoodsEnEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void insertOnDuplicate(String goodsCode, String goodsName, String goodscategoryId, String goodsTitle, Date updated, String params, String brilliant, Integer category, String listImage, Integer showInIndex) {
        goodsDao.insertOnDuplicate(goodsCode, goodsName, goodscategoryId, goodsTitle, updated, params, brilliant, category, listImage, showInIndex);
    }

    @Override
    public void insertOnDuplicate(GoodsEnEntity goodsEntity) {
        goodsDao.insertOnDuplicate(goodsEntity.getGoodsCode(), goodsEntity.getGoodsName(), goodsEntity.getGoodscategoryId(), goodsEntity.getGoodsTitle(), goodsEntity.getUpdated(), goodsEntity.getParams(), goodsEntity.getBrilliant(), goodsEntity.getCategory(), goodsEntity.getListImage(), goodsEntity.getShowInIndex());

    }

    @Override
    public List<GoodsEnEntity> selectGoodsByCode(String goodsCode) {
        return goodsDao.selectGoodsByCode(goodsCode);
    }

}