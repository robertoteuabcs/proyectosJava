package src.mx.uabcs.javaswing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Toolbar extends JPanel implements ActionListener{
	private JButton helloButton;
	private JButton goodbyeButton;
	private JButton desplegar;
	
	private StringListener textListener;
	private FormArrayListener arrayListener;
	//private FormArrayListener <FormEvent> myList;
	private ArrayList<FormEvent> myList;
	
	public Toolbar() {
		helloButton = new JButton("Hello");
		goodbyeButton = new JButton("Goodbye");
		desplegar =new JButton("Desplegar");
		desplegar.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(desplegar);
		add(helloButton);
		add(goodbyeButton);
		
	}
	
	public void setArrayList(ArrayList<FormEvent> list){
		this.myList=list;
	}
	
	public void setFormArrayListener(FormArrayListener listener){
		this.arrayListener=listener;
	}
	
	public void setStringListener(StringListener listener){
		this.textListener=listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		JButton clicked=(JButton) e.getSource();
		if(arrayListener!=null){
		if(clicked==desplegar){
			arrayListener.evento(this.myList);
		}
		}
	}
}

