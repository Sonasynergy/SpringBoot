package com.sf.company;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {
	
	@RequestMapping("/helloForm")
	public String displayForm() {
		return "silly";
	}

}
