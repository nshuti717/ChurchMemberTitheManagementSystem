/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.church.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import rw.church.model.User;

/**
 *
 * @author nshut
 */
public interface UserService extends Remote {

    User saveUser(User obj) throws RemoteException;
    User updateUser(User obj) throws RemoteException;
    User deleteUser(User obj) throws RemoteException;
    User findUserById(User obj) throws RemoteException;
    User findUserByUsername(String username) throws RemoteException;
    List<User> findAllUsers() throws RemoteException;
    String generateOTP(String username) throws java.rmi.RemoteException;
boolean verifyOTP(String username, String otp) throws java.rmi.RemoteException;

}
