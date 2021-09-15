package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.CustomerinfoEntity;
import io.renren.modules.generator.service.CustomerinfoService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-03 18:38:37
 */
@RestController
@RequestMapping("generator/customerinfo")
public class CustomerinfoController {
    @Autowired
    private CustomerinfoService customerinfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:customerinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = customerinfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:customerinfo:info")
    public R info(@PathVariable("id") Integer id){
		CustomerinfoEntity customerinfo = customerinfoService.getById(id);

        return R.ok().put("customerinfo", customerinfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:customerinfo:save")
    public R save(@RequestBody CustomerinfoEntity customerinfo){
		customerinfoService.save(customerinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:customerinfo:update")
    public R update(@RequestBody CustomerinfoEntity customerinfo){
		customerinfoService.updateById(customerinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:customerinfo:delete")
    public R delete(@RequestBody Integer[] ids){
		customerinfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
