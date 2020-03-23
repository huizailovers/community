package life.majiang.community.controller;

import life.majiang.community.dto.AccessTokenDto;
import life.majiang.community.dto.GithubUser;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.mapper.UserMapperXml;
import life.majiang.community.model.User;
import life.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author  zhangch
 */
@RestController
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

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMapperXml userMapperXml;

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
    @GetMapping("/addUser")
    @ResponseBody
    public String  addUser(){
        User user = new User();
        user.setAccountId("xxx");
        userMapper.insertUser(user);
        return "success";
    }

    @GetMapping("/user")
    @ResponseBody
    public User getUserByName(@RequestParam("name") String name){
        User user = userMapper.getUserByName(name);
        System.out.println(user);
        return user;
    }

    @GetMapping("/user1")
    @ResponseBody
    public User getUserByToken(String token){
        User user = User.builder().name("zhangch").token(token).build();
        System.out.println(user);
        return user;
    }

    @PostMapping("/saveUser")
    public String saveUser(@RequestBody User user){
        System.out.println(user);
        return  "ok";
    }

    @GetMapping("/userXml")
    public User findUserByName(
            @RequestParam(value = "name", required = false, defaultValue = "zhangch") String name){
        User user = userMapperXml.findUserByName(name);
        System.out.println(user);
        return user;
    }

    @GetMapping("/userList")
    public  List<User> findUserList(@RequestParam("name") String name){
        List<User> userlist = userMapperXml.findUserByNameLike(name);
        return userlist;
    }


}
