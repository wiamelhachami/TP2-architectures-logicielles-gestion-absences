package com.ensaf.gestionabsences.model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Etudiant {

    private int id;
    private String nom;
    private String prenom;
    private String cne;
    private String niveau;
    private double heuresAbsence;

    // Constructeur vide : obligatoire pour JAXB
    public Etudiant() {
    }

    public Etudiant(int id, String nom, String prenom, String cne,
                    String niveau, double heuresAbsence) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cne = cne;
        this.niveau = niveau;
        this.heuresAbsence = heuresAbsence;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getCne() { return cne; }
    public void setCne(String cne) { this.cne = cne; }

    public String getNiveau() { return niveau; }
    public void setNiveau(String niveau) { this.niveau = niveau; }

    public double getHeuresAbsence() { return heuresAbsence; }
    public void setHeuresAbsence(double heuresAbsence) { this.heuresAbsence = heuresAbsence; }
}