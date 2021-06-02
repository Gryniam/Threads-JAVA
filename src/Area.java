public class Area {
    private double area = 0.0;
    public synchronized void addarea(double area){
        this.area += area;
    }

    public double getArea() {
        return area;
    }
}
