package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.RecruitDao;
import io.renren.modules.generator.entity.RecruitEntity;
import io.renren.modules.generator.service.RecruitService;


@Service("recruitService")
public class RecruitServiceImpl extends ServiceImpl<RecruitDao, RecruitEntity> implements RecruitService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RecruitEntity> page = this.page(
                new Query<RecruitEntity>().getPage(params),
                new QueryWrapper<RecruitEntity>()
        );

        return new PageUtils(page);
    }

}