package com.antra.easy_notes.model;

import javax.persistence.*;

@Entity
@Table(name="notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


}
