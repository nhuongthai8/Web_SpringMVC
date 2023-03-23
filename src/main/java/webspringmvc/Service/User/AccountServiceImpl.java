package webspringmvc.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webspringmvc.DAO.UsersDAO;
import webspringmvc.Entities.Users;

@Service
public class AccountServiceImpl implements IAccountService{
	@Autowired
	UsersDAO usersDAO = new UsersDAO();

	@Override
	public int AddAccount(Users user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(12)));
		return usersDAO.AddAccount(user);
	}

	@Override
	public Users CheckAccount(Users user) {
		String pass = user.getPassword();
		user = usersDAO.CheckAccount(user);
		if(user != null) {
			if(BCrypt.checkpw(pass,user.getPassword())) {
				return user;
			}else {
				return null;
			}
		}
		return null;
	}
	
	
}
