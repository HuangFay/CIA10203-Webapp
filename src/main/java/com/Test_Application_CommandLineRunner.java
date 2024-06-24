package com;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reservationcontrol.model.ResRepository;
import com.reservationcontrol.model.ResVO;
import com.tabletype.model.TableTypeVO;

@SpringBootApplication
public class Test_Application_CommandLineRunner implements CommandLineRunner {
    
	@Autowired
	ResRepository repository ;
	
	public static void main(String[] args) {
        SpringApplication.run(Test_Application_CommandLineRunner.class);
    }

    @Override
    public void run(String...args) throws Exception {
    	
    	TableTypeVO tableTypeVO = new TableTypeVO();
    	tableTypeVO.setTableId(1);
    	//● 新增
    	
//		EmpVO empVO1 = new EmpVO();
//		empVO1.setEname("吳永志1");
//		empVO1.setJob("MANAGER");
//		empVO1.setHiredate(java.sql.Date.valueOf("2005-01-01"));
//		empVO1.setSal(new Double(50000));
//		empVO1.setComm(new Double(500));
//		empVO1.setDeptVO(deptVO);
//		repository.save(empVO1);

		//● 修改
//		EmpVO empVO2 = new EmpVO();
//		empVO2.setEmpno(7001);
//		empVO2.setEname("吳永志2");
//		empVO2.setJob("MANAGER2");
//		empVO2.setHiredate(java.sql.Date.valueOf("2002-01-01"));
//		empVO2.setSal(new Double(20000));
//		empVO2.setComm(new Double(200));
//		empVO2.setDeptVO(deptVO);
//		repository.save(empVO2);
		
		//● 刪除   //●●● --> EmployeeRepository.java 內自訂的刪除方法
//		repository.deleteByreservationControlId(1);
		
		//● 刪除   //XXX --> Repository內建的刪除方法目前無法使用，因為有@ManyToOne
		//System.out.println("--------------------------------");
		//repository.deleteById(7001);      
		//System.out.println("--------------------------------");

    	//● 查詢-findByPrimaryKey (多方emp2.hbm.xml必須設為lazy="false")(優!)
//    	Optional<ReservationControlVO> optional = repository.findById(1);
//    	ReservationControlVO resVO3 = optional.get();
//		System.out.print(resVO3.getReservationControlId() + ",");
//		System.out.print(resVO3.getReasrvationControlTable() + ",");
//		System.out.print(resVO3.getReasrvationControlDate() + ",");
//		
//		// 注意以下三行的寫法 (優!)
//		System.out.print(resVO3.getTableTypeVO().getTableId() + ",");
//		System.out.print(resVO3.getTableTypeVO().getTableType() + ",");
//		System.out.print(resVO3.getTableTypeVO().getTableTypeNumber());
//		System.out.println("\n---------------------");
      
    	
		//● 查詢-getAll (多方emp2.hbm.xml必須設為lazy="false")(優!)
//    	List<ReservationControlVO> list = repository.findAll();
//		for (ReservationControlVO ares : list) {
//			System.out.print(ares.getReservationControlId() + ",");
//	
//			System.out.print(ares.getReasrvationControlTable() + ",");
//			System.out.print(ares.getReasrvationControlDate() + ",");
//
//			// 注意以下三行的寫法 (優!)
//			System.out.print(ares.getTableTypeVO().getTableId() + ",");
//			System.out.print(ares.getTableTypeVO().getTableType() + ",");
//			System.out.print(ares.getTableTypeVO().getTableTypeNumber());
//			System.out.println();
//		}
    
    }
}
