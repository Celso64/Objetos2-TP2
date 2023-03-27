package restaurante;

public class Bebida extends Producto {

	public Bebida(Double valor) {
		super.valor = valor;
	}

	@Override
	public Double devolverValor(Integer descuento) {

		Double res = this.valor;
		res -= this.valor * ((double) descuento / 100);

		return (res);
	}
}
