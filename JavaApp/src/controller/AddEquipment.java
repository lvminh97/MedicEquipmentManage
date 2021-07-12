package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.Equipment;
import view.AddEquipmentView;

public class AddEquipment implements ActionListener{

	private AddEquipmentView view;
	
	public AddEquipment() {
		view = new AddEquipmentView();
		view.getAddBtn().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		EquipmentList.setEquipment(null);
		if(e.getSource() == view.getAddBtn()) {
			try {
				Equipment equip = new Equipment(Integer.parseInt(view.getIdTf().getText().toString()),
												view.getNameTf().getText().toString(),
												view.getStatusTf().getText().toString(),
												view.getProducerTf().getText().toString(),
												view.getProviderTf().getText().toString(),
												view.getFunctionTarea().getText().toString(),
												Integer.parseInt(view.getPriceTf().getText().toString()),
												Integer.parseInt(view.getNumberTf().getText().toString()));
				int resp = equip.addNewItem();
				if(resp == 0) {
					EquipmentList.setEquipment(equip);
					view.dispose();
				}
			}
			catch (Exception e1) {
				// TODO: handle exception
			}
		}
	}

	public AddEquipmentView getView() {
		return view;
	}

	public void setView(AddEquipmentView view) {
		this.view = view;
	}
	
}
