package pkg;

public class Cuenta {

	double saldo;

	public Cuenta(double saldo) {
		this.saldo = saldo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void ingresar(int i) {
		this.saldo += i;
		
	}

	public void retirar(int i) {
		this.saldo -= i;
		
	}
	
	
}
