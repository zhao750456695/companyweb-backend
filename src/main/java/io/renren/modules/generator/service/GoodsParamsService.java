package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.GoodsParamsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-06-18 08:38:15
 */
public interface GoodsParamsService extends IService<GoodsParamsEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<GoodsParamsEntity> queryParamsList();

    List<GoodsParamsEntity> queryParamsListByPGId(Long paramGroupId);

    List<GoodsParamsEntity> queryParamsListByPGIdEN(Long paramGroupId);

    void removeAll();
}

