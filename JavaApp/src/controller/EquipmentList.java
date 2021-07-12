package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Equipment;
import utilities.Config;
import utilities.HttpRequest;
import view.EquipmentListView;

public class EquipmentList implements ActionListener, MouseListener{

	private EquipmentListView view;
	private static Equipment equipment;
	private static DefaultTableModel equipmentListModel;
	private int selectedRow;

	public EquipmentList() {
		this.initTableModel();
		view = new EquipmentListView();
		view.getSearchBtn().addActionListener(this);
		view.getAddEquipBtn().addActionListener(this);
		view.getLogoutBtn().addActionListener(this);
		view.getEquipListTable().addMouseListener(this);
		view.getInoutMenuItem().addActionListener(this);
		view.getDeleteMenuItem().addActionListener(this);
	}

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == view.getAddEquipBtn()) {
			if(Config.account.getRole().equals("admin") == false) {
				JOptionPane.showMessageDialog(view, "Chỉ Admin mới có quyền thêm thiết bị mới!");
				return;
			}
			AddEquipment subView =  new AddEquipment();
			subView.getView().addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
//					view.getEquipList()
					if(EquipmentList.equipment != null) {
						Equipment eq = new Equipment(EquipmentList.equipment);
						equipmentListModel.addRow(new Object[] {eq.getId(), 
																eq.getName(), 
																eq.getStatus(), 
																eq.getProducer(), 
																eq.getProvider(),
																eq.getFunction(),
																eq.getPrice(),
																eq.getNumber()});
															}
				}
			});
		}
		else if(e.getSource() == view.getLogoutBtn()) {
			view.dispose();
			new Login();
		}
		else if(e.getSource() == view.getSearchBtn()) {
			view.getEquipListTable().setModel(new DefaultTableModel(new String[]{"Mã số", "Thiết bị", "Tình trạng", "Nhà SX", "Nhà cung cấp", "Chức năng", "Giá", "Số lượng"}, 0));
			String req = (Config.HOST + "/?action=app-search-act&keyword=" + view.getSearchTf().getText()).replace(" ", "%20");
			String resp = HttpRequest.getRequest(req).toString();
			try {
				JSONArray jsonArr = new JSONArray(resp);
				JSONObject jsonEle;
				for(int i = 0; i < jsonArr.length(); i++) {
					jsonEle = (JSONObject) jsonArr.get(i);
					((DefaultTableModel) view.getEquipListTable().getModel()).addRow(new Object[] {jsonEle.getString("id"),
															jsonEle.getString("name"),
															jsonEle.getString("status"),
															jsonEle.getString("producer"),
															jsonEle.getString("provider"),
															jsonEle.getString("function"),
															jsonEle.getString("price"),
															jsonEle.getString("number")
														});
				}
				
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource() == view.getInoutMenuItem()) {
			UpdateInOut subView = new UpdateInOut(Integer.parseInt(view.getEquipListTable().getValueAt(this.selectedRow, 0).toString()));
			subView.getView().addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					if(EquipmentList.equipment != null) {
						view.getEquipListTable().getModel().setValueAt(equipment.getNumber(), selectedRow, 7);
					}
				}
			});
		}
		else if(e.getSource() == view.getDeleteMenuItem()) {
			if(Config.account.getRole().equals("admin") == false) {
				JOptionPane.showMessageDialog(view, "Chỉ Admin mới có quyền thêm thiết bị mới!");
				return;
			}
			int cf = JOptionPane.showConfirmDialog(view, "Bạn có chắc chắn muốn xóa?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(cf == JOptionPane.YES_OPTION) {
				String resp = HttpRequest.getRequest(Config.HOST + "/?action=app-delete-equipment-act&id=" + view.getEquipListTable().getValueAt(this.selectedRow, 0) + "&username=" + Config.account.getUsername()).toString();
				if(resp.equals("DeleteEquipmentOK")) {
					JOptionPane.showMessageDialog(view, "Xoá thành công"); 
					((DefaultTableModel) view.getEquipListTable().getModel()).removeRow(this.selectedRow);
				}
			}
		}
	}
	
	private void initTableModel() {
		String[] columnNames = {"Mã số", "Thiết bị", "Tình trạng", "Nhà SX", "Nhà cung cấp", "Chức năng", "Giá", "Số lượng"};
		equipmentListModel = new DefaultTableModel(columnNames, 0);
		String resp = HttpRequest.getRequest(Config.HOST + "/?action=app-get-equipment-list-act").toString();
		try {
			JSONArray jsonArr = new JSONArray(resp);
			JSONObject jsonEle;
			for(int i = 0; i < jsonArr.length(); i++) {
				jsonEle = (JSONObject) jsonArr.get(i);
				equipmentListModel.addRow(new Object[] {jsonEle.getString("id"),
														jsonEle.getString("name"),
														jsonEle.getString("status"),
														jsonEle.getString("producer"),
														jsonEle.getString("provider"),
														jsonEle.getString("function"),
														jsonEle.getString("price"),
														jsonEle.getString("number")
													});
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
	
	public EquipmentListView getView() {
		return view;
	}

	public void setView(EquipmentListView view) {
		this.view = view;
	}

	public static DefaultTableModel getEquipmentListModel() {
		return equipmentListModel;
	}

	public static void setEquipmentListModel(DefaultTableModel equipmentListModel) {
		EquipmentList.equipmentListModel = equipmentListModel;
	}

	public static Equipment getEquipment() {
		return equipment;
	}

	public static void setEquipment(Equipment equipment) {
		EquipmentList.equipment = equipment;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("static-access")
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getClickCount() == 2 && view.getEquipListTable().getSelectedRow() != -1) {
			if(Config.account.getRole().equals("admin") == false) {
				JOptionPane.showMessageDialog(view, "Chỉ Admin mới có quyền sửa thông tin thiết bị!");
				return;
			}
			int row = view.getEquipListTable().getSelectedRow();
			int equip_id = Integer.parseInt(view.getEquipListTable().getValueAt(row, 0).toString());
			if(equipment == null) {
				equipment = new Equipment();
			}
			UpdateEquipment subView = new UpdateEquipment(equip_id);
			subView.getView().addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					if(EquipmentList.equipment != null) {
						Equipment eq = new Equipment(EquipmentList.equipment);
						view.getEquipListTable().setValueAt(eq.getId(), row, 0);
						view.getEquipListTable().setValueAt(eq.getName(), row, 1);
						view.getEquipListTable().setValueAt(eq.getStatus(), row, 2);
						view.getEquipListTable().setValueAt(eq.getProducer(), row, 3);
						view.getEquipListTable().setValueAt(eq.getProvider(), row, 4);
						view.getEquipListTable().setValueAt(eq.getFunction(), row, 5);
						view.getEquipListTable().setValueAt(eq.getPrice(), row, 6);
					}
				}
			});
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.isPopupTrigger()) {
			int row = view.getEquipListTable().rowAtPoint(e.getPoint());
			int column = view.getEquipListTable().columnAtPoint(e.getPoint());
			
			this.selectedRow = row;
			view.getEquipListTable().changeSelection(row, column, false, false);
			view.getPopup().show(e.getComponent(), e.getX(), e.getY());
		}
		
	}
	
}
