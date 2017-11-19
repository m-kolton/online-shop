package pl.kolton.shoponline.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Strona jest niedostêpna!");
		mv.addObject("errorDescription", "Strona której szukasz nie jest dostêpna");
		mv.addObject("title", "404 Error Page");
		
		return mv;
		
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Produkt jest niedostêpny!");
		mv.addObject("errorDescription", "Produkt którego szukasz nie jest w tej chwili dostêpny!");
		mv.addObject("title", "Produkt niedostêpny");
		
		return mv;
		
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Skontaktuj siê z administratorem strony!");
		
		/*
		 * Only for debbuging
		 */
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		
		mv.addObject("errorDescription", sw.toString() );
		mv.addObject("title", "B³¹d");
		
		return mv;
		
	}
	
}
