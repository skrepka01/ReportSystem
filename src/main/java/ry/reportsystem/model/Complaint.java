package ry.reportsystem.model;


import lombok.*;

import java.time.LocalDate;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Complaint {

    private long id;
    private String sender;
    private String recipient;
    private String description;
    private LocalDate localDate;

    public Complaint(String sender, String recipient, String description,LocalDate localDate) {
        this.sender = sender;
        this.recipient = recipient;
        this.description = description;
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "" + id +
                " | " + sender +
                " | " + recipient +
                " | " + description  +
                " | " + localDate ;
    }
}
