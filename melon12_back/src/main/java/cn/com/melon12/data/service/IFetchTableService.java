package cn.com.melon12.data.service;

import cn.com.melon12.data.entity.DataTable;
import cn.com.melon12.data.entity.FetchTable;
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
public interface IFetchTableService extends IService<FetchTable> {

    public List<FetchTable> getFetch(Integer varieties_id);
    public List<FetchTable> getAllFetch();
    public Integer getFetch_Total();
    public Integer getFetch_Today();
    public void addFetch(List<FetchTable> allfetchtable);
}
