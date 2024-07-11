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

	public boolean createReservation(ResVO resVO) {
		ResCVO resCVO;
		TableTypeVO tableTypeVO;
//		String tableTime = resCVO.getReasrvationControlTable();
		//取用戶選取的時段編號  準備切割桌位的字串位置
		Integer choseTimeId=resVO.getResTimeVO().getReservationTimeId();
		//切割字串位置及轉換成int類型
		int tableTime = Integer.parseInt(resCVO.getReasrvationControlTable().substring((choseTimeId)*2-1,choseTimeId*2));
		
		
        resCVO = resCRepository.findById(resVO.getTableTypeVO().getTableId()).orElse(null);
        if (resCVO == null || tableTime < resVO.getReservationTable()) {
            return false;
        }

        tableTypeVO.setAvailableSeats(tableTypeVO.getAvailableSeats() - reservation.getNumberOfSeats());
        tableRepository.save(table);

        reservationRepository.save(reservation);
        return true;
    }




}
