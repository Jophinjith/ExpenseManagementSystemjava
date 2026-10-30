import javax.swing.*;
import java.awt.*;
public class Budget extends JFrame  {
    private final JFrame parent;
    JTextField amountField;
    public Budget() {
        this(null);
    }
    public Budget(JFrame parent) {
        this.parent=parent;
        FinanceUI.setupFrame(this,"Set budget | Finova",520,400);
        JPanel root=FinanceUI.page();
        root.add(FinanceUI.header("Plan ahead","Set your budget","Choose a spending limit that helps you stay on track.",FinanceUI.ORANGE),BorderLayout.NORTH);
        JPanel form=FinanceUI.card(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        c.gridx=0;
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(8,0,8,0);
        c.anchor=GridBagConstraints.WEST;
        c.gridy=0;
        form.add(FinanceUI.label("Budget amount (₹)"),c);
        c.gridy++;
        amountField=FinanceUI.field(22);
        amountField.setText(Menu.budgetAmount>0?String.valueOf(Menu.budgetAmount):"");
        form.add(amountField,c);
        c.gridy++;
        JLabel current=new JLabel("Current budget: "+Menu.money(Menu.budgetAmount));
        current.setForeground(FinanceUI.MUTED);
        form.add(current,c);
        root.add(form,BorderLayout.CENTER);
        JPanel buttons=new JPanel(new FlowLayout(FlowLayout.RIGHT,10,0));
        buttons.setOpaque(false);
        JButton cancel=FinanceUI.button("Cancel",FinanceUI.NAVY),save=FinanceUI.button("Save budget",FinanceUI.ORANGE);
        cancel.addActionListener(e->dispose());
        save.addActionListener(e->save());
        buttons.add(cancel);
        buttons.add(save);
        root.add(buttons,BorderLayout.SOUTH);
        setContentPane(root);
        FinanceUI.show(this);
    }
    private void save() {
        try {
            String text=amountField.getText().trim();
            if(text.isEmpty()) {
                JOptionPane.showMessageDialog(this,"Please enter a budget amount.");
                return;
            }
            double a=Double.parseDouble(text);
            if(a<=0) {
                JOptionPane.showMessageDialog(this,"Budget must be greater than zero.");
                return;
            }
            Menu.budgetAmount=a;
            JOptionPane.showMessageDialog(this,"Budget saved successfully: "+Menu.money(a),"Saved",JOptionPane.INFORMATION_MESSAGE);
            dispose();
            if(parent instanceof BudgetManager) {
                parent.dispose();
                new BudgetManager();
            } else if(parent!=null) {
                parent.setVisible(true);
                parent.toFront();
            } else Menu.showDashboard();
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,"Please enter a valid budget amount.");
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Budget::new);
    }
}
