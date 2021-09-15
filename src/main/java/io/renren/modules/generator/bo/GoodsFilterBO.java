package io.renren.modules.generator.bo;

import lombok.Data;
import java.util.List;

@Data
public class GoodsFilterBO {
    private Long id;

    private Long parentId;

    private String label;

    private List<GoodsFilterBO> children;

    private Integer stat;

    @Override
    public String toString() {
        return "GoodsFilterBO{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", label='" + label + '\'' +
                ", children=" + children +
                ", stat=" + stat +
                '}';
    }
}
