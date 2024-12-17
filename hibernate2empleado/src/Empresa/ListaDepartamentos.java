package Empresa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author FP
 */
public class ListaDepartamentos {

    public static void main(String[] args) {

        System.out.println("");
        System.out.println("==========================================");
        System.out.println("");

        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Query q = session.createQuery("from Departamentos");
        q.setFetchSize(10);
        Iterator iter = q.iterate();

        //List<Departamentos> lista = q.list();
        //Obtenemos un Iterador y recorremos la lista
        //Iterator<Departamentos> iter = lista.iterator();
        //System.out.println("Número de departamentos: " + lista.size());
        while (iter.hasNext()) {

            //Extraer el objeto
            Departamentos depar = (Departamentos) iter.next();
            System.out.println(depar.getDeptNo() + ", " + depar.getNombre());

        }

        System.out.println("");
        System.out.println("==========================================");
        System.out.println("");

        Query q2 = session.createQuery("from Empleados as e where e.departamentos.deptNo = 20");
        List<Empleados> lista2 = q2.list();
        Iterator<Empleados> iter2 = lista2.iterator();

        while (iter2.hasNext()) {

            Empleados emp = (Empleados) iter2.next();
            System.out.println(emp.getApellido() + ", " + emp.getSalario());

        }

        System.out.println("");
        System.out.println("==========================================");
        System.out.println("");

        String hql = "from Empleados where empNo = :numemple";
        Query q3 = session.createQuery(hql);
        q3.setParameter("numemple", (short) 7369);
        Empleados emple = (Empleados) q3.uniqueResult();
        System.out.println(emple.getApellido() + ", " + emple.getOficio());

        System.out.println("");
        System.out.println("==========================================");
        System.out.println("");

        String hql2 = "from Empleados emp where emp.departamentos.deptNo = :ndep and emp.oficio = :ofi";
        Query q4 = session.createQuery(hql2);
        q4.setParameter("ndep", (byte) 30);
        q4.setParameter("ofi", "VENDEDOR");

        //recorremos y mostramos
        List<Empleados> lista = q4.list();
        Iterator<Empleados> iter4 = lista.iterator();

        while (iter4.hasNext()) {
            Empleados emp = (Empleados) iter4.next();
            System.out.println(emp.getApellido() + ", " + emp.getSalario());
        }

        System.out.println("");
        System.out.println("==========================================");
        System.out.println("");

        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM--dd");
        String strFecha = "1991-02-22";
        Date fecha = null;
        try {
            fecha = formatoDelTexto.parse(strFecha);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        String hql5 = "from Empleados where fechaAlt = :fechalata";

        Query q5 = session.createQuery(hql5);
        q5.setDate("fechalta", fecha);

        List<Byte> numeros = new ArrayList<Byte>();
        numeros.add((byte) 10);
        numeros.add((byte) 20);

        String hql6 = "from Empleados emp where emp.departamentos.deptNo in (:listadep) order by emp.departamentos.depNo";
        Query q6 = session.createQuery(hql6);
        q6.setParameterList("listadep", numeros);

        System.out.println("==========================================");

        String hql7 = "from Empleados e, Departamentos d where e.departamentos.deptNo = d.deptNo order by Apellido";
        Query cons = session.createQuery(hql7);
        Iterator q7 = cons.iterate();
        while(q7.hasNext()){
        Object[] par = (Object[]) q7.next();
        Empleados em = (Empleados) par[0];
        Departamentos de = (Departamentos) par[1];
            System.out.println(em.getApellido()+", "+em.getSalario()+","+de.getNombre()+" "+de.getLoc());
        }  
        
        session.close();
        sesion.close();

    }
}
