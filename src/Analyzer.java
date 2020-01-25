import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Analyzer implements ODEUpdate{

    private ArrayList<Double> tValues = new ArrayList<>();
    private ArrayList<Double> xValues = new ArrayList<>();
    private ArrayList<Double> vValues = new ArrayList<>();



    @Override
    public void update(double t, double x, double v) {

        tValues.add(t);
        xValues.add(x);
        vValues.add(v);

    }

    public ArrayList<Double> gettValues() {
        return tValues;
    }

    public ArrayList<Double> getxValues() {
        return xValues;
    }

    public ArrayList<Double> getvValues() {
        return vValues;
    }

    void saveToFile(String fileName) throws FileNotFoundException{
        PrintWriter printWriter = new PrintWriter(fileName);

        printWriter.println("t \t x \t v");
        for (int i = 0; i < tValues.size(); i++) {
            printWriter.println(tValues.get(i).toString() + '\t' +
                    xValues.get(i).toString() + '\t' +
                    vValues.get(i).toString());

        }
        printWriter.close();
    }
}
