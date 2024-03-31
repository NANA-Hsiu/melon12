package cn.com.melon12.data.service.impl;

import cn.com.melon12.data.entity.MarketTable;
import cn.com.melon12.data.entity.TypeTable;
import cn.com.melon12.data.mapper.TypeTableMapper;
import cn.com.melon12.data.service.ITypeTableService;
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
 * @since 2020-07-28
 */
@Service
public class TypeTableServiceImpl extends ServiceImpl<TypeTableMapper, TypeTable> implements ITypeTableService {

    @Override
    public int getTypeId(String Type, Integer Market_id) {

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("type", Type);
        wrapper.eq("id_market",Market_id);
        TypeTable myType = getOne(wrapper);
        return myType.getId();
    }

    @Override
    public List<TypeTable> getType(Integer Market_id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id_market",Market_id);
        List<TypeTable> mytype = list(wrapper);
        return mytype;
    }

    @Override
    public void addType(List<TypeTable> alltypetable) {
        int size1 = alltypetable.size();
        for (int i = 0; i < size1; i++) {
            List<TypeTable> mytypelist = list();
            int size2 = mytypelist.size();
            boolean tip = true;
            for (int j = 0; j < size2; j++) {
                if (mytypelist.get(j).getType().equals(alltypetable.get(i).getType())&&mytypelist.get(j).getIdMarket().equals(alltypetable.get(i).getIdMarket())) {
                    tip = false;
                    break;
                }
            }
            if (tip) {
                save(alltypetable.get(i));
            }
        }
    }
    @Override
    public List<TypeTable> getType() {
        QueryWrapper wrapper = new QueryWrapper();
        List<TypeTable> mytype = list();
        return mytype;

    }

    @Override
    public int getTypeId(String Type) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("type", Type);
//        wrapper.eq("id_market",Market_id);
        TypeTable myType = getOne(wrapper);
        return myType.getId();
    }
    @Override
    public Integer getType_amount() {
        QueryWrapper wrapper = new QueryWrapper();
        List<TypeTable> mytype = list();
        return mytype.size();
    }
}
