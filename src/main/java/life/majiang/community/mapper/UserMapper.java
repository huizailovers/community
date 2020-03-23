package life.majiang.community.mapper;

import life.majiang.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    /**
     *insert  user
     * @param user
     * @return void
     */
    @Insert("insert into user (name,accountId,token,gmtCreate) values ( #{name},#{accountId},#{token},#{gmtCreate})")
    void insertUser(User user);

    /**
     *get user By name
     * @param name
     * @return void
     */
    @Select("select * from user where name = #{name}")
    User getUserByName(String name);

    @Select("select * from user where token like %${name}")
    User getUserByToken(String token);


}
