package mx.uabcs.javaswing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MainFrame extends JFrame {
	
	private JButton btn;
	private TextPanel textPanel;
	private Toolbar toolbar;
	private FormPanel formPanel;
	
	private ArrayList<FormEvent> myList;
	
	DatabaseLayer dbl;
	public MainFrame() {
		
		super("Hello World");
		
		setLayout(new BorderLayout());
		myList = new ArrayList<FormEvent>();
		dbl=new DatabaseLayer();
		toolbar = new Toolbar();
		btn = new JButton("Click me");
		textPanel = new TextPanel();
		formPanel = new FormPanel();
		
		//toolbar.setTextPanel(textPanel);
		toolbar.setArrayList(myList);
		
		toolbar.setStringListener(new StringListener(){
			@Override
			public void textEmitted(String text) {
				// TODO Auto-generated method stub
				textPanel.appendText(text);
			}
		});
		
		
		
		toolbar.setArrayFormListener(new ArrayFormListener(){

			@Override
			public void arrayEmitted(ArrayList<FormEvent> lista) {
				// TODO Auto-generated method stub
				
					//System.out.println(fe.getName());

					/*textPanel.appendText("Nombre: "+fe.getName()+" \n"+"Ocupacion: "+fe.getOccupation()
							+"\n"+"Edad: "+fe.getAgeCatogory()+"\n"+"Empleo: "+fe.getIdCombo()+"\n"+"Genero:"+fe.getGender()+
							"\n"+"Pais:"+fe.getPais1());
					textPanel.appendText("\n");
					textPanel.appendText("-------------------------------------------------");
					textPanel.appendText("\n");
					//textPanel.appendText(mostraProds());
					ResultSet resultado = mc.getQuery("select * from trabajador");
					 try {
						while(resultado.next()){
							 textPanel.appendText("ID: "+resultado.getString("id")+"\n");
							 textPanel.appendText("Nombre: "+resultado.getString("nombre")+"\n");
							 textPanel.appendText("Ocupacion: "+resultado.getString("ocupacion")+"\n");
							 textPanel.appendText("Edad: "+resultado.getString("edad")+"\n");
							 textPanel.appendText("Contrato: "+resultado.getString("contrato")+"\n");
							 textPanel.appendText("Genero: "+resultado.getString("genero")+"\n");
							 textPanel.appendText("Pais: "+resultado.getString("pais")+"\n");
							 textPanel.appendText("----------------------------------"+"\n");
						 }
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
				//DatabaseLayer dbl=new DatabaseLayer();
				if(dbl.isConnected()){
					ArrayList<FormEvent> list=dbl.resultQueryExec("select * from program3");
					for(FormEvent f: list){
						textPanel.appendText("\n"+
					"ID: "+f.getId()+"\n"+"Nombre: "+f.getName()+"\n");
						textPanel.appendText("========================");
					}
					
				}
				
			}
		});
		
		formPanel.setFormListener(new FormListener(){
			
			@Override
			public void formEventOcurred(FormEvent e) {
				// TODO Auto-generated method stub
				//myList.add(e);
				//String name = e.getName();
				//String occupation = e.getOccupation();
				//textPanel.appendText(name + ": " + occupation +"\n");
				if(dbl.isConnected()){
					String sql="INSERT INTO trabajador (nombre,ocupacion,edad,empleado_id,genero,nacion_id)"+
							"VALUES('"+e.getName()+"','"+e.getOccupation()+"','"+e.getAgeCatogory()+"','"+e.getIdCombo()+"','"+e.getGender()+"','"+e.getNacion_id()+"')";
					dbl.queryExec(sql);
				}
			}
		});
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPanel.appendText("Hello\n");
			}
		});
		
		add(formPanel, BorderLayout.WEST);
		add(toolbar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	
	
}

