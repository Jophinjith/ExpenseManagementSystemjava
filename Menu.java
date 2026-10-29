import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Menu extends JFrame {
    static double totalIncome = 0.0;
    static double totalExpense = 0.0;
    static double budgetAmount = 0.0;
    static final java.util.List<String> categories = new java.util.ArrayList<String>();
    static final java.util.List<String> transactions = new java.util.ArrayList<String>();
    private JLabel incomeValue, expenseValue, balanceValue, budgetValue;

    static double getBalance() { return totalIncome - totalExpense; }
    static String money(double amount) { return String.format(java.util.Locale.US, "₹%,.2f", amount); }

    public Menu() {
        FinanceUI.setupFrame(this, "Finova | Expense Management", 940, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel root = FinanceUI.page();
        root.setBorder(new EmptyBorder(26, 34, 30, 34));

        JPanel top = new JPanel(new BorderLayout()); top.setOpaque(false);
        JPanel brand = new JPanel(); brand.setOpaque(false); brand.setLayout(new BoxLayout(brand, BoxLayout.Y_AXIS));
        JLabel eyebrow = new JLabel("PERSONAL FINANCE • SMARTER EVERY DAY");
        eyebrow.setFont(new Font("Segoe UI", Font.BOLD, 13)); eyebrow.setForeground(FinanceUI.PURPLE);
        JLabel title = new JLabel("Your money, in focus."); title.setFont(new Font("Segoe UI", Font.BOLD, 33)); title.setForeground(FinanceUI.NAVY);
        JLabel subtitle = new JLabel("A clear picture of your income, spending and goals."); subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 16)); subtitle.setForeground(FinanceUI.MUTED);
        brand.add(eyebrow); brand.add(Box.createVerticalStrut(7)); brand.add(title); brand.add(Box.createVerticalStrut(5)); brand.add(subtitle);
        JLabel logo = new JLabel("  F  "); logo.setFont(new Font("SansSerif", Font.BOLD, 25)); logo.setForeground(Color.WHITE); logo.setOpaque(true); logo.setBackground(FinanceUI.PURPLE); logo.setBorder(new EmptyBorder(9, 13, 9, 13));
        top.add(brand, BorderLayout.CENTER); top.add(logo, BorderLayout.EAST);

        JPanel metrics = new JPanel(new GridLayout(1, 4, 14, 0)); metrics.setOpaque(false);
        incomeValue = new JLabel(); expenseValue = new JLabel(); balanceValue = new JLabel(); budgetValue = new JLabel();
        metrics.add(metricCard("TOTAL INCOME", incomeValue, FinanceUI.GREEN));
        metrics.add(metricCard("TOTAL EXPENSE", expenseValue, FinanceUI.RED));
        metrics.add(metricCard("AVAILABLE BALANCE", balanceValue, FinanceUI.BLUE));
        metrics.add(metricCard("MONTHLY BUDGET", budgetValue, FinanceUI.ORANGE));

        JPanel section = new JPanel(new BorderLayout(0, 12)); section.setOpaque(false);
        JLabel sectionTitle = new JLabel("Quick actions"); sectionTitle.setFont(new Font("Segoe UI", Font.BOLD, 23)); sectionTitle.setForeground(FinanceUI.NAVY);
        JLabel sectionSub = new JLabel("Choose what you'd like to manage today."); sectionSub.setFont(new Font("Segoe UI", Font.PLAIN, 15)); sectionSub.setForeground(FinanceUI.MUTED);
        JPanel sectionHead = new JPanel(); sectionHead.setOpaque(false); sectionHead.setLayout(new BoxLayout(sectionHead, BoxLayout.Y_AXIS)); sectionHead.add(sectionTitle); sectionHead.add(Box.createVerticalStrut(4)); sectionHead.add(sectionSub);
        JPanel actions = new JPanel(new GridLayout(2, 3, 14, 14)); actions.setOpaque(false);
        actions.add(actionCard("＋", "Add income", "Record money received", FinanceUI.GREEN, () -> new Income()));
        actions.add(actionCard("−", "Add expense", "Track a purchase or bill", FinanceUI.RED, () -> new Expense()));
        actions.add(actionCard("◈", "Budget planner", "Set and review your limit", FinanceUI.ORANGE, () -> new BudgetManager()));
        actions.add(actionCard("▦", "Categories", "Organize your spending", FinanceUI.PURPLE, () -> new Category(this)));
        actions.add(actionCard("↔", "Transactions", "Review or add activity", FinanceUI.BLUE, () -> new Transaction()));
        actions.add(actionCard("▤", "Reports", "View your financial summary", FinanceUI.TEAL, () -> new Report()));

        JPanel bottom = new JPanel(new BorderLayout()); bottom.setOpaque(false); bottom.setBorder(new EmptyBorder(3, 2, 0, 2));
        JLabel footer = new JLabel("FINOVA  •  SIMPLE. CLEAR. IN CONTROL."); footer.setFont(new Font("Segoe UI", Font.BOLD, 12)); footer.setForeground(new Color(139, 146, 166));
        JButton userButton = FinanceUI.button("Profile & details", FinanceUI.NAVY); userButton.setPreferredSize(new Dimension(175, 42)); userButton.addActionListener(e -> new User());
        bottom.add(footer, BorderLayout.WEST); bottom.add(userButton, BorderLayout.EAST);

        root.add(top, BorderLayout.NORTH);
        JPanel center = new JPanel(new BorderLayout(0, 22)); center.setOpaque(false); center.add(metrics, BorderLayout.NORTH);
        JPanel actionsWrap = new JPanel(new BorderLayout(0, 14)); actionsWrap.setOpaque(false); actionsWrap.add(sectionHead, BorderLayout.NORTH); actionsWrap.add(actions, BorderLayout.CENTER);
        center.add(actionsWrap, BorderLayout.CENTER);
        root.add(center, BorderLayout.CENTER); root.add(bottom, BorderLayout.SOUTH);
        setContentPane(root); refreshDashboard(); FinanceUI.show(this);
    }

    private JPanel metricCard(String name, JLabel value, Color accent) {
        JPanel p = FinanceUI.card(new BorderLayout(0, 10)); p.setBorder(new CompoundBorder(new LineBorder(new Color(229,233,244),1,true), new EmptyBorder(15,15,15,15)));
        JLabel label = new JLabel(name); label.setFont(new Font("Segoe UI", Font.BOLD, 12)); label.setForeground(FinanceUI.MUTED);
        value.setFont(new Font("Segoe UI", Font.BOLD, 20)); value.setForeground(FinanceUI.NAVY);
        p.add(label, BorderLayout.NORTH); p.add(value, BorderLayout.CENTER); p.setBorder(new CompoundBorder(new MatteBorder(4,0,0,0,accent), new EmptyBorder(14,15,14,15))); return p;
    }

    private JPanel actionCard(String symbol, String title, String description, Color accent, Runnable action) {
        JPanel p = FinanceUI.card(new BorderLayout(16, 8)); p.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JLabel icon = new JLabel(symbol, SwingConstants.CENTER);
        icon.setFont(new Font("Segoe UI Symbol", Font.BOLD, 25));
        icon.setForeground(Color.WHITE); icon.setOpaque(true); icon.setBackground(accent);
        icon.setPreferredSize(new Dimension(58, 64)); icon.setMinimumSize(new Dimension(58, 64));
        JPanel iconWrap = new JPanel(new GridBagLayout()); iconWrap.setOpaque(false);
        iconWrap.setPreferredSize(new Dimension(62, 72)); iconWrap.add(icon);
        JLabel heading = new JLabel(title); heading.setFont(new Font("Segoe UI", Font.BOLD, 19)); heading.setForeground(FinanceUI.NAVY);
        JLabel desc = new JLabel("<html><div style='width:220px;color:#6F7891;font-size:13px'>" + description + "</div></html>");
        JPanel copy = new JPanel(); copy.setOpaque(false); copy.setLayout(new BoxLayout(copy, BoxLayout.Y_AXIS)); copy.add(heading); copy.add(Box.createVerticalStrut(5)); copy.add(desc);
        copy.setBorder(new EmptyBorder(3, 0, 0, 0)); p.add(iconWrap, BorderLayout.WEST); p.add(copy, BorderLayout.CENTER);
        p.setBorder(new CompoundBorder(new LineBorder(new Color(229,233,244),1,true), new EmptyBorder(19,19,19,16)));
        java.awt.event.MouseAdapter cardEvents = new java.awt.event.MouseAdapter() { public void mouseClicked(java.awt.event.MouseEvent e) { action.run(); } public void mouseEntered(java.awt.event.MouseEvent e) { p.setBorder(new CompoundBorder(new LineBorder(accent,2,true),new EmptyBorder(18,18,18,15))); } public void mouseExited(java.awt.event.MouseEvent e) { p.setBorder(new CompoundBorder(new LineBorder(new Color(229,233,244),1,true),new EmptyBorder(19,19,19,16))); } }; p.addMouseListener(cardEvents); iconWrap.addMouseListener(cardEvents); icon.addMouseListener(cardEvents); copy.addMouseListener(cardEvents); heading.addMouseListener(cardEvents); desc.addMouseListener(cardEvents);
        return p;
    }

    void refreshDashboard() {
        if (incomeValue != null) incomeValue.setText(money(totalIncome));
        if (expenseValue != null) expenseValue.setText(money(totalExpense));
        if (balanceValue != null) balanceValue.setText(money(getBalance()));
        if (budgetValue != null) budgetValue.setText(money(budgetAmount));
        revalidate(); repaint();
    }
    static void showDashboard() {
        for (Frame frame : Frame.getFrames()) if (frame instanceof Menu && frame.isDisplayable()) { ((Menu)frame).refreshDashboard(); frame.setVisible(true); frame.toFront(); frame.requestFocus(); return; }
        new Menu();
    }
    public static void main(String[] args) { SwingUtilities.invokeLater(() -> new Menu()); }
}
