package org.iut.mastermind.domain.partie;

public class Joueur {

    private final String nom;

    // constructeur
    public Joueur(String nom) {
        this.nom = nom;
    }

    // getter nom joueur
    public String getNom() {
        return this.nom;
    }

    // equals
    @Override
    public boolean equals(Object o) {
       return this.nom.equals(((Joueur) o).getNom());
    }

    // hascode
    @Override
    public int hashCode() {
        return this.nom.hashCode();
    }

}