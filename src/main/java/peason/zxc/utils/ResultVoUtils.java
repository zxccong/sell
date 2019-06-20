package peason.zxc.utils;

import peason.zxc.vo.ResultVo;

/**
 *
 */
public class ResultVoUtils {

    public static ResultVo success(Object object){
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setCode(0);
        resultVo.setData(object);
        resultVo.setMsg("成功");
        return resultVo;
    }

    public static ResultVo success(){
        return success(null);
    }

    public static ResultVo error(Object object){
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setCode(500);
        resultVo.setData(object);
        resultVo.setMsg("失败");
        return resultVo;
    }
    public static ResultVo error(){
        return error(null);
    }
}
