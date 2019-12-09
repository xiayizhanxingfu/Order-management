package com.service.impl;

import com.bean.Food;
import com.dao.FoodDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.FoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 下一张幸福
 */
@Service
public class FoodServiceImpl implements FoodService {
    @Resource
    FoodDao foodDao;

    @Override
    public PageInfo<Food> getFoodPage(int pageNum, int pageSize, String key, int sort,int classify) {
        PageHelper.startPage(pageNum, pageSize);
        List<Food> list = foodDao.selectAll(key, sort,classify);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
