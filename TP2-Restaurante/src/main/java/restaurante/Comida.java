package restaurante;

import java.util.Objects;

public class Comida extends Producto {

	public Comida(Double valor) {
		super.valor = Objects.requireNonNull(valor);
	}

	@Override
	public Double devolverValor(Integer descuento) {
		Double res = this.valor;
		res -= this.valor * ((double) descuento / 100);

		return (res);
	}

}
