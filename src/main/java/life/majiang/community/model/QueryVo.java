package life.majiang.community.model;

import lombok.Data;

import java.util.List;

/**
 * @author zhangch
 */
@Data
public class QueryVo {

    private User user;
    private List<Integer> ids;
}
