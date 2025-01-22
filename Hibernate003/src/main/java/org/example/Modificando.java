package org.example;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class Modificando {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hqlModif = "update Empleado set salario = :nuevoSal where apellido = :ape";
        Query q1 = session.createQuery(hqlModif);
        q1.setParameter("nuevoSal", (float)2500.4);
        q1.setParameter("ape", "GIL");
        int filasModf = q1.executeUpdate();
        session.close();
    }
}

