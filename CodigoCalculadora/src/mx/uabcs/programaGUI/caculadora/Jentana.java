package mx.uabcs.programaGUI.caculadora;
	import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
	
	
	public class Jentana extends JFrame{
		
	
			private int altura=0;
			private int ancho=0;
			private String titulo="";
			JButton btn;
			
			public Jentana(int ancho, int altura, String titulo){
				this.setSize(ancho, altura);
				this.titulo=titulo;
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				btn = new JButton("Hola mundo");
				this.add(btn);
				this.setVisible(true);
			}
			
			public Jentana(){
				this.setLayout(new BorderLayout());
				add(new CustomWidgetText(),BorderLayout.NORTH);
				add(new CustomWidgetKey(),BorderLayout.CENTER);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setVisible(true);
			}

			public int getAltura() {
				return altura;
			}

			public void setAltura(int altura) {
				this.altura = altura;
			}

			public int getAncho() {
				return ancho;
			}

			public void setAncho(int ancho) {
				this.ancho = ancho;
			}
			
			public void mostrar()
			{
				this.setSize(this.ancho, this.altura);
				this.setVisible(true);
				
			}
			
	
	
	}
