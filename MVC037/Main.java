public class Main {
    public static void main(String[] args) {
        DataModel model = new DataModel();
        DataView view = new DataView(); // Create DataView
        CalculateListener cal = new CalculateListener(model, view); //use model and datafrome view
        view.setCalculate(cal); // Set the CalculateListener after the view is create
    }
}
