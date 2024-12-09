package hilos;

public class Saldo{
	private double saldo;

	public Saldo(double saldoInicial) {
		this.saldo = saldoInicial;
	}

	public synchronized double getSaldo() {
		return saldo;
	}

	public synchronized  void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public synchronized boolean saldoSuficienteTrans(double imporNomina) {
		return saldo>imporNomina;
	}

}
