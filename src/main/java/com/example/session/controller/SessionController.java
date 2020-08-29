package com.example.session.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class SessionController {
    @GetMapping("get/session")
    public String getSession(ModelMap modelMap,
                             HttpSession session,
                             @RequestParam(name="number", required=false) Integer guessedNumber) {
        String message = null;

        if (guessedNumber == null) {
            message = "session 값 맞추기";

            session.setAttribute("randomNumber", (int)(Math.random() * 100 + 1));
            session.setAttribute("guessCount", 0);
        }
        else {
            int randomNumber = (Integer)session.getAttribute("randomNumber");
            int guessCount = (Integer)session.getAttribute("guessCount");

            if (guessedNumber == randomNumber) {
                message = guessedNumber + "은 정답입니다! " + ++guessCount + "번 만에 맞췄습니다.";

                session.removeAttribute("randomNumber");
                session.removeAttribute("guessCount");
            }
            else if (guessedNumber < randomNumber) {
                message = guessedNumber + "은 정답보다 작습니다.";

                session.setAttribute("guessCount", ++guessCount);
            }
            else {
                message = guessedNumber + "은 정답보다 큽니다.";

                session.setAttribute("guessCount", ++guessCount);
            }
        }

        modelMap.addAttribute("message", message);

        return "session";
    }
}
