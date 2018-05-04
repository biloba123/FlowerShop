package mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import entity.Manager;
import entity.User;

@Repository
public interface IManagerMapper {
	@Select("select * from manager where username=#{username} and password=#{password} ")
	Manager findManager(Manager manager);
}
