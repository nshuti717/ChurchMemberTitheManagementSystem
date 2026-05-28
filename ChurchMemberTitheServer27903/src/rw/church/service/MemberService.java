/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.church.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import rw.church.model.Member;

/**
 *
 * @author nshut
 */
public interface MemberService extends Remote {

    Member saveMember(Member obj) throws RemoteException;
    Member updateMember(Member obj) throws RemoteException;
    Member deleteMember(Member obj) throws RemoteException;
    Member findMemberById(Member obj) throws RemoteException;
    List<Member> findAllMembers() throws RemoteException;
}