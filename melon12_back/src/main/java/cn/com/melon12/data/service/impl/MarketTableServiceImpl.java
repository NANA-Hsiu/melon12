package cn.com.melon12.data.service.impl;

import cn.com.melon12.data.entity.MarketTable;
import cn.com.melon12.data.entity.ProvenceTable;
import cn.com.melon12.data.mapper.MarketTableMapper;
import cn.com.melon12.data.service.IMarketTableService;
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
public class MarketTableServiceImpl extends ServiceImpl<MarketTableMapper, MarketTable> implements IMarketTableService {

    @Override
    public int getMarketId(String Market, Integer Provence_id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("market", Market);
        wrapper.eq("id_provence",Provence_id);
        MarketTable mymarket = getOne(wrapper);
        return mymarket.getId();
    }

    @Override
    public List<MarketTable> getMarket(Integer Provence_id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id_provence",Provence_id);
        List<MarketTable> mymarket = list(wrapper);
        return mymarket;
    }

    @Override
    public void addMarket(List<MarketTable> allmarkettable) {
        int size1 = allmarkettable.size();
        for (int i = 0; i < size1; i++) {
            List<MarketTable> mymarketlist = list();
            int size2 = mymarketlist.size();
            boolean tip = true;
            for (int j = 0; j < size2; j++) {
                if (mymarketlist.get(j).getIdProvence().equals(allmarkettable.get(i).getIdProvence())&&mymarketlist.get(j).getMarket().equals(allmarkettable.get(i).getMarket())) {
                    tip = false;
                    break;
                }
            }
            if (tip) {
                save(allmarkettable.get(i));
            }
        }
    }
    @Override
    public Integer getMarket_amount() {
        QueryWrapper wrapper = new QueryWrapper();
        List<MarketTable> mm = list();
        return mm.size();
    }
}
