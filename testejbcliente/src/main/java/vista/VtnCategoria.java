package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.GestionCategoriaRemote;

public class VtnCategoria extends JFrame implements ActionListener {
	private JTextField txtnombre;
	private JTextField txtDescripcion;
	private JButton boton1;
	private GestionCategoriaRemote gc;

	public VtnCategoria() {
		super("PracticaBiblioteca");
		initialize();
	}

	private void initialize() {
		try {
			this.conectarInstancias();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSize(300, 300);
		getContentPane().setLayout(new GridLayout(1, 1));

		JLabel etiqueta1 = new JLabel("Nombre Categoria: ");
		JLabel etiqueta2 = new JLabel("Descripcion: ");
		txtnombre = new JTextField(20);
		txtDescripcion = new JTextField(20);
		boton1 = new JButton("Cargar");
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertarCategoria();
			}
		});
		boton1.setActionCommand("btnCargar");

		JButton boton2 = new JButton("Vaciar");
		boton2.addActionListener(this);
		boton2.setActionCommand("btnVaciar");

		JButton boton3 = new JButton("Terminar");
		boton3.addActionListener(this);
		boton3.setActionCommand("btnTerminar");

		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.setBorder(BorderFactory.createTitledBorder("Datos Categoria"));
		getContentPane().add(panel1);
		panel1.add(etiqueta1);
		panel1.add(txtnombre);
		panel1.add(etiqueta2);
		panel1.add(txtDescripcion);
		panel1.add(boton1, BorderLayout.SOUTH);
		panel1.add(boton2, BorderLayout.SOUTH);
		panel1.add(boton3, BorderLayout.SOUTH);
	}

	protected void insertarCategoria() {
		String nombre = txtnombre.getText();
		String descripcion = txtDescripcion.getText();
		gc.insertarCategoria(nombre, descripcion);
	}

	public void conectarInstancias() throws Exception {
		try {
			final Hashtable<String, Comparable> jndiProperties = new Hashtable<String, Comparable>();
			jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.wildfly.naming.client.WildFlyInitialContextFactory");
			jndiProperties.put("jboss.naming.client.ejb.context", true);

			jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8090");
			jndiProperties.put(Context.SECURITY_PRINCIPAL, "ejb");
			jndiProperties.put(Context.SECURITY_CREDENTIALS, "ejb");

			final Context context = new InitialContext(jndiProperties);

			final String lookupName = "ejb:/testejbserver/GestionCategoria!negocio.GestionCategoriaRemote";

			this.gc = (GestionCategoriaRemote) context.lookup(lookupName);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void actionPerformed(ActionEvent evt) {
		String comando = evt.getActionCommand();
		switch (comando) {
		case "btnTerminar":
			terminar();
			break;
		case "btnVaciar":
			vaciar();
			break;
		default:
			break;
		}
	}

	public void terminar() {
		int opcion = JOptionPane.showConfirmDialog(this, "Desea dar por terminado el programa ?", "Mensaje",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (opcion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		if (opcion == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(this, "Siga trabajando", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void vaciar() {
		txtnombre.setText("");
		txtDescripcion.setText("");
	}

	public JTextField getTxtnombre() {
		return txtnombre;
	}

	public void setTxtnombre(JTextField txtnombre) {
		this.txtnombre = txtnombre;
	}

	public JTextField getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(JTextField txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public JButton getBoton1() {
		return boton1;
	}

	public void setBoton1(JButton boton1) {
		this.boton1 = boton1;
	}

}
