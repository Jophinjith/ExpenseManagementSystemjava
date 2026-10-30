import javax.swing.*;
import java.awt.*;
public class Expense extends JFrame  {
    JTextField amountField, descriptionField;
    private JComboBox<String> categoryBox;
    public Expense()  {
        FinanceUI.setupFrame(this, "Add expense | Finova", 560, 560);
        JPanel root = FinanceUI.page();
        root.add(FinanceUI.header("Money out", "Add expense", "Record a purchase and assign it to a category.", FinanceUI.RED), BorderLayout.NORTH);
        JPanel form = FinanceUI.card(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(8, 0, 8, 0);
        c.anchor = GridBagConstraints.WEST;
        c.gridy = 0;
        form.add(FinanceUI.label("Amount (₹)"), c);
        c.gridy++;
        amountField = FinanceUI.field(22);
        amountField.setToolTipText("Enter the amount in rupees");
        form.add(amountField, c);
        c.gridy++;
        form.add(FinanceUI.label("Category"), c);
        c.gridy++;
        categoryBox = FinanceUI.combo(Menu.categories.toArray(new String[0]));
        categoryBox.setToolTipText("Choose the category that best matches this expense");
        form.add(categoryBox, c);
        c.gridy++;
        form.add(FinanceUI.label("Expense description"), c);
        c.gridy++;
        descriptionField = FinanceUI.field(22);
        descriptionField.setToolTipText("For example, lunch, bus ticket or electricity bill");
        form.add(descriptionField, c);
        c.gridy++;
        JLabel hint = new JLabel("Choose a category to keep reports and spending organized.");
        hint.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        hint.setForeground(FinanceUI.MUTED);
        form.add(hint, c);
        root.add(form, BorderLayout.CENTER);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttons.setOpaque(false);
        JButton cancel = FinanceUI.button("Cancel", FinanceUI.NAVY), save = FinanceUI.button("Save expense", FinanceUI.RED);
        cancel.addActionListener(e -> dispose());
        save.addActionListener(e -> saveExpense());
        buttons.add(cancel);
        buttons.add(save);
        root.add(buttons, BorderLayout.SOUTH);
        setContentPane(root);
        FinanceUI.show(this);
    }
    private void saveExpense()  {
        String a = amountField.getText().trim(), d = descriptionField.getText().trim();
        String category = (String) categoryBox.getSelectedItem();
        if (a.isEmpty() || d.isEmpty())  {
            JOptionPane.showMessageDialog(this, "Please enter the amount and description.", "Missing details", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (category == null || category.trim().isEmpty())  {
            JOptionPane.showMessageDialog(this, "Please add or select an expense category.", "Category required", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try  {
            double v = Double.parseDouble(a);
            if (!Double.isFinite(v) || v <= 0)  {
                JOptionPane.showMessageDialog(this, "Amount must be greater than zero.");
                return;
            }
            Menu.totalExpense += v;
            Menu.transactions.add("Expense | " + category + " | " + d + " | " + Menu.money(v));
            JOptionPane.showMessageDialog(this, "Expense saved successfully!\nCategory: " + category, "Saved", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            Menu.showDashboard();
        } catch (NumberFormatException ex)  {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount.", "Invalid amount", JOptionPane.WARNING_MESSAGE);
        }
    }
    public static void main(String[] args)  {
        SwingUtilities.invokeLater(Expense::new);
    }
}
