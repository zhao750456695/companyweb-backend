package io.renren.modules.generator.controller;

import java.util.*;

import io.renren.modules.generator.entity.GoodsimagesEnEntity;
import io.renren.modules.generator.service.GoodsimagesEnService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.GoodsimagesEntity;
import io.renren.modules.generator.service.GoodsimagesService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 商品图片管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-16 15:01:20
 */
@RestController
@RequestMapping("generator/goodsimages")
public class GoodsimagesController {
    @Autowired
    private GoodsimagesService goodsimagesService;

    @Autowired
    private GoodsimagesEnService goodsimagesEnService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsimagesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{imageId}")
    public R info(@PathVariable("imageId") Long imageId){
		GoodsimagesEntity goodsimages = goodsimagesService.getById(imageId);

        return R.ok().put("goodsimages", goodsimages);
    }

    @RequestMapping("/infoList/{goodsCode}")
    public R infoList(@PathVariable("goodsCode") String goodsCode){
        List<GoodsimagesEntity> goodsimages = goodsimagesService.selectGoodsImageByGoodsCode(goodsCode);
        List<GoodsimagesEntity> headImages = new ArrayList<>();
        List<GoodsimagesEntity> detailImages = new ArrayList<>();
        for (int i = 0; i < goodsimages.size(); i++) {
            if (goodsimages.get(i).getImageCategory().equals(1)) {
                headImages.add(goodsimages.get(i));
            }
            if (goodsimages.get(i).getImageCategory().equals(2)) {
                detailImages.add(goodsimages.get(i));
            }
        }
        Collections.sort(headImages, new SortByImageCategory());
        Collections.sort(detailImages, new SortByImageCategory());

        return R.ok().put("headImages", headImages).put("detailImages", detailImages);
    }

    @RequestMapping("/en/infoList/{goodsCode}")
    public R infoListEn(@PathVariable("goodsCode") String goodsCode){
        List<GoodsimagesEnEntity> goodsimages = goodsimagesEnService.selectGoodsImageByGoodsCode(goodsCode);
        List<GoodsimagesEnEntity> headImages = new ArrayList<>();
        List<GoodsimagesEnEntity> detailImages = new ArrayList<>();
        for (int i = 0; i < goodsimages.size(); i++) {
            if (goodsimages.get(i).getImageCategory().equals(1)) {
                headImages.add(goodsimages.get(i));
            }
            if (goodsimages.get(i).getImageCategory().equals(2)) {
                detailImages.add(goodsimages.get(i));
            }
        }
        Collections.sort(headImages, new SortByImageCategory());
        Collections.sort(detailImages, new SortByImageCategory());

        return R.ok().put("headImages", headImages).put("detailImages", detailImages);
    }


    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GoodsimagesEntity goodsimages){
        goodsimagesService.deleteGoodsImageByGoodsCode(goodsimages.getGoodsCode());
		goodsimagesService.save(goodsimages);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GoodsimagesEntity goodsimages){
		goodsimagesService.updateById(goodsimages);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] imageIds){
		goodsimagesService.removeByIds(Arrays.asList(imageIds));

        return R.ok();
    }

}

class SortByImageCategory implements Comparator {

    public int compare(Object o1, Object o2) {
        if(((GoodsimagesEntity)o1).getImageCategory()>((GoodsimagesEntity)o2).getImageCategory())
            return -1;
        return 1;
    }

}