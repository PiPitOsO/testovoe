package com.example.testovoe.repository;

import com.example.testovoe.entity.Connect;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class MyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void neww(String client1, String client2) {
        var connect = Connect.builder()
                .client1(client1)
                .client2(client2)
                .build();

        entityManager.persist(connect);
    }

    public List get() {
        Query query = entityManager.createQuery("SELECT c.client1, COUNT (c.client1), c.client2 FROM Connect c GROUP BY c.client1, c.client2");
        return query.getResultList();
    }
    public List getMax() {
        Query query = entityManager.createQuery("SELECT DISTINCT COUNT (c.client1), c.client1 FROM Connect c GROUP BY c.client1");
        return query.getResultList();
    }
    public List getMin() {
        Query query = entityManager.createQuery("SELECT DISTINCT min (c.client1), c.client1 FROM Connect c GROUP BY c.client1");
        return query.getResultList();
    }
    public List getAvg() {
        Query query = entityManager.createQuery("SELECT DISTINCT COUNT (c.client1), c.client1 FROM Connect c GROUP BY c.client1");
        return query.getResultList();
    }
}
