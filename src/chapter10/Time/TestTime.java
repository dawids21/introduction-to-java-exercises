package chapter10.Time;

public class TestTime {
    public static void main(String[] args) {
        Time time = new Time();
        System.out.printf("%02d:%02d:%02d\n", time.getHour(), time.getMinute(), time.getSecond());
        time = new Time(555550000);
        System.out.printf("%02d:%02d:%02d\n", time.getHour(), time.getMinute(), time.getSecond());
    }    
}