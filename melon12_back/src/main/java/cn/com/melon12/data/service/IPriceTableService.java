package cn.com.melon12.data.service;

import cn.com.melon12.data.entity.PriceTable;
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
public interface IPriceTableService extends IService<PriceTable> {
    public void addPrice(List<PriceTable> allpricetable);
    public List<PriceTable> getProvinceId(String type);
    public Double getPrice(String variety,Integer provinceid);
}
