package com.example.ubo.weatherapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clients") // Table "clients" dans la nouvelle BDD
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String mail;
    private String password;

    // Constructeur vide (Obligatoire pour JPA)
    public ClientEntity() {
    }

    // Constructeur utilitaire
    public ClientEntity(String nom, String prenom, String mail, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.password = password;
    }

    // Getters et Setters (Génère-les avec Alt+Insert)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}