package com.tabletype.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.restime.model.ResTimeVO;
import com.tabletype.model.TableTypeService;
import com.tabletype.model.TableTypeVO;

@Controller
@RequestMapping("/tabletype")
public class TableTypeController {
	@Autowired
	TableTypeService TableTypeSvc;
	
	@PostMapping("getOne_For_Display")
	public String getOne_For_Display(
		/***************************1.接收請求參數 - 輸入格式的錯誤處理*************************/
		
		@RequestParam("tableId") String tableId,
		ModelMap model) {
		
		/***************************2.開始查詢資料*********************************************/
//		EmpService empSvc = new EmpService();
		TableTypeVO tableTypeVO = TableTypeSvc.getOneTableType(Integer.valueOf(tableId));
		
		List<TableTypeVO> list = TableTypeSvc.getAll();
		model.addAttribute("tableTypeListData", list); // for select_page.html 第97 109行用
		
		if (tableTypeVO == null) {
			model.addAttribute("errorMessage", "查無資料");
			return "back-end/tabletype/select_page";
		}
		
		/***************************3.查詢完成,準備轉交(Send the Success view)*****************/
		model.addAttribute("tableTypeVO", tableTypeVO);
		model.addAttribute("getOne_For_Display", "true"); // 旗標getOne_For_Display見select_page.html的第126行 -->
		
//		
		return "back-end/tabletype/select_page"; // 查詢完成後轉交select_page.html由其第128行insert listOneEmp.html內的th:fragment="listOneEmp-div
	}
	
}
