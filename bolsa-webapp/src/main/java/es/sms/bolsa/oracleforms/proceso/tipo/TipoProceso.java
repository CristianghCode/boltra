package es.sms.bolsa.oracleforms.proceso.tipo;

import java.util.EnumSet;

public class TipoProceso {

	private Integer id;
	private String descripcion;
	private TipoReport tipoReport;

	private TipoProceso(Builder builder) {
		this.id = builder.id;
		this.descripcion = builder.descripcion;
		this.tipoReport = builder.tipoReport;
	}

	public enum TipoReport {
		INFORME("I"), PROCESO("P");
		private String codigo;

		private TipoReport(String codigo) {
			this.codigo = codigo;
		}

		public static TipoReport findByCodigo(String codigo) {
			return EnumSet.allOf(TipoReport.class)
					.stream()
					.filter(e -> e.codigo.equals(codigo))
					.findFirst()
					.orElseThrow(() -> new IllegalStateException(String.format("Codigo %s no encontrado.", codigo)));
		}

		public boolean isProceso() {
			return this.equals(PROCESO);
		}
	}

	public Integer getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public TipoReport getTipoReport() {
		return tipoReport;
	}

	public static Builder create() {
		return new Builder();
	}

	public static final class Builder {
		private Integer id;
		private String descripcion;
		private TipoReport tipoReport;

		private Builder() {
		}

		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}

		public Builder withDescripcion(String descripcion) {
			this.descripcion = descripcion;
			return this;
		}

		public Builder withTipoReport(String tipoReport) {
			this.tipoReport = TipoReport.findByCodigo(tipoReport);
			return this;
		}

		public TipoProceso build() {
			return new TipoProceso(this);
		}
	}
	
}
