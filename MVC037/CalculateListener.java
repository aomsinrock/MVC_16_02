import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
//64050037
// Action listener for the Calculate button
public class CalculateListener implements ActionListener {
    private DataModel model;
    private DataView view;

    public CalculateListener(DataModel model, DataView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<String> data = new ArrayList<>(); // Create a new list for each calculation
        for (int i = 0; i < 10; i++) {
            String value = JOptionPane.showInputDialog("Enter value " + (i + 1));
            data.add(value);
        }

        String selectedHardware = view.getSelectedHardware();
        model.clearData(); // Clear the previous data before adding new values
        for (String value : data) {
            model.addData(value);
        }

        List<String> result = new DataController(model).calculateData(selectedHardware);
        if (result != null) {
            view.displayData(result);
        } else {
            System.out.println("Invalid hardware choice.");
        }
    }
}
