package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class holamundo {
	boolean message = true;
	private JFrame frmBuenas;
	private JTextField txtNombre;
	private final ButtonGroup grpSexo = new ButtonGroup();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JPasswordField passwordField;
	private JLabel lblContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					holamundo window = new holamundo();
					window.frmBuenas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public holamundo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuenas = new JFrame();
		frmBuenas.getContentPane().setBackground(new Color(255, 128, 64));
		frmBuenas.setBackground(new Color(255, 128, 64));
		frmBuenas.setIconImage(Toolkit.getDefaultToolkit().getImage(holamundo.class.getResource("/META-INF/resources/webjars/fugue-icons/3.5.6/icons/android.png")));
		frmBuenas.setTitle("Hola Mundo V1.0");
		frmBuenas.setBounds(100, 100, 1108, 738);
		frmBuenas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//CHECKBOX
		JCheckBox esMayorDeEdad = new JCheckBox("Mayor de Eddad");
		
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBackground(new Color(0, 0, 255));
		JLabel lblHolal = new JLabel("");
		lblHolal.setIcon(new ImageIcon(holamundo.class.getResource("/META-INF/resources/webjars/fugue-icons/3.5.6/bonus/animated/icons/application-terminal.gif")));
		btnOk.setBounds(474, 526, 113, 59);
		frmBuenas.getRootPane().setDefaultButton(btnOk);
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Se ha presionado el botón principal.");
				frmBuenas.setTitle("Hola Mundo!");
				if (message) {
					lblHolal.setText("Hola Mundo");
					message = false;
				}
				else {
					lblHolal.setText("");
					message = true;

				}
			}
		});
		
		
		frmBuenas.getContentPane().setLayout(null);
		frmBuenas.getContentPane().add(btnOk);
		
		lblHolal.setHorizontalAlignment(SwingConstants.CENTER);
		lblHolal.setFont(new Font("Calibri", Font.PLAIN, 10));
		lblHolal.setBounds(182, 319, 696, 46);
		frmBuenas.getContentPane().add(lblHolal);
		
		JToggleButton tglbtnWillSmith = new JToggleButton("WillSmith text");
		tglbtnWillSmith.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnWillSmith.isSelected()) {
					lblHolal.setFont(lblHolal.getFont().deriveFont(Font.BOLD));
					System.out.println("Debo ponerlo en negrita");
				}
				else
					lblHolal.setFont(lblHolal.getFont().deriveFont(Font.PLAIN));
			}
		});
		
		JList list = new JList();
		
		txtNombre = new JTextField();
		txtNombre.setText("Dime tu nombre: ");
		txtNombre.setBounds(265, 65, 404, 20);
		frmBuenas.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(197, 68, 46, 14);
		frmBuenas.getContentPane().add(lblNewLabel);
		
		lblContraseña = new JLabel("Contraseña");
		passwordField = new JPasswordField();
		
		JTextArea txtrHolaKeAse = new JTextArea();
		
		JComboBox cbNacionalidad = new JComboBox();
		JButton btnNombre = new JButton("Enviar");
		btnNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre = txtNombre.getText();
				boolean negrita = tglbtnWillSmith.isSelected();
				String sexo = grpSexo.getSelection().getActionCommand();
				String aficion = list.getSelectedValue().toString();
				
				String aficiones = null;
				String eleccion = (String) cbNacionalidad.getSelectedItem();
				for (Object name : list.getSelectedValuesList()) {
					aficiones += String.valueOf(name)+", ";
					System.out.println(aficiones);
				}
				if (!nombre.equals("")) {
					String text = "Hola "+ nombre + ((esMayorDeEdad.isSelected()) ? " es": "") + " mayor de edad y " + sexo + " Contraseña: "+ passwordField.getText() + "\n" + aficiones +" "+ eleccion;
					txtrHolaKeAse.append(text);
			
					
				} else {
					lblHolal.setText("Tienes que escribir tu nombre");
				}
				
			}
		});
		btnNombre.setBounds(746, 64, 89, 23);
		frmBuenas.getContentPane().add(btnNombre);
		
		esMayorDeEdad.setBounds(259, 146, 97, 23);
		frmBuenas.getContentPane().add(esMayorDeEdad);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Grupos de Sexo", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(128, 0, 128)));
		panel.setBounds(249, 191, 121, 94);
		frmBuenas.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton rbtnMujer = new JRadioButton("FÉMINA");
		rbtnMujer.setBounds(6, 16, 109, 23);
		panel.add(rbtnMujer);
		rbtnMujer.setActionCommand("Mujer");
		grpSexo.add(rbtnMujer);
		JRadioButton rdbtnHombre = new JRadioButton("MACHO");
		rdbtnHombre.setBounds(6, 42, 109, 23);
		panel.add(rdbtnHombre);
		grpSexo.add(rdbtnHombre);
		rdbtnHombre.setActionCommand("Hombre");
		rdbtnHombre.setActionCommand("Otro");
		
		
		rdbtnHombre.setToolTipText("MACHO");
		
		JRadioButton rdbtnOtro = new JRadioButton("EPAIDERMAN");
		rdbtnOtro.setBounds(6, 65, 109, 23);
		panel.add(rdbtnOtro);
		grpSexo.add(rdbtnOtro);
		

		tglbtnWillSmith.setBounds(466, 214, 121, 23);
		frmBuenas.getContentPane().add(tglbtnWillSmith);
		
	
		passwordField.setBounds(265, 109, 404, 20);
		frmBuenas.getContentPane().add(passwordField);
		
		
		lblContraseña.setBounds(177, 112, 66, 14);
		frmBuenas.getContentPane().add(lblContraseña);
		
		
		list.setBackground(new Color(255, 128, 255));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"menganit", "juanit", "pepit"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectedIndex(2);
		list.setBounds(664, 190, 89, 71);
		frmBuenas.getContentPane().add(list);
		
	
		cbNacionalidad.setEditable(true);
		cbNacionalidad.setMaximumRowCount(4);
		cbNacionalidad.setModel(new DefaultComboBoxModel(new String[] {"Tigrense", "Antequerano", "Andorrano", "Egipcieño", "gilipollas", "Imbecil"}));
		cbNacionalidad.setBounds(820, 187, 81, 22);
		frmBuenas.getContentPane().add(cbNacionalidad);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(182, 394, 696, 101);
		frmBuenas.getContentPane().add(scrollPane);
		
		
		scrollPane.setViewportView(txtrHolaKeAse);
	}
}
