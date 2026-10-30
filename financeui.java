import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
/** Shared dark visual system for Finova. */
public final class FinanceUI  {
    // Netflix-inspired palette applied consistently across every frame.
    public static final Color NAVY = new Color(184, 29, 36); // #B81D24 deep crimson
    public static final Color PURPLE = new Color(229, 9, 20); // #E50914 bright crimson
    public static final Color BLUE = new Color(184, 29, 36);
    public static final Color TEAL = new Color(229, 9, 20);
    public static final Color GREEN = new Color(184, 29, 36);
    public static final Color ORANGE = new Color(184, 29, 36);
    public static final Color RED = new Color(229, 9, 20);
    public static final Color BG = new Color(34, 31, 31); // #221F1F
    public static final Color PANEL = new Color(43, 39, 39);
    public static final Color FIELD = new Color(52, 47, 47);
    public static final Color BORDER = new Color(92, 48, 50);
    public static final Color TEXT = new Color(245, 245, 241); // #F5F5F1
    public static final Color MUTED = new Color(177, 171, 168);
    public static final Color WHITE = new Color(245, 245, 241);
    private static final Font BODY = new Font("Segoe UI", Font.PLAIN, 17);
    private static final Font BOLD = new Font("Segoe UI", Font.BOLD, 17);
    private FinanceUI()  {
    }
    public static void setupFrame(JFrame frame, String title, int width, int height)  {
        frame.setTitle(title);
        frame.setSize(width, height);
        frame.setMinimumSize(new Dimension(Math.min(width, 560), Math.min(height, 420)));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(BG);
        frame.setLocationRelativeTo(null);
        frame.setFont(BODY);
    }
    public static JPanel page()  {
        JPanel p = new JPanel(new BorderLayout(0, 20));
        p.setBackground(BG);
        p.setBorder(new EmptyBorder(24, 28, 24, 28));
        return p;
    }
    public static JPanel header(String eyebrow, String title, String subtitle, Color accent)  {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(BG);
        JLabel small = new JLabel(eyebrow.toUpperCase());
        small.setFont(new Font("Segoe UI", Font.BOLD, 13));
        small.setForeground(accent);
        JLabel big = new JLabel(title);
        big.setFont(new Font("Segoe UI", Font.BOLD, 30));
        big.setForeground(TEXT);
        big.setBorder(new EmptyBorder(5, 0, 5, 0));
        JLabel sub = new JLabel(subtitle);
        sub.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        sub.setForeground(MUTED);
        p.add(small);
        p.add(big);
        p.add(sub);
        return p;
    }
    public static JPanel card(LayoutManager layout)  {
        JPanel p = new JPanel(layout);
        p.setBackground(PANEL);
        p.setBorder(new CompoundBorder(new LineBorder(BORDER, 1, true), new EmptyBorder(22, 22, 22, 22)));
        return p;
    }
    public static JLabel label(String text)  {
        JLabel l = new JLabel(text);
        l.setFont(BOLD);
        l.setForeground(TEXT);
        return l;
    }
    public static JTextField field(int columns)  {
        JTextField f = new JTextField(columns);
        f.setFont(BODY);
        f.setForeground(TEXT);
        f.setBackground(FIELD);
        f.setCaretColor(RED);
        f.setSelectionColor(new Color(184, 29, 36));
        f.setSelectedTextColor(WHITE);
        f.setBorder(new CompoundBorder(new LineBorder(BORDER, 1, true), new EmptyBorder(10, 12, 10, 12)));
        f.setPreferredSize(new Dimension(Math.max(240, columns * 13), 48));
        return f;
    }
    public static <T> JComboBox<T> combo(T[] items)  {
        JComboBox<T> box = new JComboBox<T>(items);
        box.setFont(BODY);
        box.setForeground(TEXT);
        box.setBackground(FIELD);
        box.setFocusable(false);
        box.setPreferredSize(new Dimension(260, 48));
        box.setBorder(new LineBorder(BORDER, 1, true));
        box.setRenderer(new DefaultListCellRenderer() {
        @Override public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean selected, boolean focus) {
        super.getListCellRendererComponent(list, value, index, selected, focus);
        setFont(BODY);
        setOpaque(true);
        setBackground(selected ? new Color(184, 29, 36) : FIELD);
        setForeground(TEXT);
        setBorder(new EmptyBorder(8, 10, 8, 10));
        return this;
        }
        });
        return box;
    }
    public static JButton button(String text, Color color)  {
        JButton b = new JButton(text);
        b.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b.setForeground(color.equals(NAVY) ? TEXT : new Color(245, 245, 241));
        b.setBackground(color);
        b.setOpaque(true);
        b.setFocusPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setBorder(new CompoundBorder(new LineBorder(color.darker(), 1, true), new EmptyBorder(12, 20, 12, 20)));
        b.setPreferredSize(new Dimension(155, 50));
        Color normal = color.equals(NAVY) ? NAVY : RED;
        Color hover = color.equals(NAVY) ? new Color(184, 29, 36) : new Color(255, 48, 58);
        b.setBackground(normal);
        b.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override public void mouseEntered(java.awt.event.MouseEvent e) {
        if (b.isEnabled()) b.setBackground(hover);
        }
        @Override public void mouseExited(java.awt.event.MouseEvent e) {
        b.setBackground(normal);
        }
        });
        return b;
    }
    public static JLabel metric(String title, String value, Color accent)  {
        JLabel l = new JLabel("<html><div style='font-size:12px;color:#B1ABA8;font-weight:bold;letter-spacing:1px'>" + title.toUpperCase() +
        "</div><div style='font-size:21px;color:#F5F5F1;font-weight:bold;margin-top:8px'>" + value + "</div></html>");
        l.setOpaque(true);
        l.setBackground(PANEL);
        l.setBorder(new CompoundBorder(new MatteBorder(4, 0, 0, 0, accent), new EmptyBorder(14, 14, 14, 14)));
        return l;
    }
    public static void styleList(JList<?> list)  {
        list.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        list.setForeground(TEXT);
        list.setBackground(FIELD);
        list.setSelectionBackground(new Color(184, 29, 36));
        list.setSelectionForeground(WHITE);
        list.setFixedCellHeight(36);
    }
    public static void styleScroll(JScrollPane scroll)  {
        scroll.setBorder(new LineBorder(BORDER, 1, true));
        scroll.getViewport().setBackground(FIELD);
    }
    public static void show(JFrame frame)  {
        // Pack after the content is installed so smaller windows never squeeze labels or fields.
        Dimension requested = frame.getSize();
        frame.pack();
        Dimension packed = frame.getSize();
        int width = Math.max(requested.width, packed.width);
        int height = Math.max(requested.height, packed.height);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        width = Math.min(width, Math.max(560, screen.width - 80));
        height = Math.min(height, Math.max(420, screen.height - 100));
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
