package com.ensaf.gestionabsences.service;

import com.ensaf.gestionabsences.model.Etudiant;
import jakarta.jws.WebService;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@WebService(endpointInterface = "com.ensaf.gestionabsences.service.AbsenceService",
        serviceName = "AbsenceService")
public class AbsenceServiceImpl implements AbsenceService {

    // Volume horaire total du module (en heures)
    private static final double VOLUME_HORAIRE = 60.0;

    // Notre "base de données" : clé = id de l'étudiant
    private final Map<Integer, Etudiant> etudiants = new LinkedHashMap<>();

    // Add : ajoute un étudiant
    @Override
    public Etudiant add(Etudiant etudiant) {
        etudiants.put(etudiant.getId(), etudiant);
        return etudiant;
    }

    // Read : retourne le taux d'absence (en %) d'un étudiant
    @Override
    public double read(int id) {
        Etudiant e = etudiants.get(id);
        if (e == null) {
            return -1; // étudiant introuvable
        }
        return tauxAbsence(e);
    }

    // Update : met à jour un étudiant existant (null s'il n'existe pas)
    @Override
    public Etudiant update(Etudiant etudiant) {
        if (!etudiants.containsKey(etudiant.getId())) {
            return null;
        }
        etudiants.put(etudiant.getId(), etudiant);
        return etudiant;
    }

    // Delete : supprime un étudiant (true si supprimé)
    @Override
    public boolean delete(int id) {
        return etudiants.remove(id) != null;
    }

    // BlackListCreate : taux >= seuil, trié par heures d'absence décroissantes,
    // puis par nom (ordre alphabétique) en cas d'égalité
    @Override
    public List<Etudiant> blackListCreate(double seuil) {
        return etudiants.values().stream()
                .filter(e -> tauxAbsence(e) >= seuil)
                .sorted(Comparator.comparingDouble(Etudiant::getHeuresAbsence).reversed()
                        .thenComparing(Etudiant::getNom))
                .collect(Collectors.toList());
    }

    private double tauxAbsence(Etudiant e) {
        return e.getHeuresAbsence() / VOLUME_HORAIRE * 100;
    }
}