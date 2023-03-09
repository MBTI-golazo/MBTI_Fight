package team.spring.springmbti.user.controller;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import team.spring.springmbti.user.service.LoginService;
import team.spring.springmbti.user.service.OAuthService;
import team.spring.springmbti.user.vo.User;


@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginservice;
	

	
	@Autowired
	private OAuthService kakaoservice;
	
	Logger log = LogManager.getLogger("case3");
	
	
	
	@GetMapping("login")
    public String home(@RequestParam(value = "code", required = false) String code,Model model) throws Exception{
        log.debug("#########" + code);
        String access_Token = kakaoservice.getKakaoAccessToken(code);
        HashMap<String, Object> userInfo = kakaoservice.getUserInfo(access_Token);
        log.debug("###access_Token#### : " + access_Token);
        log.debug("###userInfo#### : " + userInfo.get("email"));
        log.debug("###nickname#### : " + userInfo.get("nickname"));
        log.debug("###profile_image#### : " + userInfo.get("profile_image"));
        
        String userName = (String) userInfo.get("nickname");
        String userEmail = (String) userInfo.get("email");
        String userProfile = (String) userInfo.get("profile_image");
        
        User user = new User();
        user.setUserName(userName);
        user.setUserEmail(userEmail);
        user.setUserProfile(userProfile);
        
        boolean canRegister = loginservice.checkEmail(userEmail);
        
        model.addAttribute("canRegister",canRegister);
        
        if(canRegister) {
        	loginservice.userRegistration(user);
        }else {
        	log.debug("이미 생성된 아이디가 존재합니다.");
        }
        
        return "myPage";
    }
	
	// 설문조사 이동
	@PostMapping("survey1")
	public String mypage1() {
		log.debug("mypage에서 survey1으로 호출!");
		
		return "survey/survey1";
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
