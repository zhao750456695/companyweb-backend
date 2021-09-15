package io.renren.modules.generator.controller;

import io.renren.common.utils.R;
import io.renren.modules.generator.bo.FilterBindingBO;
import io.renren.modules.generator.bo.GoodsFilterBO;
import io.renren.modules.generator.entity.FilterBindingsEntity;
import io.renren.modules.generator.entity.FilterEnEntity;
import io.renren.modules.generator.entity.FilterEntity;
import io.renren.modules.generator.entity.GoodsCategoryEntity;
import io.renren.modules.generator.service.FilterBindingsService;
import io.renren.modules.generator.service.FilterEnService;
import io.renren.modules.generator.service.FilterService;
import io.renren.modules.generator.service.GoodsCategoryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-19 09:51:16
 */
@RestController
@RequestMapping("generator/filter")
public class GoodsFilterController {
    @Autowired
    private FilterService filterService;

    @Autowired
    private FilterEnService filterEnService;

    @Autowired
    private GoodsCategoryService goodsCategoryService;



    @Autowired
    private FilterBindingsService filterBindingsService;



    /**
     * 列表
     */
    @RequestMapping("/list")
//    public R list(@RequestParam Map<String, Object> params){
    public R list() {
        // PageUtils page = goodsCategoryService.queryPage(params);
        List<FilterEntity> goodsFilterEntities = filterService.queryFilterList();
        return R.ok().put("filterList", goodsFilterEntities);
    }

    /**
     * 列表
     */
    @RequestMapping("/bindingList")
//    public R list(@RequestParam Map<String, Object> params){
    public R bindingList(@RequestParam("cate") Integer cate) {

        List<FilterBindingsEntity> filterBindingsEntity = filterBindingsService.queryFilterListByCateId(cate.toString());
        List<FilterEntity> filterEntityList = new ArrayList<>();

        for (int i=0; i<filterBindingsEntity.size(); i++) {
            String ids = filterBindingsEntity.get(i).getFilterids();
            String[] idArray = ids.split(",");
            for (int j=0; j<idArray.length; j++) {
                FilterEntity filterEntity = filterService.queryFilterById(idArray[j]);
                List<FilterEntity> filterEntityList1 = filterService.queryFilterByParentId(idArray[j]);
                filterEntityList.add(filterEntity);
                filterEntityList.addAll(filterEntityList1);
            }

        }
        return R.ok().put("categoryList", filterEntityList);
    }
//
    @RequestMapping("/en/list")
    public R listEn() {
        // PageUtils page = goodsCategoryService.queryPage(params);
        List<FilterEntity> goodsFilterEntities = filterService.queryFilterListEN();
        return R.ok().put("filterList", goodsFilterEntities);
    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{catId}")
//    @RequiresPermissions("generator:goodscategory:info")
//    public R info(@PathVariable("catId") Long catId){
//		GoodsCategoryEntity goodsCategory = goodsCategoryService.getById(catId);
//
//        return R.ok().put("goodsCategory", goodsCategory);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
//    @RequiresPermissions("generator:goodscategory:save")
//    public R save(@RequestBody GoodsCategoryEntity goodsCategory){
//		goodsCategoryService.save(goodsCategory);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    @RequiresPermissions("generator:goodscategory:update")
//    public R update(@RequestBody GoodsCategoryEntity goodsCategory){
//		goodsCategoryService.updateById(goodsCategory);
//
//        return R.ok();
//    }
//
    /**
     * 重命名
     */
    @RequestMapping("/rename")
//    @RequiresPermissions("generator:goodscategory:update")
    public R rename(@RequestBody FilterEntity filterEntity){
        filterService.updateById(filterEntity);

        return R.ok();
    }
//
    @RequestMapping("/en/rename")
//    @RequiresPermissions("generator:goodscategory:update")
    public R renameEn(@RequestBody FilterEnEntity filterEntity){
        filterEnService.updateById(filterEntity);

        return R.ok();
    }
//
    /**
     * 添加筛选规则
     */
    @RequestMapping("/en/saveTopCategory")
//    @RequiresPermissions("generator:goodscategory:update")
    public R saveTopCategory(@RequestBody FilterEnEntity filterEntity){
        filterEntity.setParentId((long) 0);
        filterEnService.save(filterEntity);
        return R.ok();
    }

    @RequestMapping("/saveTopCategory")
//    @RequiresPermissions("generator:goodscategory:update")
    public R saveTopCategoryEN(@RequestBody FilterEntity filterEntity){
        filterEntity.setParentId((long) 0);
        filterService.save(filterEntity);
        return R.ok();
    }

    @RequestMapping("/saveFilter")
    public R saveFilter(@RequestBody GoodsFilterBO goodsFilterBO){
        // 先要保存或更新 筛选名称
        System.out.println(goodsFilterBO);

        FilterEntity parent = new FilterEntity();
        parent.setParentId((long) 0);
        parent.setLabel(goodsFilterBO.getLabel());
        // 然后保存筛选内容，如果是已经存在的筛选内容，则要先全部删除，然后保存
        if (goodsFilterBO.getStat().equals(1)) {
            // 更新筛选名称
            parent.setId(goodsFilterBO.getId());
            filterService.updateParentFilter(parent.getParentId(), parent.getLabel(), parent.getId());
            System.out.println(parent);
            // 删除所有
            filterService.deleteFilterItems(parent.getId());
            // 逐条保存
            for (int i=0; i<goodsFilterBO.getChildren().size(); i++) {
                FilterEntity filter = new FilterEntity();
                filter.setLabel(goodsFilterBO.getChildren().get(i).getLabel());
                filter.setParentId(parent.getId());
                filterService.save(filter);
            }
        } else {
            // 插入，并获得新增的id
            filterService.insertParentFilter(parent);
            for (int i=0; i<goodsFilterBO.getChildren().size(); i++) {
                FilterEntity filter = new FilterEntity();
                filter.setLabel(goodsFilterBO.getChildren().get(i).getLabel());
                filter.setParentId(parent.getId());
                filterService.save(filter);
            }
        }
        return R.ok();
    }

    @RequestMapping("/delFilter")
    public R delFilter(@RequestBody Long id){
        // 删除筛选名称
        filterService.deleteFilterById(id);
        // 删除子条目
        filterService.deleteFilterItems(id);
        return R.ok();
    }

    @RequestMapping("/filterBinding")
    public R filterBinding(){
        // 种类绑定筛选规则
        // 找到所有种类
        // 找到所有规则
        // 一个种类对应所有规则

        List<GoodsCategoryEntity> goodsCategoryEntityList = goodsCategoryService.queryGoodsCategoryList();
        List<FilterEntity> filterEntityList = filterService.queryFilterList();
        // 得到被选中的filter
        List<FilterBindingsEntity> filterBindingsEntityList = filterBindingsService.queryFilterBindingList();

        List<FilterEntity> filterEntityListNew = new ArrayList<>();

        List<FilterBindingBO> filterBindingBOList = new ArrayList<>();

        for (int j=0; j<filterEntityList.size(); j++){
            if (filterEntityList.get(j).getParentId()==0){
                filterEntityListNew.add(filterEntityList.get(j));
            }
        }



        for (int i=0; i<goodsCategoryEntityList.size(); i++){
            if (goodsCategoryEntityList.get(i).getParentId() != 0){
                FilterBindingBO filterBindingBO = new FilterBindingBO();
                filterBindingBO.setGoodsCategoryEntity(goodsCategoryEntityList.get(i));
                filterBindingBO.setFilterEntityList(filterEntityListNew);

                for (int m=0; m<filterBindingsEntityList.size(); m++) {
                    long y = goodsCategoryEntityList.get(i).getId();
                    int z = Integer.parseInt(filterBindingsEntityList.get(m).getCategoryid());
                    if (goodsCategoryEntityList.get(i).getId().equals(Long.parseLong(filterBindingsEntityList.get(m).getCategoryid()))) {
                        String ids = filterBindingsEntityList.get(m).getFilterids();
                        String[] idArray = ids.split(",");
                        Integer[] newArray = new Integer[idArray.length];
                        for (int h=0; h<idArray.length; h++) {
                          newArray[h] = Integer.parseInt(idArray[h]);
                        }

                        filterBindingBO.setIds(newArray);
                    }
                }

                filterBindingBOList.add(filterBindingBO);
            }
        }



        return R.ok().put("filterBOList", filterBindingBOList);
    }


    @RequestMapping("/en/filterBinding")
    public R filterBindingEN(){
        // 种类绑定筛选规则
        // 找到所有种类
        // 找到所有规则
        // 一个种类对应所有规则

        List<GoodsCategoryEntity> goodsCategoryEntityList = goodsCategoryService.queryGoodsCategoryListEN();
        List<FilterEntity> filterEntityList = filterService.queryFilterListEN();
        // 得到被选中的filter
        List<FilterBindingsEntity> filterBindingsEntityList = filterBindingsService.queryFilterBindingListEN();

        List<FilterEntity> filterEntityListNew = new ArrayList<>();

        List<FilterBindingBO> filterBindingBOList = new ArrayList<>();

        for (int j=0; j<filterEntityList.size(); j++){
            if (filterEntityList.get(j).getParentId()==0){
                filterEntityListNew.add(filterEntityList.get(j));
            }
        }



        for (int i=0; i<goodsCategoryEntityList.size(); i++){
            if (goodsCategoryEntityList.get(i).getParentId() != 0){
                FilterBindingBO filterBindingBO = new FilterBindingBO();
                filterBindingBO.setGoodsCategoryEntity(goodsCategoryEntityList.get(i));
                filterBindingBO.setFilterEntityList(filterEntityListNew);

                for (int m=0; m<filterBindingsEntityList.size(); m++) {
                    long y = goodsCategoryEntityList.get(i).getId();
                    int z = Integer.parseInt(filterBindingsEntityList.get(m).getCategoryid());
                    if (goodsCategoryEntityList.get(i).getId().equals(Long.parseLong(filterBindingsEntityList.get(m).getCategoryid()))) {
                        String ids = filterBindingsEntityList.get(m).getFilterids();
                        String[] idArray = ids.split(",");
                        Integer[] newArray = new Integer[idArray.length];
                        for (int h=0; h<idArray.length; h++) {
                            newArray[h] = Integer.parseInt(idArray[h]);
                        }

                        filterBindingBO.setIds(newArray);
                    }
                }

                filterBindingBOList.add(filterBindingBO);
            }
        }



        return R.ok().put("filterBOList", filterBindingBOList);
    }


    // filterBinding
    @RequestMapping("/saveFilterBindings")
    public R saveFilterBindings(@RequestBody FilterBindingsEntity filterBindingsEntity){
        filterBindingsService.insertOnDuplicate(Integer.parseInt(filterBindingsEntity.getCategoryid()), filterBindingsEntity.getFilterids());
        return R.ok();
    }

    @RequestMapping("/en/saveFilterBindings")
    public R saveFilterBindingsEN(@RequestBody FilterBindingsEntity filterBindingsEntity){
        filterBindingsService.insertOnDuplicateEN(Integer.parseInt(filterBindingsEntity.getCategoryid()), filterBindingsEntity.getFilterids());
        return R.ok();
    }

//    @RequestMapping("/en/saveTopCategory")
////    @RequiresPermissions("generator:goodscategory:update")
//    public R saveTopCategoryEn(@RequestBody GoodsCategoryEnEntity goodsCategory){
//        goodsCategory.setParentId((long) 0);
//        goodsCategoryEnService.save(goodsCategory);
//        return R.ok();
//    }
//
    @RequestMapping("/append")
//    @RequiresPermissions("generator:goodscategory:update")
    public R append(@RequestBody FilterEntity filterEntity){
        filterService.save(filterEntity);
        return R.ok().put("category", filterEntity);
    }
//
    @RequestMapping("/en/append")
//    @RequiresPermissions("generator:goodscategory:update")
    public R appendEn(@RequestBody FilterEnEntity filterEntity){
        filterEnService.save(filterEntity);
        return R.ok().put("category", filterEntity);
    }
//
    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:goodscategory:delete")
    public R delete(@RequestParam Long id){
        filterService.removeById((Long)id);
        return R.ok();
    }
//
    @RequestMapping("/en/delete")
    public R deleteEn(@RequestParam Long id){
        filterEnService.removeById((Long)id);
        return R.ok();
    }

}
