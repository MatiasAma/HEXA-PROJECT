package org.iut.mastermind.domain.proposition;

import java.util.ArrayList;
import java.util.List;
import static java.util.Collections.unmodifiableList;
import static org.iut.mastermind.domain.proposition.Lettre.*;

public class Reponse {
    private final String motSecret;
    private final List<Lettre> resultat = new ArrayList<>();

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
            this.resultat.add(evaluationCaractere(charactere,essai.indexOf(charactere)));
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
    private Lettre evaluationCaractere(char carCourant, int position) {
        if (!this.motSecret.contains(Character.toString(carCourant))) return INCORRECTE;
        if (!(this.motSecret.toCharArray()[position] == carCourant)) return NON_PLACEE;
        return PLACEE;
    }
}
