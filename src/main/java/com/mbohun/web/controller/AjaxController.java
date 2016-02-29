package com.mbohun.web.controller;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonView;
import com.mbohun.web.jsonview.Views;
import com.mbohun.web.model.AjaxResponse;
import com.mbohun.web.model.SearchRequest;

import com.mbohun.dao.LentBooksDao;

@RestController
public class AjaxController {

	@Autowired
	LentBooksDao lentBooksDao;
	
	@JsonView(Views.Public.class)
	@RequestMapping(value = "/getajax")
	public AjaxResponse getResult(@RequestBody SearchRequest searchRequest) {
		AjaxResponse response = new AjaxResponse();
		if (searchRequest.empty()) {
			response.setCode("400");
			response.setMsg("Empty search request!");
			return response;
		}

		List<String> payload =
			lentBooksDao.findByCustomerId(Integer.getInteger(searchRequest.getId()));

		if (payload.size() < 1) {
			response.setCode("204");
			response.setMsg("No results found!");
			return response;
		}

		response.setCode("200");
		response.setMsg("Found " + payload.size() + " results.");
		response.setPayload(payload);
		return response;
	}

}
