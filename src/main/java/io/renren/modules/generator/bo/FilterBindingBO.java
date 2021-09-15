/**
 * projectName: renren-fast
 * fileName: FilterBindingBO.java
 * packageName: io.renren.modules.generator.bo
 * date: 2021-06-16 10:15
 * copyright(c) 2017-2020 xxx公司
 */
package io.renren.modules.generator.bo;

import io.renren.modules.generator.entity.FilterEntity;
import io.renren.modules.generator.entity.GoodsCategoryEntity;

import java.util.List;

public class FilterBindingBO {
    private GoodsCategoryEntity goodsCategoryEntity;
    private List<FilterEntity> filterEntityList;
    private Integer[] ids;

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public GoodsCategoryEntity getGoodsCategoryEntity() {
        return goodsCategoryEntity;
    }

    public void setGoodsCategoryEntity(GoodsCategoryEntity goodsCategoryEntity) {
        this.goodsCategoryEntity = goodsCategoryEntity;
    }

    public List<FilterEntity> getFilterEntityList() {
        return filterEntityList;
    }

    public void setFilterEntityList(List<FilterEntity> filterEntityList) {
        this.filterEntityList = filterEntityList;
    }
}
