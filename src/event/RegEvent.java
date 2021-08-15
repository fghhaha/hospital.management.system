package event;
import System.Register;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RegEvent implements MouseListener {
    public RegEvent() {
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1) {
            new Register();
        }

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
