import javax.swing.*;
import java.awt.*;
import java.util.List;
//64050037

// View
public class DataView {
    private JFrame frame;
    private JTextArea textArea;
    private JButton calculateButton;
    private JComboBox<String> hardware;
    private JLabel selectedHardware;

    public DataView() {
        frame = new JFrame("Prototype Data View");
        ImageIcon img = new ImageIcon("logo.png"); //set logo
        frame.setIconImage(img.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);//set frame size

        // Set location to the middle screen
        frame.setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setEditable(false);

        // Set font size to 16
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        frame.getContentPane().add(controlPanel, BorderLayout.SOUTH);
        // Drop Down Select HW
        hardware = new JComboBox<>(new String[] { "CPU", "GPU", "FPGA" });
        controlPanel.add(hardware);

        selectedHardware = new JLabel("Selected hardware: ");
        controlPanel.add(selectedHardware);
        // calculateButton
        calculateButton = new JButton("Calculate");
        controlPanel.add(calculateButton);
        frame.setVisible(true);
    }
        // Show display after calculate
    public void displayData(List<String> data) {
        StringBuilder sb = new StringBuilder();
        sb.append("Data in array:\n");
        int dataSize = data.size();
        for (int i = 0; i < dataSize; i++) {
            sb.append(data.get(i));
            if (i < dataSize - 1) {
                sb.append(",");
            }
        }
        textArea.setText(sb.toString());
    }

    public String getSelectedHardware() {
        return (String) hardware.getSelectedItem();
    }

    public void setSelectedHardware(String hardware) {
        selectedHardware.setText("Selected Hardware: " + hardware);
    }

    public void setCalculate(CalculateListener cal) {
        calculateButton.addActionListener(cal);
    }
}
