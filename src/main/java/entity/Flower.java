package entity;

import org.springframework.stereotype.Component;

@Component
public class Flower {
	private int id;
	private String name;
	private String img;
	private float price;
	private String intro;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	@Override
	public String toString() {
		return "Flower [id=" + id + ", name=" + name + ", img=" + img + ", price=" + price + ", intro=" + intro + "]";
	}
	
	
}
