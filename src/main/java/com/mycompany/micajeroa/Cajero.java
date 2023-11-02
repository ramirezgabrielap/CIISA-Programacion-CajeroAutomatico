package com.mycompany.micajeroa;
import java.util.Scanner;

public class Cajero {
    final int limiteDiario = 200000;

    public void iniciar(Cliente cliente1){
        Scanner sc = new Scanner(System.in);
        String desicion;
        int opcion;
        int monto = 0;
        int pin;
        int contadorPin = 0;

        do{
            if (contadorPin >= 3) {
                System.out.println("Ha excedido el máximo de intentos");
                System.out.println("TARJETA TEMPORALMENTE BLOQUEADA");
                System.out.println("Para más información, favor contactar a la banca en línea al 6006003300");
                System.exit(0);
            }
            System.out.println("INGRESE SU CONTRASEÑA DE 4 DÍGITOS:");
            pin = sc.nextInt();
            contadorPin += 1;
        } while (cliente1.getPin() != pin);   
       
        do { 
            System.out.println("----------------------------------------");
            System.out.println("Seleccione una opción:");
            System.out.println("1.- Girar Dinero");
            System.out.println("2.- Abonar Dinero");
            System.out.println("3.- Consulta de Saldo");
            System.out.println("4.- Cambio de Clave de Seguridad");
            System.out.println("5.- Transferencia entre mis productos");
            System.out.println("6.- Transferencia a Terceros");
            System.out.println("7.- Salir");
            System.out.println("----------------------------------------");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1: 
                    System.out.println("Indique desde qué cuenta desea Girar");
                    for (Cuenta cuenta : cliente1.getCuentas()){
                        System.out.println(cuenta.getId() + ".- " + cuenta.getNombre());
                    }
                    opcion = sc.nextInt();
                    for (Cuenta cuenta : cliente1.getCuentas()){
                        if (cuenta.getId() == opcion){
                            System.out.println("Monto cuenta " + cuenta.getSaldo());
                            System.out.println("Indique el monto a Girar (máximo $200.000)");
                            monto = sc.nextInt();
                            if (monto > cuenta.getSaldo() || monto <= 0 || monto > limiteDiario) {
                                System.out.println("Monto Inválido");
                                System.exit(0);
                            }
                            System.out.println("Procesando...");
                            cuenta.setSaldo(cuenta.getSaldo() - monto);
                            System.out.println("nuevo saldo "+ cuenta.getSaldo());
                            System.out.println("RETIRE SU DINERO");
                            System.out.println("RETIRE SU COMPROBANTE");
                        }
                    }
                     break;
                case 2:
                    System.out.println("Indique a qué cuenta desea Abonar");
                    for (Cuenta cuenta : cliente1.getCuentas()){
                        System.out.println(cuenta.getId() + ".- " + cuenta.getNombre());
                    }
                    opcion = sc.nextInt();
                    for (Cuenta cuenta : cliente1.getCuentas()){
                        if (cuenta.getId() == opcion){
                            System.out.println("Monto actual en la cuenta: " + cuenta.getSaldo());
                            System.out.println("Indique el monto a Abonar (máximo $200.000 por transacción)");
                            monto = sc.nextInt();
                            if (monto <= 0 || monto > limiteDiario) {
                                System.out.println("Monto Inválido");
                                System.exit(0);
                            }
                            System.out.println("Organice los billetes y póngalos en el puerto de depósito:");
                            System.out.println(" ");
                            System.out.println("Procesando...");
                            System.out.println(" ");
                            cuenta.setSaldo(cuenta.getSaldo() + monto);
                            System.out.println("ABONO REALIZADO CON ÉXITO");
                            System.out.println("nuevo saldo " + cuenta.getSaldo());
                            System.out.println("RETIRE SU COMPROBANTE");
                        }
                    }
                    break;
                case 3: 
                    System.out.println("Indique qué cuenta desea Consultar");
                    for (Cuenta cuenta : cliente1.getCuentas()){
                        System.out.println(cuenta.getId() + ".- " + cuenta.getNombre());
                    }
                    opcion = sc.nextInt();
                    for (Cuenta cuenta : cliente1.getCuentas()){
                        if (cuenta.getId() == opcion){
                            System.out.println("Monto actual en la cuenta es de : " + cuenta.getSaldo());
                        }
                    }
                    break;
                case 4: 
                    System.out.println("Para continuar, ingrese su contraseña Actual de 4 dígitos: ");
                    pin = sc.nextInt();
                    if (cliente1.getPin() != pin) {
                        System.out.println("Pin inválido.");
                        System.exit(0);
                    }
                    System.out.println("Ingrese su nueva contraseña de 4 dígitos: ");
                    int pin1= sc.nextInt();
                    System.out.println("Ingrese nuevamente la nueva contraseña de 4 dígitos: ");
                    int pin2= sc.nextInt();
                    if (pin1 != pin2){
                        System.out.println("Error, las contraseñas no coinciden");
                        System.exit(0);
                    }
                    System.out.println(" ");
                    cliente1.setPin(pin2);
                    System.out.println("Su contraseña, ha sido modificada con éxito");
                    System.out.println("RETIRE SU COMPROBANTE");
                    break;
                case 5: 
                    System.out.println("Indique desde qué cuenta desea Transferir el saldo: ");
                    for (Cuenta cuenta : cliente1.getCuentas()){
                        System.out.println(cuenta.getId() + ".- " + cuenta.getNombre());
                    }
                    opcion = sc.nextInt();
                    for (Cuenta cuenta : cliente1.getCuentas()){
                        if (cuenta.getId() == opcion){
                            System.out.println("El monto máximo para transferir es de " + cuenta.getSaldo());
                            System.out.println("Indique el monto a Transferir");
                            monto = sc.nextInt();
                            if (monto > cuenta.getSaldo() || monto <= 0) {
                                System.out.println("Monto Inválido");
                                System.exit(0);
                            }
                            System.out.println("Procesando...");
                            cuenta.setSaldo(cuenta.getSaldo() - monto);
                        }
                    }
                    System.out.println("Indique a qué cuenta desea realizar la transferencia: ");
                    for (Cuenta cuenta : cliente1.getCuentas()){
                        if (cuenta.getId() != opcion){
                            System.out.println(cuenta.getId() + ".- " + cuenta.getNombre());
                        }
                    }
                    opcion = sc.nextInt();
                    for (Cuenta cuenta : cliente1.getCuentas()){
                        if (cuenta.getId() == opcion){
                            System.out.println(" ");
                            System.out.println("Procesando...");
                            System.out.println(" ");
                            cuenta.setSaldo(cuenta.getSaldo() + monto);
                            System.out.println("Transacción realizada con éxito");
                            System.out.println("nuevo saldo "+ cuenta.getSaldo());
                            System.out.println("RETIRE SU COMPROBANTE");
                        }
                    }             
                    break;
                case 6: 
                    System.out.println("Indique qué cuenta usará para transferir: ");
                    for (Cuenta cuenta : cliente1.getCuentas()){
                        System.out.println(cuenta.getId() + ".- " + cuenta.getNombre());
                    }
                    opcion = sc.nextInt();
                    for (Cuenta cuenta : cliente1.getCuentas()){
                        if (cuenta.getId() == opcion){
                            System.out.println("Monto máximo para transferir: " + cuenta.getSaldo());
                            System.out.println("Indique el monto a transferir");
                            monto = sc.nextInt();
                            if (monto > cuenta.getSaldo() || monto <= 0) {
                                System.out.println("Monto Inválido");
                                System.exit(0);
                            }
                            System.out.println("Indique el número de cuenta del cliente al que desea transferir: ");
                            String cuentaOtro = sc.next();
                            System.out.println(" ");
                            System.out.println("Procesando...");
                            System.out.println(" ");
                            cuenta.setSaldo(cuenta.getSaldo() - monto);
                            System.out.println("TRANSACCIÓN EXITOSA");
                            System.out.println("nuevo saldo "+ cuenta.getSaldo());
                            System.out.println("RETIRE SU COMPROBANTE");
                        }
                    }
                    break;  
                case 7: 
                    System.out.println("Seleccionó la opción para salir del sistema.");
                    System.out.println("Retire su tarjeta");
                    System.out.println("Gracias por preferirnos");
                    System.exit(0);
                    break;  
                default:
                    System.out.println("Ingrese una opción válida");
            }
 
            System.out.println("----------------------------------------");
            System.out.println("¿DESEA REALIZAR OTRA OPERACIÓN? ");
            System.out.println(" 1 = SI / 0 = NO ");
            System.out.println("----------------------------------------");
            desicion = sc.next();
        } while (desicion.equals("1") || desicion.equals("SI") || desicion.equals("si"));
        
        System.out.println("Gracias por preferirnos");
        System.out.println("Retire su tarjeta");
  
    }
}       