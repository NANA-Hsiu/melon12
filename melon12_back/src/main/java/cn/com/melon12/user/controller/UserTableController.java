package cn.com.melon12.user.controller;


import cn.com.melon12.user.entity.UserTable;
import cn.com.melon12.user.service.IUserTableService;
import net.sf.json.JSONObject;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liulongqi
 * @since 2020-07-21
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserTableController {

    @Autowired
    private IUserTableService userservice;

    @RequestMapping(value="/worker_management", method= RequestMethod.GET)
    public JSONObject Management(String changedata,String newdata,String id){
        JSONObject jsonObj = new JSONObject();
        try {
            if(id.equals("") || id == null){
                jsonObj.put("errcode", "20001");
                jsonObj.put("errmsg", "账号为空");
                return jsonObj;
            }
            if(changedata.equals("") || changedata == null){
                jsonObj.put("errcode", "20002");
                jsonObj.put("errmsg", "修改类型为空");
                return jsonObj;
            }
            if(!(changedata.equals("password") || changedata.equals("tele") || changedata.equals("name"))){
                jsonObj.put("errcode", "20003");
                jsonObj.put("errmsg", "修改类型错误");
                return jsonObj;
            }
            if(newdata.equals("") || newdata == null){
                jsonObj.put("errcode", "20004");
                jsonObj.put("errmsg", "修改后数据为空");
                return jsonObj;
            }
            Boolean result = userservice.UpdataWorker(changedata,newdata,id);
            if(result){
                UserTable myUser = userservice.getUser(id);
                jsonObj.put("errcode", "0");
                jsonObj.put("data", myUser);
                return jsonObj;
            }else{
                jsonObj.put("errcode", "20005");
                jsonObj.put("errmsg", "请求修改失败");
            }
        }catch(Exception ex){
            jsonObj.put("errcode", "20006");
            jsonObj.put("errmsg", "请求修改异常");
        }
        return jsonObj;

    }
    @RequestMapping(value="/worker_show", method= RequestMethod.GET)
    public JSONObject WorkerList(String identity){
        JSONObject jsonObj = new JSONObject();
        try {
            if(identity.equals("") || identity == null){
                jsonObj.put("errcode", "20031");
                jsonObj.put("errmsg", "身份为空");
                return jsonObj;
            }else if(!identity.equals("2")){
                jsonObj.put("errcode", "20032");
                jsonObj.put("errmsg", "身份输入格式错误");
                return jsonObj;
            }
            List<UserTable> userList = userservice.GetUserList(identity);
            jsonObj.put("errcode", "0");
            int total = userList.size();
            jsonObj.put("total", total);
            jsonObj.put("data", userList);
        }catch(Exception ex){
            jsonObj.put("errcode", "20033");
            jsonObj.put("errmsg", "请求员工数据失败");
        }
        return jsonObj;

    }

    @RequestMapping(value="/worker_add", method= RequestMethod.GET)
    public JSONObject WorkerAdd(String password, String name, String tele, String identity){
        JSONObject jsonObj = new JSONObject();
        try {
            if(identity.equals("") || identity == null){
                jsonObj.put("errcode", "20014");
                jsonObj.put("errmsg", "身份为空");
                return jsonObj;
            }else if(!identity.equals("2")){
                jsonObj.put("errcode", "20015");
                jsonObj.put("errmsg", "身份输入格式错误");
                return jsonObj;
            }
            if(password.equals("") || password == null){
                jsonObj.put("errcode", "20011");
                jsonObj.put("errmsg", "密码为空");
                return jsonObj;
            }
            if(name.equals("") || name == null){
                jsonObj.put("errcode", "20012");
                jsonObj.put("errmsg", "昵称为空");
                return jsonObj;
            }
            if(tele.equals("") || tele == null){
                jsonObj.put("errcode", "20013");
                jsonObj.put("errmsg", "手机号为空");
                return jsonObj;
            }
            UserTable Myuser = userservice.Add(password, name, tele, identity);
            jsonObj.put("errcode", "0");
            jsonObj.put("data", Myuser);
        }catch(Exception ex){
            jsonObj.put("errcode", "20015");
            jsonObj.put("errmsg", "请求添加失败");
        }
        return jsonObj;

    }

    @RequestMapping(value="/worker_delete", method= RequestMethod.GET)
    public JSONObject WorkerDelete(String id, String password){
        JSONObject jsonObj = new JSONObject();
        try {
            if(id.equals("") || id == null) {
                jsonObj.put("errcode", "20021");
                jsonObj.put("errmsg", "身份为空");
                return jsonObj;
            }
            if(password.equals("") || password == null){
                jsonObj.put("errcode", "20022");
                jsonObj.put("errmsg", "密码为空");
                return jsonObj;
            }
            Boolean result = userservice.Delete(id,password);
            if(result){
                jsonObj.put("errcode", "0");
                return jsonObj;
            }else{
                jsonObj.put("errcode", "20023");
                jsonObj.put("errmsg", "账号或密码错误");
                return jsonObj;
            }

        }catch(Exception ex){
            jsonObj.put("errcode", "20024");
            jsonObj.put("errmsg", "请求删除失败");
        }
        return jsonObj;

    }

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public JSONObject login(String id, String password){
        JSONObject jsonObj = new JSONObject();
        try {
            if(id == null || id.equals("")){
                jsonObj.put("errcode", "30002");
                jsonObj.put("errmsg", "账号为空");
                return jsonObj;
            }

            if(password == null || password.equals("")){
                jsonObj.put("errcode", "30003");
                jsonObj.put("errmsg", "密码为空");
                return jsonObj;
            }

            UserTable usertable = userservice.Mylogin(id,password);
            usertable.setPassword("");
            jsonObj.put("errcode", "0");
            jsonObj.put("data", usertable);
        }catch(Exception ex){
            jsonObj.put("errcode", "30001");
            jsonObj.put("errmsg", "登录失败");
        }
        return jsonObj;
    }

    @RequestMapping(value="/register", method= RequestMethod.GET)
    public JSONObject register(String password, String name, String tele, String identity){
        JSONObject jsonObj = new JSONObject();
        try {
            if(identity.equals("") || identity == null){
                jsonObj.put("errcode", "10015");
                jsonObj.put("errmsg", "身份为空");
                return jsonObj;
            }else if(!identity.equals("1")){
                jsonObj.put("errcode", "10016");
                jsonObj.put("errmsg", "身份输入格式错误");
                return jsonObj;
            }
            if(password.equals("") || password == null){
                jsonObj.put("errcode", "10012");
                jsonObj.put("errmsg", "密码为空");
                return jsonObj;
            }
            if(name.equals("") || name == null){
                jsonObj.put("errcode", "10013");
                jsonObj.put("errmsg", "昵称为空");
                return jsonObj;
            }
            if(tele.equals("") || tele == null){
                jsonObj.put("errcode", "10014");
                jsonObj.put("errmsg", "手机号为空");
                return jsonObj;
            }
            UserTable Myuser = userservice.Add(password, name, tele, identity);
            jsonObj.put("errcode", "0");
            jsonObj.put("data", Myuser);

        }catch(Exception ex){
            jsonObj.put("errcode", "10011");
            jsonObj.put("errmsg", "请求注册失败");
        }
        return jsonObj;
    }
    @RequestMapping(value="/account_management", method= RequestMethod.GET)
    public JSONObject AccountManagement(String changedata,String newdata,String id){
        JSONObject jsonObj = new JSONObject();
        try {
            if(id.equals("") || id == null){
                jsonObj.put("errcode", "20001");
                jsonObj.put("errmsg", "账号为空");
                return jsonObj;
            }
            if(changedata.equals("") || changedata == null){
                jsonObj.put("errcode", "20002");
                jsonObj.put("errmsg", "修改类型为空");
                return jsonObj;
            }
            if(!(changedata.equals("password") || changedata.equals("tele") || changedata.equals("name"))){
                jsonObj.put("errcode", "20003");
                jsonObj.put("errmsg", "修改类型错误");
                return jsonObj;
            }
            if(newdata.equals("") || newdata == null){
                jsonObj.put("errcode", "20004");
                jsonObj.put("errmsg", "修改后数据为空");
                return jsonObj;
            }
            Boolean result = userservice.UpdataAccountUser(changedata,newdata,id);
            if(result){
                UserTable myUser = userservice.getUser(id);
                jsonObj.put("errcode", "0");
                jsonObj.put("data", myUser);
                return jsonObj;
            }else{
                jsonObj.put("errcode", "20005");
                jsonObj.put("errmsg", "请求修改失败");
            }
        }catch(Exception ex){
            jsonObj.put("errcode", "20006");
            jsonObj.put("errmsg", "请求修改异常");
        }
        return jsonObj;

    }
    @RequestMapping(value="/user_show", method= RequestMethod.GET)
    public JSONObject UserList(String identity){
        JSONObject jsonObj = new JSONObject();
        try {
            if(identity.equals("") || identity == null){
                jsonObj.put("errcode", "20031");
                jsonObj.put("errmsg", "身份为空");
                return jsonObj;
            }else if(!identity.equals("1")){
                jsonObj.put("errcode", "20032");
                jsonObj.put("errmsg", "身份输入格式错误");
                return jsonObj;
            }
            List<UserTable> userList = userservice.GetUserList(identity);
            jsonObj.put("errcode", "0");
            int total = userList.size();
            jsonObj.put("total", total);
            jsonObj.put("data", userList);
        }catch(Exception ex){
            jsonObj.put("errcode", "20033");
            jsonObj.put("errmsg", "请求用户数据失败");
        }
        return jsonObj;

    }


    @RequestMapping(value="/user_add", method= RequestMethod.GET)
    public JSONObject UserAdd(String password, String name, String tele, String identity){
        JSONObject jsonObj = new JSONObject();
        try {
            if(identity.equals("") || identity == null){
                jsonObj.put("errcode", "20014");
                jsonObj.put("errmsg", "身份为空");
                return jsonObj;
            }else if(!identity.equals("1")){
                jsonObj.put("errcode", "20015");
                jsonObj.put("errmsg", "身份输入格式错误");
                return jsonObj;
            }
            if(password.equals("") || password == null){
                jsonObj.put("errcode", "20011");
                jsonObj.put("errmsg", "密码为空");
                return jsonObj;
            }
            if(name.equals("") || name == null){
                jsonObj.put("errcode", "20012");
                jsonObj.put("errmsg", "昵称为空");
                return jsonObj;
            }
            if(tele.equals("") || tele == null){
                jsonObj.put("errcode", "20013");
                jsonObj.put("errmsg", "手机号为空");
                return jsonObj;
            }
            UserTable Myuser = userservice.Add(password, name, tele, identity);
            jsonObj.put("errcode", "0");
            jsonObj.put("data", Myuser);
        }catch(Exception ex){
            jsonObj.put("errcode", "20015");
            jsonObj.put("errmsg", "请求添加失败");
        }
        return jsonObj;

    }


    @RequestMapping(value="/user_delete", method= RequestMethod.GET)
    public JSONObject UserDelete(String id){
        JSONObject jsonObj = new JSONObject();
        try {
            if(id.equals("") || id == null) {
                jsonObj.put("errcode", "20021");
                jsonObj.put("errmsg", "身份为空");
                return jsonObj;
            }
            Boolean result = userservice.DeleteUser(id);
            if(result){
                jsonObj.put("errcode", "0");
                return jsonObj;
            }
        }catch(Exception ex){
            jsonObj.put("errcode", "20024");
            jsonObj.put("errmsg", "请求删除失败");
        }
        return jsonObj;

    }
}
