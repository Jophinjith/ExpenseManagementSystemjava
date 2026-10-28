import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Category extends JFrame {

    JTextField categoryField;

    public Category() {

        setTitle("Category");
        setSize(400, 250);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel title = new JLabel("ADD CATEGORY");
        JLabel label = new JLabel("Category Name:");

        categoryField = new JTextField(20);

        JButton addButton = new JButton("Add Category");

        add(title);
        add(label);
        add(categoryField);
        add(addButton);

        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String category = categoryField.getText();

                if (category.isEmpty()) {

                    JOptionPane.showMessageDialog(
                        Category.this,
                        "Please enter a category."
                    );

                } else {

                    JOptionPane.showMessageDialog(
                        Category.this,
                        "Category added: " + category
                    );
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Category();
    }
}