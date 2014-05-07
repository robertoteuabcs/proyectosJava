package mx.uabcs.javaswing;

import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

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

import mx.uabcs.javaswing.DataConnection;

public class FormPanel extends JPanel {

	private JLabel nameLabel,buscadorIdLabel;
	private JLabel occupationLabel;
	private JTextField nameField,buscarId;
	private JTextField occupationField;
	private JButton okBtn,borrar,actualizar;
	private JList ageList; //Lista las edades	
	private JComboBox empCombo;
	private JRadioButton maleRadio;
	private JRadioButton femeRadio;
	private JRadioButton otherRadio;
	private ButtonGroup genderGroup;
	private JCheckBox checkBox;
	private JTextField pais;
	String pais1;
	private CheckboxGroup box;
	private static DataConnection mc = DataConnection.getInstance();
	private FormListener formListener;
	
	//Dclaraciones de los arreglos con nombres, ocupantes y paises
	String[] arregloNombres = new String[]{"Juan Antonio","Alberto Lopez","Junior Paez","Jose Perez","Will Moca",
			 "Rolando Mota","Cafesino Late","Negro Guluarte","Peludo Ardrade","Yoshio Duarte","Roberto Bourjac",
			 "Nadia Lopz","Maria Consepcion","Morena Culto","Lucinda Drug","Veronica Frank","Fresh Rap",
			 "Principe del Rap","Karla Juarez","Pamela Kenia","Perla Hirales","Juan Jose","Humberto Ignacio",
			 "Gloria Comundo","Fausto Peralta"};
	String[] arreglOcupacion=new String[]{"Albañil","Mecanico","repartidor","Programador","Plomero",
											"Mercadologo","Sirvienta","Niñera","cajero(a)","Farmaco",
											"Electrico","Herrero","secretaria","Verdulero","Mercado",
											"Inspector","Pintor","Escritor","Biologo","Geologo","Maestro",
											"Comediante","Camarografo","Asistente","Pintor","Instalador"
	};
	
	String[] arregloPais=new String[]{"Honduras","Panama","Holanda","Paraguay","Colombia",
									"Chile","Bolivia","Brazil","Uruguay","Salvador",
									"China","Indonesia","Corea","Vietnam","Dubai",
									"Canada","USA","Antartida","Greolandia","Belize",
									"Peru","España","Italia","Francia","Inglaterra"
	};
	
	String[] arregloEdad=new String[]{"18-35","36-45","46 ymas"};
	
	String[] arregloEmpleado=new String[]{"Empleado","Por Contrato","No es Empleado"};
	
	String[] arregloGenero=new String[]{"Masculino","Femenino","Otro"};
	
	
	
	public FormPanel() {
		
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		buscadorIdLabel=new JLabel("ID: ");
		buscarId=new JTextField(5);
		nameLabel = new JLabel("Nombre: ");
		occupationLabel = new JLabel("OcupaciÃ³n: ");
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
		final DatabaseLayer dbl = new DatabaseLayer();
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
		
		actualizar=new JButton("Actualizar");
		borrar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = nameField.getText();
				String occupation = occupationField.getText();
				AgeCategory ageCat = (AgeCategory)ageList.getSelectedValue();
				int edad = ageCat.getId();
				String rango = ageCat.AgeCategory();
				EmployeEmplyCategory empCat = (EmployeEmplyCategory)empCombo.getSelectedItem();
				int contrato=(contrato.getId());
				//String empTipo = contrato.getText();
				String gender = genderGroup.getSelection().getActionCommand();
				System.out.println(gender);
				String nacionalidad;

				if (checkBox.isSelected()==true) {
	            	pais1="Mexicano";
				} 
				else{
				if(checkBox.isSelected()==false){
					 pais1=pais.getName();
				}
			}

				FormEvent ev = new FormEvent(this,name,occupation,rango,empTipo,gender,nacionalidad);
				String indice = buscarId.getText();
				dbl.actQuery(ev,indice);
			}
			
		});
		
		
		
		borrar=new JButton("Borrar");
		borrar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//DatabaseLayer conexion=new DatabaseLayer();
				String sql = "delete from trabajador where id="+buscarId.getText();
				dbl.borrar(sql);
				JOptionPane.showMessageDialog(null,"Datos Borrados Correctamente","Confirmacion",
						JOptionPane.PLAIN_MESSAGE);
			}
			
		});
		okBtn = new JButton("OK");
		okBtn.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//boolean boo;
				Random Rnombres=new Random();
				Random Rocupacion=new Random();
				Random Rpais=new Random();
				Random REdad=new Random();
				Random RGenero=new Random();
				Random REmpleado=new Random();
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
				/*for(int hh=0;hh<100;hh++){
					int randomGeneradoN=Rnombres.nextInt(24);
					int randomGeneradoO=Rocupacion.nextInt(24);
					int randomGeneradoP=Rpais.nextInt(24);
					int randomGeneradoE=REdad.nextInt(3);
					int randomGeneradoEm=REmpleado.nextInt(3);
					int randomGeneradoG=RGenero.nextInt(3);
				addProd(arregloNombres[randomGeneradoN], arreglOcupacion[randomGeneradoO],arregloEdad[randomGeneradoE],arregloEmpleado[randomGeneradoEm],arregloGenero[randomGeneradoG],arregloPais[randomGeneradoP]);
				
				}*/
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
				checkBox.setSelected(false);
				
			}
		});
		
		Border innerBorder = BorderFactory.createTitledBorder("Agregar Persona");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		///Buscador ID/////////////////
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(buscadorIdLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(buscarId, gc);
		//////////// First row ///////////////////////////////////
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(nameLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(nameField, gc);
		
		////////////Second row ///////////////////////////////////
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridy = 2;
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(occupationLabel, gc);
		
		gc.gridy = 2;
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(occupationField, gc);
		
		//////////////////////JList////////////////////
		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.gridy = 3;
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
		////////////////////////boton borrar/////////
		gc.weightx = 1;
		gc.weighty = 2.0;
		
		gc.gridy = 11;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(borrar, gc);
	}
	
	public void setFormListener(FormListener listener){
		this.formListener = listener;
	}
	
	static void addProd(String nom,String cat, String edad, String idCombo, String gender, String pais1){
		try {
			mc.inserta(nom,cat, edad, idCombo, gender, pais1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

class AgeCategory{
	private int id;
	private String text;
	
	public AgeCategory(int id, String text){
		this.id=id;
		this.text=text;
	}
	
	public String AgeCategory() {
		// TODO Auto-generated method stub
		return null;
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


