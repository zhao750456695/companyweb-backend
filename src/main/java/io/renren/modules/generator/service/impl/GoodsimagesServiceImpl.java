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

import io.renren.modules.generator.dao.GoodsimagesDao;
import io.renren.modules.generator.entity.GoodsimagesEntity;
import io.renren.modules.generator.service.GoodsimagesService;


@Service("goodsimagesService")
public class GoodsimagesServiceImpl extends ServiceImpl<GoodsimagesDao, GoodsimagesEntity> implements GoodsimagesService {

    @Autowired
    private GoodsimagesDao goodsimagesDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsimagesEntity> page = this.page(
                new Query<GoodsimagesEntity>().getPage(params),
                new QueryWrapper<GoodsimagesEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<GoodsimagesEntity> selectGoodsImageByGoodsCode(String goodsCode) {
        return goodsimagesDao.selectGoodsImageByGoodsCode(goodsCode);
    }

    @Override
    public void deleteGoodsImageByGoodsCode(String goodsCode) {
        goodsimagesDao.deleteGoodsImageByGoodsCode(goodsCode);
    }

}