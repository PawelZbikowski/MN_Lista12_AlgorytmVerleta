public class EulerCromerIntegrator {

    private double dt;

    public EulerCromerIntegrator(double dt) {
        this.dt = dt;
    }

    public void integrate(CalculateAcceleration calculateAcceleration,
                          ODEUpdate odeUpdate1, double tStart, double tStop,
                          double x0, double v0){

        int nSteps = (int) ((tStop-tStart)/dt);

        double t = tStart;
        double x = x0;
        double v = v0;
        odeUpdate1.update(t,x,v);



        for (int i = 0; i < nSteps; i++) {

            double a = calculateAcceleration.a(v);
            double vNew = v + dt*a;
            double xNew = x + dt*vNew;
            t += dt;
            x = xNew;
            v = vNew;

            odeUpdate1.update(t,x,v);

        }

    }

}
