package es.ucm.fdi.social.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.DuplicateStatusException;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.ucm.fdi.acortador.business.boundary.URLredirecciones;
import es.ucm.fdi.avisos.boundary.Avisos;
import es.ucm.fdi.avisos.business.entity.Aviso;
import es.ucm.fdi.social.util.TwitterUtils;

@Controller
public class TwitterController {
	@Autowired
	URLredirecciones urlRedirecciones;
	
	@Autowired
	private Avisos avisoService;

	
	@Value("#{twitterData[consumerKey]}")
	private String consumerKey;
	
	@Value("#{twitterData[consumerSecret]}")
	private String consumerSecret;
	
	@Value("#{twitterData[accessToken]}")
	private String accessToken;
	
	@Value("#{twitterData[accessTokenSecret]}")
	private String accessTokenSecret;
	
	private static final Logger logger = LoggerFactory.getLogger("es.ucm.fdi.espacios");	

	
	@RequestMapping(value = "/tweets/rest/{id}", method = RequestMethod.GET)
	public  @ResponseBody String obtenerTweet(@PathVariable String id){
		logger.warn("DSAASDSA");
		Aviso avisoTweet = avisoService.getAviso(Long.parseLong(id));
		String textoTweet = TwitterUtils.crearTweet(urlRedirecciones, avisoTweet);
		return textoTweet;		
	}
	
	
	@RequestMapping(value = "/tweets/rest/{id}", method = RequestMethod.POST)
	public  @ResponseBody String tuitear(@RequestBody String textoTweet, @PathVariable String id){
		logger.warn("DSAASDSA");
		TwitterTemplate twitter = new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		try {
			Tweet tweet = twitter.timelineOperations().updateStatus(textoTweet);
			Aviso avisoTweet = avisoService.getAviso(Long.parseLong(id));			
			avisoService.actualizaInfoTwitter(Long.parseLong(id), tweet.getId(), tweet.getUser().getId());
			logger.warn("Creado tweet: https://twitter.com/mortadeloTIA/status/" + tweet.getId());
			return tweet.getId()+"";
		} catch (DuplicateStatusException e) {
			logger.error("Error: twitter duplicado");
			return "";
		}		
	}
}
