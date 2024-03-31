package cn.com.melon12.data.service.impl;

import cn.com.melon12.data.entity.DataTable;
import cn.com.melon12.data.entity.TypeTable;
import cn.com.melon12.data.mapper.DataTableMapper;
import cn.com.melon12.data.service.IDataTableService;
import cn.com.melon12.user.entity.UserTable;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DataTableServiceImpl extends ServiceImpl<DataTableMapper, DataTable> implements IDataTableService {

    @Override
    public List<DataTable> getDataTable(Integer id_variety){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id_variety", id_variety);
        wrapper.orderByAsc("date");
        List<DataTable> DataList = list(wrapper);
        return DataList;
    }

    @Override
    public List<DataTable> getDataTable(Integer id_variety, String date) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id_variety", id_variety);
        wrapper.like("date",date);
        wrapper.orderByAsc("date");
        List<DataTable> DataList = list(wrapper);
        return DataList;
    }

    @Override
    public void addData(List<DataTable> alldatatable) {
        int size1 = alldatatable.size();
        for (int i = 0; i < size1; i++) {
            List<DataTable> mydatalist = list();
            int size2 = mydatalist.size();
            boolean tip = true;
            for (int j = 0; j < size2; j++) {
                if (mydatalist.get(j).getIdVariety().equals(alldatatable.get(i).getIdVariety())&&mydatalist.get(j).getId().equals(alldatatable.get(i).getId())) {
                    tip = false;
                    break;
                }
            }
            if (tip) {
                save(alldatatable.get(i));
            }
        }
    }
}
