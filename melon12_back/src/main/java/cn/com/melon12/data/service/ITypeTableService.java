package cn.com.melon12.data.service;

import cn.com.melon12.data.entity.MarketTable;
import cn.com.melon12.data.entity.ProvenceTable;
import cn.com.melon12.data.entity.TypeTable;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiunana
 * @since 2020-07-28
 */
public interface ITypeTableService extends IService<TypeTable> {

    public int getTypeId(String Type, Integer Market_id);
    public List<TypeTable> getType(Integer Market_id);
    public void addType(List<TypeTable> alltypetable);
    public List<TypeTable> getType();
    public int getTypeId(String Type);
    public Integer getType_amount();
}
