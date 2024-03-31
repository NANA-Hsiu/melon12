package cn.com.melon12.data.mapper;

import cn.com.melon12.data.entity.BasedataTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liulongqi
 * @since 2020-07-30
 */
public interface BasedataTableMapper extends BaseMapper<BasedataTable> {
List<BasedataTable> getAllTypes();
List<BasedataTable> getVarity(String type);
}
