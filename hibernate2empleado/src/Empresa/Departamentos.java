package Empresa;
// Generated 06-nov-2024 9:47:02 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Departamentos generated by hbm2java
 */
public class Departamentos  implements java.io.Serializable {


     private byte deptNo;
     private String nombre;
     private String loc;
     private Set empleadoses = new HashSet(0);

    public Departamentos() {
    }

	
    public Departamentos(byte deptNo) {
        this.deptNo = deptNo;
    }
    public Departamentos(byte deptNo, String nombre, String loc, Set empleadoses) {
       this.deptNo = deptNo;
       this.nombre = nombre;
       this.loc = loc;
       this.empleadoses = empleadoses;
    }
   
    public byte getDeptNo() {
        return this.deptNo;
    }
    
    public void setDeptNo(byte deptNo) {
        this.deptNo = deptNo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getLoc() {
        return this.loc;
    }
    
    public void setLoc(String loc) {
        this.loc = loc;
    }
    public Set getEmpleadoses() {
        return this.empleadoses;
    }
    
    public void setEmpleadoses(Set empleadoses) {
        this.empleadoses = empleadoses;
    }




}

