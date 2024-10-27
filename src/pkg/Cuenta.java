package pkg;

import java.util.ArrayList;
import java.util.List;

import pkg.Movimiento.Signo;

public class Cuenta {
    
    private double saldo;
    private String numero;
    private String titular;
    private final double saldoInicial;
    private List<Movimiento> movimientos;
    private List<String> registrosErrores;

    public Cuenta(String numeroCuenta, String propietario, double saldoInicial) {
        super();
        this.numero = numeroCuenta;
        this.titular = propietario;
        this.saldo = this.saldoInicial = saldoInicial;
        this.movimientos = new ArrayList<>();
        this.registrosErrores = new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }

    public void getNumero(String numeroCuenta) {
        this.numero = numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String propietario) {
        this.titular = propietario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double balance) {
        this.saldo = balance;
    }

    public List<Movimiento> obtenerMovimientos() {
        return movimientos;
    }

    public void asignarMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public void ingreso(double cantidad) {
        setSaldo(cantidad + getSaldo());
        movimientos.add(new Movimiento(cantidad, "Depósito", Signo.H));
    }

    public boolean reintegro(double cantidad) {
        boolean exitoso = false;
        if(validarLimiteDescubierto(cantidad)) {
            setSaldo(getSaldo() - cantidad);
            movimientos.add(new Movimiento(cantidad, "Retiro", Signo.D));
            exitoso = true;
        } else {
            registrosErrores.add("\nTransacción denegada: Retiro de " + cantidad + "€");
        }
        return exitoso;
    }

    private boolean validarLimiteDescubierto(double retiro) {
        return getSaldo() - retiro >= -500;
    }

    @Override
    public String toString() {
        String resumen = "\n=========================="
                       + "\n- Número de Cuenta: " + this.numero
                       + "\nBalance inicial: " + this.saldoInicial + "€";
        for (Movimiento mov : movimientos) {
            resumen += mov.toString();
        }
        for (String error : registrosErrores) {
            resumen += error;
        }
        resumen += "\nBalance final: " + getSaldo() + "€";
        return resumen;
    }
}
