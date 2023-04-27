package learncode.spring.model;

import java.util.*;

public class UserDAO {
	public static List<User> ls = new ArrayList<User>();
	
	public User findUserName(String username) {
		for(User user : ls) {
			if(user.getUserName().equals(username)) {
				return user;
			}
		}
		return null;
	}
	public int update(User user) {
		for(int i=0; i<ls.size();i++) {
			if(ls.get(i).getUserName().equals(user.getUserName())) {
				ls.set(i, user);
				return i;
			}
		}
		return -1;
	}
	public int save(User user) {
		if(findUserName(user.getUserName())!=null) {
			update(user);
		}
		else {
			ls.add(user);
		}
		return 1;
	}
	public int delete(String username) {
		User u = findUserName(username);
		if(u!=null) {
			ls.remove(u);
			return 1;
		}
		return 0;
	}
	public List<User> getAll(){
		return ls;
	}
}
