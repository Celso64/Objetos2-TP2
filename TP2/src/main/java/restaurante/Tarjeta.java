package restaurante;

public abstract class Tarjeta {

	protected Integer DESCUENTO_COMIDA;
	protected Integer DESCUENTO_BEBIDA;
	protected Integer DESCUENTO;

	public Double pagarCuenta(Cuenta cuenta, Integer propina) {
		Double precio = cuenta.getValor(DESCUENTO + DESCUENTO_BEBIDA, DESCUENTO + DESCUENTO_COMIDA, propina);
		return precio;
	}

}
