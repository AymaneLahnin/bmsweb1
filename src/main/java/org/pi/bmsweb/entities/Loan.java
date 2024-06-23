package org.pi.bmsweb.entities;

import jakarta.persistence.*;

@Entity
public class Loan {
    @Id
    private int loanId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User borrowedBy;
    @Enumerated(EnumType.STRING)
    private Status status;
}
