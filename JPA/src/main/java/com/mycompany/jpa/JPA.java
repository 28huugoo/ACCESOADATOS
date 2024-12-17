/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author FP
 */
public class JPA {

    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("bibliotecaJPA  ");
        EntityManager em = emf.createEntityManager();

        //Libros libros = em.find(Libros.class, "123-456");
        System.out.println("");
        //System.out.println(libros.toString());

        List<Libros> libros = em.createNamedQuery("Libros.findAll").getResultList();
        for (Libros libro : libros) {
            System.out.println(libro.toString());
        }
        
        List<Libros> libros2 = em.createNamedQuery("SELECT 1 FROM libros 1").getResultList();
        for (Libros libro : libros2) {
            System.out.println(libro.toString());
        }
        em.close();
    }
}
