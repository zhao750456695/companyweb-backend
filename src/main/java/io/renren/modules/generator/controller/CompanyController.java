package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.generator.service.CompanyEnService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.CompanyEntity;
import io.renren.modules.generator.service.CompanyService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-24 12:32:19
 */
@RestController
@RequestMapping("generator/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyEnService companyEnService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:company:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = companyService.queryPage(params);

        return R.ok().put("page", page);
    }

    @RequestMapping("/en/list")
    @RequiresPermissions("generator:company:list")
    public R listEn(@RequestParam Map<String, Object> params){
        PageUtils page = companyEnService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:company:info")
    public R info(@PathVariable("id") Integer id){
		CompanyEntity company = companyService.getById(id);

        return R.ok().put("company", company);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CompanyEntity company){
        companyService.insertOnDuplicate(company.getCategory(), company.getContent());
        return R.ok();
    }

    @RequestMapping("/en/save")
    @RequiresPermissions("generator:company:save")
    public R saveEn(@RequestBody CompanyEntity company){

        companyService.insertOnDuplicateEN(company.getCategory(), company.getContent());
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:company:update")
    public R update(@RequestBody CompanyEntity company){
		companyService.updateById(company);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:company:delete")
    public R delete(@RequestBody Integer[] ids){
		companyService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
