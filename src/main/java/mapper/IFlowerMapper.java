package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.Flower;

@Repository
public interface IFlowerMapper {
	@Insert("insert into flower values(null, #{name}, #{img}, #{price}, #{intro})")
	int addFlower(Flower flower);
	
	@Select("select * from flower")
	List<Flower> findAllFlowers();
	
	@Select("select * from flower where id=#{id}")
	Flower findFlowerById(int id);
	
	@Update("update flower set name=#{name}, img=#{img}, price=#{price}, intro=#{intro} where id=#{id}")
	int updateFlower(Flower flower);
	
	@Delete("delete from flower where id=#{id}")
	int deleteFlower(int id);
	
}
