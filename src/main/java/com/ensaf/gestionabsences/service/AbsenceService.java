package com.ensaf.gestionabsences.service;

import com.ensaf.gestionabsences.model.Etudiant;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface AbsenceService {

    @WebMethod
    Etudiant add(@WebParam(name = "etudiant") Etudiant etudiant);

    @WebMethod
    double read(@WebParam(name = "id") int id);

    @WebMethod
    Etudiant update(@WebParam(name = "etudiant") Etudiant etudiant);

    @WebMethod
    boolean delete(@WebParam(name = "id") int id);

    @WebMethod
    List<Etudiant> blackListCreate(@WebParam(name = "seuil") double seuil);
}
