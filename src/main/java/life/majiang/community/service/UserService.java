package life.majiang.community.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import life.majiang.community.mapper.OrderMapper;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.Order;
import life.majiang.community.model.OrderExample;
import org.omg.CORBA.ORB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangch
 */
@Service
public class UserService {

    @Autowired
    private OrderMapper orderMapper;

    public  List<Order> getOrder(){
        OrderExample example = new OrderExample();
        example.createCriteria().andIdEqualTo(1);


        PageHelper.startPage(1, 1);
        List<Order> orders = orderMapper.selectByExample(example);
        PageInfo<Order> info = new PageInfo<>(orders);
        return orders;
    }
}
