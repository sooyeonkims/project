package sully.project.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sully.project.domain.member.Member;
import sully.project.web.session.SessionManager;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private  final SessionManager sessionManager;

    // @GetMap ping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/")
    public String homeLogin(HttpServletRequest request, Model model){
        Member member = (Member) sessionManager.getSession(request);

        if(member ==null){
            return "home";
        }
        model.addAttribute("member", member);
        return "loginHome";
    }

}
