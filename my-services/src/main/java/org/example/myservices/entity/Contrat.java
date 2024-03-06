package org.example.myservices.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.swing.*;
import java.util.UUID;

public class Contrat {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private UUID id;
    private String redaction;

}
