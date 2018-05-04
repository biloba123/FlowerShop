package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.CartItem;
import entity.Order;
import entity.User;

@Repository
public interface IOrderMapper {
	@Insert("insert into cartItem values(null, #{uid}, #{fid}, #{oid}, #{count}, #{state})")
	int addCartItem(CartItem cartItem);
	
	@Select("select * from cartItem where uid=#{uid} and fid=#{fid} and state=0")
	CartItem findCartItem(CartItem cartItem);
	
	@Update("update cartItem set count=#{count} where id=#{id}")
	int updateCartItem(CartItem cartItem);
	
	@Update("update cartItem set state=1, oid=#{oid}  where id=#{id}")
	int addToOrder(CartItem cartItem);
	
	@Select("select * from cartItem where uid=#{id}  and state=0")
	List<CartItem> findCartItems(User user);
	
	@Delete("delete from cartItem where id=#{id}")
	int deleteCartItem(int id);
	
	@Insert("insert into orders values(null, #{uid}, #{state}, #{total}, #{createTime})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int addOrder(Order order);
	
	@Select("select * from orders where uid=#{uid}")
	List<Order> findUserOrders(int uid);
	
	@Select("select * from orders")
	List<Order> findAllOrders();
	
	@Select("select * from cartItem where oid=#{oid}  and state=1")
	List<CartItem> findOrderItems(int oid);
	
	@Update("update orders set state=#{state} where id=#{id}")
	int updateOrderState(Order order);

}
