package org.iut.mastermind.domain.proposition;

import java.util.ArrayList;
import java.util.List;
import static java.util.Collections.unmodifiableList;
import static org.iut.mastermind.domain.proposition.Lettre.*;

public class Reponse {
    private final String motSecret;
    private final List<Lettre> resultat = new ArrayList<>();
    private int position;

    public Reponse(String mot) {
        this.motSecret = mot;
    }


    // on récupère la lettre à la position dans le résultat
    public Lettre lettre(int position) {
        return resultat.get(position);
    }

    // on construit le résultat en analysant chaque lettre
    // du mot proposé
    public void compare(String essai) {
        for (char charactere : essai.toCharArray()) {
            this.position = essai.indexOf(charactere);
            this.resultat.add(evaluationCaractere(charactere));
        }
    }

    // si toutes les lettres sont placées
    public boolean lettresToutesPlacees() {
       boolean toutesPlacees = true;
        for (Lettre lettre : resultat) {
            if(!(lettre == PLACEE)) toutesPlacees = false;
        }
        return toutesPlacees;
    }

    public List<Lettre> lettresResultat() {
        return unmodifiableList(resultat);
    }

    // renvoie le statut du caractère
    private Lettre evaluationCaractere(char carCourant) {
        boolean present = estPresent(carCourant);
        if (!present) return INCORRECTE;
        boolean place = estPlace(carCourant);
        if (!place) return NON_PLACEE;
        return PLACEE;
    }

    // le caractère est présent dans le mot secret
    private boolean estPresent(char carCourant) {
        return this.motSecret.contains(Character.toString(carCourant));
    }

    // le caractère est placé dans le mot secret
    private boolean estPlace(char carCourant) {
        return this.motSecret.toCharArray()[position] == carCourant;
    }
}
