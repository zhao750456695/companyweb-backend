package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.generator.entity.GoodsEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.HomeProductsEntity;
import io.renren.modules.generator.service.HomeProductsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-14 21:42:08
 */
@RestController
@RequestMapping("generator/homeproducts")
public class HomeProductsController {
    @Autowired
    private HomeProductsService homeProductsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = homeProductsService.queryPage(params);

        return R.ok().put("page", page);
    }

    @RequestMapping("/list-all")
    public R listAll(){
        List<HomeProductsEntity> goodsEntities = homeProductsService.getAll();
        return R.ok().put("goods", goodsEntities);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		HomeProductsEntity homeProducts = homeProductsService.getById(id);

        return R.ok().put("homeProducts", homeProducts);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HomeProductsEntity homeProducts){
		// homeProductsService.save(homeProducts);
        homeProductsService.insertOnDuplicate(homeProducts);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody HomeProductsEntity homeProducts){
		homeProductsService.updateById(homeProducts);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		homeProductsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
