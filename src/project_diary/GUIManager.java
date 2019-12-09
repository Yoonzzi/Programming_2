package project_diary;

import java.awt.*;
import javax.swing.*;


public class GUIManager extends JFrame {
	static void createJLabel(Container c,JLabel obj,String name, int sx, int sy, int dx, int dy, Font f)
	{
		obj.setText(name);
		obj.setSize(sx,sy);
		obj.setLocation(dx,dy);
		obj.setFont(f);
		c.add(obj);
	}
	static void createJTextField(Container c,JTextField obj,String name, int sx, int sy, int dx, int dy, Font f)
	{
		obj.setText(name);
		obj.setSize(sx,sy);
		obj.setLocation(dx,dy);
		obj.setFont(f);
		c.add(obj);
	}
	static void createJPasswordField(Container c,JPasswordField obj,String name, int sx, int sy, int dx, int dy, Font f)
	{
		obj.setText(name);
		obj.setSize(sx,sy);
		obj.setLocation(dx,dy);
		obj.setFont(f);
		c.add(obj);
	}
	static void createJButton(Container c,JButton obj,String name, int sx, int sy, int dx, int dy, Font f)
	{
		obj.setText(name);
		obj.setSize(sx,sy);
		obj.setLocation(dx,dy);
		obj.setFont(f);
		c.add(obj);
	}
}



