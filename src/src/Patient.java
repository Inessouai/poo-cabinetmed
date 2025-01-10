import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class Patient extends JFrame {
   public static String code_Pat;
   private JLabel jLabel1;
   private JScrollPane jScrollPane5;
   private JTable reservation_Table;

   public Patient() {
      this.initComponents();
      Toolkit toolkit = this.getToolkit();
      Dimension size = toolkit.getScreenSize();
      this.setLocation(size.width / 2 - this.getWidth() / 2, size.height / 2 - this.getHeight() / 2);
      this.update_Table_Reservation();
   }

   private void update_Table_Reservation() {
      // Hardcoded data for reservations
      Object[][] data = {
         {1, "123456789", "2023-10-01", "10:00", "Consultation", "Cardiology", 1, "Routine checkup"},
         {2, "987654321", "2023-10-02", "11:00", "Surgery", "Orthopedics", 0, "Knee surgery"},
         {3, "456789123", "2023-10-03", "12:00", "Consultation", "Neurology", 1, "Headache evaluation"}
      };

      String[] columnNames = {"num_res", "NSS", "Date", "Heure", "Type", "Service", "Etat", "Observation"};

      DefaultTableModel model = new DefaultTableModel(data, columnNames);
      reservation_Table.setModel(model);
   }

   private void initComponents() {
      this.jScrollPane5 = new JScrollPane();
      this.reservation_Table = new JTable();
      this.jLabel1 = new JLabel();
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.reservation_Table.setModel(new DefaultTableModel(
         new Object[][]{}, 
         new String[]{"num_res", "NSS", "Date", "Heure", "Type", "Service", "Etat", "Observation"}
      ));
      this.jScrollPane5.setViewportView(this.reservation_Table);
      this.jLabel1.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
      this.jLabel1.setText("Votre réservation :");

      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
               .addGap(152, 152, 152)
               .addComponent(this.jLabel1)
               .addContainerGap(621, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
               .addGap(151, 151, 151)
               .addComponent(this.jScrollPane5, GroupLayout.PREFERRED_SIZE, 617, GroupLayout.PREFERRED_SIZE)
               .addContainerGap(151, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(this.jLabel1)
               .addContainerGap(503, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
               .addGap(47, 47, 47)
               .addComponent(this.jScrollPane5, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE)
               .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      this.pack();
   }

   public static void main(String[] args) {
      try {
         for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
         Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, e);
      }

      EventQueue.invokeLater(() -> {
         new Patient().setVisible(true);
      });
   }
}