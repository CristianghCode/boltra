
!(function()
{
  var nativeOpen = XMLHttpRequest.prototype.open;
  XMLHttpRequest.prototype.open = function(method, url) 
  {
         if(url.match(/\/(.+\.xhtml)$/)) {
                 this.addEventListener("error", function(event) {
                         console.log("Event lanzado: " + event);
                         document.location.reload();
                 });
         }
         return nativeOpen.apply(this, arguments);
};
})();


function mostrarOpcionDetalle() {
	var curPage="";
    $(".selector-opcion").click(function() {
    	curPage=$(this).data("page");
    	$(this).addClass("activa").siblings().removeClass("activa");
        $("."+curPage).addClass("activa").siblings().removeClass("activa");
        $("."+curPage + ' .ui-inputfield').focus();
        $("."+curPage + ' .opcion__pasos-info').hide();
    });
}

function cerrarDialogo(dialogVar) {
	var dialogo = PF(dialogVar);
	if (dialogo != null && dialogo != 'undefined') {
		dialogo.hide();
	}
}

function scrollToBottom(selector) {
	scrollTo(selector, $(selector).prop("scrollHeight"));
}
function scrollToBottomWithoutAnimation(selector) {
	$(selector).scrollTop($(selector).prop("scrollHeight"));
}

function scrollToTop(selector) {
	scrollTo(selector, 0);
}

function scrollTo(selector, to) {
	var scroll = $(selector);
	scroll.animate({
		scrollTop : to
	});
}

function scrollPageToTop() {
	$("html, body").animate({ scrollTop: 0 });
}

function scrollPageToBottom() {
	$("html, body").animate({ scrollTop: $(document).height() });
}

function limpiarFiltrosTabla(tablaWidgetVar) {
	PF(tablaWidgetVar).clearFilters();
}
function ejecutarFiltrosTabla(tablaWidgetVar) {
	PF(tablaWidgetVar).filter();
}

function ocultarFiltrosTabla(idTabla) {
	$("#" + idTabla + " .ui-column-filter").hide();
	$("#" + idTabla + " .accionFiltro.filtrar").css("display", "inline-block");
	$("#" + idTabla + " .accionFiltro.limpiar").hide();
}

function mostrarFiltrosTabla(idTabla) {
	$("#" + idTabla + " .ui-column-filter").css("display", "block");
	$("#" + idTabla + " .accionFiltro.filtrar").hide();
	$("#" + idTabla + " .accionFiltro.limpiar").css("display", "inline-block");
}

function mostrarSpinner(id) {
	var idSpinner = (id == undefined ? 'ModalSpinnerWrap' : id);
	$('#' + idSpinner + '.spinner-wrap').show()
}

function ocultarSpinner(id) {
	var idSpinner = (id == undefined ? 'ModalSpinnerWrap' : id);
	$('#' + idSpinner + '.spinner-wrap').hide()
}

function limpiarErroresValidacion(id) {
	$("#" + id + " .ui-state-error").removeClass("ui-state-error")
}

function bloquearWidget(id) {
	$('#' + id + " .spinner-wrap").show();
	$('#' + id + " .contenido--bloqueado").hide();
}

function desbloquearWidget(id) {
	$('#' + id + " .spinner-wrap").hide();
	$('#' + id + " .contenido--bloqueado").show();
}

function hasText(str) {
	return !isBlank(str);
}

function isBlank(str) {
    return (!str || /^\s*$/.test(str));
}

function mostrarLoading() {
	$('.loading').show();
}

function ocultarLoading() {
	$('.loading').hide();
}

/* ------ FILTRO DE PETICIONES ------ */

function filtrarBusquedaPeticiones() {
	
	var idForm = "peticionesForm";
	var idTabla = "peticionesDataTable";

	var camposEstandar = ["prueba", "departamento", "circuito", "prioridad", "servicioPeticionario", "hospital", "estado"];
	aplicarFiltroCamposEstandar(idForm, idTabla, camposEstandar)
	
	var valorFiltroFecha = extraerIntervaloFechasCalendario(idForm);
	aplicarFiltroColumna(idForm, idTabla, "fechaRealizacion", valorFiltroFecha);
	
	var valorFiltroSubEstado = getCampoFiltroListaCheckbox(idForm, "subEstado");
	aplicarFiltroColumna(idForm, idTabla, "subEstado", valorFiltroSubEstado);
	
	ejecutarFiltrarBusquedaPeticiones();
}

function extraerPeriodoFechas(idForm) {
	var periodo = getCampoFiltro(idForm, "periodo").val();
	if (periodo.length == 0) {
		return "";
	}
	return "PER-" + periodo.split(" ")[0];
}

function extraerIntervaloFechasCalendario(idForm) {
	var fechaInicio = getCampoFiltroBootsfaces(idForm, "fechaInicio").val();
	var fechaFin = getCampoFiltroBootsfaces(idForm, "fechaFin").val();
	return "CAL-" + fechaInicio + "-" + fechaFin;
}

function aplicarFiltroCamposEstandar(idForm, idTabla, campos) {
	$.each(campos, function(index, idCampo) {
		var valorFiltro = getCampoFiltro(idForm, idCampo).val();
		aplicarFiltroColumna(idForm, idTabla, idCampo, valorFiltro);
	});	
}

function aplicarFiltroColumna(idForm, idTabla, idCampo, valorFiltro) {
	var filtroColumna = getFiltroColumna(idForm, idTabla, idCampo)
	
	if (filtroColumna.length == 1) {
		filtroColumna.val(valorFiltro);
	}
}

function getCampoFiltro(idForm, idCampo) {
	return $("#" + idForm + "\\:" + idCampo + "Filter_input");
}
function getCampoFiltroBootsfaces(idForm, idCampo) {
	return $("#" + idForm + "\\:" + idCampo + "Filter_Input");
}

function getCampoFiltroListaCheckbox(idForm, idCampo) {
	var marcados = [];
	$("input[name='" + idForm + "\\:" + idCampo + "Filter'][aria-checked='true']").each(
		function(index) {
			marcados.push($(this).val());
		}
	);
	return marcados.join(",");
}

function getFiltroColumna(idForm, idTabla, idColumna) {
	var idDataTable = idForm + "\\:" + idTabla;
	return $("#" + idDataTable + "\\:" + idColumna + "Column\\:filter");
}

function limpiarFiltroBusquedaPeticiones() {
	
	var idForm = "peticionesForm";
	
	// Limpiar selectores
	$("#" + idForm + " .ui-selectonemenu").each(function() {
		var select = $(this).find("select");
		select.prop("selectedIndex", 0 );
		var selected = select.find("option:selected");
		$(this).find("label").text(selected.text());
	});
	
	limpiarFiltrosTabla("peticionesDataTableWidgetVar");
}

function ejecutarFiltrarBusquedaPeticiones() {
	ejecutarFiltrosTabla('peticionesDataTableWidgetVar');
}

/* --- */