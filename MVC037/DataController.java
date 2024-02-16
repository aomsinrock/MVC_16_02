import java.util.ArrayList;
import java.util.List;
//64050037
// Controller
public class DataController {
    private DataModel model;

    public DataController(DataModel model) {
        this.model = model;
    }

    public void addData(String value) {
        model.addData(value);
    }

    public List<String> getData() {
        return model.getData();
    }

    public List<String> calculateData(String hardware) {
        List<String> data = getData();
        List<String> result = new ArrayList<>();

        if (hardware.equals("CPU")) {
            for (int i = 0; i < data.size(); i++) {
                if (i + 1 < data.size()) {
                    String currentValue = data.get(i);
                    String nextValue = data.get(i + 1);
                    try {
                        double currentValueParsed = Double.parseDouble(currentValue);
                        double nextValueParsed = Double.parseDouble(nextValue);
                        double sum = currentValueParsed + nextValueParsed;
                        result.add(String.valueOf(sum));
                        i++; // Skip the next value since it's already added to the sum
                    } catch (NumberFormatException e) {
                        // Skip the current value if it's not a number
                        result.add(currentValue);
                    }
                } else {
                    result.add(data.get(i)); // Add the last value as is
                }
            }
        } else if (hardware.equals("GPU")) {
            for (int i = data.size() - 1; i >= 0; i--) {
                if (i - 1 >= 0) {
                    String currentValue = data.get(i);
                    String previousValue = data.get(i - 1);
                    try {
                        double currentValueParsed = Double.parseDouble(currentValue);
                        double previousValueParsed = Double.parseDouble(previousValue);
                        double sum = currentValueParsed + previousValueParsed;
                        result.add(String.valueOf(sum));
                        i--; // Skip the previous value since it's already added to the sum
                    } catch (NumberFormatException e) {
                        // Skip the current value if it's not a number
                        result.add(currentValue + previousValue);
                        i--; // Skip the previous value since it's already used
                    }
                } else {
                    result.add(data.get(i)); // Add the first value as is
                }
            }
        } else if (hardware.equals("FPGA")) {
            int half = data.size() / 2;
            for (int i = 0; i < half; i++) {
                result.add(data.get(i)); // Add the first half from front to back
            }
            for (int i = data.size() - 1; i >= half; i--) {
                result.add(data.get(i)); // Add the second half from back to front
            }
        }
    
        return result;
    }
}
