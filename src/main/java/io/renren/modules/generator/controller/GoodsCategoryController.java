package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.generator.entity.GoodsCategoryEnEntity;
import io.renren.modules.generator.service.GoodsCategoryEnService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.GoodsCategoryEntity;
import io.renren.modules.generator.service.GoodsCategoryService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-19 09:51:16
 */
@RestController
@RequestMapping("generator/goodscategory")
public class GoodsCategoryController {
    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @Autowired
    private GoodsCategoryEnService goodsCategoryEnService;
    /**
     * 列表
     */
    @RequestMapping("/list")
//    public R list(@RequestParam Map<String, Object> params){
    public R list() {
        // PageUtils page = goodsCategoryService.queryPage(params);
        List<GoodsCategoryEntity> goodsCategoryEntities = goodsCategoryService.queryGoodsCategoryList();
        return R.ok().put("categoryList", goodsCategoryEntities);
    }

    @RequestMapping("/en/list")
    @RequiresPermissions("generator:goodscategory:list")
//    public R list(@RequestParam Map<String, Object> params){
    public R listEn() {
        // PageUtils page = goodsCategoryService.queryPage(params);
        List<GoodsCategoryEntity> goodsCategoryEntities = goodsCategoryService.queryGoodsCategoryListEN();
        return R.ok().put("categoryList", goodsCategoryEntities);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    @RequiresPermissions("generator:goodscategory:info")
    public R info(@PathVariable("catId") Long catId){
		GoodsCategoryEntity goodsCategory = goodsCategoryService.getById(catId);

        return R.ok().put("goodsCategory", goodsCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:goodscategory:save")
    public R save(@RequestBody GoodsCategoryEntity goodsCategory){
		goodsCategoryService.save(goodsCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:goodscategory:update")
    public R update(@RequestBody GoodsCategoryEntity goodsCategory){
		goodsCategoryService.updateById(goodsCategory);

        return R.ok();
    }

    /**
     * 重命名
     */
    @RequestMapping("/rename")
//    @RequiresPermissions("generator:goodscategory:update")
    public R rename(@RequestBody GoodsCategoryEntity goodsCategory){
        goodsCategoryService.updateById(goodsCategory);

        return R.ok();
    }

    @RequestMapping("/en/rename")
//    @RequiresPermissions("generator:goodscategory:update")
    public R renameEn(@RequestBody GoodsCategoryEnEntity goodsCategory){
        goodsCategoryEnService.updateById(goodsCategory);

        return R.ok();
    }

    /**
     * 重命名
     */
    @RequestMapping("/saveTopCategory")
//    @RequiresPermissions("generator:goodscategory:update")
    public R saveTopCategory(@RequestBody GoodsCategoryEntity goodsCategory){
        goodsCategory.setParentId((long) 0);
        goodsCategoryService.save(goodsCategory);
        return R.ok();
    }

    @RequestMapping("/en/saveTopCategory")
//    @RequiresPermissions("generator:goodscategory:update")
    public R saveTopCategoryEn(@RequestBody GoodsCategoryEnEntity goodsCategory){
        goodsCategory.setParentId((long) 0);
        goodsCategoryEnService.save(goodsCategory);
        return R.ok();
    }

    @RequestMapping("/append")
//    @RequiresPermissions("generator:goodscategory:update")
    public R append(@RequestBody GoodsCategoryEntity goodsCategory){
        goodsCategoryService.save(goodsCategory);
        return R.ok().put("category", goodsCategory);
    }

    @RequestMapping("/en/append")
//    @RequiresPermissions("generator:goodscategory:update")
    public R appendEn(@RequestBody GoodsCategoryEnEntity goodsCategory){
        goodsCategoryEnService.save(goodsCategory);

        return R.ok().put("category", goodsCategory);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:goodscategory:delete")
    public R delete(@RequestParam Long id){
        goodsCategoryService.removeById((Long)id);
        return R.ok();
    }

    @RequestMapping("/en/delete")
    @RequiresPermissions("generator:goodscategory:delete")
    public R deleteEn(@RequestParam Long id){
        goodsCategoryEnService.removeById((Long)id);
        return R.ok();
    }

}
