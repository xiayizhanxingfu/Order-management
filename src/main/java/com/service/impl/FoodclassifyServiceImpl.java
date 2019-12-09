package com.service.impl;

import com.bean.Food;
import com.dao.FoodclassifyDao;
import com.service.FoodclassifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 下一张幸福
 */
@Service
public class FoodclassifyServiceImpl implements FoodclassifyService {
    @Resource
    FoodclassifyDao foodclassifyDao;
    @Override
    public List<Food> getFoodListByFoodclassify() {
        return foodclassifyDao.selectAllByFoodclassify();
    }
}
