package webspringmvc.Service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webspringmvc.Entities.Users;

@Service
public interface IAccountService {
	@Autowired
	public int AddAccount(Users user);
	@Autowired
	public Users CheckAccount(Users user);
}
