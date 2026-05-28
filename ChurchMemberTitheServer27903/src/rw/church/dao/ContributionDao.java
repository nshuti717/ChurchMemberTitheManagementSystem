/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.church.dao;

import java.util.Collections;
import java.util.List;
import org.hibernate.*;
import rw.church.model.Contribution;

/**
 *
 * @author nshut
 */
public class ContributionDao {

    public Contribution saveContribution(Contribution obj) {
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
      public java.util.List<rw.church.model.Contribution> findContributionsByMonth(int month, int year) {
    try {
        org.hibernate.Session ss = rw.church.dao.HibernateUtil.getSessionFactory().openSession();
        java.util.List<rw.church.model.Contribution> list = ss.createQuery(
            "SELECT c FROM Contribution c WHERE MONTH(c.contributionDate) = :month AND YEAR(c.contributionDate) = :year")
            .setParameter("month", month)
            .setParameter("year", year)
            .list();
        ss.close();
        return list;
    } catch (Exception ex) { ex.printStackTrace(); }
    return java.util.Collections.EMPTY_LIST;
} 
    
    
    
    
    
    
    
    
    
    public Contribution updateContribution(Contribution obj) {
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

    public Contribution deleteContribution(Contribution obj) {
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

    public Contribution findContributionById(Contribution obj) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Contribution found = (Contribution) ss.get(Contribution.class, obj.getId());
            ss.close();
            return found;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Contribution> findAllContributions() {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Contribution> list = ss.createQuery("SELECT c FROM Contribution c").list();
            ss.close();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

   
}
