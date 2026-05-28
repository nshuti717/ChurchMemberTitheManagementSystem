/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.church.service.implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import rw.church.dao.ChurchServiceDao;
import rw.church.model.Service;
import rw.church.service.ChurchServiceService;

/**
 *
 * @author nshut
 */
public class ChurchServiceServiceImpl extends UnicastRemoteObject implements ChurchServiceService {

    ChurchServiceDao dao = new ChurchServiceDao();

    public ChurchServiceServiceImpl() throws RemoteException {
    }

    @Override
    public Service saveChurchService(Service obj) throws RemoteException {
        return dao.saveChurchService(obj);
    }

    @Override
    public Service updateChurchService(Service obj) throws RemoteException {
        return dao.updateChurchService(obj);
    }

    @Override
    public Service deleteChurchService(Service obj) throws RemoteException {
        return dao.deleteChurchService(obj);
    }

    @Override
    public Service findChurchServiceById(Service obj) throws RemoteException {
        return dao.findChurchServiceById(obj);
    }

    @Override
    public List<Service> findAllChurchServices() throws RemoteException {
        return dao.findAllChurchServices();
    }
}
