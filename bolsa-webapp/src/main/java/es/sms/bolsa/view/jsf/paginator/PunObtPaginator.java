package es.sms.bolsa.view.jsf.paginator;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import es.sms.bolsa.model.entity.Convocatoria;
import es.sms.bolsa.model.entity.PunObt;
import es.sms.bolsa.repository.commons.PaginationResult;
import es.sms.bolsa.service.PunObtService;

public class PunObtPaginator extends LazyDataModel<PunObt> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PunObtService punObtService;

	private Convocatoria convocatoria;

	private Long idInteresado;

	private PaginationResult<PunObt> paginationResult;

	private int nResultados;

	public PunObtPaginator(PunObtService punObtService, Convocatoria convocatoria, Long idInteresado) {
		this.punObtService = punObtService;
		this.convocatoria = convocatoria;
		this.idInteresado = idInteresado;
	}

	@Override
	public List<PunObt> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		int pageNumber = 0;
		if (pageSize > 0) {
			pageNumber = (first / pageSize) + 1;
		}
		List<PunObt> result = null;
		if (first == 0) {
			result = punObtService.findByConvocatoriaAndIdInteresado(convocatoria, idInteresado,
					PageRequest.of(first, pageSize, Sort.by("codigoMerito")));
		} else {
			first = first / pageSize;
			result = punObtService.findByConvocatoriaAndIdInteresado(convocatoria, idInteresado,
					PageRequest.of(first, pageSize, Sort.by("codigoMerito")));
		}
//		for (PunObt p : result) {
//			System.out.println("++Codigo " + p.getMerito().getIdMeritos());
//			if (p.getMerito().getPadre() != null)
//				System.out.println("\t--Codigo " + p.getMerito().getPadre().getIdMeritos());
//
//		}

		paginationResult = new PaginationResult<PunObt>();
		paginationResult.pageNumber(pageNumber);
		paginationResult.offset((paginationResult.getPageNumber() - 1) * pageSize);
		paginationResult.pageSize(pageSize);
		paginationResult.result(result);
		paginationResult
				.totalResult((int) punObtService.countByConvocatoriaAndIdInteresado(convocatoria, idInteresado));

		nResultados = (int) paginationResult.getTotalResult();
		super.setRowCount(nResultados);
		return paginationResult.getResult();

	}

	@Override
	public PunObt getRowData(String rowKey) {
		String[] split = rowKey.split("-");
		List<PunObt> items = paginationResult.getResult();

		for (PunObt po : items) {
			if (String.valueOf(po.getConvocatoria().getId()).equals(split[0])
					&& String.valueOf(po.getIdInteresado()).equals(split[1])
					&& String.valueOf(po.getCodigoMerito()).equals(split[2])) {
				return po;
			}
		}

		return null;
	}

	@Override
	public Object getRowKey(PunObt punObt) {
		return punObt.getConvocatoria().getId() + "-" + punObt.getIdInteresado() + "-" + punObt.getCodigoMerito();
	}

}
