import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class BaseDatosMundo {

	private JFrame frmBaseDeDatos;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					BaseDatosMundo window = new BaseDatosMundo();
					window.frmBaseDeDatos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BaseDatosMundo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBaseDeDatos = new JFrame();

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Pa\u00EDses", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 55, 723, 177);
		frmBaseDeDatos.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ciudades", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(14, 258, 719, 209);
		frmBaseDeDatos.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 16, 707, 186);
		panel_1.add(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 711, 155);
		panel.add(scrollPane);

		table = new JTable();

		scrollPane.setViewportView(table);

		DefaultTableModel modelo=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Code", "Name", "Continent", "Region", "SurfaceArea", "IndepYear", "Population", "LifeExpectancy", "GNP", "Capital"
				}
			);

		DefaultTableModel modelo1=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Name", "CountryCode", "District", "Population"
				}
			);
		table.setModel(modelo);
		table_1.setModel(modelo1);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = table.rowAtPoint(e.getPoint());
		        int columna = table.columnAtPoint(e.getPoint());
		        Object valor = table.getValueAt(fila, columna);

		        System.out.println(valor.toString());
		        try {
					Class.forName("com.mysql.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "");
		            Statement stmt = con.createStatement();
		            ResultSet rs = stmt.executeQuery("SELECT code FROM country where name='"+valor.toString()+"'");
		            rs.next();
		            String codigoPais=rs.getString("code");
		            rs = stmt.executeQuery("SELECT * FROM city where countrycode='"+codigoPais+"'");
		            modelo1.getDataVector().removeAllElements();
		            while (rs.next()) {
		            	System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getString("countrycode")+" "+rs.getString("district")+" "+rs.getInt("population"));
		            	modelo1.addRow(new Object[] {
		            			rs.getInt("id"),
		            			rs.getString("name"),
		            			rs.getString("countrycode"),
		            			rs.getString("district"),
		            			rs.getInt("population"),
		            	});
		            }
		            table_1.repaint();

		            rs.close();
		            stmt.close();
		            con.close();
		        } catch (SQLException | ClassNotFoundException ex) {
		            ex.printStackTrace();
		        }
			}
		});

		JComboBox comboBox = new JComboBox();
		frmBaseDeDatos.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "");
		            Statement stmt = con.createStatement();
		            ResultSet rs = stmt.executeQuery("SELECT name FROM country");

		            while (rs.next()) {
		            	//System.out.println(rs.getString("name"));
		                comboBox.addItem(rs.getString("name"));
		            }

		            rs.close();
		            stmt.close();
		            con.close();
		        } catch (SQLException | ClassNotFoundException ex) {
		            ex.printStackTrace();
		        }
			}
		});

		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "");
		            Statement stmt = con.createStatement();
		            ResultSet rs = stmt.executeQuery("SELECT code,name,continent,region,surfacearea,indepyear,population,lifeexpectancy,gnp,capital FROM country where name='"+comboBox.getSelectedItem().toString()+"'");
		            while (rs.next()) {
		            	System.out.println(rs.getString("code")+" "+rs.getString("name")+" "+rs.getString("continent")+" "+rs.getString("region")+" "+rs.getFloat("surfacearea")+" "+rs.getInt("indepyear")+" "+rs.getInt("population")+" "+rs.getFloat("lifeexpectancy")+" "+rs.getFloat("gnp")+" "+rs.getInt("capital"));
		                //comboBox.addItem(rs.getString("name"));
		            	modelo.addRow(new Object[] {
		            			rs.getString("code"),
		            			rs.getString("name"),
		            			rs.getString("continent"),
		            			rs.getString("region"),
		            			rs.getFloat("surfacearea"),
		            			rs.getInt("indepyear"),
		            			rs.getInt("population"),
		            			rs.getFloat("lifeexpectancy"),
		            			rs.getFloat("gnp"),
		            			rs.getInt("capital")
		            	});
		            }
		            table.repaint();
		            rs.close();
		            stmt.close();
		            con.close();
		        } catch (SQLException | ClassNotFoundException ex) {
		            ex.printStackTrace();
		        }
			}
		});
		comboBox.setBounds(384, 21, 170, 22);
		frmBaseDeDatos.getContentPane().add(comboBox);
		frmBaseDeDatos.setTitle("Base de Datos Mundo");
		frmBaseDeDatos.setBounds(100, 100, 779, 525);
		frmBaseDeDatos.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frmBaseDeDatos.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Selecciona un pa\u00EDs:");
		lblNewLabel.setBounds(100, 25, 205, 14);
		frmBaseDeDatos.getContentPane().add(lblNewLabel);





	}
}
