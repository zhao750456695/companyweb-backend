/**
 * projectName: renren-fast
 * fileName: ParamGroupBO.java
 * packageName: io.renren.modules.generator.bo
 * date: 2021-06-18 14:49
 * copyright(c) 2017-2020 xxx公司
 */
package io.renren.modules.generator.bo;

import io.renren.modules.generator.entity.GoodsParamsEntity;

import java.util.List;

public class ParamGroupBO {

    private Long id;
    private String paramGroupName;
    private List<GoodsParamsEntity> paramsList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParamGroupName() {
        return paramGroupName;
    }

    public void setParamGroupName(String paramGroupName) {
        this.paramGroupName = paramGroupName;
    }

    public List<GoodsParamsEntity> getParamsList() {
        return paramsList;
    }

    public void setParamsList(List<GoodsParamsEntity> paramsList) {
        this.paramsList = paramsList;
    }
}
