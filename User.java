import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class User extends JFrame {

    JTextField nameField;
    JTextField emailField;

    public User() {

        setTitle("User Details");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel title = new JLabel("USER DETAILS");
        JLabel name = new JLabel("Name:");
        JLabel email = new JLabel("Email:");

        nameField = new JTextField(20);
        emailField = new JTextField(20);

        JButton saveButton = new JButton("Save");

        add(title);
        add(name);
        add(nameField);
        add(email);
        add(emailField);
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(
                    User.this,
                    "User details saved!"
                );
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new User();
    }
}