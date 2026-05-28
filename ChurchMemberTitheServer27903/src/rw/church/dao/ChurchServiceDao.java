/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.church.dao;

import java.util.Collections;
import java.util.List;
import org.hibernate.*;
import rw.church.model.Service;

/**
 *
 * @author nshut
 */
public class ChurchServiceDao {

    public Service saveChurchService(Service obj) {
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

    public Service updateChurchService(Service obj) {
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

    public Service deleteChurchService(Service obj) {
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

    public Service findChurchServiceById(Service obj) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Service found = (Service) ss.get(Service.class, obj.getId());
            ss.close();
            return found;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Service> findAllChurchServices() {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Service> list = ss.createQuery("SELECT s FROM Service s").list();
            ss.close();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
