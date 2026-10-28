
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Income extends JFrame {

    JTextField amountField;
    JTextField sourceField;

    public Income() {

        setTitle("Income");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel title = new JLabel("ADD INCOME");

        JLabel amount = new JLabel("Amount:");
        JLabel source = new JLabel("Source:");

        amountField = new JTextField(20);
        sourceField = new JTextField(20);

        JButton addButton = new JButton("Add Income");

        add(title);
        add(amount);
        add(amountField);
        add(source);
        add(sourceField);
        add(addButton);

        addButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (amountField.getText().trim().isEmpty()
                        || sourceField.getText().trim().isEmpty()) {

                    JOptionPane.showMessageDialog(
                            Income.this,
                            "Please enter all details."
                    );

                } else {

                    try {
                        double amountValue = Double.parseDouble(
                                amountField.getText().trim()
                        );

                        if (amountValue <= 0) {
                            JOptionPane.showMessageDialog(
                                    Income.this,
                                    "Amount must be greater than zero."
                            );
                            return;
                        }

                        JOptionPane.showMessageDialog(
                                Income.this,
                                "Income added successfully!"
                        );

                        amountField.setText("");
                        sourceField.setText("");

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(
                                Income.this,
                                "Please enter a valid amount."
                        );
                    }
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Income();
    }
}
