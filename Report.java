import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
public class Report extends JFrame  {
    public Report() {
        FinanceUI.setupFrame(this,"Financial report | Finova",650,510);
        JPanel root=FinanceUI.page();
        root.add(FinanceUI.header("Your overview","Financial report","A quick snapshot of where your money stands right now.",FinanceUI.TEAL),BorderLayout.NORTH);
        JPanel metrics=new JPanel(new GridLayout(2,2,14,14));
        metrics.setOpaque(false);
        metrics.add(metric("TOTAL INCOME",Menu.money(Menu.totalIncome),FinanceUI.GREEN));
        metrics.add(metric("TOTAL EXPENSE",Menu.money(Menu.totalExpense),FinanceUI.RED));
        metrics.add(metric("AVAILABLE BALANCE",Menu.money(Menu.getBalance()),FinanceUI.BLUE));
        metrics.add(metric("BUDGET",Menu.money(Menu.budgetAmount),FinanceUI.ORANGE));
        root.add(metrics,BorderLayout.CENTER);
        JPanel bottom=new JPanel(new BorderLayout());
        bottom.setOpaque(false);
        JLabel note=new JLabel("Transactions recorded: "+Menu.transactions.size()+"     •     Categories: "+Menu.categories.size());
        note.setFont(new Font("SansSerif",Font.PLAIN,14));
        note.setForeground(FinanceUI.MUTED);
        bottom.add(note,BorderLayout.WEST);
        JButton done=FinanceUI.button("Return to dashboard",FinanceUI.TEAL);
        done.addActionListener(e->{dispose();Menu.showDashboard();});
        bottom.add(done,BorderLayout.EAST);
        root.add(bottom,BorderLayout.SOUTH);
        setContentPane(root);
        FinanceUI.show(this);
    }
    private JPanel metric(String title,String value,Color color) {
        JPanel p=FinanceUI.card(new BorderLayout());
        p.setBorder(new CompoundBorder(new MatteBorder(4,0,0,0,color),new EmptyBorder(22,20,22,20)));
        JLabel a=new JLabel(title);
        a.setFont(new Font("Segoe UI",Font.BOLD,12));
        a.setForeground(FinanceUI.MUTED);
        JLabel b=new JLabel(value);
        b.setFont(new Font("Segoe UI Semibold",Font.BOLD,25));
        b.setForeground(FinanceUI.TEXT);
        p.add(a,BorderLayout.NORTH);
        p.add(b,BorderLayout.CENTER);
        return p;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Report::new);
    }
}
