package cn.com.melon12.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiunana
 * @since 2020-07-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_User_Table")//可以不加，默认使用实体类的名字作为表名！忽略大小写 BaseMapper->User实体类->实体类的名->表名数据库操作 当数据库的表名和实体类命名不同（忽略大小写），使用@TableName注解指定表名
public class UserTable implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String password;

    private String tele;

    private String name;

    private String identity;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public UserTable(String password,String name,String tele, String identity) {
        this.password = password;
        this.tele = tele;
        this.name = name;
        this.identity = identity;
    }

    public UserTable() {
        this.id = 0;
        this.password = "";
        this.tele = "";
        this.name = "";
        this.identity = "";
    }
}
