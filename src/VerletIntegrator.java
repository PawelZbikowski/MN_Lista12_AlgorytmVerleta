public class VerletIntegrator {

    private double dt;

    public VerletIntegrator(double dt) {
        this.dt = dt;
    }

    public void integrate(CalculateAcceleration calculateAcceleration,
                            ODEUpdate odeUpdate, double tStart, double tStop,
                          double x0, double v0){

        int nSteps = (int) ((tStop-tStart)/dt);

        double t = tStart;
        double x = x0;
        double v = v0;
        odeUpdate.update(t,x,v);

        double a = calculateAcceleration.a(x);

        for (int i = 0; i < nSteps; i++) {

            double vHalf = v + dt*a/2;
            double xNew = x + dt*vHalf;
            double aNew = calculateAcceleration.a(xNew);
            double vNew = v + dt*(a + aNew)/2;
            a = aNew;
            t += dt;
            x = xNew;
            v = vNew;

            odeUpdate.update(t,x,v);

        }

    }
}
