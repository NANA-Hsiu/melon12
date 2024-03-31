package cn.com.melon12.data.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
 * @since 2020-07-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_BaseData_Table")
public class BasedataTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "data_id", type = IdType.AUTO)
    private Integer dataId;

    private String type;

    private String variety;

    private String province;

    private String market;

    private Double minPrice;

    private Double maxPrice;

    private Double avePrice;

    private String unit;

    private String date;

    public String getType() {
        return type;
    }

    public String getVariety() {
        return variety;
    }

    public String getProvince() {
        return province;
    }

    public String getMarket() {
        return market;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public Double getAvePrice() {
        return avePrice;
    }

    public String getDate() {
        return date;
    }
}
