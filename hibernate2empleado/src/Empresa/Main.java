/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empresa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.time.Clock.system;
import java.util.Date;
import org.hibernate.*;

/**
 *
 * @author FP
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.openSession();
        Transaction tx = sesion.beginTransaction();

        //Departamentos d = new Departamentos((byte) 62, "MARKETING", "GUADALAJARA");
        Departamentos d = new Departamentos((byte) 62);
        String formatofecha = "1992/08/23";
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
        Date fecha = formatoFecha.parse(formatofecha);
        //java.sql.Date formatoFechaSQL = new java.sql.Date(fecha.getTime());
        Empleados e = new Empleados((short) 4455, d, "GALLARDO", "VENDEDOR", (short) 7499, fecha, (float) 1500, (float) 100);
        //sesion.save(d);
        sesion.save(e);
        tx.commit();
        System.out.println("Registro insertado");
        sesion.close();
        sessionFactory.close();
    }

}
