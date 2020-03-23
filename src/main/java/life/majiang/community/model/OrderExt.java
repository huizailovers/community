package life.majiang.community.model;

import lombok.Data;

/**
 * 封装 订单 和用户 查询出来的关联信息
 */
@Data
public class OrderExt extends  Orders {
    private User user;
}
