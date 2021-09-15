package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.ShowimageEntity;
import io.renren.modules.generator.service.ShowimageService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-09 18:45:26
 */
@RestController
@RequestMapping("generator/showimage")
public class ShowimageController {
    @Autowired
    private ShowimageService showimageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:showimage:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = showimageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:showimage:info")
    public R info(@PathVariable("id") Integer id){
		ShowimageEntity showimage = showimageService.getById(id);

        return R.ok().put("showimage", showimage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:showimage:save")
    public R save(@RequestBody ShowimageEntity showimage){
		showimageService.save(showimage);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:showimage:update")
    public R update(@RequestBody ShowimageEntity showimage){
		showimageService.updateById(showimage);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:showimage:delete")
    public R delete(@RequestBody Integer[] ids){
		showimageService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
