package project_diary;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;

public class _3_SecretMemo extends JFrame {

	JTextArea textArea;
	JButton bSave, bOpen, bOut;
	JPanel mainPanel, panel1, panel2;

	TimeRecord time = new TimeRecord();
	SaveToFile save = new SaveToFile();


	public _3_SecretMemo() {
		
		super("Secret Memo");
		this.setSize(500,250); 
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);  

		mainPanel = new JPanel(new BorderLayout());
		panel1= new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER,0,13));

		
		textArea = new JTextArea(10,40);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		JScrollPane pane = new JScrollPane(textArea);

		bOut = new JButton("Log Out");
		bSave = new JButton("Save");
		bOpen = new JButton("Open with notepad");

		DealWithButtons db = new DealWithButtons();
		bSave.addActionListener(db);
		bOpen.addActionListener(db);
		bOut.addActionListener(db);

		panel1.add(pane);
		panel2.add(bSave);
		panel2.add(bOpen);
		panel2.add(bOut);

		mainPanel.add(panel1, BorderLayout.CENTER);
		mainPanel.add(panel2, BorderLayout.SOUTH);
	

		this.add(mainPanel);

		this.setVisible(true);
		textArea.requestFocus();
	}
	
	
	// 내부 클래스로 Action listener 작성 
	private class DealWithButtons implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String path = "QuickDiary.txt";

			if(e.getSource() == bSave) {
				PrintWriter pr = save.createFile(path);

				int option = JOptionPane.showConfirmDialog(null, "Do you want to save?", "Save",JOptionPane.YES_NO_OPTION);
				if(option == 0) {

				save.printToFile("Writer:" +_1_MainPage.txtId.getText(), pr);
				save.printToFile("---------------------------------------------", pr);
				save.printToFile(textArea.getText().trim(), pr);
				save.printToFile(time.getDate(), pr);
				save.printToFile(time.getTime(), pr);
				save.printToFile("---------------------------------------------", pr);
				save.addSpace();
				pr.close();

				textArea.setText("");
			}

		}

			if(e.getSource() == bOpen) {
				File file = new File(path);
				Desktop desktop = Desktop.getDesktop();
				
				if(file.exists() && file.length()>0) {
						
					try {
							desktop.edit(file);
						} 
					catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				
				else {
						JOptionPane.showMessageDialog(null, "No Diary. Please write and try!", "Invalid Access", JOptionPane.ERROR_MESSAGE);
					}
				}
			
			if(e.getSource() == bOut) {
				
				int option = JOptionPane.showConfirmDialog(null, "Do you want to LogOut?", "Log Out",JOptionPane.YES_NO_OPTION);
				if(option == 0) {
					new _1_MainPage();
					dispose();
					}
		
				}
			}
		}

	

public static void main(String[] args) {
	new _3_SecretMemo();

	}
}
