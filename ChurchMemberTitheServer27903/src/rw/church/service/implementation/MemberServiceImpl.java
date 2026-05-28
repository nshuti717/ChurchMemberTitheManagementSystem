/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.church.service.implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import rw.church.dao.MemberDao;
import rw.church.model.Member;
import rw.church.service.MemberService;

/**
 *
 * @author nshut
 */
public class MemberServiceImpl extends UnicastRemoteObject implements MemberService {

    MemberDao dao = new MemberDao();

    public MemberServiceImpl() throws RemoteException {
    }

    @Override
    public Member saveMember(Member obj) throws RemoteException {
        return dao.saveMember(obj);
    }

    @Override
    public Member updateMember(Member obj) throws RemoteException {
        return dao.updateMember(obj);
    }

    @Override
    public Member deleteMember(Member obj) throws RemoteException {
        return dao.deleteMember(obj);
    }

    @Override
    public Member findMemberById(Member obj) throws RemoteException {
        return dao.findMemberById(obj);
    }

    @Override
    public List<Member> findAllMembers() throws RemoteException {
        return dao.findAllMembers();
    }
}


