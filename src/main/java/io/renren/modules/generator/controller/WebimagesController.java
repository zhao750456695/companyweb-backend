package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.renren.modules.generator.entity.WebimagesEnEntity;
import io.renren.modules.generator.service.WebimagesEnService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.WebimagesEntity;
import io.renren.modules.generator.service.WebimagesService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-24 21:08:24
 */
@RestController
@RequestMapping("generator/webimages")
public class WebimagesController {
    @Autowired
    private WebimagesService webimagesService;

    @Autowired
    private WebimagesEnService webimagesEnService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:webimages:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = webimagesService.queryPage(params);

        return R.ok().put("page", page);
    }

    @RequestMapping("/getIntroPictureList")
    public R introPictureList(){
        List<WebimagesEntity> introImages = webimagesService.getPictureListByCategoryId(2);
        return R.ok().put("introImages", introImages);
    }

    @RequestMapping("/getCertPictureList")
    public R certPictureList(){
        List<WebimagesEntity> introImages = webimagesService.getPictureListByCategoryId(3);
        return R.ok().put("introImages", introImages);
    }

    @RequestMapping("/getPartnerPictureList")
    public R partnerPictureList(){
        List<WebimagesEntity> introImages = webimagesService.getPictureListByCategoryId(88);
        return R.ok().put("introImages", introImages);
    }

    @RequestMapping("/getHomePictureList")
    public R homePictureList(){
        List<WebimagesEntity> introImages = webimagesService.getPictureListByCategoryId(1);
        return R.ok().put("homeImages", introImages);
    }

    @RequestMapping("/getMallPicture")
    public R mallPicture(){
        List<WebimagesEntity> introImages = webimagesService.getPictureListByCategoryId(66);
        return R.ok().put("mallImages", introImages);
    }
    @RequestMapping("/delMallPicture")
    public R delMallPicture(){
        webimagesService.deletePictureListByCategoryId(66);
        return R.ok();
    }
    @RequestMapping("/en/list")
    @RequiresPermissions("generator:webimages:list")
    public R listEn(@RequestParam Map<String, Object> params){
        PageUtils page = webimagesEnService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:webimages:info")
    public R info(@PathVariable("id") Integer id){
		WebimagesEntity webimages = webimagesService.getById(id);

        return R.ok().put("webimages", webimages);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WebimagesEntity webimages){
        webimages.setUpdated(new Date());
//        String[] strs = webimages.getUrl().split("/");
//        webimages.setIname(strs[strs.length-1]);
		webimagesService.save(webimages);
        return R.ok();
    }

    @RequestMapping("/save-and-update")
    public R saveAndUpdate(@RequestBody WebimagesEntity webimages){
        // 先删除
        webimagesService.deletePictureListByCategoryId(66);
        // 再插入
        webimagesService.save(webimages);
        // webimagesService.insertOnDuplicate(webimages.getLink(), webimages.getUrl(), webimages.getCategory());
        return R.ok();
    }

    @RequestMapping("/en/save")
    @RequiresPermissions("generator:webimages:save")
    public R saveEn(@RequestBody WebimagesEnEntity webimages){
        webimages.setUpdated(new Date());
        String[] strs = webimages.getUrl().split("/");
        webimages.setIname(strs[strs.length-1]);
        webimagesEnService.save(webimages);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody WebimagesEntity webimages){
		webimagesService.updateById(webimages);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:webimages:delete")
    public R delete(@RequestBody Integer[] ids){
		webimagesService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
