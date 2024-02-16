import java.util.ArrayList;
import java.util.List;
//64050037

// Model
public class DataModel {
    private List<String> data; //create list

    public DataModel() {
        data = new ArrayList<>();
    }

    public void addData(String value) {
        data.add(value); //add data to list
    }

    public List<String> getData() {
        return data; //return data
    }
    public void clearData() {
        data.clear(); //clear data when calculate new array
    }
}
