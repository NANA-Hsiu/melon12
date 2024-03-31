package cn.com.melon12.data.service;

import cn.com.melon12.data.entity.PriceTable;
import cn.com.melon12.data.entity.ProvenceTable;
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
public interface IProvenceTableService extends IService<ProvenceTable> {

    public int getProvinceId(String province);

    public List<ProvenceTable> getProvince();
    public String getProvince(Integer id);
    public void addProvince(List<ProvenceTable> allprovincetable);
}
