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

import io.renren.modules.generator.entity.NewsEnEntity;
import io.renren.modules.generator.service.NewsEnService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-10 21:40:24
 */
@RestController
@RequestMapping("generator/newsen")
public class NewsEnController {
//    @Autowired
//    private NewsEnService newsEnService;
//
//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
//    @RequiresPermissions("generator:newsen:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = newsEnService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
//    @RequiresPermissions("generator:newsen:info")
//    public R info(@PathVariable("id") Integer id){
//		NewsEnEntity newsEn = newsEnService.getById(id);
//
//        return R.ok().put("newsEn", newsEn);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
//    @RequiresPermissions("generator:newsen:save")
//    public R save(@RequestBody NewsEnEntity newsEn){
//		newsEnService.save(newsEn);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    @RequiresPermissions("generator:newsen:update")
//    public R update(@RequestBody NewsEnEntity newsEn){
//		newsEnService.updateById(newsEn);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    @RequiresPermissions("generator:newsen:delete")
//    public R delete(@RequestBody Integer[] ids){
//		newsEnService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}
