/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.church.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import rw.church.model.Service;

/**
 *
 * @author nshut
 */
public interface ChurchServiceService extends Remote {

    Service saveChurchService(Service obj) throws RemoteException;
    Service updateChurchService(Service obj) throws RemoteException;
    Service deleteChurchService(Service obj) throws RemoteException;
    Service findChurchServiceById(Service obj) throws RemoteException;
    List<Service> findAllChurchServices() throws RemoteException;
}

