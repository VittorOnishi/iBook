package br.com.iBook.viewhelper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Grafico;

public class VhGrafico implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// TODO Auto-generated method stub

		String dtInicio = request.getParameter("dtInicio");
		String dtFim = request.getParameter("dtFim");

		if (dtInicio != null && dtFim != null && !dtInicio.isEmpty() && !dtFim.isEmpty()) {

			Grafico grafico = new Grafico(dtInicio, dtFim);

			return grafico;
		}

		return null;
	}

	@Override
	public void setView(List<EntidadeDominio> entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setView(EntidadeDominio entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// TODO Auto-generated method stub

		Grafico grafico = (Grafico) entDom;

		String txtLabels = "[ ";
		String dataSet = "[";
		
		if (grafico != null) {

			Map<String, Map<String, BigDecimal>> dados = grafico.getDados();


			for (String data : dados.keySet()) {
				txtLabels += "'" + data + "', ";
			}
			txtLabels += "] ";
			List<String> categorias = new ArrayList<>();

			categorias.add("Romance");
			categorias.add("Policial");
			categorias.add("Infantil");
			categorias.add("Terror");

			for (String categoria : categorias) {
				String auxDataset = "{ label: '" + categoria + "', data: [";
				for (Map<String, BigDecimal> mapa : dados.values()) {

					if (mapa.get(categoria) == null) {
						auxDataset += 0 + ",";
					} else {
						auxDataset += mapa.get(categoria) + ",";
					}

				}
				auxDataset += "], borderWidth: 1}, ";
				dataSet += auxDataset;
			}

			dataSet += "]";
			
			request.setAttribute("dataSet", dataSet);
			request.setAttribute("txtLabels", txtLabels);

		}
	}

}
