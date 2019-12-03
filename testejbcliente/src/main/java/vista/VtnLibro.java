package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

import negocio.GestionLibroRemote;

import modelo.Autor;
import modelo.Categoria;

public class VtnLibro extends JFrame {

	private JPanel contentPane;
	private JTextField txtisbn;
	private JTextField txttitulo;
	private JTextField txtnumeroPaginas;
	private JTextField txtidioma;
	private JTextField txtdescripcion;
	private JTextField txtfecha;
	private JTextField txtautor;
	private JTextField txtcategoria;
	private GestionLibroRemote gl;

	public VtnLibro() {
		super("Ingresar libro");
		initialize();
	}

	protected void initialize() {
		try {
			this.conectarInstancias();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBounds(100, 100, 519, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(12, 22, 56, 16);
		contentPane.add(lblIsbn);

		txtisbn = new JTextField();
		txtisbn.setBounds(67, 22, 116, 22);
		contentPane.add(txtisbn);
		txtisbn.setColumns(10);

		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(12, 52, 56, 16);
		contentPane.add(lblTitulo);

		JLabel lblAo = new JLabel("A\u00F1o");
		lblAo.setBounds(12, 110, 56, 16);
		contentPane.add(lblAo);

		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(222, 22, 84, 16);
		contentPane.add(lblDescripcion);

		JLabel lblNumeroPaginas = new JLabel("Numero Paginas");
		lblNumeroPaginas.setBounds(222, 52, 116, 16);
		contentPane.add(lblNumeroPaginas);

		JLabel lblIdioma = new JLabel("Idioma");
		lblIdioma.setBounds(222, 81, 56, 16);
		contentPane.add(lblIdioma);

		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(12, 142, 56, 16);
		contentPane.add(lblAutor);

		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(222, 142, 56, 16);
		contentPane.add(lblCategoria);

		txttitulo = new JTextField();
		txttitulo.setBounds(67, 52, 116, 22);
		contentPane.add(txttitulo);
		txttitulo.setColumns(10);

		txtnumeroPaginas = new JTextField();
		txtnumeroPaginas.setBounds(329, 49, 84, 22);
		contentPane.add(txtnumeroPaginas);
		txtnumeroPaginas.setColumns(10);

		txtidioma = new JTextField();
		txtidioma.setBounds(329, 81, 116, 22);
		contentPane.add(txtidioma);
		txtidioma.setColumns(10);
		
		txtdescripcion = new JTextField();
		txtdescripcion.setBounds(329, 19, 116, 22);
		contentPane.add(txtdescripcion);
		txtdescripcion.setColumns(10);

		txtfecha = new JTextField();
		txtfecha.setBounds(67, 110, 51, 22);
		contentPane.add(txtfecha);
		txtfecha.setColumns(10);
		
		txtautor = new JTextField();
		txtautor.setBounds(67, 142, 116, 22);
		contentPane.add(txtautor);
		txtautor.setColumns(10);

		txtcategoria = new JTextField();
		txtcategoria.setBounds(329, 142, 116, 22);
		contentPane.add(txtcategoria);
		txtcategoria.setColumns(10);


		Button btnguardar = new Button("Guardar");
		btnguardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertarLibro();
			}
		});
		btnguardar.setBounds(199, 210, 79, 24);
		contentPane.add(btnguardar);
	}

	private void insertarLibro() {
		String isbn = txtisbn.getText();
		String titulo = txttitulo.getText();
		String anio = txtfecha.getText();
		String descripcion = txtdescripcion.getText();
		int numPags = Integer.parseInt(txtnumeroPaginas.getText());
		String idioma = txtidioma.getText();
		String categoria = txtcategoria.getText();
		String autor = txtautor.getText();
		try {
			gl.insertarLibro(isbn, titulo, anio, descripcion, numPags, idioma, categoria, autor);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

			final String lookupName = "ejb:/testejbserver/GestionLibro!negocio.GestionLibroRemote";

			this.gl = (GestionLibroRemote) context.lookup(lookupName);  

		} catch (Exception ex) {  
			ex.printStackTrace();  
			throw ex;  
		}  
	}
}
