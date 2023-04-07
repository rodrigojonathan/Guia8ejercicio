import entidades.CuentaBancaria;
import service.CuentaBancariaServicio;

public class BancoOnline  {

    public static void main (String[] args){
        CuentaBancaria cliente = new CuentaBancaria();
        CuentaBancariaServicio clienteServicio= new CuentaBancariaServicio();

        cliente = clienteServicio.crearCuenta();
        clienteServicio.ingresar();
        System.out.println(clienteServicio);


    }

}
