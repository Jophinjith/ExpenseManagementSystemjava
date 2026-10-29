import javax.swing.*;
import java.awt.*;

public class Income extends JFrame {
    JTextField amountField, sourceField;
    public Income() {
        FinanceUI.setupFrame(this, "Add income | Finova", 520, 460);
        JPanel root = FinanceUI.page(); root.add(FinanceUI.header("Money in", "Add income", "Record salary, allowance or any other money received.", FinanceUI.GREEN), BorderLayout.NORTH);
        JPanel form = FinanceUI.card(new GridBagLayout()); GridBagConstraints c = new GridBagConstraints(); c.gridx=0;c.weightx=1;c.fill=GridBagConstraints.HORIZONTAL;c.insets=new Insets(7,0,7,0);c.anchor=GridBagConstraints.WEST;
        c.gridy=0; form.add(FinanceUI.label("Amount (₹)"),c); c.gridy++; amountField=FinanceUI.field(22); form.add(amountField,c);
        c.gridy++; form.add(FinanceUI.label("Income source"),c); c.gridy++; sourceField=FinanceUI.field(22); sourceField.setToolTipText("For example, Salary or Freelance"); form.add(sourceField,c);
        c.gridy++; JLabel hint=new JLabel("Tip: enter the amount in rupees.");hint.setForeground(FinanceUI.MUTED);hint.setFont(new Font("SansSerif",Font.PLAIN,13));form.add(hint,c);
        root.add(form,BorderLayout.CENTER); JPanel buttons=new JPanel(new FlowLayout(FlowLayout.RIGHT,10,0));buttons.setOpaque(false); JButton cancel=FinanceUI.button("Cancel",FinanceUI.NAVY), save=FinanceUI.button("Save income",FinanceUI.GREEN); cancel.addActionListener(e->dispose()); save.addActionListener(e->saveIncome());buttons.add(cancel);buttons.add(save);root.add(buttons,BorderLayout.SOUTH);setContentPane(root);FinanceUI.show(this);
    }
    private void saveIncome(){String a=amountField.getText().trim(),s=sourceField.getText().trim();if(a.isEmpty()||s.isEmpty()){JOptionPane.showMessageDialog(this,"Please enter the amount and income source.","Missing details",JOptionPane.WARNING_MESSAGE);return;}try{double v=Double.parseDouble(a);if(v<=0){JOptionPane.showMessageDialog(this,"Amount must be greater than zero.");return;}Menu.totalIncome+=v;Menu.transactions.add("Income | "+s+" | "+Menu.money(v));JOptionPane.showMessageDialog(this,"Income saved successfully!","Saved",JOptionPane.INFORMATION_MESSAGE);dispose();Menu.showDashboard();}catch(NumberFormatException ex){JOptionPane.showMessageDialog(this,"Please enter a valid amount.","Invalid amount",JOptionPane.WARNING_MESSAGE);}}
    public static void main(String[] args){SwingUtilities.invokeLater(Income::new);}
}
