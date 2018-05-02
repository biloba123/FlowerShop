package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.User;
import mapper.IUserMapper;

@Service
public class UserService {
	private IUserMapper mIUserMapper;

	@Autowired
	public UserService(IUserMapper mIUserMapper) {
		this.mIUserMapper = mIUserMapper;
	}

	public User login(User user) {
		User u=mIUserMapper.findUser(user);
		return u;
	}
	
	@Transactional
	public boolean register(User user) {
		int cnt=mIUserMapper.addUser(user);
		return cnt==0;
	}
	
	@Transactional
	public boolean updateInfo(User user) {
		int cnt=mIUserMapper.updateUser(user);
		return cnt==0;
	}
	
}
