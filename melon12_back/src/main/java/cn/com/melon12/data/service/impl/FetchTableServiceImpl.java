package cn.com.melon12.data.service.impl;

import cn.com.melon12.data.entity.DataTable;
import cn.com.melon12.data.entity.FetchTable;
import cn.com.melon12.data.entity.VarietyTable;
import cn.com.melon12.data.mapper.FetchTableMapper;
import cn.com.melon12.data.service.IFetchTableService;
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
public class FetchTableServiceImpl extends ServiceImpl<FetchTableMapper, FetchTable> implements IFetchTableService {

    @Override
    public List<FetchTable> getFetch(Integer type_id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id_type", type_id);
        wrapper.orderByAsc("date");
        List<FetchTable> FetchList = list(wrapper);
        return FetchList;
    }

    @Override
    public List<FetchTable> getAllFetch() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderByAsc("date");
        List<FetchTable> FetchList = list(wrapper);
        return FetchList;
    }

    @Override
    public void addFetch(List<FetchTable> allfetchtable) {
        int size1 = allfetchtable.size();
        for (int i = 0; i < size1; i++) {
            List<FetchTable> myfetchlist = list();
            int size2 = myfetchlist.size();
            boolean tip = true;
            for (int j = 0; j < size2; j++) {
                if (myfetchlist.get(j).getDate().equals(allfetchtable.get(i).getDate())&&myfetchlist.get(j).getIdType().equals(allfetchtable.get(i).getIdType())) {
                    tip = false;
                    break;
                }
            }
            if (tip) {
                save(allfetchtable.get(i));
            }
        }
    }
    @Override
    public Integer getFetch_Total() {
        QueryWrapper wrapper = new QueryWrapper();
        List<FetchTable> myfetch = list();
        Integer x = myfetch.size();
        Integer a = 0;
        for(int j=0;j<x;j++)
        {
            a += myfetch.get(j).getFetch();
        }
        return a;
    }

    @Override
    public Integer getFetch_Today() {
        QueryWrapper wrapper = new QueryWrapper();
        List<FetchTable> myfetch = list();
        wrapper.orderByAsc("date");
        int x = myfetch.size();
        String recent = myfetch.get(0).getDate();
        wrapper.eq("date", recent);
        List<FetchTable> FetchList = list(wrapper);
        int a = FetchList.size();
        int counter = 0;
        for(int b=0;b<a;b++)
        {
            counter += FetchList.get(b).getFetch();
        }
        return counter;
    }
}
