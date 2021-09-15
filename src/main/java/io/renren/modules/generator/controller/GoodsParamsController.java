package io.renren.modules.generator.controller;

import io.renren.common.utils.R;
import io.renren.modules.generator.bo.ParamGroupBO;
import io.renren.modules.generator.entity.GoodsCategoryEntity;
import io.renren.modules.generator.entity.GoodsParamsEnEntity;
import io.renren.modules.generator.entity.GoodsParamsEntity;
import io.renren.modules.generator.entity.ParamGroupEntity;
import io.renren.modules.generator.service.GoodsParamsEnService;
import io.renren.modules.generator.service.GoodsParamsService;
import io.renren.modules.generator.service.ParamGroupService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-06-18 08:38:15
 */
@RestController
@RequestMapping("generator/goodsparams")
public class GoodsParamsController {
    @Autowired
    private GoodsParamsService goodsParamsService;

    @Autowired
    private GoodsParamsEnService goodsParamsEnService;

    @Autowired
    private ParamGroupService paramGroupService;

    @RequestMapping("/saveTopCategory")
//    @RequiresPermissions("generator:goodscategory:update")
    public R saveTopCategory(@RequestBody GoodsParamsEntity goodsParamsEntity){
        goodsParamsEntity.setParentId((long) 0);
        goodsParamsService.save(goodsParamsEntity);
        return R.ok();
    }

    @RequestMapping("/saveTopParamWithPG")
//    @RequiresPermissions("generator:goodscategory:update")
    public R saveTopParamWithPG(@RequestBody GoodsParamsEntity goodsParamsEntity){
        goodsParamsEntity.setParentId((long) 0);
        goodsParamsService.save(goodsParamsEntity);
        return R.ok();
    }

    @RequestMapping("/en/saveTopParamWithPG")
//    @RequiresPermissions("generator:goodscategory:update")
    public R saveTopParamWithPGEN(@RequestBody GoodsParamsEnEntity goodsParamsEntity){
        goodsParamsEntity.setParentId((long) 0);
        goodsParamsEnService.save(goodsParamsEntity);
        return R.ok();
    }

    @RequestMapping("/list")
    @RequiresPermissions("generator:goodscategory:list")
    public R list() {

        List<ParamGroupEntity> paramGroupEntities = paramGroupService.queryParamGroupList();
        List<ParamGroupBO> paramGroupBOS = new ArrayList<>();
        for (int i=0; i<paramGroupEntities.size(); i++) {
            ParamGroupBO paramGroupBO = new ParamGroupBO();
            paramGroupBO.setParamGroupName(paramGroupEntities.get(i).getParamGroupName());
            List<GoodsParamsEntity> goodsParamsEntities = goodsParamsService.queryParamsListByPGId(paramGroupEntities.get(i).getId());
            paramGroupBO.setParamsList(goodsParamsEntities);
            paramGroupBO.setId(paramGroupEntities.get(i).getId());
            paramGroupBOS.add(paramGroupBO);
        }

        return R.ok().put("paramGroups", paramGroupBOS);
    }

    @RequestMapping("/list-home-goods")
    public R listHomeGoods(){
        List<GoodsParamsEntity> goods = goodsParamsService.queryParamsList();
        return R.ok().put("goodsList", goods);
    }

    @RequestMapping("/en/list")
    public R listEN() {

        List<ParamGroupEntity> paramGroupEntities = paramGroupService.queryParamGroupListEN();
        List<ParamGroupBO> paramGroupBOS = new ArrayList<>();
        for (int i=0; i<paramGroupEntities.size(); i++) {
            ParamGroupBO paramGroupBO = new ParamGroupBO();
            paramGroupBO.setParamGroupName(paramGroupEntities.get(i).getParamGroupName());
            List<GoodsParamsEntity> goodsParamsEntities = goodsParamsService.queryParamsListByPGIdEN(paramGroupEntities.get(i).getId());
            paramGroupBO.setParamsList(goodsParamsEntities);
            paramGroupBO.setId(paramGroupEntities.get(i).getId());
            paramGroupBOS.add(paramGroupBO);
        }

        return R.ok().put("paramGroups", paramGroupBOS);
    }

    @RequestMapping("/rename")
//    @RequiresPermissions("generator:goodscategory:update")
    public R rename(@RequestBody GoodsParamsEntity goodsParamsEntity){
        goodsParamsService.updateById(goodsParamsEntity);

        return R.ok();
    }

    @RequestMapping("/en/rename")
//    @RequiresPermissions("generator:goodscategory:update")
    public R renameEN(@RequestBody GoodsParamsEnEntity goodsParamsEntity){
        goodsParamsEnService.updateById(goodsParamsEntity);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("generator:goodsparams:update")
    public R update(@RequestBody GoodsParamsEntity goodsParams){
        goodsParamsService.updateById(goodsParams);

        return R.ok();
    }

    @RequestMapping("/en/update")
    // @RequiresPermissions("generator:goodsparams:update")
    public R updateEn(@RequestBody GoodsParamsEnEntity goodsParams){
        goodsParamsEnService.updateById(goodsParams);

        return R.ok();
    }

    @RequestMapping("/append")
//    @RequiresPermissions("generator:goodscategory:update")
    public R append(@RequestBody GoodsParamsEntity goodsParamsEntity){
        goodsParamsService.save(goodsParamsEntity);
        return R.ok().put("category", goodsParamsEntity);
    }

    @RequestMapping("/en/append")
//    @RequiresPermissions("generator:goodscategory:update")
    public R appendEN(@RequestBody GoodsParamsEnEntity goodsParamsEntity){
        goodsParamsEnService.save(goodsParamsEntity);
        return R.ok().put("category", goodsParamsEntity);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:goodsparams:info")
    public R info(@PathVariable("id") Long id){
		GoodsParamsEntity goodsParams = goodsParamsService.getById(id);

        return R.ok().put("goodsParams", goodsParams);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:goodsparams:save")
    public R save(@RequestBody GoodsParamsEntity goodsParams){
		goodsParamsService.save(goodsParams);

        return R.ok();
    }



    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("generator:goodsparams:delete")
    public R delete(@RequestParam Long id){
        goodsParamsService.removeById((Long)id);
        return R.ok();
    }

    @RequestMapping("/en/delete")
    // @RequiresPermissions("generator:goodsparams:delete")
    public R deleteEN(@RequestParam Long id){
        goodsParamsEnService.removeById((Long)id);
        return R.ok();
    }


}
