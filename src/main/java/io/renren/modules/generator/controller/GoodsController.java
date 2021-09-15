package io.renren.modules.generator.controller;

import java.util.*;

import io.renren.modules.generator.bo.GoodsBO;
import io.renren.modules.generator.entity.*;
import io.renren.modules.generator.service.*;
import io.renren.modules.generator.vo.GoodsVO;
import io.renren.modules.generator.vo.HomeGoodsVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 商品管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-16 15:01:20
 */
@RestController
@RequestMapping("generator/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @Autowired
    private GoodsCategoryEnService goodsCategoryEnService;

    @Autowired
    private GoodsEnService goodsEnService;

    @Autowired
    private GoodsimagesService goodsimagesService;

    @Autowired
    private GoodsimagesEnService goodsimagesEnService;

    @Autowired
    private FilterService filterService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:goods:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsService.queryPage(params);
        System.out.println("..............");
        System.out.println(page);
        for (int i=0; i<page.getList().size(); i++) {
            GoodsEntity goods = (GoodsEntity) page.getList().get(i);
            String[] strs = goods.getGoodscategoryId().split(",");
            String cats = "";
            for (int j=0; j< strs.length; j++) {
                FilterEntity filter = filterService.getById(Long.parseLong(strs[j]));
                if (filter!=null){
                    cats += " " + filter.getLabel();
                }
            }
            goods.setGoodscategoryId(cats);
        }
        return R.ok().put("page", page);
    }

    @RequestMapping("/list-all")
    public R listAll(){
        List<GoodsEntity> goodsEntities = goodsService.queryAllGoods();
        return R.ok().put("goods", goodsEntities);
    }

    // 注意：这里没有创建新表，而是使用了 tb_goods_category
    @RequestMapping("/show-in-index")
    public R getProductByFliterContent(@RequestBody List<String> list){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append("|");
            }
        }
        String ids = sb.toString();
        List<GoodsEntity> goodsEntityList = goodsService.queryGoodsInCatIDsREGEXP(ids);
        // 找到id对应的类型
        List<HomeGoodsVO> homeGoodsVOList = new ArrayList<>();
        for (int i=0; i< list.size(); i++) {
            HomeGoodsVO homeGoodsVO = new HomeGoodsVO();
            FilterEntity filterEntity = filterService.getById(Long.parseLong(list.get(i)));
            homeGoodsVO.setFilter(filterEntity);
            homeGoodsVOList.add(homeGoodsVO);
        }
        for (int j=0; j<homeGoodsVOList.size(); j++) {
            List<GoodsEntity> goodsEntityList1 = new ArrayList<>();
            for (int i=0; i< goodsEntityList.size(); i++) {
                if (goodsEntityList.get(i).getGoodscategoryId().contains(homeGoodsVOList.get(j).getFilter().getId().toString())){
                    goodsEntityList1.add(goodsEntityList.get(i));
                }
            }
            homeGoodsVOList.get(j).setGoodsList(goodsEntityList1);
        }
        return R.ok().put("homeGoodsVOList", homeGoodsVOList);
    }

    // 类别
    @RequestMapping("/save-show-in-index")
    public R saveShowInIndex(@RequestBody List<Integer> ids){
        // 先把表清空
        goodsCategoryService.removeAll();
        // 再保存最新的
        for (int i=0; i<ids.size(); i++) {
            GoodsCategoryEntity goodsCategory = new GoodsCategoryEntity();
            goodsCategory.setParentId((long)ids.get(i));
            goodsCategory.setLabel("首页显示的筛选类别");
            goodsCategoryService.save(goodsCategory);
        }
        return R.ok();
    }

    @Autowired
    private GoodsParamsService goodsParamsService;
    // 商品
    // 保存首页显示商品的id，保存在tb_goods_param表中
    @RequestMapping("/update-show-in-index")
    public R updateShowInIndex(@RequestBody List<Integer> ids){
        // 先把表清空
        goodsParamsService.removeAll();
        // 再保存最新的
        for (int i=0; i<ids.size(); i++) {
            GoodsParamsEntity goodsParamsEntity = new GoodsParamsEntity();
            goodsParamsEntity.setParentId((long)ids.get(i));
            goodsParamsEntity.setLabel("首页显示的筛选商品");
            goodsParamsService.save(goodsParamsEntity);
        }
        return R.ok();
    }

    @RequestMapping("/en/list")
    @RequiresPermissions("generator:goods:list")
    public R listEn(@RequestParam Map<String, Object> params){
        PageUtils page = goodsEnService.queryPage(params);
        System.out.println("..............");
        System.out.println(page);
        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{goodsId}")
    @RequiresPermissions("generator:goods:info")
    public R info(@PathVariable("goodsId") Long goodsId){
		GoodsEntity goods = goodsService.getById(goodsId);
        GoodsBO goodsBO = new GoodsBO();
        goodsBO.setBrilliant(goods.getBrilliant().split("@"));
        goodsBO.setParams(goods.getParams().split("@"));
        goodsBO.setGoodsCode(goods.getGoodsCode());
        goodsBO.setGoodsId(goods.getGoodsId());
        goodsBO.setGoodsName(goods.getGoodsName());
        goodsBO.setGoodsTitle(goods.getGoodsTitle());


        // goodsBO.setGoodscategoryId(goods.getGoodscategoryId());
        // 分类，数据库中只保存了子节点，需要还原为 父子节点id的数组
        String category = goods.getGoodscategoryId();
        String[] categoryArray = category.split(",");
        ArrayList<FilterEntity> cats = new ArrayList<>();
        for (int i=0; i<categoryArray.length; i++) {
            ArrayList<FilterEntity> catArray = new ArrayList<>();
            // GoodsCategoryEntity goodsCategoryEntity = goodsCategoryService.getById(Integer.parseInt(categoryArray[i]));
            FilterEntity filterEntity = filterService.queryFilterById(categoryArray[i]);
//            Long pid = goodsCategoryEntity.getParentId();
//            Long id = goodsCategoryEntity.getId();
            cats.add(filterEntity);
        }

        goodsBO.setListImage(goods.getListImage());
        goodsBO.setShowInIndex(goods.getShowInIndex());
        return R.ok().put("goods", goodsBO).put("cats", cats);
    }

    @RequestMapping("/en/info/{goodsId}")
    @RequiresPermissions("generator:goods:info")
    public R infoEn(@PathVariable("goodsId") Long goodsId){
        GoodsEnEntity goods = goodsEnService.getById(goodsId);
        GoodsBO goodsBO = new GoodsBO();
        goodsBO.setBrilliant(goods.getBrilliant().split("@"));
        goodsBO.setParams(goods.getParams().split("@"));
        goodsBO.setGoodsCode(goods.getGoodsCode());
        goodsBO.setGoodsId(goods.getGoodsId());
        goodsBO.setGoodsName(goods.getGoodsName());
        goodsBO.setGoodsTitle(goods.getGoodsTitle());
        goodsBO.setGoodscategoryId(goods.getGoodscategoryId());
        goodsBO.setListImage(goods.getListImage());
        goodsBO.setShowInIndex(goods.getShowInIndex());
        String category = goods.getGoodscategoryId();
        String[] categoryArray = category.split(",");
        ArrayList<ArrayList<Integer>> cats = new ArrayList<>();
        for (int i=0; i<categoryArray.length; i++) {
            ArrayList<Integer> catArray = new ArrayList<>();
            GoodsCategoryEnEntity goodsCategoryEntity = goodsCategoryEnService.getById(Integer.parseInt(categoryArray[i]));

            Long pid = goodsCategoryEntity.getParentId();
            Long id = goodsCategoryEntity.getId();

            catArray.add(pid.intValue());
            catArray.add(id.intValue());
            cats.add(catArray);
        }
        return R.ok().put("goods", goodsBO).put("cats", cats);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GoodsVO goodsVO){

        GoodsEntity goods = new GoodsEntity();
        goods.setGoodsName(goodsVO.getGoodsName());
        goods.setGoodsCode(goodsVO.getGoodsCode());
        goods.setGoodsTitle(goodsVO.getGoodsTitle());
        goods.setUpdated(new Date());
        String params = "";
        for (int i=0; i<goodsVO.getPars().size(); i++){
            if (params.equals("")){
                params += goodsVO.getPars().get(i);
            }else {
                params += "@" + goodsVO.getPars().get(i);
            }
        }
        String brilliant = "";
        for (int i=0; i<goodsVO.getBrill().size(); i++){
            if(brilliant.equals("")){
                brilliant += goodsVO.getBrill().get(i);
            }else{
                brilliant += "@" + goodsVO.getBrill().get(i);
            }
        }
        String categoryId = "";
        for (int i=0; i<goodsVO.getCategory().size(); i++){
            if(categoryId.equals("")){
                categoryId += goodsVO.getCategory().get(i);
            }else{
                categoryId += "," + goodsVO.getCategory().get(i);
            }
        }
        goods.setCategory(goodsVO.getCategory().get(goodsVO.getCategory().size()-1));
        goods.setParams(params);
        goods.setBrilliant(brilliant);
        goods.setGoodscategoryId(categoryId);
        for (int i=0; i<goodsVO.getListImage().size(); i++){
            goods.setListImage(goodsVO.getListImage().get(i));
        }
        goods.setShowInIndex(goodsVO.getShowInIndex());
		// goodsService.save(goods);
        goodsService.insertOnDuplicate(goods);
        goodsimagesService.deleteGoodsImageByGoodsCode(goods.getGoodsCode());
        for (int i=0; i<goodsVO.getDetailImage().size(); i++){
            GoodsimagesEntity image = new GoodsimagesEntity();
            image.setGoodsCode(goods.getGoodsCode());
            image.setImageCategory(2);
            String[] strs = goodsVO.getDetailImage().get(i).split("/");
            image.setImageName(strs[strs.length-1]);
            image.setImageUrl(goodsVO.getDetailImage().get(i));
            image.setImageCategorySort(i);
            image.setUpdated(new Date());
            goodsimagesService.save(image);
        }
        for (int i=0; i<goodsVO.getHeadImage().size(); i++){
            GoodsimagesEntity image = new GoodsimagesEntity();
            image.setGoodsCode(goods.getGoodsCode());
            image.setImageCategory(1);
            String[] strs = goodsVO.getHeadImage().get(i).split("/");
            image.setImageName(strs[strs.length-1]);
            image.setImageUrl(goodsVO.getHeadImage().get(i));
            image.setImageCategorySort(i);
            image.setUpdated(new Date());
            goodsimagesService.save(image);
        }
        return R.ok();
    }

    @RequestMapping("/en/save")
    @RequiresPermissions("generator:goods:save")
    public R saveEn(@RequestBody GoodsVO goodsVO){

        GoodsEnEntity goods = new GoodsEnEntity();
        goods.setGoodsName(goodsVO.getGoodsName());
        goods.setGoodsCode(goodsVO.getGoodsCode());
        goods.setGoodsTitle(goodsVO.getGoodsTitle());
        goods.setUpdated(new Date());
        String params = "";
        for (int i=0; i<goodsVO.getPars().size(); i++){
            if (params.equals("")){
                params += goodsVO.getPars().get(i);
            }else {
                params += "@" + goodsVO.getPars().get(i);
            }
        }
        String brilliant = "";
        for (int i=0; i<goodsVO.getBrill().size(); i++){
            if(brilliant.equals("")){
                brilliant += goodsVO.getBrill().get(i);
            }else{
                brilliant += "@" + goodsVO.getBrill().get(i);
            }
        }
        String categoryId = "";
        for (int i=0; i<goodsVO.getCategory().size(); i++){
            if(categoryId.equals("")){
                categoryId += goodsVO.getCategory().get(i);
            }else{
                categoryId += "," + goodsVO.getCategory().get(i);
            }
        }
        goods.setCategory(goodsVO.getCategory().get(goodsVO.getCategory().size()-1));
        goods.setParams(params);
        goods.setBrilliant(brilliant);
        goods.setGoodscategoryId(categoryId);
        for (int i=0; i<goodsVO.getListImage().size(); i++){
            goods.setListImage(goodsVO.getListImage().get(i));
        }
        goods.setShowInIndex(goodsVO.getShowInIndex());
        // goodsService.save(goods);
        goodsEnService.insertOnDuplicate(goods);
        goodsimagesEnService.deleteGoodsImageByGoodsCode(goods.getGoodsCode());

        for (int i=0; i<goodsVO.getDetailImage().size(); i++){
            GoodsimagesEnEntity image = new GoodsimagesEnEntity();
            image.setGoodsCode(goods.getGoodsCode());
            image.setImageCategory(2);
            String[] strs = goodsVO.getDetailImage().get(i).split("/");
            image.setImageName(strs[strs.length-1]);
            image.setImageUrl(goodsVO.getDetailImage().get(i));
            image.setImageCategorySort(i);
            image.setUpdated(new Date());
            goodsimagesEnService.save(image);
        }
        for (int i=0; i<goodsVO.getHeadImage().size(); i++){
            GoodsimagesEnEntity image = new GoodsimagesEnEntity();
            image.setGoodsCode(goods.getGoodsCode());
            image.setImageCategory(1);
            String[] strs = goodsVO.getHeadImage().get(i).split("/");
            image.setImageName(strs[strs.length-1]);
            image.setImageUrl(goodsVO.getHeadImage().get(i));
            image.setImageCategorySort(i);
            image.setUpdated(new Date());
            goodsimagesEnService.save(image);
        }
        return R.ok();
    }

    @RequestMapping("/checkGoodsCode")
    @RequiresPermissions("generator:goods:checkGoodsCode")
    public R checkGoodsCode(@RequestParam("goodsCode") String goodsCode){
        List<GoodsEntity> goodsEntities = goodsService.selectGoodsByCode(goodsCode);
        if (goodsEntities.size() > 0) {
            return R.ok();
        }
        return R.error();
    }

    @RequestMapping("/en/checkGoodsCode")
    @RequiresPermissions("generator:goods:checkGoodsCode")
    public R checkGoodsCodeEn(@RequestParam("goodsCode") String goodsCode){
        List<GoodsEnEntity> goodsEntities = goodsEnService.selectGoodsByCode(goodsCode);
        if (goodsEntities.size() > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:goods:update")
    public R update(@RequestBody GoodsEntity goods){
		goodsService.updateById(goods);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:goods:delete")
    public R delete(@RequestBody Long[] goodsIds){
		goodsService.removeByIds(Arrays.asList(goodsIds));

        return R.ok();
    }

    @RequestMapping("/en/delete")
    @RequiresPermissions("generator:goods:delete")
    public R deleteEn(@RequestBody Long[] goodsIds){
        goodsEnService.removeByIds(Arrays.asList(goodsIds));

        return R.ok();
    }
}

