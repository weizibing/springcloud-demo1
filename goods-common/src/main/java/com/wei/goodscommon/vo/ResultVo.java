package com.wei.goodscommon.vo;

/**
 * @author weizibing
 * @date 2022/5/7 10:07
 */
public class ResultVo {
    private int code;
    private String msg;
    private Object data;

    private ResultVo(){}

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static ResultVo success(Object data){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(200);
        resultVo.setMsg("成功");
        resultVo.setData(data);
        return resultVo;
    }

    /**
     * 失败
     * @return
     */
    public static ResultVo error(){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(500);
        resultVo.setMsg("失败");
        return resultVo;
    }

    public static ResultVo error(String msg){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(500);
        resultVo.setMsg(msg);
        return resultVo;
    }
}
