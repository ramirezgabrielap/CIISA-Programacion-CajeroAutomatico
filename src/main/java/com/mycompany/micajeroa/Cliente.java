package com.mycompany.micajeroa;
import java.util.ArrayList;

public class Cliente {
    int pin;
    ArrayList<Cuenta> cuentas = new ArrayList<>();

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    } 
}
