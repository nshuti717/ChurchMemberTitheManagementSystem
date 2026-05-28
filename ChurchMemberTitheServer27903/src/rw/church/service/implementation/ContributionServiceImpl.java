/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.church.service.implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import rw.church.dao.ContributionDao;
import rw.church.model.Contribution;
import rw.church.service.ContributionService;

/**
 *
 * @author nshut
 */
public class ContributionServiceImpl extends UnicastRemoteObject implements ContributionService {

    ContributionDao dao = new ContributionDao();

    public ContributionServiceImpl() throws RemoteException {
    }

    @Override
public rw.church.model.Contribution saveContribution(rw.church.model.Contribution obj) throws java.rmi.RemoteException {
    
    // 1. Save it to the database first
    rw.church.model.Contribution savedObj = dao.saveContribution(obj);
    
    // 2. Send ActiveMQ notification
    String notifMessage = "Notification: " + 
        (obj.getMember() != null ? obj.getMember().getFullName() : "Unknown") + 
        " recorded a contribution of " + obj.getAmount() + " RWF on " + 
        (obj.getContributionDate() != null ? obj.getContributionDate().toString() : "unknown date");
    rw.church.controller.NotificationProducer.sendNotification(notifMessage);
    
    // 3. Return the saved object
    return savedObj;
} 

    @Override
    public Contribution updateContribution(Contribution obj) throws RemoteException {
        return dao.updateContribution(obj);
    }

    @Override
    public Contribution deleteContribution(Contribution obj) throws RemoteException {
        return dao.deleteContribution(obj);
    }

    @Override
    public Contribution findContributionById(Contribution obj) throws RemoteException {
        return dao.findContributionById(obj);
    }

    @Override
    public List<Contribution> findAllContributions() throws RemoteException {
        return dao.findAllContributions();
    }
    @Override
public java.util.List<rw.church.model.Contribution> getContributionsByMonth(int month, int year) throws java.rmi.RemoteException {
    return dao.findContributionsByMonth(month, year);
} 
}
