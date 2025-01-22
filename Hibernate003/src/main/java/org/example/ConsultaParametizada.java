package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class ConsultaParametizada {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        String hql = "from Empleado e where e.id=:numEmpleado";
        Query query = session.createQuery(hql);

        System.out.println("Dame el número de empleado que quiere consultar");
        query.setParameter("numEmpleado", (short) 7369);
        Empleado emp = (Empleado) query.uniqueResult();
        System.out.println(emp);

        System.out.println("2DA SENTENCIA PARAMETIZADA");
/*
        String hql2 = "from Empleado emp where emp.departamentos.deptNo = :ndep and emp.oficio = :ofi";
        Query query2 = session.createQuery(hql2);
        query2.setParameter("ndep", (short) 30);
        query2.setParameter("ofi", "VENDEDOR");

        List<Empleado> lista = query2.list();
        Iterator<Empleado> iterator = lista.iterator();

        while (iterator.hasNext()) {
            Empleado emp2 = (Empleado) iterator.next();
            System.out.println(emp2);
        }
*/
        String hql3 = "from Empleado e, Departamento d where e.deptNo.id = d.id order by apellido";
        Query cons = session.createQuery(hql3);
        Iterator q = cons.list().iterator();
        while (q.hasNext()) {

            Object[] par = (Object[]) q.next();
            Empleado em = (Empleado) par[0];
            Departamento de = (Departamento) par[1];
            System.out.println(em.getApellido() + " " + em.getSalario() + " " + de.getDnombre() + " " + de.getLoc());
        }

        String hql4 = "Select e.deptNo.id, avg(salario), count(id) from Empleado e group by e.deptNo.id";
        Query cons2 = session.createQuery(hql4);
        Iterator iter2 = cons2.list().iterator();

        while (iter2.hasNext()) {
            Object[] par2 = (Object[]) iter2.next();
            Byte depar = (Byte) par2[0];
            Double media = (Double) par2[1];
            Long cuenta = (Long) par2[2];
            System.out.println("Departamento: "+depar + " Media: " + media + " NEmp: " + cuenta);
        }

        session.close();
        sf.close();
    }
}
