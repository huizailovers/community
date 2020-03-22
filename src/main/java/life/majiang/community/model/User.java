package life.majiang.community.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * @author  zhangch
 */

@Data
@Builder
public class User {

    private Long id;
    private String accountId;
    private String name;
    private String token;
    private Long gmtCreate;

    @Tolerate
    public User() {}
}
