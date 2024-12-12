import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// Главный класс
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Полиномы");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Панель для управления
        JPanel inputPanel = new JPanel(new GridLayout(2, 3, 5, 5));
        JLabel valueLabel = new JLabel("Значение:");
        JTextField valueField = new JTextField();
        JLabel pointLabel = new JLabel("Точка:");
        JTextField pointField = new JTextField();
        JButton addButton = new JButton("Добавить");

        inputPanel.add(valueLabel);
        inputPanel.add(valueField);
        inputPanel.add(pointLabel);
        inputPanel.add(pointField);
        inputPanel.add(new JLabel());
        inputPanel.add(addButton);

        // Таблица для отображения данных
        List<PolynomialData> polynomialDataList = new ArrayList<>();
        PolynomialTableModel tableModel = new PolynomialTableModel(polynomialDataList);
        JTable table = new JTable(tableModel);

        // Добавление действия для кнопки "Добавить"
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double value = Double.parseDouble(valueField.getText());
                    double point = Double.parseDouble(pointField.getText());
                    polynomialDataList.add(new PolynomialData(value, point));
                    tableModel.fireTableDataChanged();
                    valueField.setText("");
                    pointField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Введите корректные числовые значения!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Добавление справочного меню
        JMenuBar menuBar = new JMenuBar();
        JMenu helpMenu = new JMenu("Справка");
        JMenuItem aboutItem = new JMenuItem("О программе");
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Автор: Иванов И.И., группа: XYZ", "О программе", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        helpMenu.add(aboutItem);
        menuBar.add(helpMenu);

        // Добавление компонентов в окно
        frame.setJMenuBar(menuBar);
        frame.setLayout(new BorderLayout());
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}