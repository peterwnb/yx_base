package com.geek.yx.common.core.vo;

/**
 * 返回码枚举类
 */
public enum ResultCodeEnum
{
    /** 成功 */
    SUCCESS("0", "操作成功"),
    USER_PHONE_REPEAT("USER_401001","手机号重复"),
    USER_GROU_NAME_REPEAT("USER_401002","群组名重复"),
    USER_ADD_FRIEND_REPEAT("USER_401003","对方已经是你的好友，请不要重复添加"),
    USER_INVITE_EXPIRED("USER_401004","邀请过期"),
    
    
    USER_NOT_FOUND("USER_404001","用户不存在"),
    
    
    
    SERVER_INTERNAL_ERROR("500", "server internal error"),
    DB_OPERATE_FAILED("501", "数据库操作失败，请联系管理员"),
    OTHER_ERROR("-1", "other error");

    private String code;
    private String desc;

    ResultCodeEnum(String code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }

    public String getCode()
    {
        return code;
    }

    public String getDesc()
    {
        return desc;
    }

    public static void main(String[] args)
    {
        System.out.println(ResultCodeEnum.SUCCESS.getCode() + " - "
                + ResultCodeEnum.SUCCESS.getDesc());
        System.out.println(ResultCodeEnum.SUCCESS.getCode());
    }

}
