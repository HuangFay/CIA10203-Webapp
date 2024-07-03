package com.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reservation.model.ResService;
import com.reservation.model.ResVO;
import com.restime.model.ResTimeVO;

@Controller
@Validated
@RequestMapping("/res")
public class ResController {
	@Autowired
	ResService ResSvc;
	
	
	
	@PostMapping("getone_For_Display")
	public String getOne_For_Display(
			/***************************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			
			@RequestParam("reservationId") String reservationId,
			ModelMap model) {
			
			/***************************2.開始查詢資料*********************************************/
//			EmpService empSvc = new EmpService();
			ResVO resVO = ResSvc.getOneRes(Integer.valueOf(reservationId));
			
			List<ResVO> list = ResSvc.getAll();
			model.addAttribute("resTimeListData", list); // for select_page.html 第97 109行用
			
			if (resVO == null) {
				model.addAttribute("errorMessage", "查無資料");
				return "back-end/res/select_page";
			}
			
			/***************************3.查詢完成,準備轉交(Send the Success view)*****************/
			model.addAttribute("resVO", resVO);
			model.addAttribute("getOne_For_Display", "true"); // 旗標getOne_For_Display見select_page.html的第126行 -->
			
//			
			return "back-end/res/select_page"; // 查詢完成後轉交select_page.html由其第128行insert listOneEmp.html內的th:fragment="listOneEmp-div
		}
	
	
}
