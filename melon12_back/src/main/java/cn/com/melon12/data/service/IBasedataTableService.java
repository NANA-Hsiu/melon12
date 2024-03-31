package cn.com.melon12.data.service;

import cn.com.melon12.data.entity.BasedataTable;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import net.sf.json.JSONObject;
import netscape.javascript.JSObject;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiunana
 * @since 2020-07-30
 */
public interface IBasedataTableService extends IService<BasedataTable> {
    public IPage<BasedataTable> getBasedataList(String type, Integer pageNum);
    public JSONObject getReType();
    public JSONObject getReVari(String type);
}
