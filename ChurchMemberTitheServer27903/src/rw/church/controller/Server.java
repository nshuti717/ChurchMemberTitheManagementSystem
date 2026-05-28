/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.church.controller;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rw.church.service.implementation.*;

/**
 *
 * @author nshut
 */
public class Server {

    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            Registry theRegistry = LocateRegistry.createRegistry(5000);
            theRegistry.rebind("CellGroupService", new CellGroupServiceImpl());
            theRegistry.rebind("MemberService", new MemberServiceImpl());
            theRegistry.rebind("ContributionService", new ContributionServiceImpl());
            theRegistry.rebind("ChurchServiceService", new ChurchServiceServiceImpl());
            theRegistry.rebind("UserService", new UserServiceImpl());
            System.out.println("Server started on port 5000");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}   

