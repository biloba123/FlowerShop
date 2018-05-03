package service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.CartItem;
import entity.Flower;
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
		return cItems;
	}
	
	@Transactional
	public	boolean updateCartItem(CartItem cItem) {
		return mIOrderMapper.updateCartItem(cItem)==1;
	}
	
	public	boolean deleteCartItem(int id) {
		return mIOrderMapper.deleteCartItem(id)==1;
	}
	
}
