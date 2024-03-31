package cn.com.melon12.data.service.impl;

import cn.com.melon12.data.entity.ProvenceTable;
import cn.com.melon12.data.mapper.ProvenceTableMapper;
import cn.com.melon12.data.service.IProvenceTableService;
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
public class ProvenceTableServiceImpl extends ServiceImpl<ProvenceTableMapper, ProvenceTable> implements IProvenceTableService {

    @Override
    public int getProvinceId(String province){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("provence", province);
        ProvenceTable myporvence = getOne(wrapper);
        return myporvence.getId();
    }

    @Override
    public List<ProvenceTable> getProvince() {
        QueryWrapper wrapper = new QueryWrapper();
        List<ProvenceTable> myporvence = list();
        return myporvence;
    }

    @Override
    public void addProvince(List<ProvenceTable> allprovincetable) {
        int size1 = allprovincetable.size();
        for (int i = 0; i < size1; i++) {
            List<ProvenceTable> myprovincelist = list();
            int size2 = myprovincelist.size();
            boolean tip = true;
            for (int j = 0; j < size2; j++) {
                if (myprovincelist.get(j).getProvence().equals(allprovincetable.get(i).getProvence())) {
                    tip = false;
                    break;
                }
            }
            if (tip) {
                save(allprovincetable.get(i));
            }
        }
    }
    @Override
    public String getProvince(Integer id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", id);
        ProvenceTable myporvence = getOne(wrapper);
        return myporvence.getProvence();

    }
}
