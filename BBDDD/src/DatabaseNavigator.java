
import java.awt.Adjustable;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.WindowConstants;

public class DatabaseNavigator extends JFrame {
    // Componentes de la interfaz de usuario
    private JButton btnPrevious;
    private JButton btnNext;
    private JLabel lblId;
    private JLabel lblName;
    private JLabel lblCountryCode;
    private JLabel lblDistrict;
    private JLabel lblPopulation;
    private JPanel panelFields;
    private JPanel panelNavigation;
    private JScrollBar scrollBar;
    private int maxRowCount = 0; // Para almacenar el número total de filas
    private JLabel lblRecordPosition;

    // Conexión a la base de datos
    private Connection connection;
    private ResultSet resultSet;
    private Statement statement;

    public DatabaseNavigator() {
        initializeUI();
        initializeDBConnection();
        loadFirstRecord();
    }

    private void initializeUI() {
        setTitle("Database Navigator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null); // Centrar la ventana

        // Panel para los campos
        panelFields = new JPanel(new GridLayout(5, 2));
        lblId = new JLabel("ID: ");
        lblName = new JLabel("Name: ");
        lblCountryCode = new JLabel("CountryCode: ");
        lblDistrict = new JLabel("District: ");
        lblPopulation = new JLabel("Population: ");
        panelFields.add(lblId);
        panelFields.add(new JLabel()); // Espacio en blanco
        panelFields.add(lblName);
        panelFields.add(new JLabel());
        panelFields.add(lblCountryCode);
        panelFields.add(new JLabel());
        panelFields.add(lblDistrict);
        panelFields.add(new JLabel());
        panelFields.add(lblPopulation);
        lblRecordPosition = new JLabel("0/0");
        panelFields.add(lblRecordPosition); // O añadirlo a panelFields dependiendo de tu diseño
        getContentPane().add(panelFields, BorderLayout.CENTER);

        // Panel para la navegación
        panelNavigation = new JPanel();
        btnPrevious = new JButton("Previous");
        btnNext = new JButton("Next");
        panelNavigation.setLayout(new BorderLayout(0, 0));
        panelNavigation.add(btnPrevious, BorderLayout.WEST);
        panelNavigation.add(btnNext, BorderLayout.EAST);
        getContentPane().add(panelNavigation, BorderLayout.SOUTH);

        scrollBar = new JScrollBar(Adjustable.HORIZONTAL);
        panelNavigation.add(scrollBar, BorderLayout.SOUTH);

        btnPrevious.addActionListener(e -> navigateRecords(false)); // false para anterior
        btnNext.addActionListener(e -> navigateRecords(true)); // true para siguiente
    }

    private void initializeDBConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:7777/world", "root", "");
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery("SELECT * FROM city");
            resultSet.last();
            maxRowCount = resultSet.getRow(); // Obtener el número total de filas
            resultSet.first();
            scrollBar.setMinimum(0);
            scrollBar.setMaximum(maxRowCount - 1); // Ajustar el máximo al índice de la última fila
            updateLabels();
            scrollBar.addAdjustmentListener(new AdjustmentListener() {
                @Override
                public void adjustmentValueChanged(AdjustmentEvent e) {
                    try {
                        if (!e.getValueIsAdjusting()) { // Evita múltiples eventos mientras se arrastra el thumb
                            resultSet.absolute(e.getValue() + 1); // Mover a la fila especificada (+1 porque SQL empieza en 1)
                            updateLabels();
                            updateRecordPosition();
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error moving to selected record: " + ex.getMessage());
                    }
                }
            });
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error connecting to database: " + e.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
            System.exit(1); // Salir de la aplicación si no se puede establecer conexión
        }
    }

    private void loadFirstRecord() {
        try {
            if (resultSet.first()) {
                updateLabels();
                updateRecordPosition();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error reading first record: " + e.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void navigateRecords(boolean next) {
        try {
            if (next ? resultSet.next() : resultSet.previous()) {
                updateLabels();
                updateRecordPosition();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error navigating records: " + e.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateLabels() {
        try {
            lblId.setText("ID: " + resultSet.getString("ID"));
            lblName.setText("Name: " + resultSet.getString("Name"));
            lblCountryCode.setText("CountryCode: " + resultSet.getString("CountryCode"));
            lblDistrict.setText("District: " + resultSet.getString("District"));
            lblPopulation.setText("Population: " + resultSet.getString("Population"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error updating labels: " + e.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateRecordPosition() {
        try {
            int currentRow = resultSet.getRow(); // Obtener la fila actual
            lblRecordPosition.setText(currentRow + "/" + maxRowCount); // Actualizar el texto de la etiqueta
        } catch (SQLException e) {
            lblRecordPosition.setText("Error");
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                DatabaseNavigator frame = new DatabaseNavigator();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
