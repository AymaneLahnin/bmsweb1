package org.pi.bmsweb.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Author {
    @Id
    private int id;
    private String fullname;

}
