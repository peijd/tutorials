package com.ripjava.jpa.firststep;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AuthorTest {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("cdbookstorePU");
    private static EntityManager em;
    private static EntityTransaction tx;

    @BeforeAll
    static void init() {
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @AfterAll
    static void close() {
        if (em != null) em.close();
    }

    @Test
    void shouldCreateAnAuthor() {

        Author author = new Author().firstName("Adams").lastName("Douglas");
        assertNull(author.getId(), "Id should be null");

        tx.begin();
        em.persist(author);
        tx.commit();

        assertNotNull(author.getId(), "Id should not be null");
    }

    @Test
    void shouldNotCreateAnAuthorWithNullFirstname() {
        Author author = new Author().firstName(null);

        tx.begin();
        em.persist(author);
        assertThrows(RollbackException.class, () -> tx.commit());
    }
}
