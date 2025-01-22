package org.example;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ConsultasHQL {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        String hql = "from Departamento";
        Query query = session.createQuery(hql);
        List<Departamento> lista = query.list();
        for (Departamento departamento : lista){
            System.out.println(departamento);
        }
        String hql2 = "from Empleado as e where e.deptNo.id=20";
        Query query2 = session.createQuery(hql2);
        session.close();
        sf.close();
    }
}
