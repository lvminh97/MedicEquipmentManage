package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Equipment;
import model.History;
import utilities.Config;
import view.UpdateInOutView;

public class UpdateInOut implements ActionListener{

	private static UpdateInOutView view;
	private int id;
	
	public UpdateInOut(int id) {
		this.id = id;
		view = new UpdateInOutView();
		view.getEquipIdLb().setText(this.id + "");
		view.getUsernameLb().setText(Config.account.getFullname());
		view.getSetBtn().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getSetBtn()) {
			History hist = new History("", this.id, Config.account.getUsername(), Integer.parseInt(view.getNumberTf().getText()), view.getInoutList().getSelectedIndex());
			int resp = hist.addNewItem();
			if(resp == 0) {
				if(EquipmentList.getEquipment() == null) {
					EquipmentList.setEquipment(new Equipment());
				}
				EquipmentList.getEquipment().getById(this.id);
				if(view.getInoutList().getSelectedIndex() == 0) {
					EquipmentList.getEquipment().setNumber(EquipmentList.getEquipment().getNumber());
				}
				else {
					EquipmentList.getEquipment().setNumber(EquipmentList.getEquipment().getNumber());
				}
				view.dispose();
			}
		}
	}

	public static UpdateInOutView getView() {
		return view;
	}

	public static void setView(UpdateInOutView view) {
		UpdateInOut.view = view;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
