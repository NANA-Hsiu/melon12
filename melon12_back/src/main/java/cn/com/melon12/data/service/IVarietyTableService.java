package cn.com.melon12.data.service;

import cn.com.melon12.data.entity.MarketTable;
import cn.com.melon12.data.entity.ProvenceTable;
import cn.com.melon12.data.entity.VarietyTable;
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
public interface IVarietyTableService extends IService<VarietyTable> {

    public int getVarietyId(String Variety, Integer Type_id);
    public List<VarietyTable> getVariety(Integer Type_id);
    public void addVariety(List<VarietyTable> allvarietytable);
    public Integer getVariety_amount();
    public String getVarietys(Integer Variety_id);
}
