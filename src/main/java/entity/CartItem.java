package entity;

import org.springframework.stereotype.Component;

@Component
public class CartItem {
	private int id;
	private int uid;
	private int fid;
	private int oid;
	private int count;
	private int state;
	private Flower flower;
	
	

	public Flower getFlower() {
		return flower;
	}

	public void setFlower(Flower flower) {
		this.flower = flower;
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

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", uid=" + uid + ", fid=" + fid + ", oid=" + oid + ", count=" + count + ", state="
				+ state + "]";
	}

}
