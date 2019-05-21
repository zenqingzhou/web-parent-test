package com.bidewu.web.common.constant.sys;


import com.bidewu.web.common.constant.base.IntBaseType;

/**
 * 接口服务级错误代码
 * 第1位为2，代表服务级错误，中间2位代表服务模块代码，最后2位为具体错误代码
 * @author WuShoulei on 2018/2/2
 */
public enum  RestfulServiceErrorCodeEnum implements IntBaseType {

    /**
     * 通用模块，模块代码00
     */
    NOT_LOGGED("no-permission|用户未登录", 20001),
    UNAUTHORIZED("no-permission|没有开放此功能，请联系管理员", 20002),//未授权
    UNASSIGNED_ROLE("no-permission|请选择角色", 20003),
    LACK_OF_AUTHORITY("接口未指定权限码", 20004),
    ERROR_USERNAME_PASSWORD("用户名或密码错误！", 20005),
    PHONE_NOT_REGISTER("手机号未注册！", 20006),
    ERROR_USERNAME_VERIFY_CODE("用户名或验证码错误！", 20007),
    SHORT_MESSAGE_LIMIT("短信验证码发送过于频繁或已超出限制", 20008),
    SHORT_MESSAGE_SEND_ERROR("短信验证码发送失败", 20009),
    SHORT_MESSAGE_PLATFORM_EXCEPTION("短信平台异常", 20010),
    IMAGE_SIZE_BEYOND_LIMIT("图片大小超出限制", 20011),
    IMAGE_FORMAT_INCORRECT("图片格式不正确", 20012),
    IMAGE_UPLOAD_FAIL("图片上传失败", 20013),
    ERROR_PHONE_VERIFY_CODE("手机号或验证码错误！", 20014),
    IMAGE_CODE_CHECK_FAIL("图形验证码校验失败！", 20015),
    SAFE_PHONE_NOT_CORRECT("该账户不存在！", 20016),
    GRAPHIC_VERIFICATION_PAGE_ERROR("图片验证码页面源配置错误！", 20017),
    ERROR_PASSWORD("密码错误！", 20018),
    UNASSIGNED_ROLE_INTERFACE_AUTH("系统错误，未给角色分配接口权限", 20019),
    RE_LOGGED_IN("请重新登录", 20020),
    UPDATE_LEAVE_WORDS_INFO_FAIL("更新留言状态失败", 20021),

    /**
     * 客服模块，模块代码01
     */
    SAFE_PHONE_REPEAT("安全手机已存在",20101),
    ERROR_USERNAME_REPEAT("该账号已被注册过了",20102),
    ERROR_ZHANGHAO_STATUS("no-permission|禁止切换自身账号状态",20103),
    NOT_UPDATE_SELF_SAFEPHONE("不能修改自身安全账号", 20104),
    USERNAME_REPEAT("用户名已存在",20105),
    PHONENUM_ERROR("电话号码格式不正确",20106),
    USER_NOT_EXIST("用户不存在",20107),
    EDITION("版本不存在",20108),
    AGENT_BASE_INFO_NOT_EXIST("经纪人基本信息不存在",20109),
    AGENT_USER_ROLE_NOT_ASSIGN("经纪人账户未分配角色", 20110),
    START_DATE_NOT_VALID("开始时间不合法,请重新选择！", 20111),
    ACCOUNT_HAS_RENEW_RECORD_BE_EFFECTIVE("账户有续费未生效记录", 20112),
    ACCOUNT_HAS_PRE_OPEN_RECORD_BE_EFFECTIVE("账户有预开通未生效记录", 20113),
    RENEW_DISCONTINUITY_OF_TIME("续费时间不连续", 20114),
    END_TIME_NOT_ALLOW_BEFORE_START_TIME("结束时间不能早于开始时间", 20115),
    UPDATE_CITY_ISSHOW_FAIL("城市上线失败", 20116),
    UPDATE_CITY_DISTRICTINFO_FAIL("修改城市区域信息失败", 20117),
    UPDATE_CITY_CONDITIONINFO_FAIL("修改城市筛选条件失败", 20118),
    UPDATE_CITY_AD_INFO_FAIL("修改城市广告位信息失败", 20119),
    UPDATE_PROJ_SCORE_FAIL("修改楼盘积分失败", 20120),
    UPDATE_CITY_PARK_INFO_FAIL("修改城市公园信息失败", 20121),
    UPDATE_USER_ROLE_KEY_FAIL("修改客服角色编码失败", 20122),
    USER_IS_DEL("用户已停用", 20123),


    /**
     * 经纪人模块，模块代码02
     */
    NOT_AGENT_PHONE("手机号码未填写",20201),
    PHONE_REPEAT("手机号码已被注册过了",20202),
    UPDATE_AGENT_PASSWORD_FAIL("更新失败,请检查原始密码是否填写正确",20203),
    UPDATE_FIRST_SECOND("两次填写的密码不相同",20204),
    ERROR_USER_PWSD("填写的登录密码不正确",20205),
    ERROR_CODE_INFO("短信验证码不正确",20206),
    ID_REQUEST_FAILED("身份证信息不符合,请重新上传身份证信息！",20207),
    ID_PHOTO_MESSAGE_FAILED("上传的身份证信息与注册的身份信息不符！",20208),
    AGENT_BUSINESS_CONFIG_ERROR("经纪人业务指标配置错误", 20209),
    ERROR_USER_ACCOUNT("该用户账号不存在！",20210),
    ERROR_AGENT_HEADPHONE("经纪人头像修改失败！",20211),
    AGENT_NOT_AUTHORITY("该经纪人没有该权限！",20212),
    ALIYUN_ID_CARD_IDENTIFY_FAILED("阿里云身份证识别失败",20213),
    AGENT_ACCOUNT_EXIST("该身份证下以有其他账号处于生效状态,无法完成身份认证！",20214),
    AGENT_SERVICE_BUSINESS_CIRCLE_NOT_REPEAT("服务商圈重复！",20215),
    HOUSE_BELONG_TO_NOT_AGENT("房源所属经纪人不存在！",20216),

    AGENT_HAS_OPEN_PAYMENT("已开通付费", 20217),

    /**
     * 经纪公司模块，模块代码03
     */
    CORP_ACCOUNT_INVALID("经济公司账号不存在",20301),
    CORP_INVALID("公司不存在",20302),
    CORP_ACCOUNT_EXSIT_STATUS("检查该经济公司账号是否生效！",20303),
    CORP_ACCOUNT_EXSIT_EXIST("门店已存在！",20304),

    /**
     * 房源模块，模块代码04
     */
    SAVE_RENT_HOUSE_ERROR("出租房源录入失败", 20401),
    HOUSE_RENT_NOT_FOUND("该房源不存在！", 20402),
    UPDATE_RENT_HOUSE_ERROR("出租房源更新失败", 20403),
    HOUSE_RENT_PUBLISH_BEYOND_LIMIT("出租房源发布数量超出限制", 20404),
    ERROR_HOUSE_COUNT_MAX("推荐房源数量超标",20405),
    SAVE_SELL_HOUSE_ERROR("出售房源录入失败", 20406),
    CITY_SELL_HOUSE_LIST_ERROR("城市出售房源列表异常", 20407),
    UPDATE_SELL_HOUSE_ERROR("出售房源更新失败", 20408),
    HOUSE_SELL_PUBLISH_BEYOND_LIMIT("出售房源发布数量超出限制", 20409),
    HOUSE_SELL_FORCE_SHELVES("出售房源强制下架失败！", 20410),
    HOUSE_RENT_FORCE_OFF_FAIL("出租房源强制下架失败！", 20411),
    AGENT_CLAIM_HOUSE_LIMIT("您认领的房源数量已达上限！", 20412),
    HOUSE_CLAIMED_COUNT_LIMIT("房源被认领数量达到上限！", 20413),
    HOUSE_HAS_BEEN_CLAIMED("房源已被认领，不可重复认领！", 20414),
    HOUSE_CANCEL_CLAIM_MESSAGE("房源取消认领失败！", 20415),
    HOUSE_RENT_ISDEL_ERROR("房源删除失败！", 20416),
    HOUSE_RENT_NOT_FOUND_OR_HAS_FORCE_OFF("房源不存在或已被强制下架！", 20417),
    HOUSE_SELL_ISDEL_ERROR_MESSAGE("缺少房源下架原因！",20418),
    HOUSE_RENT_RECOMMEND_BEYOND_LIMIT("推荐房源数量已达上限，不可推荐！", 20419),
    HOUSE_NOT_FOUND_OR_NO_PUBLISH("房源不存在或未发布！", 20420),
    HOUSE_RECOMMEND_FAIL("设置店铺推荐失败！", 20421),
    HOUSE_CANCEL_RECOMMEND_FAIL("取消店铺推荐失败！", 20422),
    CONTENT_HAS_SENSITIVE_WORD("房源标题或房源描述含有敏感词，请检查！", 20423),
    AGENT_PUBLISH_HOUSE_LIMIT("您发布的房源数量已达上限！", 20424),
    HOUSE_PUBLISH_COUNT_LIMIT("房源被发布数量已达上限！", 20425),
    HOUSE_INFO_NOT_EXIST("楼盘不存在！", 20426),
    SIGNATURE_VERIFICATION_FAILED("签名校验失败", 20427),
    PROPERTY_NOT_MATCHED("楼盘未匹配", 20428),
    UNOPENED_CITY("未开放城市", 20429),



    /**
     * 支付模块，模块代码05
     */
    ERROR_PAY_FAIL("支付失败！",20501),
    ERROR_PAY_REQUEST("调用失败！",20502),
    ERROR_CLOSE_PAY_FAIL("订单关闭失败！",20503),
    ERROR_REFUND_PAY_FAIL("退款失败！",20504),
    ERROR_QUERY_REFUND_PAY_FAIL("查询退款失败！",20505);



    /**
     * 订单模块，模块代码06
     */

    /**
     * 统计模块，模块代码07
     */


    private String desc;
    private int value;

    RestfulServiceErrorCodeEnum(String desc, int value) {
        this.desc = desc;
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
