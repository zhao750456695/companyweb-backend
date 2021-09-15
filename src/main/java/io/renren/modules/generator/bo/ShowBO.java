package io.renren.modules.generator.bo;

import lombok.Data;

import java.util.List;

@Data
public class ShowBO {
    private String title;
    /**
     * 发布日期
     */
    private String updated;
    /**
     * 描述
     */
    private String descri;
    /**
     * 内容
     */
    private String content;

    private List<String> images;

    private Integer id;
}
