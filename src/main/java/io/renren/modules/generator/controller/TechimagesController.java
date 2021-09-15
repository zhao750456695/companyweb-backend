package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.TechimagesEntity;
import io.renren.modules.generator.service.TechimagesService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-26 09:49:22
 */
@RestController
@RequestMapping("generator/techimages")
public class TechimagesController {
    @Autowired
    private TechimagesService techimagesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:techimages:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = techimagesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:techimages:info")
    public R info(@PathVariable("id") Integer id){
		TechimagesEntity techimages = techimagesService.getById(id);

        return R.ok().put("techimages", techimages);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:techimages:save")
    public R save(@RequestBody TechimagesEntity techimages){
        techimages.setUpdated(new Date());
		techimagesService.save(techimages);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:techimages:update")
    public R update(@RequestBody TechimagesEntity techimages){
		techimagesService.updateById(techimages);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:techimages:delete")
    public R delete(@RequestBody Integer[] ids){
		techimagesService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
