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

import io.renren.modules.generator.dao.WebimagesDao;
import io.renren.modules.generator.entity.WebimagesEntity;
import io.renren.modules.generator.service.WebimagesService;


@Service("webimagesService")
public class WebimagesServiceImpl extends ServiceImpl<WebimagesDao, WebimagesEntity> implements WebimagesService {

    @Autowired
    private WebimagesDao webimagesDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WebimagesEntity> page = this.page(
                new Query<WebimagesEntity>().getPage(params),
                new QueryWrapper<WebimagesEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<WebimagesEntity> getPictureListByCategoryId(Integer categoryId) {
        return webimagesDao.getPictureListByCategoryId(categoryId);
    }

    @Override
    public void deletePictureListByCategoryId(Integer categoryId) {
        webimagesDao.deletePictureListByCategoryId(categoryId);
    }

    @Override
    public void insertOnDuplicate(String link, String url, Integer category) {
        webimagesDao.insertOnDuplicate(link, url, category);
    }

}