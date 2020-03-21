package life.majiang.community.controller;

import life.majiang.community.dto.AccessTokenDto;
import life.majiang.community.dto.GithubUser;
import life.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author  zhangch
 */
@Controller
@PropertySource(value = "classpath:githubclient.properties",encoding = "utf-8")
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String clientRedirecturi;

    @GetMapping("/callback")
    @ResponseBody
    public GithubUser callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state){

        AccessTokenDto accessTokenDto = AccessTokenDto.builder()
                .client_id(clientId)
                .client_secret(clientSecret)
                .redirect_uri(clientRedirecturi)
                .state("").build();

        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        GithubUser githubUser = githubProvider.getUser(accessToken);

        return githubUser;
    }
}
