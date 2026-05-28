/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.church.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import rw.church.model.Contribution;

/**
 *
 * @author nshut
 */
public interface ContributionService extends Remote {

    Contribution saveContribution(Contribution obj) throws RemoteException;
    Contribution updateContribution(Contribution obj) throws RemoteException;
    Contribution deleteContribution(Contribution obj) throws RemoteException;
    Contribution findContributionById(Contribution obj) throws RemoteException;
    List<Contribution> findAllContributions() throws RemoteException;
    java.util.List<rw.church.model.Contribution> getContributionsByMonth(int month, int year) throws java.rmi.RemoteException;
} 