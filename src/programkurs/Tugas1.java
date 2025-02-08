// RadioButtonDemo.java
package programkurs;
 
import javax.swing.*;
 
public class Tugas1 extends JFrame {
    private JPanel mainPanel;
    private JRadioButton tunaiRadio;
    private JRadioButton kreditRadio;
    private JButton calculateButton;
    private JLabel discountLabel;
    private ButtonGroup paymentGroup;
 
    public Tugas1() {
        setContentPane(mainPanel);
        setTitle("Payment Discount");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        paymentGroup = new ButtonGroup();
        paymentGroup.add(tunaiRadio);
        paymentGroup.add(kreditRadio);
 
        calculateButton.addActionListener(e -> calculateDiscount());
    }
 
    private void calculateDiscount() {
        double discount = 0;
 
        if(tunaiRadio.isSelected()) {
            discount = 0.1; // 10% diskon
        } else if(kreditRadio.isSelected()) {
            discount = 0.05; // 5% diskon
        }
 
        discountLabel.setText(String.format("Diskon: %.0f%%", 
discount * 100));
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Tugas1().setVisible(true));
    }
}
 