package mx.uabcs.programaGUI.caculadora;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CustomWidgetText extends JPanel {
	
	JTextArea text;
	
	public CustomWidgetText(){
		
		this.setLayout(new BorderLayout(4,4));
		text=new JTextArea("0", 2, 1);
		//text.setPreferredSize(new Dimension (0,50));
		text.setFont(new Font( "ARIAL",Font.BOLD,25 ));
		//text.setEditable(false);
		
		add(text,BorderLayout.CENTER);
	}

}
