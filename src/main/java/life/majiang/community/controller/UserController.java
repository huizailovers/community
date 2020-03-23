package life.majiang.community.controller;

import life.majiang.community.mapper.UserMapper;
import life.majiang.community.mapper.UserMapperXml;
import life.majiang.community.model.OrderExt;
import life.majiang.community.model.QueryVo;
import life.majiang.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  zhangch
 */
@RestController
public class UserController {

    @Autowired
    private UserMapperXml userMapperXml;


    @PostMapping("/user")
    public User  addUser(@RequestBody User user){
        userMapperXml.addUser(user);
        System.out.println(user);
        return user;
    }

    @GetMapping("/queryUser")
    public User findUserByQueryVo(){
        User user = new User();
        user.setName("zhangch");
        QueryVo vo = new QueryVo();
        vo.setUser(user);

        User user1 = userMapperXml.findUserByQueryVo(vo);
        return user1;
    }

    @GetMapping("/orderExt")
    public List<OrderExt> findOrdersAndUserRstMap(){
        List<OrderExt> list = userMapperXml.findOrdersAndUserRstMap();
        return list;
    }

    @GetMapping("/orderUser")
    public List<User> findUserAndOrder(){
        List<User> userList = userMapperXml.findUserOrderList();
        return  userList;
    }

    @GetMapping("/user/ids")
    public List<User> findUserListByIds(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        QueryVo vo = new QueryVo();
        vo.setIds(list);
        List<User> userInIds = userMapperXml.findUserInIds(vo);
        return userInIds;
    }

}
