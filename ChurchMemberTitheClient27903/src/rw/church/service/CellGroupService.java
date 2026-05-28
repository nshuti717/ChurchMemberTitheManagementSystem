/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.church.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import rw.church.model.CellGroup;

/**
 *
 * @author nshut
 */
public interface CellGroupService extends Remote {

    CellGroup saveCellGroup(CellGroup obj) throws RemoteException;
    CellGroup updateCellGroup(CellGroup obj) throws RemoteException;
    CellGroup deleteCellGroup(CellGroup obj) throws RemoteException;
    CellGroup findCellGroupById(CellGroup obj) throws RemoteException;
    List<CellGroup> findAllCellGroups() throws RemoteException;
}
