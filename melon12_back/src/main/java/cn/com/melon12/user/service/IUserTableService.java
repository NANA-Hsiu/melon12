package cn.com.melon12.user.service;

import cn.com.melon12.user.entity.UserTable;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liulongqi
 * @since 2020-07-21
 */
public interface IUserTableService extends IService<UserTable> {

    public UserTable Mylogin(String id, String password);
    public UserTable getUser(String id);
    public List<UserTable> GetUserList(String identity);
    public UserTable Add(String password, String name, String tele, String identity);
    public boolean Delete(String id, String password);
    public boolean UpdataWorker(String changedata, String newdata , String id);
    public boolean UpdataAccountUser(String changedata, String newdata , String id);
    public boolean DeleteUser(String id);
}
