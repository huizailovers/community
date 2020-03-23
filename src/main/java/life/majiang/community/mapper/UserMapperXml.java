package life.majiang.community.mapper;

import life.majiang.community.model.OrderExt;
import life.majiang.community.model.QueryVo;
import life.majiang.community.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author  zhangch
 */
@Mapper
public interface UserMapperXml {
    /**
     *find user by name
     * @param name
     * @return
     */
    User findUserByName(String name);

    /**
     * find user use like
     * @param name
     * @return
     */
    List<User> findUserByNameLike(String name);

    /**
     * add user auto primary key
     * @param users
     */
    void addUser(User users);

    /**
     * find User By QueryVo
     * @param vo
     * @return
     */
    User findUserByQueryVo(QueryVo vo);

    /**
     * get order and user info
     * @return
     */
    List<OrderExt> findOrdersAndUserRstMap();

    /**
     * find user and order
     * @return
     */
    List<User> findUserOrderList();

    /**
     * in ids query
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
