package org.example;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "departamentos")
public class Departamento {
    @Id
    @Column(name = "dept_no", nullable = false)
    private Byte id;

    @Column(name = "nombre", length = 15)
    private String nombre;

    @Column(name = "loc", length = 15)
    private String loc;

    @OneToMany(mappedBy = "deptNo")
    private Set<org.example.Empleado> empleados = new LinkedHashSet<>();

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public String getDnombre() {
        return nombre;
    }

    public void setDnombre(String dnombre) {
        this.nombre = dnombre;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Set<org.example.Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<org.example.Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", dnombre='" + nombre + '\'' +
                ", loc='" + loc + '\'' +
                ", empleados=" + empleados +
                '}';
    }
}