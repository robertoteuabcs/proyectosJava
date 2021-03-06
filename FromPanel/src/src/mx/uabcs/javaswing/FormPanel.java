package src.mx.uabcs.javaswing;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class FormPanel extends JPanel {
	
	private JLabel nameLabel;
	private JLabel ocupattionLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private JButton okBtn;
	//Form Listener
	private FormListener formListener;
	private FormArrayListener listener;
	
	//ArrayList <FormEvent> lista= new ArrayList <FormEvent> ();
	
	public FormPanel(){
		Dimension dim = getPreferredSize();
		dim.width=250;
		setPreferredSize(dim);
	

	nameLabel=new JLabel("Nombre: ");
	nameField =new JTextField(10);
	ocupattionLabel=new JLabel("Ocupattion: ");
	occupationField=new JTextField(10);
	okBtn=new JButton("OK");
	okBtn.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
			//TODO Auto-generated method stub
			String name=nameField.getText();
			String occupation=occupationField.getText();
			
			FormEvent eve= new FormEvent(this,name,occupation);
			//lista.add(eve);
			
			//if(formListener!=null){
				//formListener.formEventOcurred(eve);
			//}
			
			if(formListener!=null){
				formListener.formEventOcurred(eve);
			}
			
		}
	});

	//BOrder
	Border innerBorder=BorderFactory.createTitledBorder("Agregar Personas");
	Border outerBorder=BorderFactory.createEmptyBorder(5, 5, 5, 5);
	setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
	
	setLayout(new GridBagLayout());
	
	GridBagConstraints gc= new GridBagConstraints();
	
	////////////////FIRST NOW///////////////////////
	
	gc.weightx=1;
	gc.weighty=0.1;
	
	gc.gridx=0;
	gc.gridy=0;
	gc.fill=GridBagConstraints.NONE;
	gc.anchor=GridBagConstraints.LINE_END;
	gc.insets=new Insets(0,0,0,5);
	add(nameLabel,gc);
	
	gc.gridx=1;
	gc.gridy=0;
	gc.insets=new Insets(0,0,0,0);
	gc.anchor=GridBagConstraints.LINE_START;
	add(nameField, gc);
	
	///////////////SECON NOW///////////////////////////////
	gc.weightx=1;
	gc.weighty=0.1;
	
	gc.gridy=1;
	gc.gridx=0;
	gc.insets=new Insets(0,0,0,5);
	gc.anchor=GridBagConstraints.LINE_END;
	add(ocupattionLabel,gc);
	
	gc.gridy=1;
	gc.gridx=1;
	gc.insets=new Insets(0,0,0,0);
	gc.anchor=GridBagConstraints.LINE_START;
	add(occupationField,gc);
	//////////////tercer//////////////////////////////////////////////
	gc.weightx=1;
	gc.weighty=2.0;
	
	gc.gridy=2;
	gc.gridx=1;
	gc.insets=new Insets(0,0,0,5);
	gc.anchor=GridBagConstraints.LINE_START;
	
	add(okBtn,gc);
	}


	public void setFormListener(FormListener listener){
		this.formListener=listener;
		
	}
	
	public void setFormArrayListener(FormArrayListener lista){
		this.listener=lista;
	}
}
