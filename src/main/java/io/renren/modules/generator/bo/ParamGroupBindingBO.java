/**
 * projectName: renren-fast
 * fileName: ParamGroupBindingBO.java
 * packageName: io.renren.modules.generator.bo
 * date: 2021-06-18 18:22
 * copyright(c) 2017-2020 xxx公司
 */
package io.renren.modules.generator.bo;

import io.renren.modules.generator.entity.GoodsCategoryEntity;
import io.renren.modules.generator.entity.ParamGroupEntity;

import java.util.List;

public class ParamGroupBindingBO {
    private GoodsCategoryEntity goodsCategoryEntity;
    private List<ParamGroupEntity> paramGroupEntityList;
    private Long[] checkedId;

    public GoodsCategoryEntity getGoodsCategoryEntity() {
        return goodsCategoryEntity;
    }

    public void setGoodsCategoryEntity(GoodsCategoryEntity goodsCategoryEntity) {
        this.goodsCategoryEntity = goodsCategoryEntity;
    }

    public List<ParamGroupEntity> getParamGroupEntityList() {
        return paramGroupEntityList;
    }

    public void setParamGroupEntityList(List<ParamGroupEntity> paramGroupEntityList) {
        this.paramGroupEntityList = paramGroupEntityList;
    }

    public Long[] getCheckedId() {
        return checkedId;
    }

    public void setCheckedId(Long[] checkedId) {
        this.checkedId = checkedId;
    }
}
