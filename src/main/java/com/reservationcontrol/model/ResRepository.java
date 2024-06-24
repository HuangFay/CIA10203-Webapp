package com.reservationcontrol.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ResRepository extends JpaRepository<ResVO, Integer>{

	@Transactional
	@Modifying
	@Query(value = "delete from morningcode where reservationControlId =?1", nativeQuery = true)
	void deleteByreservationControlId(int reservationControlId);

	
}
