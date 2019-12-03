package vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VtnInicial extends JFrame{
	
	private JMenuBar barraMenu;
    private List<JMenu> menuList;
    private List<JMenuItem> menuItemList;
    private JDesktopPane escritorio;
	    
    public VtnInicial(String titulo) {
        super(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(1240, 450);
        this.iniciaComponente();
        this.setVisible(true);
    }

    public void iniciaComponente() {
    	
        this.escritorio = new JDesktopPane();
        this.barraMenu = new JMenuBar();

        this.menuList = new ArrayList<JMenu>();
        this.menuList.add(new JMenu("Usuarios"));//0
        this.menuList.add(new JMenu("Libros"));//1
        this.menuList.add(new JMenu("Prestamos"));//2

        this.menuItemList = new ArrayList<JMenuItem>();
        this.menuItemList.add(new JMenuItem("Nuevo Usuario"));//0
        this.menuItemList.add(new JMenuItem("Actualizar Usuario"));//1
        this.menuItemList.add(new JMenuItem("Nuevo Libro"));//2
        this.menuItemList.add(new JMenuItem("Ingresar Categoria"));//3
        this.menuItemList.add(new JMenuItem("Ingresar Autor"));//4

        this.setContentPane(this.escritorio);
        this.setJMenuBar(barraMenu);
        for (int i = 0; i < this.menuList.size(); i++) {
            barraMenu.add(this.menuList.get(i));
        }
        this.menuList.get(0).add(this.menuItemList.get(0));
        this.menuList.get(0).add(this.menuItemList.get(1));
        this.menuList.get(1).add(this.menuItemList.get(2));
        this.menuList.get(1).add(this.menuItemList.get(3));
        this.menuList.get(1).add(this.menuItemList.get(4));
        
        for (int i = 0; i < this.menuItemList.size(); i++) {
        	this.menuItemList.get(i).addActionListener(new MenuSeleccion(this));
        }
    }
    
    public JMenuBar getBarraMenu() {
        return barraMenu;
    }
    public void setBarraMenu(JMenuBar barraMenu) {
        this.barraMenu = barraMenu;
    }
    public List<JMenu> getMenuList() {
        return menuList;
    }
    public void setMenuList(List<JMenu> menuList) {
        this.menuList = menuList;
    }
    public List<JMenuItem> getMenuItemList() {
        return menuItemList;
    }
    public void setMenuItemList(List<JMenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }
    public JDesktopPane getEscritorio() {
        return escritorio;
    }
    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }
}

