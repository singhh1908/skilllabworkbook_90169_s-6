package com.curdop;

import com.curdop.entity.ProductAuto;
import com.curdop.entity.ProductIdentity;
import com.curdop.entity.ProductSequence;
import com.curdop.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Run this to observe ID generation differences.
 * It inserts 1 row into each table and prints generated IDs.
 */
public class StrategyDemo {

    public static void runOnce() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            ProductAuto a = new ProductAuto("AUTO Demo", 10.0);
            ProductIdentity i = new ProductIdentity("IDENTITY Demo", 20.0);
            ProductSequence s = new ProductSequence("SEQUENCE Demo", 30.0);

            session.persist(a);
            session.persist(i);
            session.persist(s);

            tx.commit();

            System.out.println("\n--- ID Strategy Demo Results ---");
            System.out.println("AUTO id      = " + a.getId());
            System.out.println("IDENTITY id  = " + i.getId());
            System.out.println("SEQUENCE id  = " + s.getId());
            System.out.println("--------------------------------\n");
        }
    }
}
