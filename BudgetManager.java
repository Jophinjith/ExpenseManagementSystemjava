import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BudgetManager extends JFrame {

    public BudgetManager() {

        setTitle("Budget Manager");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel title = new JLabel("BUDGET MANAGER");

        JButton setBudget = new JButton("Set Budget");
        JButton viewBudget = new JButton("View Budget");

        add(title);
        add(setBudget);
        add(viewBudget);

        setBudget.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Budget();
            }
        });

        viewBudget.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(
                    BudgetManager.this,
                    "Budget details will be displayed here."
                );
            }
        });

        setVisible(true);
    }
}

