import javax.swing.*;
import java.awt.*;
public class User extends JFrame  {
    JTextField nameField,emailField;
    public User() {
        FinanceUI.setupFrame(this,"Profile | Finova",520,430);
        JPanel root=FinanceUI.page();
        root.add(FinanceUI.header("Personal details","Your profile","Keep your account details together.",FinanceUI.PURPLE),BorderLayout.NORTH);
        JPanel form=FinanceUI.card(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        c.gridx=0;
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(8,0,8,0);
        c.anchor=GridBagConstraints.WEST;
        c.gridy=0;
        form.add(FinanceUI.label("Full name"),c);
        c.gridy++;
        nameField=FinanceUI.field(22);
        form.add(nameField,c);
        c.gridy++;
        form.add(FinanceUI.label("Email address"),c);
        c.gridy++;
        emailField=FinanceUI.field(22);
        form.add(emailField,c);
        root.add(form,BorderLayout.CENTER);
        JPanel buttons=new JPanel(new FlowLayout(FlowLayout.RIGHT,10,0));
        buttons.setOpaque(false);
        JButton cancel=FinanceUI.button("Close",FinanceUI.NAVY),save=FinanceUI.button("Save details",FinanceUI.PURPLE);
        cancel.addActionListener(e->dispose());
        save.addActionListener(e->{if(nameField.getText().trim().isEmpty()||emailField.getText().trim().isEmpty()){JOptionPane.showMessageDialog(this,"Please enter both your name and email.");return;}JOptionPane.showMessageDialog(this,"User details saved!","Saved",JOptionPane.INFORMATION_MESSAGE);dispose();});
        buttons.add(cancel);
        buttons.add(save);
        root.add(buttons,BorderLayout.SOUTH);
        setContentPane(root);
        FinanceUI.show(this);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(User::new);
    }
}
