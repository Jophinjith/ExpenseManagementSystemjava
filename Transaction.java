import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Transaction extends JFrame {
   JTextField transactionField;

   public Transaction() {
      this.setTitle("Transaction");
      this.setSize(400, 250);
      this.setLayout(new FlowLayout());
      this.setDefaultCloseOperation(2);
      JLabel var1 = new JLabel("TRANSACTION");
      JLabel var2 = new JLabel("Transaction:");
      this.transactionField = new JTextField(20);
      JButton var3 = new JButton("Save");
      this.add(var1);
      this.add(var2);
      this.add(this.transactionField);
      this.add(var3);
      var3.addActionListener(new ActionListener() {
         {
            Objects.requireNonNull(Transaction.this);
         }

         public void actionPerformed(ActionEvent var1) {
            if (Transaction.this.transactionField.getText().isEmpty()) {
               JOptionPane.showMessageDialog(Transaction.this, "Please enter transaction details.");
            } else {
               JOptionPane.showMessageDialog(Transaction.this, "Transaction saved!");
            }

         }
      });
      this.setVisible(true);
   }

   public static void main(String[] var0) {
      new Transaction();
   }
}
