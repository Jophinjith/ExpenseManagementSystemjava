import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/** Shared visual styling for the Expense Management System. */
public final class FinanceUI {
    public static final Color NAVY = new Color(25, 35, 74);
    public static final Color PURPLE = new Color(105, 75, 220);
    public static final Color BLUE = new Color(55, 126, 235);
    public static final Color TEAL = new Color(20, 166, 155);
    public static final Color GREEN = new Color(38, 166, 106);
    public static final Color ORANGE = new Color(245, 145, 55);
    public static final Color RED = new Color(220, 75, 95);
    public static final Color BG = new Color(245, 247, 253);
    public static final Color TEXT = new Color(43, 50, 75);
    public static final Color MUTED = new Color(111, 120, 145);
    public static final Color WHITE = Color.WHITE;
    private static final Font BODY = new Font("Segoe UI", Font.PLAIN, 17);
    private static final Font BOLD = new Font("Segoe UI", Font.BOLD, 17);

    private FinanceUI() {}

    public static void setupFrame(JFrame frame, String title, int width, int height) {
        frame.setTitle(title);
        frame.setSize(width, height);
        frame.setMinimumSize(new Dimension(Math.min(width, 480), Math.min(height, 360)));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(BG);
        frame.setLocationRelativeTo(null);
        frame.setFont(BODY);
    }

    public static JPanel page() {
        JPanel p = new JPanel(new BorderLayout(0, 20));
        p.setBackground(BG);
        p.setBorder(new EmptyBorder(24, 28, 26, 28));
        return p;
    }

    public static JPanel header(String eyebrow, String title, String subtitle, Color accent) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(BG);
        JLabel small = new JLabel(eyebrow.toUpperCase());
        small.setFont(new Font("Segoe UI", Font.BOLD, 13));
        small.setForeground(accent);
        JLabel big = new JLabel(title);
        big.setFont(new Font("Segoe UI", Font.BOLD, 30));
        big.setForeground(NAVY);
        big.setBorder(new EmptyBorder(5, 0, 4, 0));
        JLabel sub = new JLabel(subtitle);
        sub.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        sub.setForeground(MUTED);
        p.add(small); p.add(big); p.add(sub);
        return p;
    }

    public static JPanel card(LayoutManager layout) {
        JPanel p = new JPanel(layout);
        p.setBackground(WHITE);
        p.setBorder(new CompoundBorder(new LineBorder(new Color(229, 233, 244), 1, true), new EmptyBorder(22, 22, 22, 22)));
        return p;
    }

    public static JLabel label(String text) {
        JLabel l = new JLabel(text);
        l.setFont(BOLD);
        l.setForeground(TEXT);
        return l;
    }

    public static JTextField field(int columns) {
        JTextField f = new JTextField(columns);
        f.setFont(BODY);
        f.setForeground(TEXT);
        f.setBackground(new Color(250, 251, 255));
        f.setCaretColor(PURPLE);
        f.setBorder(new CompoundBorder(new LineBorder(new Color(215, 221, 237), 1, true), new EmptyBorder(10, 12, 10, 12)));
        f.setPreferredSize(new Dimension(Math.max(240, columns * 13), 44));
        return f;
    }

    public static JButton button(String text, Color color) {
        JButton b = new JButton(text);
        b.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b.setForeground(WHITE);
        b.setBackground(color);
        b.setOpaque(true);
        b.setFocusPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setBorder(new EmptyBorder(13, 20, 13, 20));
        b.setPreferredSize(new Dimension(150, 48));
        return b;
    }

    public static JLabel metric(String title, String value, Color accent) {
        JLabel l = new JLabel("<html><div style='font-size:12px;color:#6F7891;font-weight:bold'>" + title.toUpperCase() +
                "</div><div style='font-size:21px;color:#20294D;font-weight:bold;margin-top:7px'>" + value + "</div></html>");
        l.setOpaque(true);
        l.setBackground(WHITE);
        l.setBorder(new CompoundBorder(new MatteBorder(4, 0, 0, 0, accent), new EmptyBorder(14, 14, 14, 14)));
        return l;
    }

    public static void show(JFrame frame) { frame.setLocationRelativeTo(null); frame.setVisible(true); }
}
