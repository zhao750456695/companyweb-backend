package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.generator.entity.ShowimageEntity;
import io.renren.modules.generator.service.ShowimageService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.SampleimageEntity;
import io.renren.modules.generator.service.SampleimageService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-25 17:25:57
 */
@RestController
@RequestMapping("generator/sampleimage")
public class SampleimageController {
    @Autowired
    private SampleimageService sampleimageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:sampleimage:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sampleimageService.queryPage(params);
        return R.ok().put("page", page);
    }


    @RequestMapping("/show/list")
    public R showImgList(@RequestParam Map<String, Object> params){
        PageUtils page = showimageService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:sampleimage:info")
    public R info(@PathVariable("id") Integer id){
		SampleimageEntity sampleimage = sampleimageService.getById(id);
        return R.ok().put("sampleimage", sampleimage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:sampleimage:save")
    public R save(@RequestBody SampleimageEntity sampleimage){
        sampleimageService.insertOnDuplicate(sampleimage.getCategory(), sampleimage.getUrl());
		// sampleimageService.save(sampleimage);
        return R.ok();
    }

    @Autowired
    private ShowimageService showimageService;

    @RequestMapping("/show/save")
    public R showImgSave(@RequestBody ShowimageEntity sampleimage){
        showimageService.insertOnDuplicate(sampleimage.getShowId(), sampleimage.getUrl());
        return R.ok();
    }

    @RequestMapping("/show/del")
    public R showImgDel(@RequestBody int id){
        showimageService.removeById(id);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:sampleimage:update")
    public R update(@RequestBody SampleimageEntity sampleimage){
		sampleimageService.updateById(sampleimage);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		sampleimageService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @RequestMapping("/deleteByCat")
    public R deleteByCat(@RequestBody Integer cat){
        sampleimageService.removeByCat(cat);
        return R.ok();
    }
}
