package com.mycompany.micajeroa;
import java.util.ArrayList;
import java.util.List;

public class MiCajeroA {

    public static void main(String[] args) {
        // Cliente 1
        
        Cliente cliente1 = new Cliente();
        cliente1.setPin(1111);
        
        Cuenta cuenta1c1 = new Cuenta();
        cuenta1c1.setNombre("CuentaCorriente");
        cuenta1c1.setSaldo(100000);
        cuenta1c1.setId(1);
        Cuenta cuenta2c1 = new Cuenta();
        cuenta2c1.setNombre("CuentaVista");
        cuenta2c1.setSaldo(5000);
        cuenta2c1.setId(2);
        
        List cuentas = new ArrayList();
        cuentas.add(cuenta1c1);
        cuentas.add(cuenta2c1);
        cliente1.setCuentas((ArrayList<Cuenta>) cuentas);

        
        // Inicio el Cajero
        
        Cajero cajero = new Cajero();
        cajero.iniciar(cliente1);   
        
    }
}
