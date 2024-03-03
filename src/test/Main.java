package test;

import view.ViewTimer;

/**
 *
 * @author Luis
 */
public class Main {
    public static void main(String[] args) {
        ViewTimer viewTimer = new ViewTimer();
        viewTimer.setTitle("Timer");
        viewTimer.setSize(500, 200);
        viewTimer.setLayout(null);
        viewTimer.setVisible(true);
    }
}
