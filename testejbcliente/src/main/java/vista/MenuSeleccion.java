package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuSeleccion implements ActionListener{
	
	private VtnInicial ventanaInic;

	public MenuSeleccion(VtnInicial ventanaInicial) {
		this.ventanaInic = ventanaInicial;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.ventanaInic.getMenuItemList().get(0))){
            VtnIngresarUsuario vIngresarUsuario = new VtnIngresarUsuario();
            this.ventanaInic.getEscritorio().add(vIngresarUsuario);    
            vIngresarUsuario.setVisible(true);
        }
		
		if(e.getSource().equals(this.ventanaInic.getMenuItemList().get(2))){
			VtnLibro vLibro= new VtnLibro();
			vLibro.setVisible(true);
        }
		
		if(e.getSource().equals(this.ventanaInic.getMenuItemList().get(3))){
			VtnCategoria vCategoria= new VtnCategoria();
			vCategoria.setVisible(true);
        }
		
		if(e.getSource().equals(this.ventanaInic.getMenuItemList().get(4))){
			VtnAutor vAutor= new VtnAutor();
			vAutor.setVisible(true);
        }
		
	}
}
