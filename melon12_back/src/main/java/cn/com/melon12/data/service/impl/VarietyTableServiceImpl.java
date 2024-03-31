package cn.com.melon12.data.service.impl;

import cn.com.melon12.data.entity.MarketTable;
import cn.com.melon12.data.entity.TypeTable;
import cn.com.melon12.data.entity.VarietyTable;
import cn.com.melon12.data.mapper.VarietyTableMapper;
import cn.com.melon12.data.service.IVarietyTableService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liulongqi
 * @since 2020-07-27
 */
@Service
public class VarietyTableServiceImpl extends ServiceImpl<VarietyTableMapper, VarietyTable> implements IVarietyTableService {

    @Override
    public int getVarietyId(String Variety, Integer Type_id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("variety", Variety);
        wrapper.eq("id_type",Type_id);
        VarietyTable myvariety = getOne(wrapper);
        return myvariety.getId();
    }

    @Override
    public List<VarietyTable> getVariety(Integer Type_id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id_type",Type_id);
        List<VarietyTable> myvariety = list(wrapper);
        return myvariety;
    }

    @Override
    public void addVariety(List<VarietyTable> allvarietytable) {
        int size1 = allvarietytable.size();
        for (int i = 0; i < size1; i++) {
            List<VarietyTable> myvarietylist = list();
            int size2 = myvarietylist.size();
            boolean tip = true;
            for (int j = 0; j < size2; j++) {
                if (myvarietylist.get(j).getVariety().equals(allvarietytable.get(i).getVariety())&&myvarietylist.get(j).getIdType().equals(allvarietytable.get(i).getIdType())) {
                    tip = false;
                    break;
                }
            }
            if (tip) {
                save(allvarietytable.get(i));
            }
        }
    }
    @Override
    public Integer getVariety_amount() {
        QueryWrapper wrapper = new QueryWrapper();
        List<VarietyTable> myvariety = list();
        return myvariety.size();
    }

    @Override
    public String getVarietys(Integer Variety_id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",Variety_id);
      VarietyTable  myvariety = getOne(wrapper);
        return myvariety.getVariety();
    }
}
