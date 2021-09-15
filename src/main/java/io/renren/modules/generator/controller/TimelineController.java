package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.TimelineEntity;
import io.renren.modules.generator.service.TimelineService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-13 21:25:35
 */
@RestController
@RequestMapping("generator/timeline")
public class TimelineController {
    @Autowired
    private TimelineService timelineService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        // PageUtils page = timelineService.queryPage(params);
        List<TimelineEntity> timelineEntities = timelineService.selectByOrder();
        return R.ok().put("timelines", timelineEntities);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{year}")
    public R info(@PathVariable("year") String year){
		TimelineEntity timeline = timelineService.getById(year);

        return R.ok().put("timeline", timeline);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TimelineEntity timeline){
		// timelineService.save(timeline);
        timelineService.insertOnDuplicate(timeline);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TimelineEntity timeline){
		timelineService.updateById(timeline);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] years){
		timelineService.removeByIds(Arrays.asList(years));

        return R.ok();
    }

}
