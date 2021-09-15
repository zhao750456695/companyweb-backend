package io.renren.modules.generator.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.generator.entity.GoodsEntity;
import io.renren.modules.generator.vo.IndexVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.IndexEntity;
import io.renren.modules.generator.service.IndexService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-06 09:05:25
 */
@RestController
@RequestMapping("generator/index")
public class IndexController {
    @Autowired
    private IndexService indexService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:index:list")
    public R list(@RequestParam Map<String, Object> params){
        // PageUtils page = indexService.queryPage(params);
        // 关于公司
        IndexEntity about = new IndexEntity();
        about = indexService.selectAbout();

        List<IndexEntity> aboutItems = new ArrayList<>();
        aboutItems = indexService.selectAboutItems();

        List<IndexEntity> aboutNums = new ArrayList<>();
        aboutNums = indexService.selectAboutNums();

        // 公司动态
        IndexEntity dynamic = new IndexEntity();
        dynamic = indexService.selectNews();

        IndexEntity product = new IndexEntity();
        product = indexService.selectProduct();

        IndexEntity tech = new IndexEntity();
        tech = indexService.selectTech();

        return R.ok().put("abouth1", about.getH1()).put("abouth2", about.getH2()).put("aboutlist", aboutItems)
                .put("aboutlist1", aboutNums).put("dynamic", dynamic).put("product", product).put("tech", tech);
    }

    @RequestMapping("/en/list")
    @RequiresPermissions("generator:index:list")
    public R listEn(@RequestParam Map<String, Object> params){
        // PageUtils page = indexService.queryPage(params);
        // 关于公司
        IndexEntity about = new IndexEntity();
        about = indexService.selectAboutEN();

        List<IndexEntity> aboutItems = new ArrayList<>();
        aboutItems = indexService.selectAboutItemsEN();

        List<IndexEntity> aboutNums = new ArrayList<>();
        aboutNums = indexService.selectAboutNumsEN();

        // 公司动态
        IndexEntity dynamic = new IndexEntity();
        dynamic = indexService.selectNewsEN();

        IndexEntity product = new IndexEntity();
        product = indexService.selectProductEN();

        IndexEntity tech = new IndexEntity();
        tech = indexService.selectTechEN();

        return R.ok().put("abouth1", about.getH1()).put("abouth2", about.getH2()).put("aboutlist", aboutItems)
                .put("aboutlist1", aboutNums).put("dynamic", dynamic).put("product", product).put("tech", tech);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:index:info")
    public R info(@PathVariable("id") Integer id){
		IndexEntity index = indexService.getById(id);

        return R.ok().put("index", index);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:index:save")
    public R save(@RequestBody IndexVO indexVO){
		IndexEntity index = null;

        index = new IndexEntity();
        index.setCategory(0);
        index.setH1(indexVO.getAbouth1());
        index.setH2(indexVO.getAbouth2());
        index.setKid(0);
        indexService.insertOnDuplicate(index);

        index = new IndexEntity();
        index.setCategory(1);
        index.setH1(indexVO.getC1h1());
        index.setH2(indexVO.getC1h2());
        index.setKid(1);
        indexService.insertOnDuplicate(index);

//        index = new IndexEntity();
//        index.setCategory(1);
//        index.setH1(indexVO.getC1h1());
//        index.setH2(indexVO.getC1h2());
//        index.setKid(2);
//        indexService.insertOnDuplicate(index);

        index = new IndexEntity();
        index.setCategory(1);
        index.setH1(indexVO.getC2h1());
        index.setH2(indexVO.getC2h2());
        index.setKid(2);
        indexService.insertOnDuplicate(index);

        index = new IndexEntity();
        index.setCategory(1);
        index.setH1(indexVO.getC3h1());
        index.setH2(indexVO.getC3h2());
        index.setKid(3);
        indexService.insertOnDuplicate(index);

        index = new IndexEntity();
        index.setCategory(1);
        index.setH1(indexVO.getC4h1());
        index.setH2(indexVO.getC4h2());
        index.setKid(4);
        indexService.insertOnDuplicate(index);

        index = new IndexEntity();
        index.setCategory(1);
        index.setH1(indexVO.getC5h1());
        index.setH2(indexVO.getC5h2());
        index.setKid(5);
        indexService.insertOnDuplicate(index);

        index = new IndexEntity();
        index.setCategory(1);
        index.setH1(indexVO.getC6h1());
        index.setH2(indexVO.getC6h2());
        index.setKid(6);
        indexService.insertOnDuplicate(index);

        index = new IndexEntity();
        index.setCategory(2);
        index.setH1(indexVO.getNum1());
        index.setH2(indexVO.getKeyword1());
        index.setKid(7);
        indexService.insertOnDuplicate(index);

        index = new IndexEntity();
        index.setCategory(2);
        index.setH1(indexVO.getNum2());
        index.setH2(indexVO.getKeyword2());
        index.setKid(8);
        indexService.insertOnDuplicate(index);

        index = new IndexEntity();
        index.setCategory(2);
        index.setH1(indexVO.getNum3());
        index.setH2(indexVO.getKeyword3());
        index.setKid(9);
        indexService.insertOnDuplicate(index);

        index = new IndexEntity();
        index.setCategory(2);
        index.setH1(indexVO.getNum4());
        index.setH2(indexVO.getKeyword4());
        index.setKid(10);
        indexService.insertOnDuplicate(index);

        index = new IndexEntity();
        index.setCategory(3);
        index.setH1(indexVO.getNewsh1());
        index.setH2(indexVO.getNewsh2());
        index.setKid(11);
        indexService.insertOnDuplicate(index);

        index = new IndexEntity();
        index.setCategory(4);
        index.setH1(indexVO.getProducth1());
        index.setH2(indexVO.getProducth2());
        index.setKid(12);
        indexService.insertOnDuplicate(index);

        index = new IndexEntity();
        index.setCategory(5);
        index.setH1(indexVO.getTechh1());
        index.setH2(indexVO.getTechh2());
        index.setKid(13);
        indexService.insertOnDuplicate(index);

        return R.ok();
    }

    /**
     * 保存
     */
    @RequestMapping("/en/save")
    @RequiresPermissions("generator:index:save")
    public R saveEn(@RequestBody IndexVO indexVO){
        IndexEntity index = null;

        index = new IndexEntity();
        index.setCategory(0);
        index.setH1(indexVO.getAbouth1());
        index.setH2(indexVO.getAbouth2());
        index.setKid(0);
        indexService.insertOnDuplicateEN(index);

        index = new IndexEntity();
        index.setCategory(1);
        index.setH1(indexVO.getC1h1());
        index.setH2(indexVO.getC1h2());
        index.setKid(1);
        indexService.insertOnDuplicateEN(index);

//        index = new IndexEntity();
//        index.setCategory(1);
//        index.setH1(indexVO.getC1h1());
//        index.setH2(indexVO.getC1h2());
//        index.setKid(2);
//        indexService.insertOnDuplicate(index);

        index = new IndexEntity();
        index.setCategory(1);
        index.setH1(indexVO.getC2h1());
        index.setH2(indexVO.getC2h2());
        index.setKid(2);
        indexService.insertOnDuplicateEN(index);

        index = new IndexEntity();
        index.setCategory(1);
        index.setH1(indexVO.getC3h1());
        index.setH2(indexVO.getC3h2());
        index.setKid(3);
        indexService.insertOnDuplicateEN(index);

        index = new IndexEntity();
        index.setCategory(1);
        index.setH1(indexVO.getC4h1());
        index.setH2(indexVO.getC4h2());
        index.setKid(4);
        indexService.insertOnDuplicateEN(index);

        index = new IndexEntity();
        index.setCategory(1);
        index.setH1(indexVO.getC5h1());
        index.setH2(indexVO.getC5h2());
        index.setKid(5);
        indexService.insertOnDuplicateEN(index);

        index = new IndexEntity();
        index.setCategory(1);
        index.setH1(indexVO.getC6h1());
        index.setH2(indexVO.getC6h2());
        index.setKid(6);
        indexService.insertOnDuplicateEN(index);

        index = new IndexEntity();
        index.setCategory(2);
        index.setH1(indexVO.getNum1());
        index.setH2(indexVO.getKeyword1());
        index.setKid(7);
        indexService.insertOnDuplicateEN(index);

        index = new IndexEntity();
        index.setCategory(2);
        index.setH1(indexVO.getNum2());
        index.setH2(indexVO.getKeyword2());
        index.setKid(8);
        indexService.insertOnDuplicateEN(index);

        index = new IndexEntity();
        index.setCategory(2);
        index.setH1(indexVO.getNum3());
        index.setH2(indexVO.getKeyword3());
        index.setKid(9);
        indexService.insertOnDuplicateEN(index);

        index = new IndexEntity();
        index.setCategory(2);
        index.setH1(indexVO.getNum4());
        index.setH2(indexVO.getKeyword4());
        index.setKid(10);
        indexService.insertOnDuplicateEN(index);

        index = new IndexEntity();
        index.setCategory(3);
        index.setH1(indexVO.getNewsh1());
        index.setH2(indexVO.getNewsh2());
        index.setKid(11);
        indexService.insertOnDuplicateEN(index);

        index = new IndexEntity();
        index.setCategory(4);
        index.setH1(indexVO.getProducth1());
        index.setH2(indexVO.getProducth2());
        index.setKid(12);
        indexService.insertOnDuplicateEN(index);

        index = new IndexEntity();
        index.setCategory(5);
        index.setH1(indexVO.getTechh1());
        index.setH2(indexVO.getTechh2());
        index.setKid(13);
        indexService.insertOnDuplicateEN(index);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:index:update")
    public R update(@RequestBody IndexEntity index){
		indexService.updateById(index);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:index:delete")
    public R delete(@RequestBody Integer[] ids){
		indexService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
