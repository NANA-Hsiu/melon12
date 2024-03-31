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
 * @since 2020-07-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_Data_Table")
public class DataTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer idVariety;

    private String date;

    private Double max;

    private Double min;

    private Double ave;

    private Double sales;

    public String getDate() {
        return date;
    }

    public Double getAve() {
        return ave;
    }

    public Double getSales() {
        return sales;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Double getMax() {
        return max;
    }

    public Double getMin() {
        return min;
    }

    public void setIdVariety(Integer idVariety) {
        this.idVariety = idVariety;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public void setAve(Double ave) {
        this.ave = ave;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }

    public Integer getIdVariety() {
        return idVariety;
    }

    public Integer getId() {
        return id;
    }
}
