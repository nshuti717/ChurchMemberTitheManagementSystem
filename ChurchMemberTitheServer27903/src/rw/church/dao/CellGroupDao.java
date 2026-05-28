/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.church.dao;

import java.util.Collections;
import java.util.List;
import org.hibernate.*;
import rw.church.model.CellGroup;

/**
 *
 * @author nshut
 */
public class CellGroupDao {

    public CellGroup saveCellGroup(CellGroup obj) {
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

    public CellGroup updateCellGroup(CellGroup obj) {
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

    public CellGroup deleteCellGroup(CellGroup obj) {
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

    public CellGroup findCellGroupById(CellGroup obj) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            CellGroup found = (CellGroup) ss.get(CellGroup.class, obj.getId());
            ss.close();
            return found;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<CellGroup> findAllCellGroups() {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<CellGroup> list = ss.createQuery("SELECT c FROM CellGroup c").list();
            ss.close();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
