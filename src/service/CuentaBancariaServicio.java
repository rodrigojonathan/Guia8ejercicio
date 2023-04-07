/*Agregar la clase CuentaBancariaServicio en el paquete Servicios que contenga:
        Método para crear cuenta pidiéndole los datos al usuario.
        Método ingresar(double): recibe una cantidad de dinero a ingresar y se le sumará al saldo actual.
        Método retirar(double): recibe una cantidad de dinero a retirar y se le restara al saldo actual. Si la cuenta no tiene la cantidad de dinero a retirar se retirará el máximo posible hasta dejar la cuenta en 0.
        Método extraccionRapida: le permitirá sacar solo un 20% de su saldo. Validar que el usuario no saque más del 20%.
        Método consultarSaldo: permitirá consultar el saldo disponible en la cuenta.
        Método consultarDatos: permitirá mostrar todos los datos de la cuenta.*/


        package service;

import entidades.CuentaBancaria;

import java.util.Scanner;

//Agregar la clase CuentaBancariaServicio en el paquete Servicios
public class CuentaBancariaServicio {
private CuentaBancaria cuentaCliente = new CuentaBancaria();


//  Método para crear cuenta pidiéndole los datos al usuario.
public CuentaBancaria crearCuenta (){
    Scanner leer = new Scanner (System.in);
    System.out.println("Ingrese numero de cuenta");
    cuentaCliente.setNuemeroCuenta(leer.nextInt());
    System.out.println("Ingrese dni del cliente");
    cuentaCliente.setDniCliente(leer.nextInt());
    System.out.println("Ingrese saldo actual");
    cuentaCliente.setSaldoActual(leer.nextDouble());

    return cuentaCliente;
}


//Método ingresar(double): recibe una cantidad de dinero a ingresar y se le sumará al saldo actual.

    public void ingresar (){
    Scanner leer= new Scanner(System.in);
        System.out.println("Ingrese cantidad a ingresar:");
        cuentaCliente.setSaldoActual(cuentaCliente.getSaldoActual()+leer.nextDouble());

    }

// Método retirar(double): recibe una cantidad de dinero a retirar y se le restara al saldo actual.
// Si la cuenta no tiene la cantidad de dinero a retirar se retirará el máximo posible hasta dejar la cuenta en 0.

    public void retirar (){
    Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese cantidad a retirar");
        double cantidad = leer.nextDouble();
    if (cantidad<= cuentaCliente.getSaldoActual()){
        cuentaCliente.setSaldoActual(cuentaCliente.getSaldoActual()- cantidad);
    }  else {
        cuentaCliente.setSaldoActual(leer.nextDouble());
        cuentaCliente.setSaldoActual(0);
        System.out.println("No posea fondos suficientes, se retirar el dinero disponible");
    }
    }

//Método extraccionRapida: le permitirá sacar solo un 20% de su saldo. Validar que el usuario no saque más del 20%.

    public double extraccionRapida (){
    Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese cantidad a retirar:");
        double cantidad = leer.nextDouble();
        if(cantidad <= (cuentaCliente.getSaldoActual()*20/100)) {
            cuentaCliente.setSaldoActual(cuentaCliente.getSaldoActual()- cantidad);
            return cuentaCliente.getSaldoActual();
        } else {
            System.out.println("¡Lo sentimos!\n Solo puede retirar el 20% de su saldo actual en una extraccion rapidad.");
        return extraccionRapida();
        }
    }

//Método consultarSaldo: permitirá consultar el saldo disponible en la cuenta.

    public double consultarSaldo(){
    return cuentaCliente.getSaldoActual();
    }

//Método consultarDatos: permitirá mostrar todos los datos de la cuenta

    public String consultarDatos (){
    return cuentaCliente.toString();
    }
}
