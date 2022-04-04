package sample.simple.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class TestController {

	@RequestMapping(value = "/test", method = RequestMethod.GET	)
	public String test() {
		System.out.println("This is ServerProvider1 po" );
		log.info("-----");
		return "ok";
	}
	@RequestMapping(value = "/showServletContext", method = RequestMethod.GET	)
	public String showServletContext(HttpServletRequest httpRequest) {
		ServletContext servletContext=httpRequest.getSession().getServletContext();
		log.info("------------------------- HttpServletRequest httpRequest.getSession().getServletContext(),{}",servletContext);
		WebApplicationContext webApplicationContext = (WebApplicationContext)servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		log.info("-------------------------webApplicationContext,{}",webApplicationContext);
		return "ok";
	}

}
