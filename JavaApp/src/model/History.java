package model;

import org.json.JSONException;
import org.json.JSONObject;

import utilities.Config;
import utilities.HttpRequest;

public class History {
	private String time;
	private int id;
	private String username;
	private int number;
	private int inout;
	
	public int addNewItem() {
		if(this.id == 0) {
			return 1;
		}
		JSONObject json = new JSONObject();
		try {
			json.put("id", this.id);
			json.put("number", this.number + "");
			json.put("username", this.username);
			json.put("in_out", (this.inout == 1) ? "out" : "in");
			String req = (Config.HOST + "/?action=app-add-history-act&data=" + json.toString()).replace(" ", "%20");
			String resp = HttpRequest.getRequest(req).toString();
			if(resp.equals("AddHistoryOK"))
				return 0; // add successful
			else
				return 2; // add failed
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 2;
	}
	
	public History(String time, int id, String username, int number, int inout) {
		super();
		this.time = time;
		this.id = id;
		this.username = username;
		this.number = number;
		this.inout = inout;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getInout() {
		return inout;
	}
	public void setInout(int inout) {
		this.inout = inout;
	}
}
