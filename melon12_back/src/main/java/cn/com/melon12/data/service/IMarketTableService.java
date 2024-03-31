package cn.com.melon12.data.service;

import cn.com.melon12.data.entity.MarketTable;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiunana
 * @since 2020-07-27
 */
public interface IMarketTableService extends IService<MarketTable> {

    public int getMarketId(String Market, Integer Provence_id);
    public List<MarketTable> getMarket(Integer Province_id);
    public Integer getMarket_amount();
    public void addMarket(List<MarketTable> allmarkettable);
}
