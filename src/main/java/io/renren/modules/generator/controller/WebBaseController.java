/**
 * projectName: renren-fast
 * fileName: WebBaseController.java
 * packageName: io.renren.modules.generator.controller
 * date: 2021-04-25 7:56
 * copyright(c) 2017-2020 xxx公司
 */
package io.renren.modules.generator.controller;

import com.alibaba.fastjson.JSONObject;
import io.renren.common.annotation.SysLog;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.generator.entity.WebBaseEntity;
import io.renren.modules.generator.entity.WebimagesEntity;
import io.renren.modules.sys.entity.SysConfigEntity;
import io.renren.modules.sys.service.SysConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("generator/webase")
public class WebBaseController {

    @Autowired
    private SysConfigService sysConfigService;

    /**
     * 所有配置列表
     */
    @GetMapping("/list")
    @RequiresPermissions("sys:config:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysConfigService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("/en/list")
    @RequiresPermissions("sys:config:list")
    public R listEn(@RequestParam Map<String, Object> params){
        PageUtils page = sysConfigService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 配置信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("sys:config:info")
    public R info(@PathVariable("id") Long id){
        SysConfigEntity config = sysConfigService.getById(id);

        return R.ok().put("config", config);
    }

    /**
     * 保存配置
     */
    @SysLog("保存配置")
    @PostMapping("/save")
    @RequiresPermissions("sys:config:save")
    public R save(@RequestBody WebBaseEntity webBaseEntity){

        SysConfigEntity config = new SysConfigEntity();
        config.setParamKey("WEBASE_KEY");
        String value = JSONObject.toJSONString(webBaseEntity);
        config.setParamValue(value);
        ValidatorUtils.validateEntity(config);

        sysConfigService.saveConfig(config);

        return R.ok();
    }

    @SysLog("保存配置")
    @PostMapping("/en/save")
    @RequiresPermissions("sys:config:save")
    public R saveEn(@RequestBody WebBaseEntity webBaseEntity){

        SysConfigEntity config = new SysConfigEntity();
        config.setParamKey("WEBASE_KEY_EN");
        String value = JSONObject.toJSONString(webBaseEntity);
        config.setParamValue(value);
        ValidatorUtils.validateEntity(config);

        sysConfigService.saveConfig(config);

        return R.ok();
    }

    /**
     * 修改配置
     */
    @SysLog("修改配置")
    @PostMapping("/update")
    @RequiresPermissions("sys:config:update")
    public R update(@RequestBody WebBaseEntity webBaseEntity, @RequestParam Integer id){
        SysConfigEntity config = new SysConfigEntity();
        config.setParamKey("WEBASE_KEY");
        String value = JSONObject.toJSONString(webBaseEntity);
        config.setParamValue(value);
        config.setId((long)id);
        ValidatorUtils.validateEntity(config);

        sysConfigService.update(config);

        return R.ok();
    }

    /**
     * 修改配置
     */
    @SysLog("修改配置")
    @PostMapping("/en/update")
    @RequiresPermissions("sys:config:update")
    public R updateEn(@RequestBody WebBaseEntity webBaseEntity, @RequestParam Integer id){
        SysConfigEntity config = new SysConfigEntity();
        config.setParamKey("WEBASE_KEY_EN");
        String value = JSONObject.toJSONString(webBaseEntity);
        config.setParamValue(value);
        config.setId((long)id);
        ValidatorUtils.validateEntity(config);

        sysConfigService.update(config);

        return R.ok();
    }

    /**
     * 删除配置
     */
    @SysLog("删除配置")
    @PostMapping("/delete")
    @RequiresPermissions("sys:config:delete")
    public R delete(@RequestBody Long[] ids){
        sysConfigService.deleteBatch(ids);

        return R.ok();
    }

    @SysLog("删除配置")
    @PostMapping("/en/delete")
    @RequiresPermissions("sys:config:delete")
    public R deleteEn(@RequestBody Long[] ids){
        sysConfigService.deleteBatch(ids);

        return R.ok();
    }
}
