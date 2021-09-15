package io.renren.modules.generator.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.generator.bo.ShowBO;
import io.renren.modules.generator.entity.ShowimageEntity;
import io.renren.modules.generator.service.ShowimageService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.ShowsEntity;
import io.renren.modules.generator.service.ShowsService;
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
@RequestMapping("generator/shows")
public class ShowsController {
    @Autowired
    private ShowsService showsService;

    @Autowired
    private ShowimageService showimageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:shows:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = showsService.queryPage(params);

        return R.ok().put("page", page);
    }

    @RequestMapping("/album")
    public R getAlbum(){
        List<ShowimageEntity> album = showimageService.getByShowId(0);
//        List<String> urls = new ArrayList<>();
//        for (int i=0; i<album.size(); i++) {
//            urls.add(album.get(i).getUrl());
//        }
        return R.ok().put("album", album);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:shows:info")
    public R info(@PathVariable("id") Integer id){
		ShowsEntity shows = showsService.getById(id);
		List<ShowimageEntity> showImg = showimageService.getByShowId(id);
		List<String> sImg = new ArrayList<>();
		for (int i=0; i<showImg.size(); i++) {
		    sImg.add(showImg.get(i).getUrl());
        }
        ShowBO show = new ShowBO();
        show.setContent(shows.getContent());
        show.setDescri(shows.getDescri());
        show.setUpdated(shows.getUpdated());
        show.setTitle(shows.getTitle());
        show.setImages(sImg);
        return R.ok().put("shows", show);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:shows:save")
    public R save(@RequestBody ShowsEntity shows){
		showsService.save(shows);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:shows:update")
    public R update(@RequestBody ShowBO showBO){

        ShowsEntity show = new ShowsEntity();
        show.setContent(showBO.getContent());
        show.setDescri(showBO.getDescri());
        show.setTitle(showBO.getTitle());
        show.setUpdated(showBO.getUpdated());
        show.setId(showBO.getId());
        showsService.updateShowById(show);
        // 更新展会对应的图片
        if (showBO.getImages().size()>0) {
            // 先删除
            showimageService.delImageByShowId(show.getId());
            // 再插入
            for (int i=0; i<showBO.getImages().size(); i++) {
                showimageService.insertOnDuplicate(show.getId(), showBO.getImages().get(i));
            }
        }
		showsService.updateById(show);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:shows:delete")
    public R delete(@RequestBody Integer[] ids){
		showsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
