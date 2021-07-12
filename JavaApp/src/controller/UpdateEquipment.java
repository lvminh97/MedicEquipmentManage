package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Equipment;
import view.UpdateEquipmentView;

public class UpdateEquipment implements ActionListener{
	
	private int id;
	private static UpdateEquipmentView view;
	
	public UpdateEquipment(int id) {
		this.id = id;
		EquipmentList.getEquipment().getById(this.id);
		view = new UpdateEquipmentView();
		view.getIdTf().setText(EquipmentList.getEquipment().getId() + "");
		view.getNameTf().setText(EquipmentList.getEquipment().getName());
		view.getStatusTf().setText(EquipmentList.getEquipment().getStatus());
		view.getProducerTf().setText(EquipmentList.getEquipment().getProducer());
		view.getProviderTf().setText(EquipmentList.getEquipment().getProvider());
		view.getFunctionTarea().setText(EquipmentList.getEquipment().getFunction());
		view.getPriceTf().setText(EquipmentList.getEquipment().getPrice() + "");
		EquipmentList.setEquipment(null);
		
		view.getUpdateBtn().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == view.getUpdateBtn()) {
			Equipment eq = new Equipment(Integer.parseInt(view.getIdTf().getText()),
										view.getNameTf().getText(),
										view.getStatusTf().getText(),
										view.getProducerTf().getText(),
										view.getProviderTf().getText(),
										view.getFunctionTarea().getText(),
										Integer.parseInt(view.getPriceTf().getText()),
										0);
			EquipmentList.setEquipment(eq);
			int resp = EquipmentList.getEquipment().updateItem(this.id);
			if(resp == 0) {
				view.dispose();
			}
		}
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static UpdateEquipmentView getView() {
		return view;
	}

	public static void setView(UpdateEquipmentView view) {
		UpdateEquipment.view = view;
	}
}
