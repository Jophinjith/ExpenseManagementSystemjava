import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
public class Category extends JFrame  {
    private final JFrame parent;
    JTextField categoryField;
    public Category()  {
        this(null);
    }
    public Category(JFrame parent)  {
        this.parent = parent;
        FinanceUI.setupFrame(this, "Categories | Finova", 720, 620);
        JPanel root = FinanceUI.page();
        root.add(FinanceUI.header("Stay organized", "Expense categories", "Create and manage labels used when recording expenses.", FinanceUI.PURPLE), BorderLayout.NORTH);
        JPanel form = FinanceUI.card(new BorderLayout(0, 18));
        JPanel entry = new JPanel(new BorderLayout(0, 9));
        entry.setOpaque(false);
        entry.add(FinanceUI.label("New category name"), BorderLayout.NORTH);
        categoryField = FinanceUI.field(22);
        categoryField.setToolTipText("Example: Pets, Travel, Subscriptions");
        entry.add(categoryField, BorderLayout.CENTER);
        form.add(entry, BorderLayout.NORTH);
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String s : Menu.categories) model.addElement(s);
        JList<String> list = new JList<>(model);
        FinanceUI.styleList(list);
        list.setFixedCellHeight(40);
        JScrollPane scroll = new JScrollPane(list);
        FinanceUI.styleScroll(scroll);
        scroll.setPreferredSize(new Dimension(520, 270));
        scroll.setBorder(new TitledBorder(new LineBorder(FinanceUI.BORDER), "YOUR CATEGORIES", TitledBorder.LEADING, TitledBorder.TOP,
        new Font("Segoe UI", Font.BOLD, 12), FinanceUI.MUTED));
        form.add(scroll, BorderLayout.CENTER);
        root.add(form, BorderLayout.CENTER);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttons.setOpaque(false);
        JButton cancel = FinanceUI.button("Cancel", FinanceUI.NAVY), add = FinanceUI.button("Add category", FinanceUI.TEAL);
        cancel.addActionListener(e -> returnToParent());
        add.addActionListener(e -> {
        String s = categoryField.getText().trim();
        if (s.isEmpty()) { JOptionPane.showMessageDialog(this, "Please enter a category name."); return; }
        boolean exists = Menu.categories.stream().anyMatch(existing -> existing.equalsIgnoreCase(s));
        if (exists) { JOptionPane.showMessageDialog(this, "That category already exists."); return; }
        Menu.categories.add(s); model.addElement(s); categoryField.setText("");
        JOptionPane.showMessageDialog(this, "Category added. It is now available in the expense category selector.", "Category added", JOptionPane.INFORMATION_MESSAGE);
        returnToParent();
        });
        buttons.add(cancel);
        buttons.add(add);
        root.add(buttons, BorderLayout.SOUTH);
        setContentPane(root);
        FinanceUI.show(this);
    }
    private void returnToParent()  {
        dispose();
        if (parent != null)  {
            parent.setVisible(true);
            parent.toFront();
        }
        else Menu.showDashboard();
    }
    public static void main(String[] args)  {
        SwingUtilities.invokeLater(Category::new);
    }
}
