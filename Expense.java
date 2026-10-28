import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Expense extends JFrame {

    JTextField amountField;
    JTextField descriptionField;

    public Expense() {

        setTitle("Expense");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel title = new JLabel("ADD EXPENSE");

        JLabel amount = new JLabel("Amount:");
        JLabel description = new JLabel("Description:");

        amountField = new JTextField(20);
        descriptionField = new JTextField(20);

        JButton addButton = new JButton("Add Expense");

        add(title);
        add(amount);
        add(amountField);
        add(description);
        add(descriptionField);
        add(addButton);

        addButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String amountText = amountField.getText();
                String descriptionText = descriptionField.getText();

                if (amountText.isEmpty() || descriptionText.isEmpty()) {

                    JOptionPane.showMessageDialog(
                        Expense.this,
                        "Please enter all details."
                    );

                } else {

                    JOptionPane.showMessageDialog(
                        Expense.this,
                        "Expense added successfully!"
                    );
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Expense();
    }
}