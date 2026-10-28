import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame {

    public Menu() {

        setTitle("Expense Management System");
        setSize(500, 450);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("EXPENSE MANAGEMENT SYSTEM");

        JButton userButton = new JButton("User");
        JButton categoryButton = new JButton("Category");
        JButton incomeButton = new JButton("Income");
        JButton expenseButton = new JButton("Expense");
        JButton transactionButton = new JButton("Transaction");
        JButton budgetButton = new JButton("Budget");
        JButton reportButton = new JButton("Report");

        add(title);
        add(userButton);
        add(categoryButton);
        add(incomeButton);
        add(expenseButton);
        add(transactionButton);
        add(budgetButton);
        add(reportButton);

        userButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new User();
            }
        });

        categoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Category();
            }
        });

        incomeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Income();
            }
        });

        expenseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Expense();
            }
        });

        transactionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Transaction();
            }
        });

        budgetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BudgetManager();
            }
        });

        reportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Report();
            }
        });

        setVisible(true);
    }

    // Main method must be INSIDE the Menu class
    public static void main(String[] args) {
        new Menu();
    }
}
