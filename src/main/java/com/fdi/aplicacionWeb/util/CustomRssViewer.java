package com.fdi.aplicacionWeb.util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import com.fdi.aplicacionWeb.domain.Aviso;
import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Content;
import com.rometools.rome.feed.rss.Item;

public class CustomRssViewer extends AbstractRssFeedView {
	@Override
	protected void buildFeedMetadata(Map<String, Object> model, Channel feed,
			HttpServletRequest request) {

		feed.setTitle("Mkyong Dot Com");
		feed.setDescription("Java Tutorials and Examples");
		feed.setLink("http://www.mkyong.com");

		super.buildFeedMetadata(model, feed, request);
	}


	@Override
	protected List<Item> buildFeedItems(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		@SuppressWarnings("unchecked")
		List<Aviso> listContent = (List<Aviso>) model.get("feedContent");
		List<Item> items = new ArrayList<Item>(listContent.size());

		for(Aviso tempContent : listContent ){

			Item item = new Item();

			Content content = new Content();
			content.setValue(tempContent.getContenidoAviso());
			item.setContent(content);

			item.setTitle(tempContent.getTitulo());
			item.setLink(tempContent.getEtiqueta());
			item.setPubDate(Date.valueOf(tempContent.getDiaEvento()));

			items.add(item);
		}

		return items;
	}

}
