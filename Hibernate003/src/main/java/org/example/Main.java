package org.example;

import org.hibernate.*;

public class Main {
    public static void main(String[] args) {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("Inserto una fila en la tabla DEPARTAMENTO");

        Departamento departamento = new Departamento();
        departamento.setId((byte) 63);
        departamento.setDnombre("Marketing");
        departamento.setLoc("Guadalajara");

        session.persist(departamento);
        tx.commit();
        session.close();
        sesion.close();
    }
}