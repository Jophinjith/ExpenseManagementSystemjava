import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Budget extends JFrame {

    JTextField amountField;

    public Budget() {

        setTitle("Budget");
        setSize(400, 250);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel title = new JLabel("SET BUDGET");
        JLabel label = new JLabel("Budget Amount:");

        amountField = new JTextField(20);

        JButton setButton = new JButton("Set Budget");

        add(title);
        add(label);
        add(amountField);
        add(setButton);

        setButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (amountField.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(
                        Budget.this,
                        "Please enter budget amount."
                    );

                } else {

                    JOptionPane.showMessageDialog(
                        Budget.this,
                        "Budget set successfully!"
                    );
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Budget();
    }
}   
