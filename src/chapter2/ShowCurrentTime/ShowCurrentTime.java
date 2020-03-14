package chapter2.ShowCurrentTime;

import java.util.Scanner;

public class ShowCurrentTime {
    public static void main(String[] args) {

        //Get GMT
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the time zone offset to GMT: ");
        int gmt = input.nextInt();
        input.close();

        // Obtain the total milliseconds since midnight, Jan 1, 1970
        long totalMilliseconds = System.currentTimeMillis();
        
        // Obtain the total seconds since midnight, Jan 1, 1970
        long totalSeconds = totalMilliseconds / 1000;

        // Compute the current second in the minute in the hour
        long currentSecond = totalSeconds % 60;

        // Obtain the total minutes
        long totalMinutes = totalSeconds / 60;

        // Compute the current minute in the hour
        long currentMinute = totalMinutes % 60;

        // Obtain the total hours
        long totalHours = totalMinutes / 60;

        // Compute the current hour
        long currentHour = (totalHours % 24) + gmt;

        // Display results
        System.out.format("Current time is %02d:%02d:%02d GMT%+d\n", currentHour, 
                            currentMinute, currentSecond, gmt);
    }
}