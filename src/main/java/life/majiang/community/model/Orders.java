package life.majiang.community.model;

import lombok.Data;

/**
 * @author zhangch
 *  订单相关属性
 */
@Data
public class Orders {
    private Long id;
    private String orderName;
    private int number;
    private Long userId;
}
