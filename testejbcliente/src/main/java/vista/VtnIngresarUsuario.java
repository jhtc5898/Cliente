package vista;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import negocio.GestionUsuarioRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.awt.event.ActionEvent;

public class VtnIngresarUsuario extends JInternalFrame {

	private JTextField txtNomb;
	private JTextField txtTelf;
	private JTextField txtDir;
	private JTextField txtCed;
	private JButton btnRegistrar;
	private GestionUsuarioRemote gu;

	public VtnIngresarUsuario() {
		super("PracticaBiblioteca");
		initialize();
	}

	public void initialize() {
		try {
			this.conectarInstancias();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTitle("Ingresar Nuevo Usuario");
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 580, 350);
		getContentPane().setLayout(null);
		
		JLabel lblNombresYApellidos = new JLabel("Nombres y Apellidos");
		lblNombresYApellidos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNombresYApellidos.setBounds(20, 98, 154, 30);
		getContentPane().add(lblNombresYApellidos);
		
		JLabel lblIngresarNuevoUsuario = new JLabel("Registrar Nuevo Usuario");
		lblIngresarNuevoUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblIngresarNuevoUsuario.setBounds(177, 13, 227, 22);
		getContentPane().add(lblIngresarNuevoUsuario);
		
		txtNomb = new JTextField();
		txtNomb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNomb.setBounds(180, 99, 268, 30);
		getContentPane().add(txtNomb);
		txtNomb.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tel\u00E9fono");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(20, 146, 72, 16);
		getContentPane().add(lblNewLabel);
		
		txtTelf = new JTextField();
		txtTelf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTelf.setBounds(180, 139, 147, 30);
		getContentPane().add(txtTelf);
		txtTelf.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Direcci\u00F3n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(20, 184, 72, 16);
		getContentPane().add(lblNewLabel_1);
		
		txtDir = new JTextField();
		txtDir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDir.setBounds(180, 178, 268, 30);
		getContentPane().add(txtDir);
		txtDir.setColumns(10);
		
		JLabel lblCedula = new JLabel("C\u00E9dula");
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCedula.setBounds(20, 63, 56, 16);
		getContentPane().add(lblCedula);
		
		txtCed = new JTextField();
		txtCed.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCed.setBounds(180, 57, 147, 30);
		getContentPane().add(txtCed);
		txtCed.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertarUsuario();
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegistrar.setBounds(210, 239, 130, 35);
		getContentPane().add(btnRegistrar);
	}
	
	protected void insertarUsuario() {
		String cedula = txtCed.getText();
		String nombre = txtNomb.getText();
		String telefono = txtTelf.getText();
		String direccion = txtDir.getText();
		gu.insertarUsuario(cedula, nombre, telefono, direccion);
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

			final String lookupName = "ejb:/testejbserver/GestionUsuario!negocio.GestionUsuarioRemote";

			this.gu = (GestionUsuarioRemote) context.lookup(lookupName);  

		} catch (Exception ex) {  
			ex.printStackTrace();  
			throw ex;  
		}  
	}
	
	public JTextField getTxtNomb() {
		return txtNomb;
	}

	public void setTxtNomb(JTextField txtNomb) {
		this.txtNomb = txtNomb;
	}

	public JTextField getTxtTelf() {
		return txtTelf;
	}

	public void setTxtTelf(JTextField txtTelf) {
		this.txtTelf = txtTelf;
	}

	public JTextField getTxtDir() {
		return txtDir;
	}

	public void setTxtDir(JTextField txtDir) {
		this.txtDir = txtDir;
	}

	public JTextField getTxtCed() {
		return txtCed;
	}

	public void setTxtCed(JTextField txtCed) {
		this.txtCed = txtCed;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}
}
