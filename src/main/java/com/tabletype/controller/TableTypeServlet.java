package com.tabletype.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tabletype.model.*;


public class TableTypeServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("tableId");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入桌型編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/tabletype/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer tableId = null;
				try {
					tableId = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("桌型編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/tabletype/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				TableTypeService tableSvc = new TableTypeService();
				TableTypeVO tableVO = tableSvc.getOneTableType(tableId);
				if (tableVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/tabletype/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("tableTypeVO", tableVO); // 資料庫取出的empVO物件,存入req
				String url = "/tabletype/listOneTableType.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer tableId = Integer.valueOf(req.getParameter("tableId"));
				
				/***************************2.開始查詢資料****************************************/
				TableTypeService empSvc = new TableTypeService();
				TableTypeVO tableVO = empSvc.getOneTableType(tableId);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("tableVO", tableVO);         // 資料庫取出的empVO物件,存入req
				String url = "/tabletype/update_table_type_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);
		}
		
		
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer tableId = Integer.valueOf(req.getParameter("tableId").trim());
				Integer tableType = Integer.valueOf(req.getParameter("tableType").trim());
				Integer tableTypeNumber = Integer.valueOf(req.getParameter("tableTypeNumber").trim());
				
				
				
					

				TableTypeVO tableVO = new TableTypeVO();
				tableVO.setTableId(tableId);
				tableVO.setTableType(tableType);
				tableVO.setTableTypeNumber(tableTypeNumber);
				

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
req.setAttribute("tableTypeVO", tableVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/tabletype/update_table_type_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				TableTypeService tableSvc = new TableTypeService();
				tableVO = tableSvc.updateTableType(tableId,tableType,tableTypeNumber);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("tableTypeVO", tableVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/tabletype/listOneTableType.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);
		}

        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
			
        	List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
		
				// Send the use back to the form, if there were errors
				Integer tableType = Integer.valueOf(req.getParameter("tableType").trim());
				Integer tableTypeNumber = Integer.valueOf(req.getParameter("tableTypeNumber").trim());
				
				
				
				
			
			
				
			

				TableTypeVO tableVO = new TableTypeVO();
				
				tableVO.setTableType(tableType);
				tableVO.setTableTypeNumber(tableTypeNumber);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
req.setAttribute("tableTypeVO", tableVO); // 含有輸入格式錯誤的empVO物件,也存入req 埋伏二號
					RequestDispatcher failureView = req
							.getRequestDispatcher("/tabletype/addEmp.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				TableTypeService tableSvc = new TableTypeService();
				tableVO = tableSvc.addTableType(tableType,tableTypeNumber);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/tabletype/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
		}
		
		
		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer tableType = Integer.valueOf(req.getParameter("tableType"));
				
				/***************************2.開始刪除資料***************************************/
				TableTypeService tableSvc = new TableTypeService();
				tableSvc.deleteTableType(tableType);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/tabletype/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
	}
}
