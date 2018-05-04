package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Flower;
import entity.Manager;
import entity.Order;
import service.FlowerService;
import service.ManagerService;
import service.OrderService;

@Controller
@RequestMapping("/Manager")
public class ManagerController {
	@Autowired
	private ManagerService mManagerService;
	@Autowired
	private FlowerService mFlowerService;
	@Autowired
	private OrderService mOrderService;
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(isLogined(session)) {
			return "redirect:/Manager/flower-list";
		}
		return "manager/login";
	}
	
	@RequestMapping("/check")
	public String check(Manager manager, HttpSession session) {
		if(mManagerService.checkManager(manager)) {
			session.setAttribute("manager", manager.getUsername());
			return "redirect:/Manager/flower-list";
		}
		return backToLogin(session, "用户名或密码错误");
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("manager");
		return "redirect:/Flower/";
	}
	
	@RequestMapping("/flower-list")
	public String flowerList(HttpSession session) {
		if(!isLogined(session)) {
			return backToLogin(session, "请先登录");
		}
		
		List<Flower> flowers=mFlowerService.getAllFlowers();
		session.setAttribute("m-flowers", flowers);
		return "manager/flower-list";
	}
	
	@RequestMapping("/add-flower")
	public String addFlower(HttpSession session) {
		if(!isLogined(session)) {
			return backToLogin(session, "请先登录");
		}
		
		session.removeAttribute("m-editFlower");
		return "manager/add-flower";
	}
	
	@RequestMapping("/add")
	public String add(Flower flower) {
		mFlowerService.addFlower(flower);
		return "redirect:/Manager/flower-list";
	}
	
	@RequestMapping(value="/edit-flower/{id}", method=RequestMethod.GET)
	public String editFlower(@PathVariable int id, HttpSession session) {
		if(!isLogined(session)) {
			return backToLogin(session, "请先登录");
		}
		
		List<Flower> flowers=(List<Flower>) session.getAttribute("m-flowers");
		for(Flower f: flowers) {
			if(f.getId()==id) {
				session.setAttribute("m-editFlower", f);
				break;
			}
		}
		
		return "manager/add-flower";
	}
	
	@RequestMapping("/update")
	public String update(Flower flower, HttpSession session) {
		Flower f=(Flower) session.getAttribute("m-editFlower");
		flower.setId(f.getId());
		mFlowerService.updateFlower(flower);
		return "redirect:/Manager/flower-list";
	}
	
	@RequestMapping("/delete-flower")
	public String deleteFlower(HttpSession session) {
		Flower f=(Flower) session.getAttribute("m-editFlower");
		mFlowerService.deleteFlower(f.getId());
		return "redirect:/Manager/flower-list";
	}
	
	@RequestMapping("/order-list")
	public String orderList(HttpSession session) {
		if(!isLogined(session)) {
			return backToLogin(session, "请先登录");
		}
		session.setAttribute("m-orders", mOrderService.getAllOrders());
		return "manager/order-list";
	}
	
	@RequestMapping(value="/order-detail/{id}", method=RequestMethod.GET)
	public String orderDetail(@PathVariable int id, HttpSession session) {
		List<Order> orders=(List<Order>) session.getAttribute("m-orders");
		for(Order order: orders) {
			if(order.getId()==id) {
				session.setAttribute("m-order", order);
				break;
			}
		}
		
		session.setAttribute("m-orderItems", mOrderService.getOrderItems(id));
		return "manager/order-detail";
	}
	
	@RequestMapping(value="/change/{id}/{state}", method=RequestMethod.GET)
	public String change(@PathVariable int id, @PathVariable int state,HttpSession session) {
		if(mOrderService.updateOrderState(id, state)) {
			Order order=(Order) session.getAttribute("m-order");
			order.setState(state);
		}
		
		return "redirect:/Manager/order-detail/"+id;
	}
	
	
	private boolean isLogined(HttpSession session) {
		return session.getAttribute("manager")!=null;
	}
	
	
	private String backToLogin(HttpSession session, String msg) {
		session.setAttribute("err", msg);
		return "redirect:/Manager/";
	}
}
