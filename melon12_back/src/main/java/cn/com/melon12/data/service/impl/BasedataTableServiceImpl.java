package cn.com.melon12.data.service.impl;

import cn.com.melon12.data.entity.BasedataTable;
import cn.com.melon12.data.entity.TypeTable;
import cn.com.melon12.data.entity.VarietyTable;
import cn.com.melon12.data.mapper.BasedataTableMapper;
import cn.com.melon12.data.service.IBasedataTableService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liulongqi
 * @since 2020-07-30
 */
@Service
public class BasedataTableServiceImpl extends ServiceImpl<BasedataTableMapper, BasedataTable> implements IBasedataTableService {
@Autowired
BasedataTableMapper basedataTableMapper;

    @Override
    public IPage<BasedataTable> getBasedataList(String type, Integer pageNum) {
        Integer pageSize = 20;
        IPage<BasedataTable> page = new Page(pageNum, pageSize);

        QueryWrapper<BasedataTable> wrapper=new QueryWrapper<BasedataTable>();
        wrapper.eq("type",type);

        IPage<BasedataTable> resultPage = page(page,wrapper);

        return resultPage;
    }

    @Override
    public JSONObject getReType() {

        List<BasedataTable> myType = basedataTableMapper.getAllTypes();
        List<JSONObject> myt = new ArrayList<>();
        JSONObject typejson=new JSONObject();
        int i = myType.size();
        for(int j = 0; j < i ; j++ ) {
            typejson=new JSONObject();
            typejson.put("name", myType.get(j).getType());
            myt.add(typejson);
        }
        JSONObject jsonObj1 = new JSONObject();
        jsonObj1.put("type", "产品种类");
        jsonObj1.put("types",myt);
        return jsonObj1;
    }

    @Override
    public JSONObject getReVari(String type) {
    //    Integer varieties_id = typeTableService.getTypeId(type);
        List<BasedataTable> myvariety = basedataTableMapper.getVarity(type);
        List<JSONObject> mym = new ArrayList<JSONObject>();
        JSONObject varietyJson=new JSONObject();
        int i = myvariety.size();
        for(int j = 0; j < i ; j++ ) {
            varietyJson=new JSONObject();
            varietyJson.put("name",myvariety.get(j).getVariety());
            mym.add(varietyJson);
        }
        JSONObject jsonObj1 = new JSONObject();
        jsonObj1.put("type", "品种");
        jsonObj1.put("varieties", mym);
        return jsonObj1;
    }
}
