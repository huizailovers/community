package life.majiang.community.controller;

import life.majiang.community.model.Order;
import life.majiang.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderContorller {

    @Autowired
    private UserService userService;

    @GetMapping("/order")
    public  List<Order> getOrders(){
        List<Order> order = userService.getOrder();
        return order;
    }
}
