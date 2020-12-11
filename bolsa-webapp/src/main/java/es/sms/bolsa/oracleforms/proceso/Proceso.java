package es.sms.bolsa.oracleforms.proceso;

import static org.apache.commons.lang3.StringUtils.lowerCase;

import java.util.Date;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import es.sms.bolsa.oracleforms.proceso.tipo.TipoProceso;
import es.sms.bolsa.oracleforms.proceso.tipo.TipoProceso.TipoReport;

public class Proceso {

	private Long id;
	private String descripcion;
	private TipoProceso tipoProceso;
	private String login;
	private Date fechaLanzamiento;
	private Date fechaEjecucion;
	private Date fechaFin;
	private Boolean huboError;
	private String descripcionError;
	private String nombreReport;
	private Long idFichero;

	private Proceso(Builder builder) {
		this.id = builder.id;
		this.descripcion = builder.descripcion;
		this.tipoProceso = builder.tipoProceso;
		this.login = builder.login;
		this.fechaLanzamiento = builder.fechaLanzamiento;
		this.fechaEjecucion = builder.fechaEjecucion;
		this.fechaFin = builder.fechaFin;
		this.huboError = builder.huboError;
		this.descripcionError = builder.descripcionError;
		this.nombreReport = builder.nombreReport;
		this.idFichero = builder.idFichero;
	}

	public boolean tieneFichero() {
		return StringUtils.isNotBlank(nombreReport) || (idFichero!=null && idFichero!=0L);
	}
	
	// TODO Copiado de acceso, refactorizar esta delicia.
	public String getEstado() {
		boolean esProceso = tipoProceso.getTipoReport()
				.isProceso();
		if (esProceso && fechaEjecucion == null) {
			return "En planificador";
		}
		return (fechaFin == null ? "En ejecuci�n" : (!huboError ? (esProceso ? "Finalizado OK" : "Ejecutado") : "Error"));
	}

	public Long getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public TipoProceso getTipo() {
		return tipoProceso;
	}

	public String getLogin() {
		return login;
	}

	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}

	public Boolean getHuboError() {
		return huboError;
	}

	public String getDescripcionError() {
		return descripcionError;
	}

	public String getNombreReport() {
		return nombreReport;
	}

	public Long getIdFichero() {
		return idFichero;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public static Builder create() {
		return new Builder();
	}

	public static final class Builder {
		private Long id;
		private String descripcion;
		private TipoProceso tipoProceso;
		private String login;
		private Date fechaLanzamiento;
		private Date fechaEjecucion;
		private Date fechaFin;
		private Boolean huboError;
		private String descripcionError;
		private String nombreReport;
		private Long idFichero;

		private Builder() {
		}

		public Builder withId(Long id) {
			this.id = id;
			return this;
		}

		public Builder withDescripcion(String descripcion) {
			this.descripcion = descripcion;
			return this;
		}

		public Builder withTipo(TipoProceso tipoProceso) {
			this.tipoProceso = tipoProceso;
			return this;
		}

		public Builder withLogin(String login) {
			this.login = login;
			return this;
		}

		public Builder withFechaLanzamiento(Date fechaLanzamiento) {
			this.fechaLanzamiento = fechaLanzamiento;
			return this;
		}

		public Builder withFechaEjecucion(Date fechaEjecucion) {
			this.fechaEjecucion = fechaEjecucion;
			return this;
		}

		public Builder withFechaFin(Date fechaFin) {
			this.fechaFin = fechaFin;
			return this;
		}

		public Builder withHuboError(String huboError) {
			this.huboError = BooleanUtils.toBoolean(lowerCase(huboError));
			return this;
		}

		public Builder withDescripcionError(String descripcionError) {
			this.descripcionError = descripcionError;
			return this;
		}

		public Builder withNombreReport(String nombreReport) {
			this.nombreReport = nombreReport;
			return this;
		}

		public Builder withIdFichero(Long idFichero) {
			this.idFichero = idFichero;
			return this;
		}

		public Proceso build() {
			return new Proceso(this);
		}
	}

	public TipoReport getTipoReport() {
		return tipoProceso.getTipoReport();
	}
}
