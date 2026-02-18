package com.curdop.dao;

import com.curdop.entity.Product;
import com.curdop.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDAO {

    // CREATE
    public Long addProduct(Product product) {
        Transaction tx = null;
        Long id = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            id = (Long) session.save(product);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return id;
    }

    // READ BY ID
    public Product getProductById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Product.class, id);
        }
    }

    // READ ALL
    public List<Product> getAllProducts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Product", Product.class).list();
        }
    }

    // UPDATE (price and/or quantity)
    public boolean updateProduct(Long id, Double newPrice, Integer newQuantity) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Product p = session.get(Product.class, id);
            if (p == null) return false;

            tx = session.beginTransaction();
            if (newPrice != null) p.setPrice(newPrice);
            if (newQuantity != null) p.setQuantity(newQuantity);
            session.merge(p);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    // DELETE
    public boolean deleteProduct(Long id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Product p = session.get(Product.class, id);
            if (p == null) return false;

            tx = session.beginTransaction();
            session.remove(p);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
