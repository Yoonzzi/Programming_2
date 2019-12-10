package project_diary;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class _2_Join extends GUIManager
{
	static String fileSrc = "Login_data.txt";
	JLabel lbId,lbPw,lbName,lbTitle, laAdminNo;
	JButton bEnter,bCancel;
	JTextField txtId,txtName;
	JPasswordField txtPw, txtAdminNo;

	_2_Join (){
		Container contentPane = getContentPane();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Join");
		setLayout(null);
		Font f1 = new Font("Arial",Font.BOLD,20);
		Font f2 = new Font("Arial",Font.PLAIN,12);
		
		lbTitle = new JLabel();
		lbId=new JLabel();
		lbPw=new JLabel();
		lbName=new JLabel();
		txtId=new JTextField();
		txtName=new JTextField();
		txtPw=new JPasswordField();
		bEnter = new JButton();
		bCancel = new JButton();
		
		laAdminNo = new JLabel();
		txtAdminNo = new JPasswordField();
		
		createJLabel(contentPane, lbTitle, "Sign up", 200, 50, 85, 5, f1);
		createJLabel(contentPane, lbId, "User ID : ", 80, 20, 40, 65, f2);
		createJLabel(contentPane, lbPw, "User PW : ", 80, 20, 40, 90, f2);
		createJLabel(contentPane, lbName, "Name : ", 80, 20, 40, 115, f2);
		createJTextField(contentPane, txtId, "", 100,20,110,65,f2);
		createJTextField(contentPane, txtName, "", 100,20,110,115,f2);
		createJPasswordField(contentPane, txtPw, "", 100,20,110,90,f2);
		createJButton(contentPane, bCancel, "Cancel", 70, 25, 30, 170, f2);
		createJButton(contentPane, bEnter, "Enter", 110, 25, 105, 170, f2);
		
		createJLabel(contentPane, laAdminNo, "Admin No", 80, 20, 40, 140, f2);
		createJPasswordField(contentPane, txtAdminNo, "", 100, 20, 110, 140, f2);
		
		
		bEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!txtId.getText().equals("") && txtPw.getPassword().length>0 && txtAdminNo.getPassword().length>0){		
					String id = txtId.getText();
					String pw = new String(txtPw.getPassword());
					String name = txtName.getText();
					String admin = new String(txtAdminNo.getPassword());
					String adminNo = "1104";
					
					if(_1_MainPage.Login_data.get(id)!=null)
						JOptionPane.showMessageDialog(null, " Already exist ID ", "Join Error", JOptionPane.ERROR_MESSAGE);
				
					else if(_1_MainPage.Login_data.get(id) == null) {
							if (admin.equals(adminNo)){
								_1_MainPage.Login_data.put(id, new LoginData (id,pw,name));
								_1_MainPage.saveData();
								JOptionPane.showMessageDialog(null, " Success join ", "Join! ", JOptionPane.INFORMATION_MESSAGE);
								dispose();
							}
							else if (!admin.equals(adminNo)){
								JOptionPane.showMessageDialog(null, " Wrong AdminNo ", "Join Error ", JOptionPane.INFORMATION_MESSAGE);
							}
						}

			}
				else {
					JOptionPane.showMessageDialog(null, " Please enter all required fields ", "Join Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		bCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		setSize(250,230);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();		
		int screenX=(int)(screen.getWidth() / 2 - this.getWidth() / 2);
		int screenY=(int)(screen.getHeight() / 2 - this.getHeight() / 2);
		setLocation(screenX,screenY);
		setVisible(true);
		//setResizable(false);
	}
	
	public static void main(String[] args) {
		new _2_Join ();
	}
}


