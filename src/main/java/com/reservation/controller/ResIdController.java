package com.reservation.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mem.model.MemService;
import com.mem.model.MemVO;
import com.reservation.model.ResService;
import com.reservation.model.ResVO;
import com.restime.model.ResTimeService;
import com.restime.model.ResTimeVO;
import com.tabletype.model.TableTypeService;
import com.tabletype.model.TableTypeVO;

@Controller
@RequestMapping("/res")
public class ResIdController {
	@Autowired
	ResService ResSvc;
	@Autowired
	MemService MemSvc;
	@Autowired
	ResTimeService ResTimeSvc;
	@Autowired
	TableTypeService TableTypeSvc;

	@GetMapping("addRes")
	public String addEmp(ModelMap model) {
		ResVO resVO = new ResVO();
		model.addAttribute("resVO", resVO);
		return "back-end/res/addRes";
	}

	@PostMapping("insert")
	public ResponseEntity<String> insert(@Valid ResVO resVO, BindingResult result, ModelMap model) throws IOException {
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		if (result.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input");
		}

		resVO.setReservationDate(LocalDateTime.now());
		boolean isCreated = ResSvc.createReservation(resVO);
		if (!isCreated) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No available tables");
		}

		/*************************** 2.開始新增資料 *****************************************/
		ResSvc.addRes(resVO);

		/*************************** 3.新增完成,準備轉交(Send the Success view) **************/
		List<ResVO> list = ResSvc.getAll();
		model.addAttribute("resListData", list);
		model.addAttribute("success", "新增成功");

		return ResponseEntity.status(HttpStatus.CREATED).body("Reservation created successfully");
	}

	@GetMapping("getOne")
	public String getOneEmp(Integer reservationId, ModelMap model) {
		ResVO resVO = ResSvc.getOneRes(reservationId);
		model.addAttribute("resVO", resVO);
		return "back-end/res/updateRes";
	}

	@GetMapping("list")
	public String getAll(ModelMap model) {
		List<ResVO> list = ResSvc.getAll();
		model.addAttribute("resListData", list);
		return "back-end/res/resList";
	}

	@ModelAttribute("memListData")
	protected List<MemVO> referenceListData() {
		List<MemVO> list = MemSvc.getAll();
		return list;
	}

	@ModelAttribute("resTimeListData")
	protected List<ResTimeVO> resTimeListData() {
		List<ResTimeVO> list = ResTimeSvc.getAll();
		return list;
	}

	@ModelAttribute("tableTypeListData")
	protected List<TableTypeVO> tabelTypeListData() {
		List<TableTypeVO> list = TableTypeSvc.getAll();
		return list;
	}

	@PostMapping("reservation")
	public ResponseEntity<String> createReservation(@RequestBody ResVO resVO) {
		boolean result = ResSvc.createReservation(resVO);
		if (result) {
			return ResponseEntity.ok("Reservation created successfully");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No available tables");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> cancelReservation(@PathVariable Integer id) {
		boolean result = ResSvc.cancelReservation(id);
		if (result) {
			return ResponseEntity.ok("Reservation cancelled successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reservation not found");
		}
	}
}
