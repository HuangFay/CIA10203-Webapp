package com.reservation.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservationcontrol.model.ResCRepository;
import com.reservationcontrol.model.ResCVO;
import com.tabletype.model.TableTypeVO;



@Service("resService")
public class ResService {
	@Autowired
	ResRepository repository;
	@Autowired
	ResCRepository resCRepository;
	
	
	public void addRes(ResVO resVO) {
		repository.save(resVO);
	}
	public void updateRes(ResVO resVO) {
		repository.save(resVO);
	}
	public ResVO getOneRes(Integer reservvationId) {
		Optional<ResVO> optional=repository.findById(reservvationId);
		return optional.orElse(null);
	}
	
	
	public List<ResVO>getAll(){
		return repository.findAll();
	}

	
	

	
	//桌位控制
		 public boolean createReservation(ResVO resVO) {

			 ResCVO resCVO = new ResCVO();
			 resCVO.setTableTypeVO(resVO.getTableTypeVO());
			 resCVO.setReservationControlDate(resVO.getReservationEatdate());
			 resCVO.setReservationControlTable(resVO.getReservationTable().toString());

			 // Save ResCVO
			 resCRepository.save(resCVO);


			 	resCVO = resCRepository.findByTableTypeVOAndReservationControlDate(resVO.getTableTypeVO(), resVO.getReservationEatdate());
				TableTypeVO tableTypeVO;
//				String tableTime = resCVO.getReasrvationControlTable();
				//取用戶選取的時段編號  準備切割桌位的字串位置
				Integer choseTimeId=resVO.getResTimeVO().getReservationTimeId();
				//切割字串位置及轉換成int類型
				int tableTime = Integer.parseInt(resCVO.getReservationControlTable().substring((choseTimeId)*2-1,choseTimeId*2));
				
			 
		         
		        if (resCVO == null || tableTime < resVO.getReservationTable()) {
		            return false;
		        }
		        
		        repository.save(resVO);
		        int updatedTableCount = Integer.parseInt(resCVO.getReservationControlTable()) - resVO.getReservationTable();
		        resCVO.setReservationControlTable(String.valueOf(updatedTableCount));
		        resCRepository.save(resCVO);
		        return true;
		    }
		
	
			public boolean cancelReservation(Integer reservationId) {

		        ResVO resVO = repository.findById(reservationId).orElse(null);
		        if (resVO == null) {
		            return false;
		        }
		
		        ResCVO resCVO = resCRepository.findByTableTypeVOAndReservationControlDate(resVO.getTableTypeVO(), resVO.getReservationEatdate());
		        if (resCVO != null) {
		            int updatedTableCount = Integer.parseInt(resCVO.getReservationControlTable()) + resVO.getReservationTable();
		            resCVO.setReservationControlTable(String.valueOf(updatedTableCount));
		            resCRepository.save(resCVO);
		        }
		
		        repository.delete(resVO);
		        return true;
		    }



}
