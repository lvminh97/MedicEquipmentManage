package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import utilities.Config;
import view.LoginView;

public class Login implements ActionListener{
	
	public final static int LOGIN_SUCCESS = 0;
	public final static int LOGIN_WRONG_PASSWORD = 1;
	
	public static LoginView loginView;
	
	public Login() {
		loginView = new LoginView();
		loginView.getLoginBtn().addActionListener(this);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginView.getLoginBtn()) {
			int checkLogin = Config.account.login(loginView.getUsernameTf().getText(), loginView.getPasswordTf().getText());
			if(checkLogin == 0) {
				JOptionPane.showMessageDialog(loginView, "Đăng nhập thành công!");
				loginView.dispose();
				new EquipmentList();
			}
			else if(checkLogin == 1){
				JOptionPane.showMessageDialog(loginView, "Sai tên đăng nhập hoặc mật khẩu!");
			}
			else if(checkLogin == 2) {
				JOptionPane.showMessageDialog(loginView, "Tài khoản của bạn không đủ quyền truy cập!");
			}
		}
		
	}
}
