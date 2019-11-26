package com.service.impl;

import com.bean.Food;
import com.dao.FoodDao;
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
    public List<Food> getFoodList() {
        return foodDao.selectAll();
    }
}
