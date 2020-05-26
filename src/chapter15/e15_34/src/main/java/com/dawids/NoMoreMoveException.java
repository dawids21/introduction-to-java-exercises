package com.dawids;

public class NoMoreMoveException extends Exception {
    private final Point head;
    private final boolean reachBoundary;

    public NoMoreMoveException() {
        head = new Point(0, 0);
        reachBoundary = false;
    }

    public NoMoreMoveException(Point head, boolean reachBoundary) {
        this.head = head;
        this.reachBoundary = reachBoundary;
    }

    public boolean isReachBoundary() {
        return reachBoundary;
    }

    public int getHeadX() {
        return head.getX();
    }

    public int getHeadY() {
        return head.getY();
    }
}
