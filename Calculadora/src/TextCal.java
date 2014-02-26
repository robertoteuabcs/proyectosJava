import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
	


public class TextCal extends JPanel{
	private JTextArea textArea;
	
	public TextCal(){
		setLayout(new GridLayout(3, 3, 0, 0));
		
		textArea=new JTextArea();
		textArea.setBorder(new EmptyBorder(4,4,4,4));
		//textArea.setText("0");
		add(new JScrollPane(textArea),BorderLayout.NORTH);	
		//add(textArea);
		//textArea.setSize(100, 30);
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	

}
