package it.epicode.be;

import it.epicode.be.dao.DAOEvent;
import it.epicode.be.entities.Concert;
import it.epicode.be.enums.ConcertType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3-D2");
        public static void main(String[] args) {
            System.out.println("Concert W3-D2");
            EntityManager em = emf.createEntityManager();

            DAOEvent sd = new DAOEvent(em);
            Concert pinkFloyd = new Concert("Pink Floyd", "01-24-2024", "Best Concert Ever Made", ConcertType.PUBLIC, 75000);
            Concert abba = new Concert("Abba", "01-25-2024", "Experience Swedish Music Live", ConcertType.PRIVATE, 75000);
            Concert martinGarrix = new Concert("Martin Garrix", "07-25-2024", "Live Techno Music Live From Belgium", ConcertType.PRIVATE, 70000);

            sd.save(pinkFloyd);
            sd.save(abba);
            sd.save(martinGarrix);

            long id = 2;
            Concert abbaFromDB = sd.findById(id);
            if (abbaFromDB != null) {
                System.out.println(abbaFromDB);
            } else {
                System.out.println("Concert with id " + id + " not found");
            }
            sd.deleteById(5);

            em.close();
            emf.close();
        }
}


