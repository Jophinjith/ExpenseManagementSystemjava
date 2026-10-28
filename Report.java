
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Report extends JFrame {

    public Report() {

        setTitle("Report");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel title = new JLabel("EXPENSE REPORT");

        JButton summaryButton = new JButton("View Summary");

        add(title);
        add(summaryButton);

        summaryButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(
                    Report.this,
                    "Income : ₹0\n"
                    + "Expense : ₹0\n"
                    + "Balance : ₹0"
                );
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Report();
    }
}