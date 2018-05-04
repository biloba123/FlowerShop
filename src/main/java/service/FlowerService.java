package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Flower;
import mapper.IFlowerMapper;

@Service
public class FlowerService {
	private IFlowerMapper mIFlowerMapper;

	@Autowired
	public FlowerService(IFlowerMapper mIFlowerMapper) {
		this.mIFlowerMapper = mIFlowerMapper;
	}
	
	public List<Flower> getAllFlowers(){
		return mIFlowerMapper.findAllFlowers();
	}
	
	public boolean addFlower(Flower flower) {
		return mIFlowerMapper.addFlower(flower)==1;
	}
	
	public boolean updateFlower(Flower flower) {
		return mIFlowerMapper.updateFlower(flower)==1;
	}
	
	public boolean deleteFlower(int id) {
		return mIFlowerMapper.deleteFlower(id)==1;
	}
	
}
