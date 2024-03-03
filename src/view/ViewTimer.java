package view;

import controller.HiloTimer;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Luis
 */
public class ViewTimer extends JFrame implements Runnable {

    private HiloTimer hiloTimer = new HiloTimer();
    private JLabel lblTimer = new JLabel("00:00:00");

    public ViewTimer() {
        lblTimer.setBounds(30, 30, 450, 80);
        lblTimer.setFont(new Font("Arial", Font.BOLD, 100));
        add(lblTimer);
        hiloTimer.start();

        Thread actualizacionThread = new Thread(this);
        actualizacionThread.start();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void run() {
        try {
            while (true) {
                int horas = hiloTimer.getHours();
                int minutos = hiloTimer.getMinutes();
                int segundos = hiloTimer.getSeconds();

                String tiempoFormateado = String.format("%02d:%02d:%02d", horas, minutos, segundos);
                lblTimer.setText(tiempoFormateado);

                Thread.sleep(10); // Duerme 200 milisegundos
//                System.out.println(hiloTimer.getSeconds());

                if (hiloTimer.minutes == 30) {
                    break;
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ViewTimer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
