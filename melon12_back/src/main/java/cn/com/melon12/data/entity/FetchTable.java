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
@TableName("t_Fetch_Table")
public class FetchTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer idType;

    private String date;

    private Integer fetches;

    public String getDate() {
        return date;
    }

    public Integer getFetch() {
        return fetches;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFetches(Integer fetches) {
        this.fetches = fetches;
    }

    public Integer getIdType() {
        return idType;
    }

    public Integer getFetches() {
        return fetches;
    }
}
