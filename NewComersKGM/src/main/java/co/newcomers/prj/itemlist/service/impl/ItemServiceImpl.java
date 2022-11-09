package co.newcomers.prj.itemlist.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.newcomers.prj.common.DataSource;
import co.newcomers.prj.itemlist.mapper.ItemMapper;
import co.newcomers.prj.itemlist.service.ItemService;
import co.newcomers.prj.itemlist.vo.ItemVO;

public class ItemServiceImpl implements ItemService{
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private ItemMapper map = sqlSession.getMapper(ItemMapper.class);
	@Override
	public List<ItemVO> itemSelectList() {
		// TODO Auto-generated method stub
		return map.itemSelectList();
	}

	@Override
	public ItemVO itemSelect(ItemVO vo) {
		// TODO Auto-generated method stub
		return map.itemSelect(vo);
	}

	@Override
	public ItemVO itemSearch(ItemVO vo) {
		// TODO Auto-generated method stub
		return map.itemSearch(vo);
	}
	
	@Override
	public int itemInsert(ItemVO vo) {
		// TODO Auto-generated method stub
		return map.itemInsert(vo);
	}

	@Override
	public int itemDelete(ItemVO vo) {
		// TODO Auto-generated method stub
		return map.itemDelete(vo);
	}

	@Override
	public int itemUpdate(ItemVO vo) {
		// TODO Auto-generated method stub
		return map.itemUpdate(vo);
	}


}
