package team.spring.springmbti;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import team.spring.springmbti.user.service.JoinService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private JoinService joinservice;
	
	Logger log = LogManager.getLogger("case3");
	
	@GetMapping("login")
    public String home(@RequestParam(value = "code", required = false) String code) throws Exception{
        System.out.println("#########" + code);
        return "testPage";
    }
	 
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		boolean canUse=false;
		
		canUse = joinservice.idCheck("test123");
		
		if(canUse) {
			log.debug("사용 가능");
		}
		
		return "home";
	}
	
	@RequestMapping(value="/mbti_character/delete")
	@DeleteMapping
	public ResponseEntity<?> method02(Integer characterNum ){
		log.debug("delete방식으로 호출이 되었어요");
		log.debug(characterNum);

		
		return null;
	}
	
}
