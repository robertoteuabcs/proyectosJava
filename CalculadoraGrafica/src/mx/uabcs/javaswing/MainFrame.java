package mx.uabcs.javaswing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MainFrame extends JFrame {
	
	private JButton btn;
	private TextPanel textPanel;
	private Toolbar toolbar;
	
	public MainFrame() {
		
		super("Hello World");
		
		setLayout(new BorderLayout());
		
		toolbar = new Toolbar();
		
		textPanel = new TextPanel();
		
		//toolbar.setTextPanel(textPanel);
		toolbar.setStringListener(new StringListener(){

			@Override
			public void textEmitted(String text) {
				// TODO Auto-generated method stub
				textPanel.appendText(text);
			}
			
		});
		
		
		add(toolbar, BorderLayout.CENTER);
		add(textPanel, BorderLayout.NORTH);
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
