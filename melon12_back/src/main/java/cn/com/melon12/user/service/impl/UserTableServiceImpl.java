package cn.com.melon12.user.service.impl;

import cn.com.melon12.user.entity.UserTable;
import cn.com.melon12.user.mapper.UserTableMapper;
import cn.com.melon12.user.service.IUserTableService;
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
 * @since 2020-07-21
 */
@Service
public class UserTableServiceImpl extends ServiceImpl<UserTableMapper, UserTable> implements IUserTableService {

    @Override
    public UserTable Mylogin(String id, String password) {
        //wrapper 条件封装对象，内部可以无限地封装条件
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", id);
        wrapper.eq("password", password);
        UserTable userTable = getOne(wrapper);
        return userTable;
    }

    @Override
    public UserTable getUser(String id){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", id);
        UserTable userTable = getOne(wrapper);
        return userTable;
    }

    @Override
    public List<UserTable> GetUserList(String identity) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("identity", identity);
        List<UserTable> userList = list(wrapper);
        return userList;
    }

    @Override
    public UserTable Add(String password, String name, String tele, String identity){
        UserTable myUser = new UserTable(password,name,tele,identity);
        try{
            if(save(myUser)){
                QueryWrapper wrapper = new QueryWrapper();
                wrapper.eq("password", password);
                wrapper.eq("name", name);
                wrapper.eq("tele", tele);
                wrapper.eq("identity", identity);
                myUser = getOne(wrapper);
                return myUser;
            }
        } catch (Exception ex){

        }
        return myUser;
    }

    @Override
    public boolean Delete(String id,String password){
        try{
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("id", id);
            wrapper.eq("password", password);
            return remove(wrapper);
            //等价于 delete from usertable where id=id and password=password
        }catch (Exception ex){

        }
        return false;
    }

    @Override
    public boolean UpdataWorker(String changedata, String newdata , String id){
        try{
            UserTable user = getUser(id);
            if(changedata.equals("password")){
                user.setPassword(newdata);
            }else if(changedata.equals("tele")){
                user.setTele(newdata);
            }else if(changedata.equals("name")){
                user.setName(newdata);
            }
            return updateById(user);
        }catch (Exception ex){

        }
        return false;
    }
    @Override
    public boolean UpdataAccountUser(String changedata, String newdata, String id) {
        try{
            UserTable user = getUser(id);
            if(changedata.equals("password")){
                user.setPassword(newdata);
            }else if(changedata.equals("tele")){
                user.setTele(newdata);
            }else if(changedata.equals("name")){
                user.setName(newdata);
            }
            return updateById(user);
        }catch (Exception ex){

        }
        return false;
    }
    @Override
    public boolean DeleteUser(String id){
        try{
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("id", id);
            return remove(wrapper);
        }catch (Exception ex){

        }
        return false;
    }
}
