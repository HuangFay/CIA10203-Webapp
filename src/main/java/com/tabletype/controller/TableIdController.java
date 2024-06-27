package com.tabletype.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tabletype.model.TableTypeService;
import com.tabletype.model.TableTypeVO;

@Controller
@RequestMapping("/tabletype")
public class TableIdController {
	@Autowired
	TableTypeService TableTypeSvc;
	
	@GetMapping("addTableType")
	public String addTableType(ModelMap model) {
		TableTypeVO tableVO = new TableTypeVO();
		model.addAttribute("tableVO",tableVO);
		return "back/tabletye/addTableType";
	}
}
