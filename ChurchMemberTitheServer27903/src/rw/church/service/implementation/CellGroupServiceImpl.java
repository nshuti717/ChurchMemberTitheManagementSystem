/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.church.service.implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import rw.church.dao.CellGroupDao;
import rw.church.model.CellGroup;
import rw.church.service.CellGroupService;

/**
 *
 * @author nshut
 */
public class CellGroupServiceImpl extends UnicastRemoteObject implements CellGroupService {

    CellGroupDao dao = new CellGroupDao();

    public CellGroupServiceImpl() throws RemoteException {
    }

    @Override
    public CellGroup saveCellGroup(CellGroup obj) throws RemoteException {
        return dao.saveCellGroup(obj);
    }

    @Override
    public CellGroup updateCellGroup(CellGroup obj) throws RemoteException {
        return dao.updateCellGroup(obj);
    }

    @Override
    public CellGroup deleteCellGroup(CellGroup obj) throws RemoteException {
        return dao.deleteCellGroup(obj);
    }

    @Override
    public CellGroup findCellGroupById(CellGroup obj) throws RemoteException {
        return dao.findCellGroupById(obj);
    }

    @Override
    public List<CellGroup> findAllCellGroups() throws RemoteException {
        return dao.findAllCellGroups();
    }
}
