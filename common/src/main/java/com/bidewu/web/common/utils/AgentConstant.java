package com.bidewu.web.common.utils;

/**
 * @author WuShoulei on 2018/2/1
 */
public class AgentConstant {

    /**
     * 系统版本号
     */
    public static final String SYS_VERSION = "1.0.0";

    /**
     * JWT存储系统版本号
     */
    public static final String JWT_VERSION = "jwtVersion";

    /**
     * JWT加密算法对应的密钥
     */
    public static final String JWT_SECRET = "@#$123";

    /**
     * JWT用户信息对应Key
     */
    public static final String JWT_CLAIM_KEY = "auth";

    /**
     * Redis保存JWT用于二次验证——前缀
     */
    public static final String REDIS_JWT_PREFIX = "agent-jwt-";

    /**
     * 保存企业下级的ids
     */
    public static final String REDIS_SUBCORPIDS = "agent-subCorpIds-";

    /**
     * 保存在请求中的用户信息变量值
     */
    public static final String USER_AUTH = "userAuth";

    /**
     * 根父目录编码
     */
    public static final Integer ROOT_PARENT_MENU_CODE = 0;

    /**
     * 用户类型-个人账户
     */
    public static final Short AGENT_USER_TYPE = 1;

    /**
     * 用户类型-企业账户
     */
    public static final Short CORP_USER_TYPE = 2;

    /**
     * 用户类型-城市账户
     */
    public static final Short CITY_USER_TYPE = 3;

    /**
     * 用户类型-全国账户
     */
    public static final Short COUNTRY_USER_TYPE = 4;

    /**
     * 接口权限类型
     */
    public static final Short INTERFACE_AUTH_TYPE = 1;

    /**
     * 数据权限类型
     */
    public static final Short DATA_AUTH_TYPE = 2;

    /**
     * 阿里云短信服务短信签名
     */
    public static final String ALIYUN_SHORT_MESSAGE_SIGN_NAME = "比得屋";

    /**
     * 短信业务扩展字段————注册
     */
    public static final String ALIYUN_SHORT_MESSAGE_REGISTER = "REGISTER";

    /**
     * 短信业务扩展字段————登录
     */
    public static final String ALIYUN_SHORT_MESSAGE_LOGIN = "LOGIN";

    /**
     * 短信业务扩展字段————经纪人账户密码找回
     */
    public static final String ALIYUN_SHORT_MESSAGE_RETRIEVE_PASSWORD = "RETRIEVE_PASSWORD";

    /**
     * 短信业务扩展字段————非经纪人账户密码找回
     */
    public static final String ALIYUN_SHORT_MESSAGE_NON_PERSONAL_RETRIEVE_PASSWORD = "NON_PERSONAL_RETRIEVE_PASSWORD";

    /**
     * 短信模板 注册 密码找回等模板
     */
    public static final String ALIYUN_SHORT_MESSAGE_TEMPLATECODE = "SMS_127156775";
    /**
     * 短信业务扩展字段————安全手机号码
     */
    public static final String SEND_PHONE_BY_SAFEPHONE = "SEND_PHONE_BY_SAFEPHONE";

    /**
     * 短信业务扩展字段————修改手机号码
     */
    public static final String MODIFY_PHONE_EXTENSION_FIELD = "modify_phone_EXTENSION_FIELD_";

    /**
     * 重置账户密码短信模板
     */
    public static final String ACCOUNT_FORGOT_PASSWORD_REST_PASSWORD_CORP = "SMS_126357559";
    /**
     * 短信业务扩展字段-重置密码短信模板
     */
    public static final String RESET_PASSWORD_EXTENSION_FIELD = "RESET_PASSWORD_EXTENSION_FIELD";
    /**
     * 开通全国账号短信模板
     */
    public static final String NATIONAL_ACCOUNT_MESSAGE_TEMPLATE = "SMS_127160316";

    /**
     * 短信业务扩展字段-开通全国账号
     */
    public static final String OPEN_NEW_NATIONAL_ACCOUNT = "OPEN_NEW_NATIONAL_ACCOUNT";
    /**
     * 开通城市账号短信模板
     */
    public static final String City_ACCOUNT_MESSAGE_TEMPLATE = "SMS_127150353";
    /**
     * 短信业务扩展字段-开通城市账号
     */
    public static final String City_ACCOUNT_MESSAGE_TEMPLATE_EXTENSION_FIELD = "City_ACCOUNT_MESSAGE_TEMPLATE_EXTENSION_FIELD";

    /**
     * 开通企业账号短信模板
     */
    public static final String CORP_ACCOUNT_MESSAGE_TEMPLATE = "SMS_127160320";
    /**
     * 短信业务扩展字段-开通企业账号
     */
    public static final String CORP_ACCOUNT_MESSAGE_TEMPLATE_EXTENSION_FIELD = "CORP_ACCOUNT_MESSAGE_TEMPLATE_EXTENSION_FIELD";
    /**
     * 经纪人名片审核成功短信模板
     */
    public static final String EXAM_AGENT_VERIFY_SUSS_MESSAGE_TEMPLATE = "SMS_126462809";
    /**
     * 短信业务扩展字段-经纪人名片审核成功短信模板
     */
    public static final String EXAM_AGENT_VERIFY_SUSSMESSAGE_TEMPLATE_EXTENSION_FIELD = "EXAM_AGENT_VERIFY_MESSAGE_TEMPLATE_EXTENSION_FIELD";
    /**
     * 经纪人名片审核失败短信模板
     */
    public static final String EXAM_AGENT_VERIFY_FAIL_MESSAGE_TEMPLATE = "SMS_126358704";
    /**
     * 短信业务扩展字段-经纪人名片审核失败短信模板
     */
    public static final String EXAM_AGENT_VERIFY_FAIL_MESSAGE_TEMPLATE_EXTENSION_FIELD = "EXAM_AGENT_VERIFY_FAIL_MESSAGE_TEMPLATE_EXTENSION_FIELD";
    /**
     * 城市房源强制下架
     */
    public static final String CITY_HOUSE_FORCED_OFF_SHELVES="您的编号${houseID}的[${projName}]的[type]房源违反规定被管理员强制删除，原因:${message}";
    /**
     * 短信业务扩展字段-城市房源强制下架
     */

    public static final String CITY_HOUSE_FORCED_OFF_SHELVES_TEMPLATE_EXTENSION_FIELD="CITY_HOUSE_FORCED_OFF_SHELVES_TEMPLATE_EXTENSION_FIELD";
    /**
     * 前台预约咨询提交成功后向经纪人发送短信模板
     */
    public static final String AGENT_SELL_HOUSE_LEAVE_MESSAGE_MESSAGE_TEMPLATE = "SMS_137540233";
    /**
     * 短信业务扩展字段-前台预约咨询提交成功后向经纪人发送短信模板
     */
    public static final String AGENT_SELL_HOUSE_LEAVE_MESSAGE_MESSAGE_TEMPLATE_EXTENSION_FIELD = "AGENT_SELL_HOUSE_LEAVE_MESSAGE_MESSAGE_TEMPLATE_EXTENSION_FIELD";
    /**
     * 图形验证码保存Cookie
     */
    public static final String GRAPHIC_VERIFICATION_CODE_COOKIE = "graphic_code";

    /**
     * 图形验证码对应的页面源
     */
    public static final String GRAPHIC_VERIFICATION_PAGE = "agent_verify_login, agent_password_login, non_agent_forget_password";

    /**
     * 方案发送修改
     */
    public static final String PLAN_SEND_START  = "【懂房帝】根据您的找房需求，懂房帝置业咨询师";

    /**
     * 方案发送修改
     */
    public static final String PLAN_SEND_END  = "已为您生成专属置业报告并发送，请注意查收，希望能对您有所帮助。";


    /**
     * 房源发布状态码(出租&出售)————未发布
     */
    public static final Short HOUSE_NO_PUBLISH_STATUS = 0;

    /**
     * 房源发布状态码(出租&出售)————已发布
     */
    public static final Short HOUSE_PUBLISH_STATUS = 1;

    /**
     * 出售房源认领状态——认领已发布
     */
    public static final Short HOUSE_CLAIM_STATUS = 0;

    /**
     * 出售房源认领状态——认领待发布
     */
    public static final Short HOUSE_NOT_CLAIM_STATUS = 1;

    /**
     * 房源发布状态(出租&出售)————下架
     */
    public static final Short House_OFF_PUBLISH_STATUS = 2;

    /**
     * 房源发布状态(出租&出售)————强制下架
     */
    public static final Short HOUSE_FORCE_OFF_PUBLISH_STATUS = 3;

    /**
     * 房源信息来源——经纪人录入
     */
    public static final Short HOUSE_SOURCE_INPUT = 1;

    /**
     * 房源信息来源——经纪人认领
     */
    public static final Short HOUSE_SOURCE_CLAIM = 2;

    /**
     * 户型图图片类别
     */
    public static final Integer LAYOUT_IMAGE_TYPE = 1;

    /**
     * 室内图图片类别
     */
    public static final Integer INDOOR_IMAGE_TYPE = 2;

    /**
     * 小区图/室外图图片类别
     */
    public static final Integer BUILD_IMAGE_TYPE = 3;
    /**
     * 经纪人认领的房源上限数量
     */
    public static final Integer AGENT_CLAIM_HOUSE_NUM=10;
    /**
     * 房源认领上限数量
     */
    public static final Integer HOUSE_CLAIM_LIMIT_NUM=10;

    /**
     * 录入并发布
     */
    public static final Short INPUT_PUBLISH = 4;

    /**
     * 录入未发布
     */
    public static final Short INPUT_NO_PUBLISH = 5;

    /**
     * 发布
     */
    public static final Short UPDATE_PUBLISH = 6;

    /**
     * 取消发布
     */
    public static final Short CANCEL_PUBLISH = 7;

    /**
     * 录入删除
     */
    public static final Short INPUT_DEL = 8;

    /**
     * 免费版版本号
     */
    public static final Integer FREE_V_NUM = 502;

    /**
     * 是否开通付费：0-未开通
     */
    public static final Short PaymentAuth_0 = 0;

    /**
     * 经纪人基本信息开通付费标志位
     */
    public static final Short OPEN_PAYMENT = 1;

    /**
     * 开通付费的版本：0-免费版
     */
    public static final Short PaymentVersion_0 = 0;
    /**
     * 是否推荐:0-否
     */
    public static final Short Is_Recommend_0 = 0;

    /**
     * 发布状态:0-待发布
     */
    public static final Short status_0 = 0;
    /**
     * 经纪人推优配置数量：0
     */
    public static final Integer LimitCount_0 = 0;
    /**
     * 经纪人推优配置业务类型：1-全部的
     */
    public static final Integer BusinessType_1 = 1;
    /**
     * 操作类型(1-注册账号
     */
    public static final Integer OperationType_1 = 1;

    /**
     * 操作类型：开通付费
     */
    public static final Integer OPERATION_TYPE_OPEN_PAYMENT = 2;

    /**
     * 操作类型:3-开通推优
     */
    public static final Integer OperationType_3 = 3;

    /**
     * 操作类型:5-客服关闭账号
     */
    public static final Integer OperationType_5 = 5;
    /**
     * 操作类型:6-账号被转移
     */
    public static final Integer OperationType_6 = 6;
    /**
     * 操作类型:7-转移新注册
     */
    public static final Integer OperationType_7 = 7;
    /**
     * 北京的城市编号
     */
    public static final Integer BJ = 12;

    /**
     * 开通付费类型——普通开通
     */
    public static final Short PAYMENT_TYPE_GENERAL_OPEN = 0;

    /**
     * 开通付费类型——预开通
     */
    public static final Short PAYMENT_TYPE_PRE_OPEN = 1;

    /**
     * 开通付费类型——续费
     */
    public static final Short PAYMENT_TYPE_RENEW = 2;

    /**
     * 开通付费流水待生效
     */
    public static final Short PAYMENT_HISTORY_BE_EFFECTIVE = 0;

    /**
     * 开通付费流水生效
     */
    public static final Short PAYMENT_HISTORY_TAKE_EFFECT = 1;
    /**
     * 开通付费历史-状态：待生效
     */
    public static final Short OpenPaymentHistoryStatus_0 = 0;
    /**
     * 开通付费历史-状态：无效
     */
    public static final Short OpenPaymentHistoryStatus_2 = 2;
    /**
     * 开通付费历史-类型：续费
     */
    public static final Short OpenPaymentHistoryType_2 = 2;
    /**
     * 开通付费历史-类型：预开通
     */
    public static final Short OpenPaymentHistoryType_1 = 1;

    /**
     * app端系统默认用户头像
     */
    public static final String[] SYS_USER_AVATAR  = {"195.png", "196.png","197.png","198.png","199.png","200.png",};

    /**
     * app端系统头像随机值
     */
    public static final Integer RANDOM_AVATAR = 5;

    /**
     * app端用户基本信息有效性 1,有效 0，无效
     */
    public static final Short USER_BASIC_STATUS = 1;
    /**
     * crm用户注册来源  APP
     */
    public static final Short USER_REGISTER_SOURCE_APP = 3;


}
