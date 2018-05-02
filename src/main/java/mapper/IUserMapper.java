package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.User;

@Repository
public interface IUserMapper {
	
	@Insert("insert into user values(null, #{username}, #{password},  #{sex})")
	int addUser(User user);
	
	@Select("select * from user where username=#{username} and password=#{password} ")
	User findUser(User user);
	
	@Update("update user set username=#{username}, password=#{password}, sex=#{sex} where id=#{id}")
	int updateUser(User user);

}
