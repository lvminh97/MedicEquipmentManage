package view;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class UpdateInOutView extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JLabel equipIdLb, usernameLb;
	private JTextField numberTf;
	private JList<String> inoutList;
	private JButton setBtn;
	
	public UpdateInOutView() {
		this.setTitle("Nhập/xuấtthiết bị");
		this.setSize(450, 360);
		this.setLocation(200, 100);
		
		JLabel idLb = new JLabel("Mã số");
		idLb.setSize(120, 30);
		idLb.setLocation(40, 20);
		this.add(idLb);
		this.equipIdLb = new JLabel();
		this.equipIdLb.setSize(200, 30);
		this.equipIdLb.setLocation(180, 20);
		this.add(this.equipIdLb);
		
		JLabel numberLb = new JLabel("Số lượng");
		numberLb.setSize(120, 30);
		numberLb.setLocation(40, 70);
		this.add(numberLb);
		this.numberTf = new JTextField();
		this.numberTf.setSize(200, 30);
		this.numberTf.setLocation(180, 70);
		this.add(this.numberTf);
		
		JLabel inoutLb = new JLabel("Nhập/xuất");
		inoutLb.setSize(120, 30);
		inoutLb.setLocation(40,  120);
		this.add(inoutLb);
		this.inoutList = new JList<String>(new String[]{"Nhập", "Xuất"});
		this.inoutList.setSize(200, 50);
		this.inoutList.setLocation(180, 130);
		this.inoutList.setSelectedIndex(0);
		this.add(this.inoutList);

		JLabel unamLb = new JLabel("Người nhập liệu");
		unamLb.setSize(120, 30);
		unamLb.setLocation(40,  190);
		this.add(unamLb);
		this.usernameLb = new JLabel();
		this.usernameLb.setSize(200, 30);
		this.usernameLb.setLocation(180, 190);
		this.add(this.usernameLb);
		
		this.setBtn = new JButton("Thực hiện");
		this.setBtn.setSize(120, 30);
		this.setBtn.setLocation(150, 270);
		this.add(this.setBtn);
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}

	public JLabel getEquipIdLb() {
		return equipIdLb;
	}

	public void setEquipIdLb(JLabel equipIdLb) {
		this.equipIdLb = equipIdLb;
	}

	public JTextField getNumberTf() {
		return numberTf;
	}

	public void setNumberTf(JTextField numberTf) {
		this.numberTf = numberTf;
	}
	
	public JLabel getUsernameLb() {
		return usernameLb;
	}

	public void setUsernameLb(JLabel usernameLb) {
		this.usernameLb = usernameLb;
	}

	public JList<String> getInoutList() {
		return inoutList;
	}

	public void setInoutList(JList<String> inoutList) {
		this.inoutList = inoutList;
	}

	public JButton getSetBtn() {
		return setBtn;
	}

	public void setSetBtn(JButton setBtn) {
		this.setBtn = setBtn;
	}
}
