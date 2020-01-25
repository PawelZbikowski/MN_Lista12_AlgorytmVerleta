import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Tester {

    public static void main(String[] args) {

        VerletIntegrator vi = new VerletIntegrator(0.01);
        EulerCromerIntegrator eci = new EulerCromerIntegrator(0.01);

        Analyzer analyzer = new Analyzer();
        TenisToss tenisToss = new TenisToss();

        Analyzer analyzer1 = new Analyzer();
        TenisToss tenisToss1 = new TenisToss();

        TolaCarBreaking tolaCarBreaking = new TolaCarBreaking();
        Analyzer analyzer2 = new Analyzer();

        // Zad 1
        vi.integrate(tenisToss, analyzer, 0, 1.3, 1.5, 5.2);

        double maxValueVerlet = maxValue(analyzer.getxValues());
        System.out.println("Maksymalna wysokosc przy wyrzucie pilki dla metody Verleta: " + maxValueVerlet + "m");

        // Zad 2
        eci.integrate(tenisToss1, analyzer1, 0, 1.3, 1.5, 5.2);

        double maxValueEuler = maxValue(analyzer1.getxValues());
        System.out.println("Maksymalna wysokosc przy wyrzucie pilki dla metody Eulera-Cromera: " + maxValueEuler + "m");

        // Zad 3
        eci.integrate(tolaCarBreaking, analyzer2, 0, 12.15, 0., 83.33);

        double [] timeAndDistanceValues = timeAndDistance(analyzer2.gettValues(), analyzer2.getxValues(), analyzer2.getvValues());
        System.out.println("Odległość przejechana przez samochód podczas hamowania wynosi " + timeAndDistanceValues[1] + "m,\na czas wynosi " + timeAndDistanceValues[0] + "s.");

        try {
            analyzer.saveToFile("test.txt");
            analyzer.saveToFile("test2.txt");
            analyzer2.saveToFile("BreakingTest.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static double maxValue(ArrayList<Double> array){
        double diff;
        double max = 0;
        for (int i = 0; i < array.size(); i++) {
            diff = array.get(i+1) - array.get(i);
            if(diff < 0){
                max = array.get(i);
                break;
            }
        }
        return max;
    }

    public static double[] timeAndDistance(ArrayList<Double> time, ArrayList<Double> distance, ArrayList<Double> speed){
        double speedo;
        double timo = 0;
        double distanco = 0;
        for (int i = 0; i < time.size(); i++) {
            speedo = speed.get(i);
            if(speedo < 0){
                timo = time.get(i);
                distanco = distance.get(i);
                break;
            }

        }
        return new double[] {timo,distanco};
    }

}
