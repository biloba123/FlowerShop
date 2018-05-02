package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import entity.Flower;

@Repository
public interface IFlowerMapper {
	@Insert("insert into flower values(null, #{name}, #{img}, #{price}, #{intro})")
	int addFlower(Flower flower);
	
	@Select("select * from flower")
	List<Flower> findAllFlowers();
	
	
}
