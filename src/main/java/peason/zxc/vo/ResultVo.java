package peason.zxc.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的外层对象
 */
@Data
public class ResultVo<T> implements Serializable {

    private static final long serialVersionUID = 202149568281589850L;
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T Data;
}
