package entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Order {
	private int id;
	private int uid;
	private int state;
	private float total;
	private String createTime;
	
	public Order() {
		createTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", uid=" + uid + ", state=" + state + ", total=" + total + ", createTime="
				+ createTime + "]";
	}
	
	
}
