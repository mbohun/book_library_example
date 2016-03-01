package com.mbohun.web.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.mbohun.web.jsonview.Views;
import com.mbohun.web.model.SearchRequest;
import com.mbohun.web.model.AjaxResponse;

import org.springframework.beans.factory.annotation.Autowired;
import com.mbohun.dao.LentBooksDao;
import java.util.List;

@RestController
public class AjaxController {

	@Autowired
	LentBooksDao lentBooksDao;

	@JsonView(Views.Public.class)
	@RequestMapping(value = "/getajax", method = RequestMethod.POST)
	public @ResponseBody AjaxResponse getResult(@RequestBody SearchRequest searchRequest) {

		List<String> payload =
			lentBooksDao.findByCustomerId(Integer.parseInt(searchRequest.getId()));
 
		AjaxResponse response = new AjaxResponse();
		response.setCode("200");
		response.setMsg("");
		response.setPayload(payload);
		return response;
	}

}
