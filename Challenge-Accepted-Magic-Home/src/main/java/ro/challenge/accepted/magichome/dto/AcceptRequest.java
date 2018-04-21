package ro.challenge.accepted.magichome.dto;

/**
 * Created by sebi on 4/21/18.
 */
public class AcceptRequest {

    private int reservationId;

    private String text;

    private boolean accept;


    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    @Override
    public String toString() {
        return "AcceptRequest{" +
                "reservationId=" + reservationId +
                ", text='" + text + '\'' +
                ", accept=" + accept +
                '}';
    }
}
