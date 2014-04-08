package mx.uabcs.javaswing;

import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;

public class FormPanel extends JPanel {

	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private JButton okBtn;
	private JList ageList; //Lista las edades	
	private JComboBox empCombo;
	private JRadioButton maleRadio;
	private JRadioButton femeRadio;
	private JRadioButton otherRadio;
	private ButtonGroup genderGroup;
	private JCheckBox checkBox;
	private JTextField pais;
	private CheckboxGroup box;
	
	private FormListener formListener;
	
	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
		nameLabel = new JLabel("Nombre: ");
		occupationLabel = new JLabel("Ocupación: ");
		nameField = new JTextField(10);
		occupationField = new JTextField(10);
		empCombo =new JComboBox();
		ageList= new JList();//Creamos Lista
		//Radio Button
		maleRadio =new JRadioButton("Masculino");
		maleRadio.setActionCommand("Masculino");
		femeRadio =new JRadioButton("Femenino");
		femeRadio.setActionCommand("Femenino");
		otherRadio =new JRadioButton("Otro");
		otherRadio.setActionCommand("Otro");
		
		genderGroup= new ButtonGroup();
		maleRadio.setSelected(true);
		genderGroup.add(maleRadio);
		genderGroup.add(femeRadio);
		genderGroup.add(otherRadio);
		
		checkBox=new JCheckBox("Mexico",false);
		pais=new JTextField(10);
		pais.setEditable(true);
		
		//pais.addActionListener(new );
		//checkBox.add
		//if(checkBox.isSelected()==false){
		//	pais.setEditable(false);
		//}

		
		checkBox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (checkBox.isSelected()==false) {
		            	pais.setEditable(true);
		        } 
				else{
					if(checkBox.isSelected()==true){
						pais.setEditable(false);
					}
				}
			}
		});
		
		DefaultListModel ageModel =new DefaultListModel();
		ageModel.addElement(new AgeCategory(66,"18 - 35"));
		ageModel.addElement(new AgeCategory(77,"36 - 45"));
		ageModel.addElement(new AgeCategory(99,"46 y mas"));
		ageList.setModel(ageModel);
		ageList.setPreferredSize(new Dimension(110,70));
		ageList.setBorder(BorderFactory.createEtchedBorder());
		ageList.setSelectedIndex(0);
		
		DefaultComboBoxModel empModel=new DefaultComboBoxModel();
		empModel.addElement(new EmployeEmplyCategory(33,"Empleado"));
		empModel.addElement(new EmployeEmplyCategory(22,"Por contrado"));
		empModel.addElement(new EmployeEmplyCategory(33,"No es Empleado")); 
		empCombo.setModel(empModel);
		empCombo.setSelectedIndex(0);
		
		okBtn = new JButton("OK");
		okBtn.addActionListener(new ActionListener() {
			
			String pais1;
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//boolean boo;
				if (checkBox.isSelected()==true) {
		            	pais1=checkBox.getText();
		        } 
				else{
					if(checkBox.isSelected()==false){
						 pais1=pais.getText();
					}
				}
				String name = nameField.getText();
				String occupation = occupationField.getText();
				
				//JList
				AgeCategory ageCat=(AgeCategory)ageList.getSelectedValue();
				String id=ageCat.toString();
				//ComboBox 
				EmployeEmplyCategory empCat=(EmployeEmplyCategory)empCombo.getSelectedItem();
				String idCombo=empCat.toString();
						//empCombo.getSelectedItem()
				//String valor = (String)empCombo.getSelectedItem();
				//System.out.println(empCat.getId());
				//System.out.println(ageCat.getId());
				String gender=genderGroup.getSelection().getActionCommand();
				//System.out.println(gender);
				FormEvent ev = new FormEvent(this, name, occupation,id,idCombo,gender,pais1);
				
				if(formListener != null) {
					formListener.formEventOcurred(ev);
				}
				
				/*if(nameField.getText()!=" " || occupationField.getText()!=" "){
					
				}
				else{
					JOptionPane.showMessageDialog(null,"Algun Campo Esta Vacio	","Confirmacion",
							JOptionPane.PLAIN_MESSAGE);
				}*/
				JOptionPane.showMessageDialog(null,"Datos Guardados Correctamente","Confirmacion",
						JOptionPane.PLAIN_MESSAGE);
				nameField.setText(" ");
				occupationField.setText(" ");
				empCombo.setSelectedIndex(0);;
				ageList.setSelectedIndex(0);
				maleRadio.setSelected(true);
				pais.setText(" ");

			}
		});
		
		Border innerBorder = BorderFactory.createTitledBorder("Agregar Persona");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		//////////// First row ///////////////////////////////////
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(nameLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(nameField, gc);
		
		////////////Second row ///////////////////////////////////
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridy = 1;
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(occupationLabel, gc);
		
		gc.gridy = 1;
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(occupationField, gc);
		
		//////////////////////JList////////////////////
		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.gridy = 2;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(ageList, gc);
		
		///////////////ComboBox
		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.gridy = 4;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(empCombo, gc);
		
		/////////Radio Button/////////////
		
		gc.weightx = 1;
		gc.weighty = 0.5;
		
		gc.gridy = 5;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(maleRadio, gc);
		///////Radio Button//////////////////
		gc.weightx = 1;
		gc.weighty = 0.5;
		
		gc.gridy = 6;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(femeRadio, gc);
		
		gc.weightx = 1;
		gc.weighty = 0.5;
		
		gc.gridy = 7;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(otherRadio, gc);
		
		////////////////////CheckBox//////////////////////
		gc.weightx = 1;
		gc.weighty = 0.5;
		
		gc.gridy = 8;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(checkBox, gc);
		
		/////////////////Campo de Texto Pais/////
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 1;
		gc.gridy = 9;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(pais, gc);

		////////////Third row ///////////////////////////////////
		
		gc.weightx = 1;
		gc.weighty = 2.0;
		
		gc.gridy = 10;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(okBtn, gc);
	}
	
	public void setFormListener(FormListener listener){
		this.formListener = listener;
	}
}

class AgeCategory{
	private int id;
	private String text;
	
	public AgeCategory(int id, String text){
		this.id=id;
		this.text=text;
	}
	
	public String toString(){
		return text;
	}
	
	public int getId(){
		return id;
	}
}

class EmployeEmplyCategory{
	private int id;
	private String text;
	
	public EmployeEmplyCategory(int id, String text){
		this.id=id;
		this.text=text;
	}
	//Setenable
	public String toString(){
		return text;
	}
	
	public int getId(){
		return id;
	}
}

