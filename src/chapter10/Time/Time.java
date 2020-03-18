package chapter10.Time;

import java.util.Calendar;

class Time {
    private int hour;
    private int minute;
    private int second;
    
    Time() {
        Calendar currentDate = Calendar.getInstance();
        hour = currentDate.get(Calendar.HOUR);
        minute = currentDate.get(Calendar.MINUTE);
        second = currentDate.get(Calendar.SECOND);
    }

    Time(long millis) {
        setTime(millis);
    }

    Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    int getHour() {
        return hour;
    }

    int getMinute() {
        return minute;
    }

    int getSecond() {
        return second;
    }

    void setTime(long elapseTime) {
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(elapseTime);
        hour = date.get(Calendar.HOUR);
        minute = date.get(Calendar.MINUTE);
        second = date.get(Calendar.SECOND);
    }
}