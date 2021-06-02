public class Calculate implements Runnable {

    private Area area;
    private double firstcord;
    private double secondcord;
    private double step;

    public Calculate(double Firstcord, double Secondcord, double Step, Area area) {
        firstcord = Firstcord;
        secondcord = Secondcord;
        step = Step;
        this.area = area;
    }
     void add(){

        double integral = 0.0;
        for (double i = firstcord; i < secondcord - step / 2; i += step) {
            integral += Math.sin((i + step / 2) * step);
        }
        area.addarea(integral);

    }
    @Override
    public void run() {
      //  System.out.printf("%s Started\n", Thread.currentThread().getName());
        add();
    }
}
