package team.spring.springmbti.user.controller;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import team.spring.springmbti.user.service.JoinService;
import team.spring.springmbti.user.service.OAuthService;


@Controller
public class LoginController {
	
	@Autowired
	private JoinService joinservice;
	
	@Autowired
	private OAuthService kakaoservice;
	
	Logger log = LogManager.getLogger("case3");
	
	
	
	@GetMapping("login")
    public String home(@RequestParam(value = "code", required = false) String code) throws Exception{
        System.out.println("#########" + code);
        String access_Token = kakaoservice.getKakaoAccessToken(code);
        HashMap<String, Object> userInfo = kakaoservice.getUserInfo(access_Token);
        log.debug("###access_Token#### : " + access_Token);
        log.debug("###userInfo#### : " + userInfo.get("email"));
        log.debug("###nickname#### : " + userInfo.get("nickname"));
        log.debug("###profile_image#### : " + userInfo.get("profile_image"));
        return "testPage";
    }
	 
//	@RequestMapping(value = "/home", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		boolean canUse=false;
//		
//		canUse = joinservice.idCheck("test123");
//		
//		if(canUse) {
//			log.debug("사용 가능");
//		}
//		
//		return "home";
//	}
	
}
