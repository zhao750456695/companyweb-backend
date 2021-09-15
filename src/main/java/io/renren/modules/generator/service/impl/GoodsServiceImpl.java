package io.renren.modules.generator.service.impl;

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

import io.renren.modules.generator.dao.GoodsDao;
import io.renren.modules.generator.entity.GoodsEntity;
import io.renren.modules.generator.service.GoodsService;


@Service("goodsService")
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, GoodsEntity> implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsEntity> page = this.page(
                new Query<GoodsEntity>().getPage(params),
                new QueryWrapper<GoodsEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void insertOnDuplicate(String goodsCode, String goodsName, String goodscategoryId, String goodsTitle, Date updated, String params, String brilliant, Integer category, String listImage, Integer showInIndex) {
        goodsDao.insertOnDuplicate(goodsCode, goodsName, goodscategoryId, goodsTitle, updated, params, brilliant, category, listImage, showInIndex);
    }

    @Override
    public void insertOnDuplicate(GoodsEntity goodsEntity) {
        goodsDao.insertOnDuplicate(goodsEntity.getGoodsCode(), goodsEntity.getGoodsName(), goodsEntity.getGoodscategoryId(), goodsEntity.getGoodsTitle(), goodsEntity.getUpdated(), goodsEntity.getParams(), goodsEntity.getBrilliant(), goodsEntity.getCategory(), goodsEntity.getListImage(), goodsEntity.getShowInIndex());
    }

    @Override
    public List<GoodsEntity> selectGoodsByCode(String goodsCode) {
        return goodsDao.selectGoodsByCode(goodsCode);
    }

    @Override
    public List<GoodsEntity> queryGoodsInCatIDs(List<String> cat) {
        return goodsDao.queryGoodsInCatIDs(cat);
    }

    @Override
    public List<GoodsEntity> queryGoodsInCatIDsREGEXP(String idString) {
        return goodsDao.queryGoodsInCatIDsREGEXP(idString);
    }

    @Override
    public List<GoodsEntity> queryAllGoods() {
        return goodsDao.queryAllGoods();
    }

}