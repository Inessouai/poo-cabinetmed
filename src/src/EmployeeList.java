import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EmployeeList extends JFrame {

    public EmployeeList(String nss, String date, String service, int i) {
        if (i == 1) {
            setTitle("Medecin list");
        } else {
            setTitle("Infermier list");
        }
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a scroll pane for the employee panels
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);

        // Create a panel for the employee panels
        JPanel employeePanel = new JPanel();
        employeePanel.setLayout(new BoxLayout(employeePanel, BoxLayout.Y_AXIS));

        // Dummy data for employees
        ArrayList<String[]> employees = new ArrayList<>();
        if (i == 1) {
            // Dummy data for doctors
            employees.add(new String[]{"1", "John", "Doe", "Médical", "Cardiology"});
            employees.add(new String[]{"2", "Jane", "Smith", "Médical", "Neurology"});
        } else {
            // Dummy data for nurses
            employees.add(new String[]{"3", "Alice", "Johnson", "Paramédical", "General Nursing"});
            employees.add(new String[]{"4", "Bob", "Brown", "Paramédical", "Pediatric Nursing"});
        }

        for (String[] employee : employees) {
            int id = Integer.parseInt(employee[0]);
            String nom = employee[1];
            String prenom = employee[2];
            String secteur = employee[3];
            String specialite = employee[4];

            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

            // Add a label with the employee name
            JLabel nameLabel = new JLabel(nom);
            panel.add(nameLabel);
            JLabel nameLabel4 = new JLabel(prenom);
            panel.add(nameLabel4);
            JLabel nameLabel2 = new JLabel(specialite);
            panel.add(nameLabel2);

            // Add an edit button
            JButton detailButton = new JButton("Choisire");
            panel.add(detailButton);
            detailButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Simulate choosing an employee
                    JOptionPane.showMessageDialog(null, "Employee chosen: " + nom + " " + prenom);
                    dispose();
                }
            });
            employeePanel.add(panel);
        }

        // Add the employee panel to the scroll pane
        scrollPane.setViewportView(employeePanel);

        // Add the scroll pane to the frame
        add(scrollPane);

        // Display the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        // Example usage
        new EmployeeList("123", "2023-10-01", "Cardiology", 1);
    }
}