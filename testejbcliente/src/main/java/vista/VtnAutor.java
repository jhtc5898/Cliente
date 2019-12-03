package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;

import negocio.ConexionBDRemote;
import negocio.GestionAutorRemote;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class VtnAutor extends JFrame{

	private JTextField textField;
	private JTextField textField_1;
	private JButton btnGuardar;
	private GestionAutorRemote ga;

	public VtnAutor() {
		initialize();
	}

	private void initialize() {
		try {
			this.conectarInstancias();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBounds(100, 100, 600, 200);	
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);

		JLabel lblNombre = new JLabel("Nombre:");
		panel.add(lblNombre);
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		panel.add(lblNacionalidad);
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertarAutor();
			}
		});
		panel.add(btnGuardar);
	}

	protected void insertarAutor() {
		String nombre = textField.getText();
		String nacionalidad = textField_1.getText();
		ga.insertarAutor(nombre, nacionalidad);
	}

	public void conectarInstancias() throws Exception {
		try {  
			final Hashtable<String, Comparable> jndiProperties = new Hashtable<String, Comparable>();  
			jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");  
			jndiProperties.put("jboss.naming.client.ejb.context", true);  

			jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8090");  
			jndiProperties.put(Context.SECURITY_PRINCIPAL, "ejb");  
			jndiProperties.put(Context.SECURITY_CREDENTIALS, "ejb");  

			final Context context = new InitialContext(jndiProperties);  

			final String lookupName = "ejb:/testejbserver/GestionAutor!negocio.GestionAutorRemote";

			this.ga = (GestionAutorRemote) context.lookup(lookupName);  

		} catch (Exception ex) {  
			ex.printStackTrace();  
			throw ex;  
		}  
	}
}
