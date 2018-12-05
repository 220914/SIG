package ventanas;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static String usuario, contrase�a;
	public static JDesktopPane dpEscritorio;
	public static JMenu mnPrincipal;
	 


	@SuppressWarnings("deprecation")
	public Principal() {
		
		
		setTitle("Soluciones Industriales");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagenes/sig.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1200, 750);
		
	

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		//A�ADIR
		mnPrincipal = new JMenu("");
		mnPrincipal.setHorizontalTextPosition(SwingConstants.CENTER);
		mnPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		mnPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnPrincipal.setBackground(Color.WHITE);
		mnPrincipal.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "A�adir", TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM, null, new Color(0, 0, 0)));
		mnPrincipal.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/a\u00F1adir.png")));
		menuBar.add(mnPrincipal);
		//CLIENTE
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mntmCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/user.png")));
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				cliente RI=new cliente();
				Principal.dpEscritorio.add(RI);
				RI.show();
			}
			
		});
		mntmCliente.setFont(new Font("Arial", Font.BOLD, 14));
		mntmCliente.setBackground(Color.WHITE);
		mntmCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mnPrincipal.add(mntmCliente);
		//PROVEEDOR
		JMenuItem mntmProveedor = new JMenuItem("Proveedor");
		mntmProveedor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mntmProveedor.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/proveedor.png")));
		mntmProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				proveedor PR=new proveedor();
				Principal.dpEscritorio.add(PR);
				PR.show();
			}

		});
		mntmProveedor.setFont(new Font("Arial", Font.BOLD, 14));
		mntmProveedor.setBackground(Color.WHITE);
		mntmProveedor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mnPrincipal.add(mntmProveedor);
		
		JMenuItem mntmDineroExtra = new JMenuItem("Dinero extra");
		mntmDineroExtra.setBackground(Color.WHITE);
		mntmDineroExtra.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		mntmDineroExtra.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/dinero.png")));
		mntmDineroExtra.setFont(new Font("Arial", Font.BOLD, 14));
		mntmDineroExtra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dineroextra pr=new Dineroextra();
				Principal.dpEscritorio.add(pr);
				pr.show();
			}
		});
		mnPrincipal.add(mntmDineroExtra);
		
		
		JMenuItem mntmRetiro = new JMenuItem("Retiro");
		mntmRetiro.setBackground(Color.WHITE);
		mntmRetiro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		mntmRetiro.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/1.png")));
		mntmRetiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				retiro r=new retiro();
				Principal.dpEscritorio.add(r);
				r.show();
			}
		});
		mntmRetiro.setFont(new Font("Arial", Font.BOLD, 14));
		mnPrincipal.add(mntmRetiro);
	

		JMenu mnConsultar = new JMenu("  ");
		mnConsultar.setHorizontalTextPosition(SwingConstants.CENTER);
		mnConsultar.setHorizontalAlignment(SwingConstants.CENTER);
		mnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnConsultar.setFont(new Font("Arial", Font.BOLD, 14));
		mnConsultar.setBackground(Color.WHITE);
		mnConsultar.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/search.png")));
		mnConsultar.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Consultas", TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM, null, new Color(0, 0, 0)));
		menuBar.add(mnConsultar);

		JMenuItem mntmProveedores = new JMenuItem("Proveedor");
		mntmProveedores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mntmProveedores.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/proveedor.png")));
		mntmProveedores.setFont(new Font("Arial", Font.BOLD, 14));
		mntmProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Consultas Pr= new Consultas();
				Principal.dpEscritorio.add(Pr);
				Pr.show();
				Consultas.nomTabla="proveedor";
			conexiones.ConsultarBD.consultaTotal("proveedor");				
			}
		});
		
		JMenuItem mntmClientes = new JMenuItem("Cliente");

		mntmClientes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mntmClientes.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/user.png")));
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Consultas Cl= new Consultas();
				Principal.dpEscritorio.add(Cl);
				Cl.show();
				Consultas.nomTabla="cliente";
				conexiones.ConsultarBD.consultaTotal("cliente");
				
				
			}
		});
		mntmClientes.setFont(new Font("Arial", Font.BOLD, 14));
		mnConsultar.add(mntmClientes);
		
		mnConsultar.add(mntmProveedores);
		
		
		JMenuItem mntmDineroExtra_1 = new JMenuItem("Dinero extra");
		mntmDineroExtra_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mntmDineroExtra_1.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/dinero.png")));
		mntmDineroExtra_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Consultas DE=new Consultas();
				Principal.dpEscritorio.add(DE);
				DE.show();
				Consultas.nomTabla="Dineroextra";
				conexiones.ConsultarBD.consultaTotal("Dineroextra");
				
			}
		});
		mntmDineroExtra_1.setFont(new Font("Arial", Font.BOLD, 14));
		mnConsultar.add(mntmDineroExtra_1);
		
		JMenuItem mntmRetiro_1 = new JMenuItem("Retiro");
		mntmRetiro_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
		mntmRetiro_1.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/1.png")));
		mntmRetiro_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Consultas E=new Consultas();
				Principal.dpEscritorio.add(E);
				E.show();
				Consultas.nomTabla="retiro";
				conexiones.ConsultarBD.consultaTotal("retiro");
			}
		});
		mntmRetiro_1.setFont(new Font("Arial", Font.BOLD, 14));
		mnConsultar.add(mntmRetiro_1);
		
		JMenu menu = new JMenu("");
		menu.setHorizontalTextPosition(SwingConstants.CENTER);
		menu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menu.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/opciones.png")));
		menu.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Opciones", TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM, null, new Color(0, 0, 0)));
		menu.setBackground(Color.WHITE);
		menuBar.add(menu);
		//CERRAR SESION
		JMenuItem mntmSerrarSecion = new JMenuItem("Cerrar sesi\u00F3n");
		mntmSerrarSecion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.ALT_MASK));
		mntmSerrarSecion.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/logout.png")));
		mntmSerrarSecion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal.super.dispose();
				Login frame = new Login();
				frame.setVisible(true);
			}
		});
		mntmSerrarSecion.setFont(new Font("Arial", Font.BOLD, 14));
		mntmSerrarSecion.setBackground(Color.WHITE);
		menu.add(mntmSerrarSecion);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mntmSalir.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/tacha.png")));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmSalir.setFont(new Font("Arial", Font.BOLD, 14));
		mntmSalir.setBackground(Color.WHITE);
		menu.add(mntmSalir);
		
		//INFORMACION
		JMenu menu_1 = new JMenu("   ");
		menu_1.setHorizontalTextPosition(SwingConstants.CENTER);
		menu_1.setHorizontalAlignment(SwingConstants.CENTER);
		menu_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menu_1.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/info.png")));
		menu_1.setFont(new Font("Arial", Font.BOLD, 14));
		menu_1.setBorder(new TitledBorder(UIManager.getBorder("Acerca de"), "Informaci\u00F3n", TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM, null, new Color(0, 0, 0)));
		menu_1.setBackground(Color.WHITE);
		menuBar.add(menu_1);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, InputEvent.CTRL_MASK));
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, 
						"Punto de control para soluciones industriales\n"
								+ "Version: KAVAJA 5.0\n"
								+ "Tecnolog�a JAVA\n"
								+ "BINARITEC\n"
								+ "La venta de este producto sin autorizacion de\n"
								+ "BINARITEC es un incumplimiento de la ley\n"
								+ " y podra ser acreedor a una multa federal\n"
								+ "Este producto esta desarrollado en IDE Eclipse\n"
								+ "Todos los derechos reservados");
			}
		});
		mntmAcercaDe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmAcercaDe.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/acercade.png")));
		mntmAcercaDe.setFont(new Font("Arial", Font.BOLD, 14));
		mntmAcercaDe.setBackground(Color.WHITE);
		menu_1.add(mntmAcercaDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		dpEscritorio = new JDesktopPane();
		dpEscritorio.setBackground(Color.WHITE);
		contentPane.add(dpEscritorio, BorderLayout.CENTER);
	}
}