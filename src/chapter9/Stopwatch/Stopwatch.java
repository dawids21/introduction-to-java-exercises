package chapter9.Stopwatch;

import java.util.Date;

class Stopwatch {
    private long startTime;
    private long endTime;

    Stopwatch() {
        startTime = new Date().getTime();
    }

    long getStartTime() {
        return startTime;
    }

    long getEndTime() {
        return endTime;
    }

    void start() {
        startTime = new Date().getTime();
    }

    void stop() {
        endTime = new Date().getTime();
    }

    long getElapsedTime() {
        return (endTime - startTime);
    }
}