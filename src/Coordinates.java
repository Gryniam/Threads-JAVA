public class Coordinates {
    double firstcor;
    double secondcor;
    public Coordinates() { }
    public Coordinates(double first, double second) {
        this.firstcor = first;
        this.secondcor = second;
    }
    public double getfirst(){
        return this.firstcor;
    }
    public void setFirstcor(double firstc){
        this.firstcor = firstc;
    }
    public double getsecond(){
        return this.secondcor;
    }
    public void setSecondcor(double seccor){
        this.secondcor = seccor;
    }
}
