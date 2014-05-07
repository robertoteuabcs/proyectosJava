package mx.uabcs.javaswing;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class App {

	public static void main(String[] args) {
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection conexion=null;
		
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdtrabajador","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Fallo");
			e.printStackTrace();
		}
		
		if(conexion!=null)
			System.out.println("Conexion Correcta");
		else
			System.out.println("Fallo la Conexcion");
		
		try {
			Statement smt=conexion.createStatement();
			String sql="INSERT INTO trabajador (nombre,ocupacion,edad,contrato,genero,pais)"+
					"VALUES('Rafa Marquez','wEBAS','46 ymas','Empleado','Otro','Colombia')";
			smt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		/*DatabaseLayer dbl=new DatabaseLayer();
		if(dbl.isConnected()){
			String sql="INSERT INTO trabajador (nombre,ocupacion,edad,contrato,genero,pais)"+
					"VALUES('pamela Anderson','wEBAS','46 ymas','Empleado','Otro','Colombia')";
			//dbl.queryExec(sql);
			ResultSet rs=dbl.resultQueryExec("select * from trabajador");
			try {
				while(rs.next()){
					System.out.println(rs.getString("nombre"));
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();
				
			}
		});	
	}
	}

