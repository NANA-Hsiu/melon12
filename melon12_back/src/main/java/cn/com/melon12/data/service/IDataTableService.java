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
public interface IDataTableService extends IService<DataTable> {

    public List<DataTable> getDataTable(Integer id_variety);
    public List<DataTable> getDataTable(Integer id_variety,String date);

    public void addData(List<DataTable> alldatatable);
}
