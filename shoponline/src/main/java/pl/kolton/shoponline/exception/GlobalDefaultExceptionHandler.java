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
		mv.addObject("errorTitle", "Strona jest niedost�pna!");
		mv.addObject("errorDescription", "Strona kt�rej szukasz nie jest dost�pna");
		mv.addObject("title", "404 Error Page");
		
		return mv;
		
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Produkt jest niedost�pny!");
		mv.addObject("errorDescription", "Produkt kt�rego szukasz nie jest w tej chwili dost�pny!");
		mv.addObject("title", "Produkt niedost�pny");
		
		return mv;
		
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Skontaktuj si� z administratorem strony!");
		
		/*
		 * Only for debbuging
		 */
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		
		mv.addObject("errorDescription", sw.toString() );
		mv.addObject("title", "B��d");
		
		return mv;
		
	}
	
}
