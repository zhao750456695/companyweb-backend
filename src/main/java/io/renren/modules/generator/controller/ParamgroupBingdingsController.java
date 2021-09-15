package io.renren.modules.generator.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.generator.entity.ParamgroupBingdingsEntity;
import io.renren.modules.generator.service.ParamgroupBingdingsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-06-18 18:30:43
 */
@RestController
@RequestMapping("generator/paramgroupbingdings")
public class ParamgroupBingdingsController {
    @Autowired
    private ParamgroupBingdingsService paramgroupBingdingsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:paramgroupbingdings:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = paramgroupBingdingsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:paramgroupbingdings:info")
    public R info(@PathVariable("id") Long id){
		ParamgroupBingdingsEntity paramgroupBingdings = paramgroupBingdingsService.getById(id);

        return R.ok().put("paramgroupBingdings", paramgroupBingdings);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:paramgroupbingdings:save")
    public R save(@RequestBody ParamgroupBingdingsEntity paramgroupBingdings){
		paramgroupBingdingsService.save(paramgroupBingdings);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:paramgroupbingdings:update")
    public R update(@RequestBody ParamgroupBingdingsEntity paramgroupBingdings){
		paramgroupBingdingsService.updateById(paramgroupBingdings);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:paramgroupbingdings:delete")
    public R delete(@RequestBody Long[] ids){
		paramgroupBingdingsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
