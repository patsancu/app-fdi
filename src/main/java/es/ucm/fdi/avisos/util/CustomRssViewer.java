package es.ucm.fdi.avisos.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.LocalDateTime;
import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Content;
import com.rometools.rome.feed.rss.Item;

import es.ucm.fdi.avisos.business.entity.Aviso;

public class CustomRssViewer extends AbstractRssFeedView {

	private static String dominio = "http://localhost:8080";

	@Override
	protected void buildFeedMetadata(Map<String, Object> model, Channel feed,
			HttpServletRequest request) {

		feed.setTitle("Feed de la Facultad de Informatica, Universidad Complutense de Madrid");
		feed.setDescription("Noticias acerca de la Fdi-UCM");
		feed.setLink("http://informatica.ucm.es");

		LocalDateTime today = new LocalDateTime();
		feed.setLastBuildDate(today.toDate());

		super.buildFeedMetadata(model, feed, request);
	}

	@Override
	protected List<Item> buildFeedItems(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		@SuppressWarnings("unchecked")
		List<Aviso> listContent = (List<Aviso>) model.get("feedContent");
		List<Item> items = new ArrayList<Item>(listContent.size());

		for (Aviso tempContent : listContent) {

			Item item = new Item();

			// Contenido del aviso
			Content content = new Content();
			content.setValue(tempContent.getContenidoAviso());
			item.setContent(content);

			item.setTitle(tempContent.getTitulo());

			// Enlace al propio aviso
			item.setLink(dominio
					+ request.getSession().getServletContext().getContextPath()
					+ "/aviso/" + tempContent.getId());

			// Autor
			if (tempContent.getAutor() != null) {
				item.setAuthor(tempContent.getAutor());
			}

			// Fecha caducidad
			if (tempContent.getFinPublicacion() != null) {
				item.setExpirationDate(tempContent.getFinPublicacion()
						.toDate());
			}

			// Fecha publicacion aviso
			item.setPubDate(tempContent.getFechaCreacion().toDate());

			items.add(item);
		}

		return items;
	}

}
