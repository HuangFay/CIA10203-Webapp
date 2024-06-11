package com.tabletype.model;

import java.util.List;

public class TableTypeService {
	private TableTypeDAO_interface dao;
	
	public TableTypeService() {
		dao = new TableTypeJNDIDAO();
	}
	public TableTypeVO addTableType( Integer tableType,Integer tableTypeNumber) {
		
		TableTypeVO tableTypeVO = new TableTypeVO();
		
		tableTypeVO.setTableType(tableType);
		tableTypeVO.setTableId(tableTypeNumber);
		
		return tableTypeVO;
	}
	
	public TableTypeVO updateTableType(Integer tableId,Integer tableType,Integer tableTypeNumber) {
		TableTypeVO tableTypeVO = new TableTypeVO();
		tableTypeVO.setTableId(tableId);
		tableTypeVO.setTableType(tableType);
		tableTypeVO.setTableTypeNumber(tableTypeNumber);
		
		
		dao.update(tableTypeVO);
		return dao.findByPrimaryKey(tableId);
		
	}
	
	public void deleteTableType(Integer tableId) {
		dao.delete(tableId);
	}
	public TableTypeVO getOneTableType(Integer tableId) {
		return dao.findByPrimaryKey(tableId);
	}

	public List<TableTypeVO> getAll() {
		return dao.getAll();
	}
	
	
	
	
	
	
	
	
	
}
