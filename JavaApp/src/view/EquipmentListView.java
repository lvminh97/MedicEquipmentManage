package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.EquipmentList;
import utilities.Config;

public class EquipmentListView extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JButton logoutBtn, searchBtn, addEquipBtn;
	private JTextField searchTf;
	private JTable equipListTable;
	private JPopupMenu popup;
	private JMenuItem inoutMenuItem, deleteMenuItem;
	
	public EquipmentListView() {
		this.initialize();
	}
	
	private void initialize() {
		this.setTitle("Phần mềm quản lý thiết bị y tế");
		this.setSize(1200, 800);
		this.setLocation(100, 100);
		
		JLabel lbl1 = new JLabel("QUẢN LÝ THIẾT BỊ");
		lbl1.setFont(new Font(lbl1.getFont().getName(), Font.BOLD, 50));
		lbl1.setLocation(50, 10);
		lbl1.setSize(600, 80);
		this.add(lbl1);
		JLabel lbl2 = new JLabel();
		lbl2.setText("Xin chào");
		lbl2.setFont(new Font(lbl2.getFont().getName(), Font.TRUETYPE_FONT, 20));
		lbl2.setSize(90, 20);
		lbl2.setLocation(720, 35);
		this.add(lbl2);
		JLabel lbl3 = new JLabel();
		lbl3.setText(Config.account.getFullname());
		lbl3.setFont(new Font(lbl3.getFont().getName(), Font.BOLD, 20));
		lbl3.setSize(250, 30);
		lbl3.setLocation(800, 30);
		this.add(lbl3);
		
		this.logoutBtn = new JButton("Đăng xuất");
		this.logoutBtn.setSize(100, 30);
		this.logoutBtn.setLocation(1060, 30);
		this.add(this.logoutBtn);
		
		this.searchTf = new JTextField();
		this.searchTf.setSize(500, 30);
		this.searchTf.setLocation(60, 150);
		this.add(this.searchTf);
		
		this.searchBtn = new JButton("Tìm kiếm");
		this.searchBtn.setSize(100, 30);
		this.searchBtn.setLocation(580, 150);
		this.add(this.searchBtn);
		
		this.addEquipBtn = new JButton("Thêm thiết bị");
		this.addEquipBtn.setSize(200, 30);
		this.addEquipBtn.setLocation(800, 150);
		this.add(this.addEquipBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(1100, 520);
		scrollPane.setLocation(60, 230);
		this.add(scrollPane);
		
		this.equipListTable = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		this.equipListTable.setSize(1100, 520);
		this.equipListTable.setLocation(60, 230);
		this.equipListTable.setModel(EquipmentList.getEquipmentListModel());
		scrollPane.setViewportView(this.equipListTable);
		
		this.popup = new JPopupMenu();
		this.inoutMenuItem = new JMenuItem("Nhập/xuất");
		this.deleteMenuItem = new JMenuItem("Xóa");
		this.popup.add(this.inoutMenuItem);
		this.popup.add(this.deleteMenuItem);
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}

	public JButton getLogoutBtn() {
		return logoutBtn;
	}

	public void setLogoutBtn(JButton logoutBtn) {
		this.logoutBtn = logoutBtn;
	}

	public JButton getSearchBtn() {
		return searchBtn;
	}

	public void setSearchBtn(JButton searchBtn) {
		this.searchBtn = searchBtn;
	}

	public JButton getAddEquipBtn() {
		return addEquipBtn;
	}

	public void setAddEquipBtn(JButton addEquipBtn) {
		this.addEquipBtn = addEquipBtn;
	}

	public JTextField getSearchTf() {
		return searchTf;
	}

	public void setSearchTf(JTextField searchTf) {
		this.searchTf = searchTf;
	}

	public JTable getEquipListTable() {
		return equipListTable;
	}

	public void setEquipListTable(JTable equipListTable) {
		this.equipListTable = equipListTable;
	}

	public JPopupMenu getPopup() {
		return popup;
	}

	public void setPopup(JPopupMenu popup) {
		this.popup = popup;
	}

	public JMenuItem getInoutMenuItem() {
		return inoutMenuItem;
	}

	public void setInoutMenuItem(JMenuItem inoutMenuItem) {
		this.inoutMenuItem = inoutMenuItem;
	}

	public JMenuItem getDeleteMenuItem() {
		return deleteMenuItem;
	}

	public void setDeleteMenuItem(JMenuItem deleteMenuItem) {
		this.deleteMenuItem = deleteMenuItem;
	}
	
}
