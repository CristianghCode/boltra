package es.sms.bolsa.view.jsf.paginator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import es.sms.bolsa.model.entity.AportacionMeritos;
import es.sms.bolsa.model.entity.Convocatoria;
import es.sms.bolsa.repository.commons.PaginationResult;
import es.sms.bolsa.service.AportacionMeritosService;
import es.sms.bolsa.service.PunObtService;

public class AportacionMeritosPaginator extends LazyDataModel<AportacionMeritos> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AportacionMeritosService aportacionMeritosService;

	private Convocatoria convocatoria;

	private String nifInteresado;
	
	private PaginationResult<AportacionMeritos> paginationResult;

	private int nResultados;

	public AportacionMeritosPaginator(AportacionMeritosService aportacionMeritosService, Convocatoria convocatoria,
			String nifInteresado) {
		this.aportacionMeritosService = aportacionMeritosService;
		this.convocatoria = convocatoria;
		this.nifInteresado = nifInteresado;
	}

	@Override
	public List<AportacionMeritos> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		int pageNumber = 0;
		if (pageSize > 0) {
			pageNumber = (first / pageSize) + 1;
		}
		List<AportacionMeritos> result = null;
		if (convocatoria == null)
			result = new ArrayList<>();
		if (first == 0) {
			if (nifInteresado == null) {
				result = aportacionMeritosService.findAllByConvocatoria(
						PageRequest.of(first, pageSize, Sort.by("codigoAportacionMeritos")), convocatoria);
			} else {
				result = aportacionMeritosService.findByConvocatoriaAndNif(
						PageRequest.of(first, pageSize, Sort.by("codigoAportacionMeritos")), convocatoria,
						nifInteresado);
			}
		} else {
			first = first / pageSize;
			if (nifInteresado == null) {
				result = aportacionMeritosService.findAllByConvocatoria(
						PageRequest.of(first, pageSize, Sort.by("codigoAportacionMeritos")), convocatoria);
			} else {
				result = aportacionMeritosService.findByConvocatoriaAndNif(
						PageRequest.of(first, pageSize, Sort.by("codigoAportacionMeritos")), convocatoria,
						nifInteresado);
			}
		}

		paginationResult = new PaginationResult<AportacionMeritos>();
		paginationResult.pageNumber(pageNumber);
		paginationResult.offset((paginationResult.getPageNumber() - 1) * pageSize);
		paginationResult.pageSize(pageSize);
		paginationResult.result(result);
		if (convocatoria == null)
			paginationResult.totalResult(0);
		else {
			if (nifInteresado == null)
				paginationResult.totalResult((int) aportacionMeritosService.countByConvocatoria(convocatoria));
			else {
				paginationResult.totalResult((int) aportacionMeritosService.countByConvocatoriaAndNifInteresado(convocatoria, nifInteresado));
			}
		}

		nResultados = (int) paginationResult.getTotalResult();
		super.setRowCount(nResultados);
		return paginationResult.getResult();

	}

	@Override
	public AportacionMeritos getRowData(String rowKey) {
		List<AportacionMeritos> aportaciones = paginationResult.getResult();

		for (AportacionMeritos s : aportaciones) {
			if (String.valueOf(s.getCodigoAportacionMeritos()).equals(rowKey)) {
				return s;
			}
		}

		return null;
	}

	@Override
	public Object getRowKey(AportacionMeritos solicitud1610) {
		return solicitud1610.getCodigoAportacionMeritos();
	}

	public PaginationResult<AportacionMeritos> getPaginationResult() {
		return paginationResult;
	}

	public void setPaginationResult(PaginationResult<AportacionMeritos> paginationResult) {
		this.paginationResult = paginationResult;
	}

	public int getnResultados() {
		return nResultados;
	}

	public void setnResultados(int nResultados) {
		this.nResultados = nResultados;
	}

	public Convocatoria getConvocatoria() {
		return convocatoria;
	}

	public void setConvocatoria(Convocatoria convocatoria) {
		this.convocatoria = convocatoria;
	}

	public String getNifInteresado() {
		return nifInteresado;
	}

	public void setNifInteresado(String nifInteresado) {
		this.nifInteresado = nifInteresado;
	}

}
