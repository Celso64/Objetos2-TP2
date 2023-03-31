package restaurante;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cuenta {

	private Ticket registro;

	public static final Integer PROPINA_BAJA = 2;
	public static final Integer PROPINA_MEDIA = 3;
	public static final Integer PROPINA_ALTA = 5;

	private List<Comida> comidas;
	private List<Bebida> bebidas;

	public Cuenta(Ticket registro) {
		this.registro = Objects.requireNonNull(registro);
		this.bebidas = new ArrayList<Bebida>();
		this.comidas = new ArrayList<Comida>();
	}

	public void addProducto(Comida c) {
		this.comidas.add(c);
	}

	public void addProducto(Bebida b) {
		this.bebidas.add(b);
	}

	public Double getValor(Integer descuentoBebida, Integer descuentoComida, Integer propina) {

		Double res = 0.0;

		for (Bebida b : bebidas) {
			res += b.devolverValor(descuentoBebida);
		}

		for (Comida c : comidas) {
			res += c.devolverValor(descuentoComida);
		}

		res = res * (1.0 + (double) propina / 100.0);

		// Esta linea solo es para truncar a 2 cifras decimales.
		res = Math.floor(res * 100.0) / 100.0;

		this.registro.registrarPago(LocalDate.now(), res);

		return res;
	}

}
