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
 * @since 2020-07-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_Market_Table")
public class MarketTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer idProvence;

    private String market;

    public void setIdProvence(Integer idProvence) {
        this.idProvence = idProvence;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getMarket() {
        return market;
    }

    public Integer getIdProvence() {
        return idProvence;
    }

    public Integer getId() {
        return id;
    }
}
