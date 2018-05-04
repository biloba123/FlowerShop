package service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.CartItem;
import entity.Flower;
import entity.Order;
import entity.User;
import mapper.IFlowerMapper;
import mapper.IOrderMapper;

@Service
public class OrderService {
	private IOrderMapper mIOrderMapper;
	private IFlowerMapper mIFlowerMapper;

	
	@Autowired
	public OrderService(IOrderMapper mIOrderMapper, IFlowerMapper mIFlowerMapper) {
		this.mIOrderMapper = mIOrderMapper;
		this.mIFlowerMapper = mIFlowerMapper;
	}

	@Transactional
	public	boolean addToCart(CartItem cItem) {
		CartItem cItemOld=mIOrderMapper.findCartItem(cItem);
		int cnt=0;
		if(cItemOld!=null) {//update
			cItemOld.setCount(cItemOld.getCount()+1);
			cnt=mIOrderMapper.updateCartItem(cItemOld);
		}else {//insert
			cnt=mIOrderMapper.addCartItem(cItem);
		}
		return cnt==1;
	}
	
	public List<CartItem> getCartItems(User user){
		List<CartItem> cItems=mIOrderMapper.findCartItems(user);
		attachFlowerToCartItem(cItems);
		return cItems;
	}
	
	@Transactional
	public	boolean updateCartItem(CartItem cItem) {
		return mIOrderMapper.updateCartItem(cItem)==1;
	}
	
	public	boolean deleteCartItem(int id) {
		return mIOrderMapper.deleteCartItem(id)==1;
	}
	
	@Transactional
	public void createOrder(List<CartItem> cartItems) {
		Order order=new Order();
		float total=0;
		for(CartItem cItem: cartItems) {
			total+=cItem.getFlower().getPrice()*cItem.getCount();
		}
		order.setTotal(total);
		order.setUid(cartItems.get(0).getUid());
		System.out.println(order);
		mIOrderMapper.addOrder(order);
		System.out.println(order);
		
		int orderId=order.getId();
		for(CartItem cItem: cartItems) {
			cItem.setOid(orderId);
			cItem.setState(1);
			mIOrderMapper.addToOrder(cItem);
		}
	}
	
	public List<Order> getUserOrders(int uid) {
		return mIOrderMapper.findUserOrders(uid);
	}
	
	public List<Order> getAllOrders() {
		return mIOrderMapper.findAllOrders();
	}
	
	public List<CartItem> getOrderItems(int oid){
		List<CartItem> cItems=mIOrderMapper.findOrderItems(oid);
		attachFlowerToCartItem(cItems);
		return cItems;
	}
	
	@Transactional
	public boolean updateOrderState(int oid, int state) {
		Order order=new Order();
		order.setId(oid);
		order.setState(state);
		return mIOrderMapper.updateOrderState(order)==1;
	}
	
	private void attachFlowerToCartItem(List<CartItem> cItems) {
		CartItem cItem;
		Flower flower;
		for(Iterator<CartItem> iterator=cItems.iterator(); iterator.hasNext(); ) {
			cItem=iterator.next();
			flower=mIFlowerMapper.findFlowerById(cItem.getFid());
			if(flower!=null) {
				cItem.setFlower(flower);
			}else {
				iterator.remove();
			}
		}
	}
	
}
