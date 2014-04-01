package src.mx.uabcs.javaswing;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();
				/*ArrayList <Persona> lista= new ArrayList <Persona> ();
		
				Persona persona=new Persona(18,"Roberto","Guapura");
				Persona persona1=new Persona(15,"Alberto","Juan");
				Persona persona2=new Persona(99,"Humberto","Jose");
				Persona persona3=new Persona(45,"Paul","Pura");
				Persona persona4=new Persona(33,"Maria","Lopez");
				
				lista.add(persona);
				lista.add(persona1);
				lista.add(persona2);
				lista.add(persona3);
				lista.add(persona4);

				
				
				/*for(int x=0;x<=lista.size()-1;x++)
				{
					System.out.println(lista.get(x).getNombre());
					System.out.println(lista.get(x).getApellidos());
					System.out.println(lista.get(x).getEdad());
					System.out.println("----------------");
				
				
				
				/*Iterator it = lista.iterator();
				while(it.hasNext()){
					Persona p=(Persona) it.next();
					/*System.out.println(((Persona)it.next()).getApellidos());
					System.out.println(((Persona)it.next()).getEdad());
					System.out.println(((Persona)it..getNombre());
					
					System.out.println(p.getApellidos()+" "+p.getEdad()+" "+p.getNombre());
				}
				
				for(Persona p: lista)
				{
					System.out.println(p.getApellidos()+" "+p.getEdad()+" "+p.getNombre());
				}
				*/
			}
		});	
	}

}
