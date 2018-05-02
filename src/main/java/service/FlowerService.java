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
	
}
