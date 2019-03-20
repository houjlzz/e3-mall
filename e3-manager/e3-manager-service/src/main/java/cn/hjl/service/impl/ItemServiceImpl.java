package cn.hjl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hjl.mapper.TbItemMapper;

import cn.hjl.pojo.TbItem;
import cn.hjl.pojo.TbItemExample;
import cn.hjl.pojo.TbItemExample.Criteria;
import cn.hjl.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private TbItemMapper itemMapper;
	public TbItem getItemById(long itemId) {
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		
	    // itemMapper.selectByPrimaryKey(itemId);
		List<TbItem> items = itemMapper.selectByExample(example);
		if (items != null && items.size() != 0) {
			return items.get(0);
		}
		return null;
	}
}
