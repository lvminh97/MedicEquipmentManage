package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UpdateEquipmentView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JTextField idTf, nameTf, statusTf, producerTf, providerTf, priceTf;
	private JTextArea functionTarea;
	private JButton updateBtn, deleteBtn;
	
	public UpdateEquipmentView() {
		this.setTitle("Cập nhật thiết bị");
		this.setSize(600, 700);
		this.setLocation(200, 100);
		
		JLabel idLb = new JLabel("Mã số");
		idLb.setSize(80, 30);
		idLb.setLocation(20, 20);
		this.add(idLb);
		this.idTf = new JTextField();
		this.idTf.setSize(350, 30);
		this.idTf.setLocation(200, 20);
		this.add(this.idTf);
		
		JLabel nameLb = new JLabel("Tên thiết bị");
		nameLb.setSize(80, 30);
		nameLb.setLocation(20, 70);
		this.add(nameLb);
		this.nameTf = new JTextField();
		this.nameTf.setSize(350, 30);
		this.nameTf.setLocation(200, 70);
		this.add(this.nameTf);
		
		JLabel statusLb = new JLabel("Tình trạng");
		statusLb.setSize(80, 30);
		statusLb.setLocation(20, 120);
		this.add(statusLb);
		this.statusTf = new JTextField();
		this.statusTf.setSize(350, 30);
		this.statusTf.setLocation(200, 120);
		this.add(this.statusTf);
		
		JLabel producerLb = new JLabel("Nhà sản xuất");
		producerLb.setSize(80, 30);
		producerLb.setLocation(20, 170);
		this.add(producerLb);
		this.producerTf = new JTextField();
		this.producerTf.setSize(350, 30);
		this.producerTf.setLocation(200, 170);
		this.add(this.producerTf);
		
		JLabel providerLb = new JLabel("Nhà cung cấp");
		providerLb.setSize(80, 30);
		providerLb.setLocation(20, 220);
		this.add(providerLb);
		this.providerTf = new JTextField();
		this.providerTf.setSize(350, 30);
		this.providerTf.setLocation(200, 220);
		this.add(this.providerTf);
		
		JLabel functionLb = new JLabel("Tác dụng");
		functionLb.setSize(80, 30);
		functionLb.setLocation(20, 270);
		this.add(functionLb);
		this.functionTarea = new JTextArea();
		this.functionTarea.setSize(350, 100);
		this.functionTarea.setLocation(200, 270);
		this.add(this.functionTarea);
		
		JLabel priceLb = new JLabel("Giá tiền");
		priceLb.setSize(80, 30);
		priceLb.setLocation(20, 390);
		this.add(priceLb);
		this.priceTf = new JTextField();
		this.priceTf.setSize(350, 30);
		this.priceTf.setLocation(200, 390);
		this.add(this.priceTf);
		
		this.updateBtn = new JButton("Cập nhật");
		this.updateBtn.setSize(150, 40);
		this.updateBtn.setLocation(200, 470);
		this.add(this.updateBtn);
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}

	public JTextField getIdTf() {
		return idTf;
	}

	public void setIdTf(JTextField idTf) {
		this.idTf = idTf;
	}

	public JTextField getNameTf() {
		return nameTf;
	}

	public void setNameTf(JTextField nameTf) {
		this.nameTf = nameTf;
	}

	public JTextField getStatusTf() {
		return statusTf;
	}

	public void setStatusTf(JTextField statusTf) {
		this.statusTf = statusTf;
	}

	public JTextField getProducerTf() {
		return producerTf;
	}

	public void setProducerTf(JTextField producerTf) {
		this.producerTf = producerTf;
	}

	public JTextField getProviderTf() {
		return providerTf;
	}

	public void setProviderTf(JTextField providerTf) {
		this.providerTf = providerTf;
	}

	public JTextField getPriceTf() {
		return priceTf;
	}

	public void setPriceTf(JTextField priceTf) {
		this.priceTf = priceTf;
	}

	public JTextArea getFunctionTarea() {
		return functionTarea;
	}

	public void setFunctionTarea(JTextArea functionTarea) {
		this.functionTarea = functionTarea;
	}

	public JButton getUpdateBtn() {
		return updateBtn;
	}

	public void setUpdateBtn(JButton updateBtn) {
		this.updateBtn = updateBtn;
	}

	public JButton getDeleteBtn() {
		return deleteBtn;
	}

	public void setDeleteBtn(JButton deleteBtn) {
		this.deleteBtn = deleteBtn;
	}

}
