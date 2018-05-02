package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Flower;
import service.FlowerService;

@Controller
@RequestMapping("/Flower")
public class FlowerController {
	@Autowired
	private FlowerService mFlowerService;
	
	@RequestMapping("/")
	public String flowerList(HttpSession session) {
		List<Flower> flowers=mFlowerService.getAllFlowers();
		session.setAttribute("flowers", flowers);
		return "flower/flower-list";
	}
}
