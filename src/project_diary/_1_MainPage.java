package project_diary;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.swing.*;
import java.io.*;

public class _1_MainPage extends GUIManager { 
	
	static HashMap < String,LoginData > Login_data = new HashMap < String,LoginData >();
	static String fileSrc = "Login_data.txt";
	static JTextField txtId;
	
	JFrame frame;
	JPasswordField txtPw;
	JLabel lbId,lbPw, lbJoin, lbTitle;
	JButton bLogin,bJoin,bExit;

	_1_MainPage (){ 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		Font f1 = new Font("Arial",Font.BOLD,20);
		Font f2 = new Font("Arial",Font.PLAIN,12);
		setLayout(null);
		setTitle("Login");
		
		lbTitle = new JLabel();
		lbId = new JLabel();
		lbPw = new JLabel();
		lbJoin = new JLabel();
		txtId = new JTextField();
		txtPw = new JPasswordField();
		bLogin = new JButton();
		bJoin = new JButton();
		bExit =new JButton();
		
		createJLabel(contentPane,lbTitle,"Secret Memo",145,50,80,10,f1);
		createJLabel(contentPane,lbId,"User ID : ",80,40,20,60,f2);
		createJTextField(contentPane,txtId,"",110,20,85,70,f2);
		createJLabel(contentPane,lbPw,"User PW : ",80,40,20,90,f2);
		createJTextField(contentPane,txtPw,"",110,20,85,100,f2);
		createJLabel(contentPane,lbJoin,"Sign up : ",80,40,20,120,f2);
		createJButton(contentPane,bLogin,"Login",70,60,200,65,f2);
		createJButton(contentPane,bJoin,"Join",115,25,82,130,f2);
		createJButton(contentPane,bExit,"EXIT",78,25,196,130,f2);
		
		// Login과 관련된 이벤트 정리 
		txtId.addActionListener(new LoginActionListener());
		txtPw.addActionListener(new LoginActionListener());
		bLogin.addActionListener(new LoginActionListener());
		
		// join 버튼 이벤트 
		bJoin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new _2_Join();
			}
		});
		
		// 종료 버튼 이벤트 
		bExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		setSize(300,200);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();		
		int screenX=(int)(screen.getWidth() / 2 - this.getWidth() / 2);
		int screenY=(int)(screen.getHeight() / 2 - this.getHeight() / 2);
		setLocation(screenX,screenY);
		setVisible(true);
		setResizable(false);
		
	}
	
	
	//Login과 관련된 이벤트 
	class LoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(!txtId.getText().equals("")&&txtPw.getPassword().length>0){
				String id = new String(txtId.getText());
				String pwd2 = new String(txtPw.getPassword());
			    String a = "/Users/yoonji/eclipse-workspace/yoonzzi/Login_data.txt";
		    	FileReader fr;
						
		    	try { 
		    		fr = new FileReader(fileSrc);
					BufferedReader br = new BufferedReader(fr);

					String data;
							
					try { // 아이디 비번 입력시 Login_data에서 정보 읽기 
					   while ((data = br.readLine()) != null) {
				       String[] row = data.split(",");
							        
				       if (id.equals(row[0])){ // 아이디 맞아 ! 
				    	   if (pwd2.equals(row[1])){ //비번 맞아 ! 로그인 성공! 
				    		   	JOptionPane.showMessageDialog(null, " Success Login! ", "Login! ", JOptionPane.INFORMATION_MESSAGE);
				    		   	_3_SecretMemo diary = new _3_SecretMemo();
								setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								dispose();
								break;
				    	   		}
							        	
				        	else { // 비밀번호 틀려 ! 
				        		JOptionPane.showMessageDialog(null, "Wrong PW", " Login Error ", JOptionPane.ERROR_MESSAGE);
								txtPw.requestFocus();
								break;
								}
				     		}
							        
				       else { // ID 정보 틀려 (ID없거나.. )
				    	   JOptionPane.showMessageDialog(null, "ID not found", "Login Error", JOptionPane.ERROR_MESSAGE);
				    	   txtId.requestFocus();
			        		}
					   }
					}
					catch (IOException e1) {
							e1.printStackTrace();
								}
						} 
			 catch (FileNotFoundException e2) {
							e2.printStackTrace();
							
						}	

					}
			
			else if(txtId.getText().equals("")){ // ID 입력 없이 로그인 버튼 클릭 
				JOptionPane.showMessageDialog(null, "Enter ID", "Invalid Access", JOptionPane.ERROR_MESSAGE);
				txtId.requestFocus();
			}
			
			else if(txtPw.getPassword().length==0) { // PW 입력 없이 로그인 버튼 클릭 
				JOptionPane.showMessageDialog(null, "Enter PW", "Invalid Access", JOptionPane.ERROR_MESSAGE);
				txtPw.requestFocus();
			}
		}
	}
	
	
	
// 메인 메소드 ! 	
	public static void main(String[] args) {

		new _1_MainPage();
	}
	

// join 할때 save Data 
	static void saveData ( ) {
		FileWriter fw = null;	 
		BufferedWriter bw = null;	
		String str;	// 
		
		try{
			fw = new FileWriter(fileSrc);	
			bw = new BufferedWriter(fw);	
			
			Set <String> keys = _1_MainPage.Login_data.keySet();
			Iterator <String> it = keys.iterator();
			while(it.hasNext()){
				LoginData temp = _1_MainPage.Login_data.get(it.next());
				String id = temp.getId();
				String pwd = temp.getPassword();
				String name = temp.getName();
				str=id+","+pwd+","+name+"\r\n";
				bw.write(str);
			}
			bw.close();	
			fw.close();
		}
		catch(IOException e){
			e.printStackTrace();
			System.out.println("Data Save Error");
		}
	}
	

}




