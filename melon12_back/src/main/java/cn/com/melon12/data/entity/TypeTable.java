package cn.com.melon12.data.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liulongqi
 * @since 2020-07-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_Type_Table")
public class TypeTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer idMarket;

    public void setIdMarket(Integer idMarket) {
        this.idMarket = idMarket;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    public Integer getIdMarket() {
        return idMarket;
    }

    public String getType() {
        return type;
    }

    public Integer getId() {
        return id;
    }
}
