package src.mx.uabcs.javaswing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {
	
	private JButton btn;
	private TextPanel textPanel;
	private Toolbar toolbar;
	private FormPanel formpanel;
	ArrayList <FormEvent> lista= new ArrayList <FormEvent> ();
	
	private ArrayList<FormEvent> myList;
	
	public MainFrame() {
		super("Hello World");
		myList=new ArrayList<FormEvent> ();
		setLayout(new BorderLayout());
		
		
		
		toolbar = new Toolbar();
		btn = new JButton("Click me");
		textPanel = new TextPanel();
		
		formpanel=new FormPanel();
		
		

		//toolbar.setTextPanel(textPanel);
		toolbar.setStringListener(new StringListener(){

			@Override
			public void textEmitted(String text) {
				// TODO Auto-generated method stub
				textPanel.appendText(text);
			}
			
		});
		
		toolbar.setFormArrayListener(new FormArrayListener(){

			@Override
			public void evento(ArrayList<FormEvent> lista) {
				// TODO Auto-generated method stub
				for(FormEvent fe: lista){
					System.out.println(fe.getName());
				}
			}
			
			
		});
		
		formpanel.setFormListener(new formListener());
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPanel.appendText("Hello\n");
			}
		});
		add(formpanel,BorderLayout.WEST);
		add(toolbar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	
}
