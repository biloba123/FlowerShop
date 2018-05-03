package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.org.apache.regexp.internal.recompile;

import entity.Flower;
import service.FlowerService;

@Controller
@RequestMapping("/Flower")
public class FlowerController {
	@Autowired
	private FlowerService mFlowerService;
	private List<Flower> mFlowers;
	
	@RequestMapping("/")
	public String flowerList(HttpSession session) {
		getFlowers(session);
		return "flower/flower-list";
	}
	
	@RequestMapping(value="/details/{id}", method=RequestMethod.GET)
	public String details(@PathVariable int id, HttpSession session) {
		if(mFlowers==null) {
			getFlowers(session);
		}
		
		for(Flower flower: mFlowers) {
			if(flower.getId()==id) {
				session.setAttribute("detail-flower", flower);
				break;
			}
		}
		
		return "flower/details";
	}
	
	private void getFlowers(HttpSession session){
		mFlowers=mFlowerService.getAllFlowers();
		session.setAttribute("flowers", mFlowers);
	}
}
