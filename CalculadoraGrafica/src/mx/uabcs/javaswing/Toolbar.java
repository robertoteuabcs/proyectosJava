package mx.uabcs.javaswing;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Toolbar extends JPanel implements ActionListener, Operaciones{ 
	
	private JButton uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueva,cero;
	private JButton entre,suma,resta,multiplicacion,punto,igual,borrar;
	
	//private TextPanel textPanel;}
	
	private StringListener textListener;
	private Operaciones ope;
	private String numeros[]=new String [10];
	private String auxnumeros[]=new String[10];
	private int x=0,xx=0;
	String num="";
	private int i=0,ii=0;
	double numero=0.0;
	double numero2=0.0,resultado=0.0;	
	public Toolbar() {
		this.setLayout(new GridLayout(5,5,4,4));
		
		borrar=new JButton("CE");
		borrar.addActionListener(this);
		
		siete = new JButton("7");
		siete.addActionListener(this);
		
		ocho = new JButton("8");
		ocho.addActionListener(this);
		
		nueva = new JButton("9");
		nueva.addActionListener(this);
		
		entre = new JButton("/");
		entre.addActionListener(this);
		
		cuatro = new JButton("4");
		cuatro.addActionListener(this);
		
		cinco = new JButton("5");
		cinco.addActionListener(this);
		
		seis = new JButton("6");
		seis.addActionListener(this);

		multiplicacion = new JButton("*");
		multiplicacion.addActionListener(this);
		
		uno = new JButton("1");
		uno.addActionListener(this);
		
		dos = new JButton("2");
		dos.addActionListener(this);
		
		tres = new JButton("3");
		tres.addActionListener(this);
		
		resta = new JButton("-");
		resta.addActionListener(this);
		
		cero = new JButton("0");
		cero.addActionListener(this);
		
		punto = new JButton(".");
		punto.addActionListener(this);
		
		resta = new JButton("-");
		resta.addActionListener(this);
		
		igual = new JButton("=");
		igual.addActionListener(this);
		
		suma = new JButton("+");
		suma.addActionListener(this);
		//setLayout(new FlowLayout(FlowLayout.LEFT));
		add(siete);
		add(ocho);
		add(nueva);
		add(entre);
		add(cuatro);
		add(cinco);
		add(seis);
		add(multiplicacion);
		
		add(uno);
		add(dos);
		add(tres);
		add(resta);
		add(punto);
		add(cero);
		add(igual);
		add(suma);
		add("NORT",borrar);
		
		
	}
	
	/*public void setTextPanel(TextPanel textPanel){
		this.textPanel=textPanel;
	}*/
	
	public void setStringListener(StringListener listener){//Recibe como parametro 
		this.textListener=listener;				//Se lo asigan el parametro como referencia en memoria 
	}
	
	/*public void setSuma(Operaciones numero,Operaciones numero2)
	{
		this.suma=String.valueOf(numero)+String.valueOf(numero2);
	}*/
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JButton click = (JButton)arg0.getSource();
		
		if(click==borrar)
		{
			if(textListener!=null){
				for(int xxp=0;xxp<4;xxp++)
				{
					textListener.textEmitted(""+"\n");
				}
			}
			
			for(int f=0;f<numeros.length-1;f++){
				numeros[f]=null;
				auxnumeros[f]=null;
			}
			
			num="";
			numero=0;
			numero2=0;	
			x=0;
			xx=0;		
		}
		if(click==siete){
			if(textListener!=null){
				textListener.textEmitted(click.getText());
			num+=click.getText();
			//textPanel.appendText("Gello\n");
			}
		}
		if(click==ocho){
			if(textListener!=null){
				textListener.textEmitted(click.getText());
			}
			num+=click.getText();
		}
		
		if(click==nueva){
			if(textListener!=null){
				textListener.textEmitted(click.getText());
			}
			num+=click.getText();
		}
		
		if(click==cuatro){
			if(textListener!=null){
				textListener.textEmitted(click.getText());
			}
			num+=click.getText();
		}
		
		if(click==cinco){
			if(textListener!=null){
				textListener.textEmitted(click.getText());
			}
			num+=click.getText();
		}
		
		if(click==seis){
			if(textListener!=null){
				textListener.textEmitted(click.getText());
			}
			num+=click.getText();
		}
		
		
		if(click==uno){
			if(textListener!=null){
				textListener.textEmitted(click.getText());
			}
			num+=click.getText();
		}
		
		if(click==dos){
			if(textListener!=null){
				textListener.textEmitted(click.getText());
			}
			num+=click.getText();
		}
		
		if(click==tres){
			if(textListener!=null){
				textListener.textEmitted(click.getText());
			}
			num+=click.getText();
		}
		
		if(click==cero){
			if(textListener!=null){
				textListener.textEmitted(click.getText());
			}
			num+=click.getText();
		}
		
		if(click==igual)
		{
			textListener.textEmitted("=");
			numeros[x]=num;
			i=0;
			ii=0;
			
			/*for(int w=0;w<numeros.length;w++)
			{
				System.out.println(numeros[w]);
			}*/
			

			for(i=0;i<numeros.length;i++)
			{
				if(numeros[i]=="*"|| numeros[i]=="/")
				{
					//
					switch(numeros[i])
					{
					case "*":
						/*numero=Double.parseDouble(numeros[i-1]);
						numero2=Double.parseDouble(numeros[i+1]);
						numeros[i+1]=Double.toString((numero*numero2));
						//Double.toString((numero*numero2));*/
						Mult(numeros[i-1],numeros[i+1],i);
						numeros[i]=null;
						numeros[i-1]=null;

					break;
					
					case "/":
						/*numero=Double.parseDouble(numeros[i-1]);
						numero2=Double.parseDouble(numeros[i+1]);
						numeros[i+1]=Double.toString( (numero/numero2));*/
						Div(numeros[i-1],numeros[i+1],i);
						numeros[i]=null;
						numeros[i-1]=null;
						break;
					}
					
				}

			
		}
				for(int w=0;w<numeros.length;w++)
				{
					System.out.println(numeros[w]);
					if(numeros[w]!=null)
					auxnumeros[xx++]=numeros[w];
				}
				
				for(i=0;i<auxnumeros.length;i++)
				{
					if(auxnumeros[i]=="+"|| auxnumeros[i]=="-")
					{
						//
						switch(auxnumeros[i])
						{
						case "+":
							//numero=Double.parseDouble(auxnumeros[ii-1]);
							//numero2=Double.parseDouble(auxnumeros[ii+1]);
							//auxnumeros[i+1]=Double.toString((numero+numero2));
							Suma(auxnumeros[i-1],auxnumeros[i+1],i);
							auxnumeros[i]=null;
							auxnumeros[i-1]=null;

						break;
						
						case "-":
							/*numero=Double.parseDouble(auxnumeros[ii-1]);
							numero2=Double.parseDouble(auxnumeros[ii+1]);
							auxnumeros[ii+1]=Double.toString((numero-numero2));*/
							this.Resta(auxnumeros[i-1],auxnumeros[i+1],i);
							auxnumeros[i]=null;
							auxnumeros[i-1]=null;
							break;
						}	
					}
			}
				//System.out.println(auxnumeros[2]);
			//System.out.println("---------------------------------");
				for(int w=0;w<auxnumeros.length;w++)
				{
					System.out.println(auxnumeros[w]);
					if(auxnumeros[w]!=null)
						textListener.textEmitted(auxnumeros[w]);
					//textListener.textEmitted(Double.toString(resultado));
				}		
		}
		
		if(click==entre){
			if(textListener!=null){
				textListener.textEmitted(click.getText());
				numeros[x++]=num;
				numeros[x++]="/";
				num="";
			}
		}
		
		if(click==multiplicacion){
			if(textListener!=null){
				textListener.textEmitted(click.getText());
				numeros[x++]=num;
				numeros[x++]=click.getText();
				num="";
			}
		}
		
		if(click==suma){
			if(textListener!=null){
				textListener.textEmitted(click.getText());
				numeros[x++]=num;
				numeros[x++]=click.getText();
				num="";
			}
		}
		
		if(click==resta){
			if(textListener!=null){
				textListener.textEmitted(click.getText());
				numeros[x++]=num;
				numeros[x++]=click.getText();
				num="";
			}
		}
		
		
	}

	@Override
	public void Suma(String numero, String numero2,int i) {
		resultado=Double.parseDouble(numero)+Double.parseDouble(numero2);
		auxnumeros[i+1]=String.valueOf(resultado);
				
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Resta(String numero, String numero2,int i) {
		resultado=Double.parseDouble(numero)-Double.parseDouble(numero2);
		auxnumeros[i+1]=String.valueOf(resultado);
				
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Mult(String numero, String numero2,int i) {
		resultado=Double.parseDouble(numero)*Double.parseDouble(numero2);
		numeros[i+1]=String.valueOf(resultado);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Div(String numero, String numero2,int i) {
		resultado=Double.parseDouble(numero)/Double.parseDouble(numero2);
		numeros[i+1]=String.valueOf(resultado);
		// TODO Auto-generated method stub
		
	}
}
