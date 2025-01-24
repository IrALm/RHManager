package com.backend.Gestion_Employee.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;


@Entity
@Data
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Le Domaine de travail doit être précisé")
    private DomaineEmploye domaine;
    @NotBlank(message = "Le champ nom ne doit pas être vide")
    private String nom;
    @NotBlank(message = "Le champ prénom ne doit pas être vide")
    private String prenom;
    @NotBlank(message = "Le champ numéro est obligatoire")
    private String tel; // Remplacé "string" par "String"
    @NotNull(message = "SALAIRE NE DOIT PAS ETRE NUL")
    @Positive
    private Double salaire;
    @NotNull(message = "L'annéee d'entrée est obligatoire")
    private LocalDate data_embauche;
}

