package io.renren.modules.generator.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.generator.entity.FilterBindingsEntity;
import io.renren.modules.generator.service.FilterBindingsService;
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
 * @date 2021-06-17 10:31:41
 */
@RestController
@RequestMapping("generator/filterbindings")
public class FilterBindingsController {
    @Autowired
    private FilterBindingsService filterBindingsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:filterbindings:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = filterBindingsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:filterbindings:info")
    public R info(@PathVariable("id") Long id){
		FilterBindingsEntity filterBindings = filterBindingsService.getById(id);

        return R.ok().put("filterBindings", filterBindings);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:filterbindings:save")
    public R save(@RequestBody FilterBindingsEntity filterBindings){
		filterBindingsService.save(filterBindings);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:filterbindings:update")
    public R update(@RequestBody FilterBindingsEntity filterBindings){
		filterBindingsService.updateById(filterBindings);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:filterbindings:delete")
    public R delete(@RequestBody Long[] ids){
		filterBindingsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
