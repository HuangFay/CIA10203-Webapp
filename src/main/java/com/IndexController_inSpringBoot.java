package com;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.mem.model.MemService;
import com.reservation.model.ResService;
import com.reservation.model.ResVO;
import com.reservationcontrol.model.ResCService;
import com.reservationcontrol.model.ResCVO;
import com.restime.model.ResTimeService;
import com.restime.model.ResTimeVO;
import com.tabletype.model.TableTypeService;
import com.tabletype.model.TableTypeVO;



//@PropertySource("classpath:application.properties") // 於https://start.spring.io建立Spring Boot專案時, application.properties文件預設已經放在我們的src/main/resources 目錄中，它會被自動檢測到
@Controller
public class IndexController_inSpringBoot {
	
	
	@Autowired
	ResCService resCSvc;
	@Autowired
	TableTypeService tableSvc;
	@Autowired
	ResTimeService resTimeSvc;
	@Autowired
	ResService resSvc;
	@Autowired
	MemService memSvc;
    
    private String message;
	
    private List<String> myList = Arrays.asList("Spring Boot Quickstart 官網 : https://start.spring.io", "IDE 開發工具", "直接使用(匯入)官方的 Maven Spring-Boot-demo Project + pom.xml", "直接使用官方現成的 @SpringBootApplication + SpringBootServletInitializer 組態檔", "依賴注入(DI) HikariDataSource (官方建議的連線池)", "Thymeleaf", "Java WebApp (<font color=red>快速完成 Spring Boot Web MVC</font>)");
    @GetMapping("/")
    public String index(Model model) {
    	model.addAttribute("message", "HAHA");
        model.addAttribute("myList", "haha");
        return "index"; //view
    }
    
    // http://......../hello?name=peter1
    @GetMapping("/hello")
    public String indexWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("message", name);
        return "back-end/resc/select_page"; //view
    }
    @ModelAttribute("resListData") // for select_page.html 第135行用
	protected List<ResVO> referenceListData_Res(Model model) {
		model.addAttribute("resVO", new ResVO()); // for select_page.html 第133行用
		List<ResVO> list = resSvc.getAll();
		return list;
	}
  
   //訂位控制選擇畫面
    @GetMapping("/resc/select_page")
	public String select_page(Model model) {
		return "back-end/resc/select_page";
	}
    //訂位控制顯示全部畫面
    @GetMapping("/resc/listAllResC")
	public String listAllResc(Model model) {
		return "back-end/resc/listAllResC";
	}
    
    @ModelAttribute("resCListData")  // for select_page.html 第97 109行用 // for listAllEmp.html 第117 133行用
	protected List<ResCVO> referenceListData(Model model) {
		
    	List<ResCVO> list = resCSvc.getAll();
		return list;
	}
    
    @GetMapping("/res/listAllRes")
  	public String listAllRes(Model model) {
    	
  		return "back-end/res/listAllRes";
  	}

    @ModelAttribute("tableTypeListData") // for select_page.html 第135行用
	protected List<TableTypeVO> referenceListData_TableType(Model model) {
		model.addAttribute("tableTypeVO", new TableTypeVO()); // for select_page.html 第133行用
		List<TableTypeVO> list = tableSvc.getAll();
		return list;
	}
    //訂位時段資料
    @ModelAttribute("resTimeListData") // for select_page.html 第135行用
	protected List<ResTimeVO> referenceListData_ResTime(Model model) {
		model.addAttribute("resTImeVO", new ResTimeVO()); // for select_page.html 第133行用
		List<ResTimeVO> list = resTimeSvc.getAll();
		return list;
	}
    //訂位時段選擇畫面
    @GetMapping("/restime/select_page")
	public String select_page1(Model model) {
		return "back-end/restime/select_page";
	}
    
    //訂位按鈕跳轉mapping
    @GetMapping("/reservation")
    public String home() {
        return "back-end/res/addRes"; // 對應的Thymeleaf模板名稱
    }
    //訂位時段顯示全部畫面
    @GetMapping("/restime/listAllResTime")
	public String listAllResTime(Model model) {
		return "back-end/restime/listAllResTime";
	}
    //桌型選擇畫面
    @GetMapping("/tabletype/select_page")
	public String select_tabletype_page(Model model) {
		return "back-end/tabletype/select_page";
	}
    //桌型顯示全部畫面
    @GetMapping("/tabletype/listAllTableType")
	public String listAllTableType(Model model) {
		return "back-end/tabletype/listAllTableType2";
	}
    
    

  //後台測試首頁畫面
    @GetMapping("/backIndex")
	public String backIndex(Model model) {
		return "backIndex";
	}
    
    @GetMapping("/index2")
   	public String index2(Model model) {
   		return "index2";
   	}
    
    
    
    //訂位功能選擇畫面
    @GetMapping("/res/select_page")
	public String resselect_page(Model model) {
		return "back-end/res/select_page";
	}
}