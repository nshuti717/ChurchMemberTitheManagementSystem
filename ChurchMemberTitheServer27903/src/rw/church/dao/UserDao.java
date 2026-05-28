/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.church.dao;

import java.util.Collections;
import java.util.List;
import org.hibernate.*;
import rw.church.model.User;

/**
 *
 * @author nshut
 */
public class UserDao {

    public User saveUser(User obj) {
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

    public User updateUser(User obj) {
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

    public User deleteUser(User obj) {
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

    public User findUserById(User obj) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            User found = (User) ss.get(User.class, obj.getId());
            ss.close();
            return found;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public User findUserByUsername(String username) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            User found = (User) ss.createQuery(
                "SELECT u FROM User u WHERE u.username = :username")
                .setParameter("username", username)
                .uniqueResult();
            ss.close();
            return found;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<User> findAllUsers() {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<User> list = ss.createQuery("SELECT u FROM User u").list();
            ss.close();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
