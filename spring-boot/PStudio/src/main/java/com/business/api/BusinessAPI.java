package com.business.api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.dto.BusinessDTO;
@Controller //dinh nghia javaClass nay la Api
public class BusinessAPI {
	@RequestMapping(value = "/iphone", method = RequestMethod.POST)

    @ResponseBody

    public BusinessDTO createNew(@RequestBody BusinessDTO model) {

            return model;

    }
}
