package it.epicode.be.dao;

import it.epicode.be.entities.Concert;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DAOEvent {
    private final EntityManager em;

    public DAOEvent(EntityManager em) {
        this.em = em;
    }

    public void save(Concert concert) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(concert);
        transaction.commit();
        System.out.println("Concert " + concert.getTitle() + " added correctly");
    }

    public Concert findById(long id) {
        return em.find(Concert.class, id);
    }
    public void deleteById(long id) {
        Concert found = this.findById(id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
        } else {
            System.out.println("The concert with id " + id + " is not found");
        }
    }
}
