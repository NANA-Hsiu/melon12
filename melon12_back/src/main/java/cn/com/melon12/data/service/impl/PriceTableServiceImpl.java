package cn.com.melon12.data.service.impl;

import cn.com.melon12.data.entity.FetchTable;
import cn.com.melon12.data.entity.PriceTable;
import cn.com.melon12.data.mapper.PriceTableMapper;
import cn.com.melon12.data.service.IPriceTableService;
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
public class PriceTableServiceImpl extends ServiceImpl<PriceTableMapper, PriceTable> implements IPriceTableService {
    @Override
    public List<PriceTable> getProvinceId(String type) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("type", type);
        List<PriceTable> myporvence = list(wrapper);

        return myporvence;
    }

    @Override
    public Double getPrice(String variety,Integer provinceid) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("type", variety);
        wrapper.eq("id_provence", provinceid);
        PriceTable mypice= getOne(wrapper);

        return mypice.getPrice();
    }
    @Override
    public void addPrice(List<PriceTable> allpricetable) {
        int size1 = allpricetable.size();
        for (int i = 0; i < size1; i++) {
            List<PriceTable> mypricelist = list();
            int size2 = mypricelist.size();
            boolean tip = true;
            for (int j = 0; j < size2; j++) {
                if (mypricelist.get(j).getIdProvence().equals(allpricetable.get(i).getIdProvence())&&mypricelist.get(j).getType().equals(allpricetable.get(i).getType())) {
                    tip = false;
                    break;
                }
            }
            if (tip) {
                save(allpricetable.get(i));
            }
        }
    }
}
