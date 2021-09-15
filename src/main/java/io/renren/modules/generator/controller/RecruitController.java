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

import io.renren.modules.generator.entity.RecruitEntity;
import io.renren.modules.generator.service.RecruitService;
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
@RequestMapping("generator/recruit")
public class RecruitController {
    @Autowired
    private RecruitService recruitService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = recruitService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:recruit:info")
    public R info(@PathVariable("id") Integer id){
		RecruitEntity recruit = recruitService.getById(id);

        return R.ok().put("recruit", recruit);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RecruitEntity recruit){
		recruitService.save(recruit);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:recruit:update")
    public R update(@RequestBody RecruitEntity recruit){
		recruitService.updateById(recruit);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:recruit:delete")
    public R delete(@RequestBody Integer[] ids){
		recruitService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
