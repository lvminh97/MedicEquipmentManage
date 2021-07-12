package model;

import org.json.JSONException;
import org.json.JSONObject;

import utilities.Config;
import utilities.HttpRequest;

public class Account {
	@SuppressWarnings("unused")
	private String username, password, fullname, mobile, role;
	
	public Account() {}
	
	public void setDataFromUsername(String user) {
		this.username = null;
		String data = HttpRequest.getRequest(Config.HOST + "/?action=app-get-user-act").toString();
		if(data == null) return;
		try {
			JSONObject json = new JSONObject(data);
			this.username = json.getString("username");
			this.fullname = json.getString("fullname");
			this.mobile   = json.getString("mobile");
			this.role     = json.getString("role");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int login(String username, String password) {
		this.username = null;
		String param = "{\"user\":\"" + username + "\",\"pass\":\"" + password + "\"}";
		String resp = HttpRequest.getRequest(Config.HOST + "/?action=app-login-act&data=" + param).toString();
		try {
			JSONObject data = new JSONObject(resp);
			if(data.getString("status").equals("OK")){
				JSONObject accountData = new JSONObject(data.getString("account"));
				this.username = accountData.getString("username");
//				this.password = accountData.getString("password");
				this.fullname = accountData.getString("fullname");
				this.mobile   = accountData.getString("mobile");
				this.role = accountData.getString("role");
				return 0;
			}
			else if(data.getString("status").equals("Wrong")) {
				return 1;
			}
			else if(data.getString("status").equals("NotRole")) {
				return 2;
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 3;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
