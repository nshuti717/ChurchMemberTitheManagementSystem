/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.church.service.implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import rw.church.dao.UserDao;
import rw.church.model.User;
import rw.church.service.UserService;

/**
 *
 * @author nshut
 */
public class UserServiceImpl extends UnicastRemoteObject implements UserService {
    
    private static java.util.HashMap<String, String> otpStore = new java.util.HashMap<>();

    UserDao dao = new UserDao();

    public UserServiceImpl() throws RemoteException {
    }

    @Override
    public User saveUser(User obj) throws RemoteException {
        User saved = dao.saveUser(obj);
        try {
            if (obj.getMember() != null && obj.getMember().getEmail() != null) {
                rw.church.controller.EmailService.sendWelcome(
                    obj.getMember().getEmail(),
                    obj.getMember().getFullName()
                );
            }
        } catch (Exception ex) {
            System.out.println("Welcome notification skipped: " + ex.getMessage());
        }
        return saved;
    }

    @Override
    public User updateUser(User obj) throws RemoteException {
        return dao.updateUser(obj);
    }

    @Override
    public User deleteUser(User obj) throws RemoteException {
        return dao.deleteUser(obj);
    }

    @Override
    public User findUserById(User obj) throws RemoteException {
        return dao.findUserById(obj);
    }

    @Override
    public User findUserByUsername(String username) throws RemoteException {
        return dao.findUserByUsername(username);
    }

    @Override
    public List<User> findAllUsers() throws RemoteException {
        return dao.findAllUsers();
    }
    @Override
public String generateOTP(String username) throws java.rmi.RemoteException {
    rw.church.model.User user = dao.findUserByUsername(username);
    if (user == null) return null;
    String otpCode = String.valueOf((int)(Math.random() * 900000) + 100000);
    otpStore.put(username, otpCode);
    System.out.println("====================================");
    System.out.println("OTP for user [" + username + "]: " + otpCode);
    System.out.println("====================================");
    try {
        if (user.getMember() != null && user.getMember().getEmail() != null) {
            rw.church.controller.EmailService.sendOTP(
                user.getMember().getEmail(),
                user.getUsername(),
                otpCode
            );
        } else {
            System.out.println("OTP for [" + username + "]: " + otpCode);
        }
    } catch (Exception ex) {
        System.out.println("OTP for [" + username + "]: " + otpCode);
    }
    return otpCode;
}

@Override
public boolean verifyOTP(String username, String otp) throws java.rmi.RemoteException {
    String stored = otpStore.get(username);
    if (stored != null && stored.equals(otp)) {
        otpStore.remove(username); // OTP expires after one use
        return true;
    }
    return false;
} 
}
