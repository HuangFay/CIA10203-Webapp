package com.reservation.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mem.model.MemService;
import com.reservation.model.ResService;
import com.reservation.model.ResVO;
import com.restime.model.ResTimeVO;

@Controller
@RequestMapping("/res")
public class ResIdController {
	@Autowired
	ResService ResSvc;
	@Autowired
	MemService MemSvc;
	
	
	@GetMapping("addRes")
	public String addEmp(ModelMap model) {
		ResVO resVO = new ResVO();
		model.addAttribute("resVO", resVO);
		return "back-end/res/addRes";
	}
	
	
	@GetMapping("insert")
	public String insert(@Valid ResVO resVO, BindingResult result, ModelMap model) throws IOException{
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
	
		/*************************** 2.開始新增資料 *****************************************/
		// EmpService empSvc = new EmpService();
		ResSvc.addRes(resVO);
		/*************************** 3.新增完成,準備轉交(Send the Success view) **************/
		List<ResVO> list = ResSvc.getAll();
		model.addAttribute("resListData", list);
		model.addAttribute("success", "- (新增成功)");
		return "redirect:/resc/listAllRes"; // 新增成功後重導至IndexController_inSpringBoot.java的第50行@GetMapping("/emp/listAllEmp")
	
		
		
	}
	
	
	
}