/**
 * projectName: renren-fast
 * fileName: WebBaseEntity.java
 * packageName: io.renren.modules.generator.entity
 * date: 2021-04-25 7:56
 * copyright(c) 2017-2020 xxx公司
 */
package io.renren.modules.generator.entity;


import lombok.Data;

@Data
public class WebBaseEntity {

    private String webname;
    /**
     *
     */
    private String descri;
    /**
     *
     */
    private String keyword;

    private String title;

    private String iconurl;

    private String slogan;

    private String record;
}
