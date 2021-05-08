package hu.unideb.inf.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaCasinoDAO implements SFMCasinoDAO{

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();


    @Override
    public void saveUser(User2 user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteUser(User2 user) {
        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateUser(User2 user) {
        deleteUser(user);
        saveUser(user);
    }

    @Override
    public List<User2> getUser() {
        TypedQuery<User2> query = entityManager.createQuery(
                "SELECT user FROM User2 user", User2.class);
        List<User2> users = query.getResultList();
        return users;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
