package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.CartItem;
import entity.Flower;
import entity.Order;
import entity.User;
import service.OrderService;
import util.AccountUtil;

@Controller
@RequestMapping("/Order")
public class OrderController {
	@Autowired
	private OrderService mOrderService;
	
	@RequestMapping(value="/add-to-card/{id}", method=RequestMethod.GET)
	public String addToCart(@PathVariable int id, HttpSession session) {
		User user=AccountUtil.getUser(session);
		if(user==null) {
			return AccountUtil.backToLogin(session, "请先登录");
		}else {
			CartItem item=new CartItem();
			item.setUid(user.getId());
			item.setFid(id);
			item.setCount(1);
			mOrderService.addToCart(item);
			return "redirect:/Flower/details/"+id;
		}
	}
	
	@RequestMapping("/cart")
	public String myCart(HttpSession session) {
		User user=AccountUtil.getUser(session);
		if(user!=null) {
			List<CartItem> cItems=mOrderService.getCartItems(user);
			session.setAttribute("cartItems", cItems);
			return "order/cart";
		}else {
			return AccountUtil.backToLogin(session, "请先登录");
		}
	}
	
	@RequestMapping(value="/edit-cart-item/{id}", method=RequestMethod.GET)
	public String editCartItem(@PathVariable int id, HttpSession session) {
		List<CartItem> cItems=(List<CartItem>) session.getAttribute("cartItems");
		for(CartItem cItem: cItems) {
			if(cItem.getId()==id) {
				session.setAttribute("editCartItem", cItem);
				break;
			}
		}
		
		return "order/edit-cart-item";
	}
	
	@RequestMapping("/update-cart-item")
	public String updateCartItem(int count, HttpSession session) {
		CartItem cartItem=(CartItem) session.getAttribute("editCartItem");
		cartItem.setCount(count);
		mOrderService.updateCartItem(cartItem);
		return "redirect:/Order/cart";
	}
	
	@RequestMapping("/delete-cart-item")
	public String deleteCartItem(HttpSession session) {
		CartItem cartItem=(CartItem) session.getAttribute("editCartItem");
		mOrderService.deleteCartItem(cartItem.getId());
		return "redirect:/Order/cart";
	}
	
	@RequestMapping("/my-order")
	public String myOrder(HttpSession session) {
		User user=AccountUtil.getUser(session);
		if(user==null) {
			return AccountUtil.backToLogin(session, "请先登录");
		}else {
			List<Order> orders=mOrderService.getUserOrders(user.getId());
			session.setAttribute("orders", orders);
			return "order/my-order";
		}
	}
	
	@RequestMapping("/create-order")
	public String createOrder(HttpSession session) {
		List<CartItem> cItems=(List<CartItem>) session.getAttribute("cartItems");
		if(cItems==null || cItems.size()<1) {
			return "redirect:/Order/cart";
		}
		
		mOrderService.createOrder(cItems);
		return "redirect:/Order/my-order";
	}
	
	@RequestMapping(value="/order-detail/{id}", method=RequestMethod.GET)
	public String orderDetail(@PathVariable int id, HttpSession session) {
		List<Order> orders=(List<Order>) session.getAttribute("orders");
		for(Order order: orders) {
			if(order.getId()==id) {
				session.setAttribute("order", order);
				break;
			}
		}
		
		session.setAttribute("orderItems", mOrderService.getOrderItems(id));
		return "order/order-detail";
	}
}
