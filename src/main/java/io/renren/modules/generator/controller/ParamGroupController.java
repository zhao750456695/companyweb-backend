package io.renren.modules.generator.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.generator.bo.ParamGroupBO;
import io.renren.modules.generator.bo.ParamGroupBindingBO;
import io.renren.modules.generator.entity.*;
import io.renren.modules.generator.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-06-18 13:11:46
 */
@RestController
@RequestMapping("generator/paramgroup")
public class ParamGroupController {
    @Autowired
    private ParamGroupService paramGroupService;

    @Autowired
    private ParamGroupEnService paramGroupEnService;


    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @Autowired
    private ParamgroupBingdingsService paramgroupBingdingsService;

    @Autowired
    private GoodsParamsService goodsParamsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:paramgroup:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = paramGroupService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		// ParamGroupEntity paramGroup = paramGroupService.getById(id);
        ParamgroupBingdingsEntity paramgroupBingdingsEntity = paramgroupBingdingsService.getByCategoryId(id);
        ParamGroupEntity paramGroup = paramGroupService.getById(paramgroupBingdingsEntity.getParamgroupid());

        List<GoodsParamsEntity> paramsEntityList = goodsParamsService.queryParamsListByPGId(paramGroup.getId());

        ParamGroupBO paramGroupBO = new ParamGroupBO();
        // 这里的id是参数组的id
        paramGroupBO.setId(paramGroup.getId());
        paramGroupBO.setParamGroupName(paramGroup.getParamGroupName());
        paramGroupBO.setParamsList(paramsEntityList);


        return R.ok().put("paramGroupBO", paramGroupBO);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("generator:paramgroup:save")
    public R save(@RequestBody ParamGroupEntity paramGroup){
		paramGroupService.save(paramGroup);

        return R.ok();
    }

    @RequestMapping("/en/save")
    // @RequiresPermissions("generator:paramgroup:save")
    public R saveEN(@RequestBody ParamGroupEnEntity paramGroup){
        paramGroupEnService.save(paramGroup);

        return R.ok();
    }
    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ParamGroupEntity paramGroup){
		paramGroupService.updateById(paramGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/en/update")
    public R updateEN(@RequestBody ParamGroupEnEntity paramGroup){
        paramGroupEnService.updateById(paramGroup);

        return R.ok();
    }
    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestParam Long id){
		paramGroupService.removeById((Long)id);

        return R.ok();
    }

    @RequestMapping("/en/delete")
    public R deleteEN(@RequestParam Long id){
        paramGroupEnService.removeById((Long)id);

        return R.ok();
    }

    @RequestMapping("/paramGroupBinding")
    public R paramGroupBinding(){
        // 种类绑定筛选规则
        // 找到所有种类
        // 找到所有规则
        // 一个种类对应所有规则

        List<GoodsCategoryEntity> goodsCategoryEntityList = goodsCategoryService.queryGoodsCategoryList();
        List<ParamGroupEntity> paramGroupList = paramGroupService.queryParamGroupList();

        // 得到被选中的filter
        List<ParamgroupBingdingsEntity> paramgroupBingdingsEntityList = paramgroupBingdingsService.queryParamGroupBindingList();

        List<ParamGroupBindingBO> paramGroupBindingBOList = new ArrayList<>();



        for (int i=0; i<goodsCategoryEntityList.size(); i++){
            if (goodsCategoryEntityList.get(i).getParentId() != 0){
                ParamGroupBindingBO paramGroupBindingBO = new ParamGroupBindingBO();
                paramGroupBindingBO.setGoodsCategoryEntity(goodsCategoryEntityList.get(i));
                paramGroupBindingBO.setParamGroupEntityList(paramGroupList);

                for (int m=0; m<paramgroupBingdingsEntityList.size(); m++) {
                    long y = goodsCategoryEntityList.get(i).getId();

                    if (goodsCategoryEntityList.get(i).getId().equals(paramgroupBingdingsEntityList.get(m).getCategoryid())) {
                        Long id = paramgroupBingdingsEntityList.get(m).getParamgroupid();
                        // String[] idArray = ids.split(",");
                        Long[] newArray = new Long[1];
                        newArray[0] =  id;
                        paramGroupBindingBO.setCheckedId(newArray);
                    }
                }

                paramGroupBindingBOList.add(paramGroupBindingBO);
            }
        }



        return R.ok().put("filterBOList", paramGroupBindingBOList);
    }

    @RequestMapping("/en/paramGroupBinding")
    public R paramGroupBindingEN(){
        // 种类绑定筛选规则
        // 找到所有种类
        // 找到所有规则
        // 一个种类对应所有规则

        List<GoodsCategoryEntity> goodsCategoryEntityList = goodsCategoryService.queryGoodsCategoryListEN();
        List<ParamGroupEntity> paramGroupList = paramGroupService.queryParamGroupListEN();

        // 得到被选中的filter
        List<ParamgroupBingdingsEntity> paramgroupBingdingsEntityList = paramgroupBingdingsService.queryParamGroupBindingListEN();

        List<ParamGroupBindingBO> paramGroupBindingBOList = new ArrayList<>();



        for (int i=0; i<goodsCategoryEntityList.size(); i++){
            if (goodsCategoryEntityList.get(i).getParentId() != 0){
                ParamGroupBindingBO paramGroupBindingBO = new ParamGroupBindingBO();
                paramGroupBindingBO.setGoodsCategoryEntity(goodsCategoryEntityList.get(i));
                paramGroupBindingBO.setParamGroupEntityList(paramGroupList);

                for (int m=0; m<paramgroupBingdingsEntityList.size(); m++) {
                    long y = goodsCategoryEntityList.get(i).getId();

                    if (goodsCategoryEntityList.get(i).getId().equals(paramgroupBingdingsEntityList.get(m).getCategoryid())) {
                        Long id = paramgroupBingdingsEntityList.get(m).getParamgroupid();
                        // String[] idArray = ids.split(",");
                        Long[] newArray = new Long[1];
                        newArray[0] =  id;
                        paramGroupBindingBO.setCheckedId(newArray);
                    }
                }

                paramGroupBindingBOList.add(paramGroupBindingBO);
            }
        }

        return R.ok().put("filterBOList", paramGroupBindingBOList);
    }

    // saveParamGroupBindings
    @RequestMapping("/saveParamGroupBindings")
    public R saveParamGroupBindings(@RequestBody ParamgroupBingdingsEntity paramgroupBingdingsEntity){
        paramgroupBingdingsService.insertOnDuplicate(paramgroupBingdingsEntity.getCategoryid(), paramgroupBingdingsEntity.getParamgroupid());
        return R.ok();
    }

    @RequestMapping("/en/saveParamGroupBindings")
    public R saveParamGroupBindingsEN(@RequestBody ParamgroupBingdingsEntity paramgroupBingdingsEntity){
        paramgroupBingdingsService.insertOnDuplicateEN(paramgroupBingdingsEntity.getCategoryid(), paramgroupBingdingsEntity.getParamgroupid());
        return R.ok();
    }
}
