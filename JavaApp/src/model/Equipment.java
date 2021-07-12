package model;

import org.json.JSONException;
import org.json.JSONObject;

import utilities.Config;
import utilities.HttpRequest;

public class Equipment {
	private int id;
	private String name, status, producer, provider, function;
	private int price;
	private int number;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void getById(int _id) {
		this.id = 0;
		String resp = HttpRequest.getRequest(Config.HOST + "/?action=app-get-equipment-act&id=" + _id).toString();
		try {
			JSONObject json = new JSONObject(resp);
			this.id = json.getInt("id");
			this.name = json.getString("name");
			this.status = json.getString("status");
			this.producer = json.getString("producer");
			this.provider = json.getString("provider");
			this.function = json.getString("function");
			this.price = json.getInt("price");
			this.number = json.getInt("number");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int addNewItem() {
		if(this.id == 0) {
			return 1; // object is null
		}
		JSONObject json = new JSONObject();
		try {
			json.put("id", this.id);
			json.put("name", this.name);
			json.put("status", this.status);
			json.put("producer", this.producer);
			json.put("provider", this.provider);
			json.put("function", this.function);
			json.put("price", this.price);
			json.put("number", this.number);
			json.put("username", Config.account.getUsername());
			String req = (Config.HOST + "/?action=app-add-equipment-act&data=" + json.toString()).replace(" ", "%20");
			String resp = HttpRequest.getRequest(req).toString();
			if(resp.equals("AddNewEquipmentOK"))
				return 0; // add successful
			else
				return 2; // add failed
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return 2; // add failed
	}
	
	public int updateItem(int id) {
		if(this.id == 0) {
			return 1; // object is null
		}
		JSONObject json = new JSONObject();
		try {
			json.put("id", this.id);
			json.put("name", this.name);
			json.put("status", this.status);
			json.put("producer", this.producer);
			json.put("provider", this.provider);
			json.put("function", this.function);
			json.put("price", this.price);
			json.put("old_id", id);
			json.put("username", Config.account.getUsername());
			String req = (Config.HOST + "/?action=app-update-equipment-act&data=" + json.toString()).replace(" ", "%20");
			String resp = HttpRequest.getRequest(req).toString();
			if(resp.equals("UpdateEquipmentOK"))
				return 0; // update successful
			else
				return 2; // update failed
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 2; // update failed
	}
	
	public Equipment() {}
	
	public Equipment(int id, String name, String status, String producer, String provider, String function, int price,
			int number) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.producer = producer;
		this.provider = provider;
		this.function = function;
		this.price = price;
		this.number = number;
	}

	public Equipment(Equipment eq) {
		super();
		this.id = eq.id;
		this.name = eq.name;
		this.status = eq.status;
		this.producer = eq.producer;
		this.provider = eq.provider;
		this.function = eq.function;
		this.price = eq.price;
		this.number = eq.number;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
