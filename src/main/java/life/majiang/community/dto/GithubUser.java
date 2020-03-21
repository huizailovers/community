package life.majiang.community.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GithubUser {

    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
