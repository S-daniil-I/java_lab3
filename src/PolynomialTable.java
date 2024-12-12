
import javax.swing.*;
        import java.util.ArrayList;
import java.util.List;

public class PolynomialTable {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Таблица многочленов");
        List<PolynomialData> data = new ArrayList<>();
        data.add(new PolynomialData(16, 2));
        data.add(new PolynomialData(15, 3));
        data.add(new PolynomialData(9, 1));

        PolynomialTableModel model = new PolynomialTableModel(data);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane);
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
