/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productorconsumidor;

/**
 *
 * @author FP
 */
public class ObjetoCompartido {

    int valor;
    boolean disponible = false;

    public synchronized int get() {
        while (disponible == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.disponible = false;
        notifyAll();
        return this.valor;
    }

    public synchronized void set(int vale) {
        while (disponible == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.valor = vale;
        this.disponible = true;
        notifyAll();
    }

}
