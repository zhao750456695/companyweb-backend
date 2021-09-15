package io.renren.modules.generator.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import io.renren.modules.generator.bo.ShowBO;
import io.renren.modules.generator.dao.ShowsDao;
import io.renren.modules.generator.entity.NewsEnEntity;
import io.renren.modules.generator.entity.ShowimageEntity;
import io.renren.modules.generator.entity.ShowsEntity;
import io.renren.modules.generator.service.NewsEnService;
import io.renren.modules.generator.service.ShowimageService;
import io.renren.modules.generator.service.ShowsService;
import io.renren.modules.oss.cloud.OSSFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.NewsEntity;
import io.renren.modules.generator.service.NewsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-20 19:52:16
 */
@RestController
@RequestMapping("generator/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @Autowired
    private NewsEnService newsEnService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:news:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = newsService.queryPage(params);

        return R.ok().put("page", page);
    }

    @RequestMapping("/en/list")
    @RequiresPermissions("generator:news:list")
    public R listEn(@RequestParam Map<String, Object> params){
        PageUtils page = newsEnService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:news:info")
    public R info(@PathVariable("id") String title){
        NewsEntity news = null;
        if (title != "0") {
            news = newsService.getById(title);
        }

        return R.ok().put("news", news);
    }

    @RequestMapping("/en/info/{id}")
    @RequiresPermissions("generator:news:info")
    public R infoEn(@PathVariable("id") String title){
        NewsEnEntity news = null;
        if (title != "0") {
            news = newsEnService.getById(title);
        }
        return R.ok().put("news", news);
    }

    @Autowired
    private ShowsService showsService;
    @Autowired
    private ShowimageService showimageService;
    /**
     * 保存
     */
    @RequestMapping("/show/save")
    @RequiresPermissions("generator:news:save")
    public R showSave(@RequestBody ShowBO showBO){
        // 首先保存展会信息
        ShowsEntity show = new ShowsEntity();
        show.setContent(showBO.getContent());
        show.setDescri(showBO.getDescri());
        show.setTitle(showBO.getTitle());
        show.setUpdated(showBO.getUpdated());
        showsService.insertShowInfo(show);
        // 然后保存展会对应的图片
        for (int i=0; i<showBO.getImages().size(); i++) {
            showimageService.insertOnDuplicate(show.getId(), showBO.getImages().get(i));
        }
        return R.ok();
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:news:save")
    public R save(@RequestBody NewsEntity news){
		// news.setUpdated(new Date());
        newsService.save(news);
        return R.ok();
    }

    @RequestMapping("/en/save")
    @RequiresPermissions("generator:news:save")
    public R saveEn(@RequestBody NewsEnEntity news){
        news.setUpdated(new Date());
        newsEnService.save(news);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:news:update")
    public R update(@RequestBody NewsEntity news){
		newsService.updateById(news);

        return R.ok();
    }

    @RequestMapping("/en/update")
    @RequiresPermissions("generator:news:update")
    public R updateEn(@RequestBody NewsEnEntity news){
        newsEnService.updateById(news);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:news:delete")
    public R delete(@RequestBody String[] titles){
		newsService.removeByIds(Arrays.asList(titles));
        return R.ok();
    }

    @RequestMapping("/en/delete")
    @RequiresPermissions("generator:news:delete")
    public R deleteEn(@RequestBody String[] titles){
        newsEnService.removeByIds(Arrays.asList(titles));
        return R.ok();
    }

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/test")
    @RequiresPermissions("generator:news:delete")
    public void test(MultipartFile upload, HttpServletRequest request, HttpServletResponse response) throws IOException {

        log.info(upload.getName());
        String url = "";
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String date2=sdf.format(date);
            url = OSSFactory.build().upload(new ByteArrayInputStream(upload.getBytes()), "chunjiang/news/" + date2 + "/" + upload.getOriginalFilename());
            log.info(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,Object> map = new HashMap<String,Object>() ;
        map.put("fileName", upload.getOriginalFilename()) ;
        map.put("uploaded", 1) ;
        map.put("url", url) ;
        String result = JSON.toJSONString(map);
//        "fileName":"1.png",
//                "uploaded":"1",
//                "url":"http://xxxxx.com:8080/download/6c"
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }

    @RequestMapping("/uploadPasteImage")
    public void uploadPasteImage(MultipartFile upload, HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info(upload.getName());
        String url = "";
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String date2=sdf.format(date);
            url = OSSFactory.build().upload(new ByteArrayInputStream(upload.getBytes()), "chunjiang/news/" + date2 + "/" + upload.getOriginalFilename());
            log.info(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,Object> map = new HashMap<String,Object>() ;
        map.put("fileName", upload.getOriginalFilename()) ;
        map.put("uploaded", 1) ;
        map.put("url", url) ;
        String result = JSON.toJSONString(map);
//        "fileName":"1.png",
//                "uploaded":"1",
//                "url":"http://xxxxx.com:8080/download/6c"
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }



}
