package chapter5.pounds_kg;

public class PoundsToKg {
    public static void main(String[] args) {
        int kg = 1;
        int pounds = 20;
        System.out.println("Kilograms Pounds | Pounds Kilograms");
        while (kg < 200) {
            System.out.format("%-9d %6.1f | %-6d %9.2f\n", kg, kg * 2.2, pounds, pounds * 0.454545);
            kg += 2;
            pounds += 5;
        }
    }
}