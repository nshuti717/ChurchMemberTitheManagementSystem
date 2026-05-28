/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.church.dao;

import java.util.Collections;
import java.util.List;
import org.hibernate.*;
import rw.church.model.Member;

/**
 *
 * @author nshut
 */
public class MemberDao {

    public Member saveMember(Member obj) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.save(obj);
            tr.commit();
            ss.close();
            return obj;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Member updateMember(Member obj) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.update(obj);
            tr.commit();
            ss.close();
            return obj;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Member deleteMember(Member obj) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.delete(obj);
            tr.commit();
            ss.close();
            return obj;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Member findMemberById(Member obj) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Member found = (Member) ss.get(Member.class, obj.getId());
            ss.close();
            return found;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Member> findAllMembers() {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Member> list = ss.createQuery("SELECT m FROM Member m").list();
            ss.close();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
