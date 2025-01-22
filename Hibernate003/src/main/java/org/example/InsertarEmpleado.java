package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class InsertarEmpleado {
    public static void main(String[] args) {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Empleado empleado = new Empleado();

        Short id = (short) 4455;
        String apellido = "Pepe";
        Float comision = (float) 10;
        Short dir = (short) 7499;
        LocalDate fecha = LocalDate.now();
        String oficio = "Vendedor";
        Float salario = (float) 1500.00;

        //Departamento
        Departamento departamento = new Departamento();
        departamento.setId((byte)10);

        Empleado emp = new Empleado(id, apellido, oficio, dir, fecha, salario, comision, departamento);

        session.save(emp);
        tx.commit();
        session.close();
        sesion.close();
    }
}
