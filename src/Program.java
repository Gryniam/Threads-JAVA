import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static double x0 = 0;
    public static double x1 = Math.PI / 2;
    public static double h = 0.0000001;
    public static double k = 0;
    static List<Coordinates> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        int iterator = 1;
        while (iterator <= 50) {
            List<Thread> calc = new ArrayList<>();
            double firstcord = x0;
            double secondcord = x1;
            for (int i = 0; i < iterator; i++) {
                secondcord +=  (x1-x0)/iterator;
                list.add(new Coordinates(firstcord, secondcord));
                firstcord = secondcord;
            }
            Area area = new Area();
            long time = System.currentTimeMillis();
            for (int i = 0; i < iterator; i++) {
                Calculate savenum = new Calculate(list.get(i).getfirst(), list.get(i).getsecond(),h ,area);
                Thread t = new Thread(savenum, "MyThread " + i);
                calc.add(t);
                t.start();
            }
            for(var i: calc){
                i.join();
            }
            System.out.printf("Кількість потоків: %2d | результат: %.15f | час виконання(мілісекунди): %s\n", iterator, area.getArea(), (System.currentTimeMillis()-time));
            try(FileOutputStream fos=new FileOutputStream("result.csv",true);
                PrintStream printStream = new PrintStream(fos)){
               // printStream.println("Кількість потоків" + ';'+ "Результат виконання" + ';' + "Час виконання(в мілісекундах)");
                String string=Double.toString(iterator)+';'+area.getArea()+';'+(System.currentTimeMillis()-time);
                printStream.println(string);
            } catch (IOException e) {
                e.printStackTrace();
            }
            list.clear();
            k = 0.0;
            iterator++;
        }
System.exit(0);

    }
}
