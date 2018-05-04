package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.Manager;
import mapper.IManagerMapper;

@Repository
public class ManagerService {
	private IManagerMapper mIManagerMapper;

	@Autowired
	public ManagerService(IManagerMapper mIManagerMapper) {
		this.mIManagerMapper = mIManagerMapper;
	}
	
	public boolean checkManager(Manager manager) {
		return mIManagerMapper.findManager(manager)!=null;
	}
	
}
