

public class UserAccount {
	
	string userName;
	string userNickName;
	
	string getUserName() {
		return userName;
	}
	
	void setUserName(string userName) {
		this.userName = userName;
	}
	
	string getUserNickName() {
		return userNickName;
	}

	void setUserNickName() {
		this.userNickName = userNickName;
	}
	int compareNames(string userName, string userNickName) {
		if (userName == userNickName) {
			return -1;
		}
		else {
			return 0;
		}
	}
	void publicInfo() {
 print.("This is public info");
	}
	}
