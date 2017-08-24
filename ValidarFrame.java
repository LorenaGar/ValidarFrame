package frames;
//Validacion de la informacion del usuario mediante expresiones regulares.
import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ValidarFrame extends JFrame{
	private JTextField telefonoCampoTexto,codigoPostalCampoTexto,
	estadoCampoTexto,ciudadCampoTexto,direccionCampoTexto,
	nombreCampoTexto,apellidoCampoTexto;
	
	public ValidarFrame()
	{
		
		super("VALIDACION");
		//crear los cmponentes de la GUI
		
		JLabel telefonoetiqueta=new JLabel("Telefono");
		JLabel codigoPostaletiqueta=new JLabel("C.P");
		JLabel estadoetiqueta=new JLabel("Estado");
		JLabel ciudadetiqueta=new JLabel("Ciudad");
		JLabel direccionetiqueta=new JLabel("Direccion");
		JLabel nombreetiqueta=new JLabel("Primer Nombre");
		JLabel apellidoetiqueta=new JLabel("Apellido Paterno");
	    JButton aceptarBoton=new JButton("Aceptar");
	    
	    aceptarBoton.addActionListener(new ActionListener() //clase interna
	    		{
	    	public void actionPerformed(ActionEvent evento) {
	    		validarFecha();
	    	}
	    	}//fin de la clase interna
	    );//fin de la llamada a addActionListener
	    
	    telefonoCampoTexto=new JTextField(15);
	    codigoPostalCampoTexto=new JTextField(5);
	    estadoCampoTexto=new JTextField(2);
	    ciudadCampoTexto= new JTextField(12);
	    direccionCampoTexto=new JTextField(20);
	    nombreCampoTexto=new JTextField(20);
	    apellidoCampoTexto=new JTextField(20);
	    
	    JPanel primerNombre=new JPanel();
	    primerNombre.add(nombreetiqueta);
	    primerNombre.add(nombreCampoTexto);
	    
	    JPanel apellidoPaterno=new JPanel();
	    apellidoPaterno.add(apellidoetiqueta);
	    apellidoPaterno.add(apellidoCampoTexto);
	    
	    JPanel direccion1=new JPanel();
	    direccion1.add(direccionetiqueta);
	    direccion1.add(direccionCampoTexto);
	    
	    JPanel direccion2=new JPanel();
	    direccion2.add(ciudadetiqueta);
	    direccion2.add(ciudadCampoTexto);
	    direccion2.add(estadoetiqueta);
	    direccion2.add(estadoCampoTexto);
	    direccion2.add(codigoPostaletiqueta);
	    direccion2.add(codigoPostalCampoTexto);
	    
	    JPanel telefono=new JPanel();
	    telefono.add(telefonoetiqueta);
	    telefono.add(telefonoCampoTexto);
	    
	    JPanel aceptar=new JPanel();
	    aceptar.add(aceptarBoton);
	    
	    //agregar los componentes ala aplicacion
	    
	    Container contenedor=getContentPane();
	    contenedor.setLayout(new GridLayout(6,1));
	    
	    contenedor.add(primerNombre);
	    contenedor.add(apellidoPaterno);
	    contenedor.add(direccion1);
	    contenedor.add(direccion2);
	    contenedor.add(telefono);
	    contenedor.add(aceptar);
	    
	    setSize(400,225);
	    setVisible(true);
	    }//fin del constructor de ValidarFrame

	public static void main(String[] args) 
	{
	    ValidarFrame aplicacion=new ValidarFrame ();
		aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	//maneja el evento de accion de aceptarBoton
	
	private void validarFecha()
	{
		//asegurar qu no haya cuadros de texto vacios
		if(apellidoCampoTexto.getText().equals("")||nombreCampoTexto.getText().equals("")
		   ||direccionCampoTexto.getText().equals("")||ciudadCampoTexto.getText().equals("")
		   ||estadoCampoTexto.getText().equals("")||codigoPostalCampoTexto.getText().equals("")
		   ||telefonoCampoTexto.getText().equals(""))//fin de la condicion
			
			{JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos");}
			
		//si el formato de primer nombre es invalido, mostrar mensaje
		else if(!nombreCampoTexto.getText().matches("[A-Z][a-zA-Z]*"))
			JOptionPane.showMessageDialog(this, "Primer nombre invalido");
		
		//si el formato de apellido paterno es invalido, mostrar mensaje
		else if(!apellidoCampoTexto.getText().matches("[A-Z][a-zA-Z]*"))
					JOptionPane.showMessageDialog(this, "Apellido Paterno invalido");
		
		
		//si el formato de direccion es invalido, mostrar mensaje
		else if(!direccionCampoTexto.getText().matches("\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+"))
		   JOptionPane.showMessageDialog(this, "Direccion invalido");
		
		//si el formato de ciudad es invalido, mostrar mensaje
		else if(!ciudadCampoTexto.getText().matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+"))
		 JOptionPane.showMessageDialog(this, "Estado invalido");
		
		//si el formato de codigo postal es invalido, mostrar mensaje
				else if(!codigoPostalCampoTexto.getText().matches("\\d{5}")) 
				 JOptionPane.showMessageDialog(this, "Codigo Postal invalido");
				
		//si el formato de telefono es invalido, mostrar mensaje
				else if(!telefonoCampoTexto.getText().matches("[1-9]\\d{2}-[1-9]\\d{2}-\\d{4}"))  
				 JOptionPane.showMessageDialog(this, "Numero Telefonico invalido");
		
		else //la informacion es valida, avisar al usuario
			 JOptionPane.showMessageDialog(this, "¡GRACIAS!");
	}//FIN  del metodo validar fecha

}//fin de la clase ValidarFrame
