import javax.swing.*;
import java.awt.*;
public class BudgetManager extends JFrame  {
    public BudgetManager() {
        FinanceUI.setupFrame(this,"Budget planner | Finova",560,430);
        JPanel root=FinanceUI.page();
        root.add(FinanceUI.header("Plan & review","Budget planner","Set a limit and see how your current finances compare.",FinanceUI.ORANGE),BorderLayout.NORTH);
        JPanel card=FinanceUI.card(new GridLayout(3,1,0,12));
        card.add(metric("CURRENT BUDGET",Menu.money(Menu.budgetAmount),FinanceUI.ORANGE));
        card.add(metric("TOTAL SPENT",Menu.money(Menu.totalExpense),FinanceUI.RED));
        card.add(metric("BUDGET REMAINING",Menu.money(Menu.budgetAmount-Menu.totalExpense),Menu.budgetAmount-Menu.totalExpense>=0?FinanceUI.GREEN:FinanceUI.RED));
        root.add(card,BorderLayout.CENTER);
        JPanel buttons=new JPanel(new FlowLayout(FlowLayout.RIGHT,10,0));
        buttons.setOpaque(false);
        JButton back=FinanceUI.button("Back",FinanceUI.NAVY),set=FinanceUI.button("Set budget",FinanceUI.ORANGE);
        back.addActionListener(e->{dispose();Menu.showDashboard();});
        set.addActionListener(e->{new Budget(this);setVisible(false);});
        buttons.add(back);
        buttons.add(set);
        root.add(buttons,BorderLayout.SOUTH);
        setContentPane(root);
        FinanceUI.show(this);
    }
    private JPanel metric(String title,String value,Color color) {
        JPanel p=FinanceUI.card(new BorderLayout());
        p.add(FinanceUI.metric(title,value,color));
        return p;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(BudgetManager::new);
    }
}
