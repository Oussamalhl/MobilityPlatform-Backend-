package tn.esprit.stage.services;



import tn.esprit.stage.entities.Candidature;

import java.util.List;

public interface IEmailingServiceImpl {
    void ConfirmationMail( Candidature c) throws Exception;
    void PreselectionMail( Candidature c) throws Exception;

}
