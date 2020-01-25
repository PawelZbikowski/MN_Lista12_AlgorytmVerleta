public class TolaCarBreaking implements CalculateAcceleration{

    @Override
    public double a(double x) {
        return -0.7*9.81 - (0.86*Math.pow(x,2))/1200.;
    }

}
