package com.jichuangsi.mes.constant;

public class ResultCode {
	public static final String SUCESS = "0010";//成功
	public static final String PARAM_MISS = "0020";//缺少参数
	public static final String PARAM_ERR = "0021";//参数不正确
	public static final String TOKEN_MISS = "0030";//缺少token
	public static final String TOKEN_CHECK_ERR = "0031";//token校验异常
	public static final String SYS_ERROR = "0050";//系统内部异常
	public static final String SYS_BUSY = "0051";//熔断
	
	public static final String SUCESS_MSG = "成功";
	public static final String PARAM_MISS_MSG = "缺少参数";
	public static final String PARAM_ERR_MSG = "参数不正确";
	public static final String TOKEN_MISS_MSG = "缺少token";
	public static final String TOKEN_CHECK_ERR_MSG = "token校验异常";
	public static final String SYS_ERROR_MSG = "系统繁忙";
	public static final String SYS_BUSY_MSG = "系统繁忙";
	public static final String NO_ACCESS = "无权访问";

	public final static String ACCOUNT_ISEXIST_MSG = "账号已存在";
	public final static String ACCOUNT_NOTEXIST_MSG = "账号不存在，或者账户密码错误";
	public final static String PWD_NOT_MSG = "两次密码不一致";
	public final static String PWD_LIMIT = "设置的密码不能少于6位数";
	public final static String PWD_NOTEXIST_MSG = "密码错误";
	public final static String USER_NOROLE_MSG = "该账户没有分配角色，请先让管理员分配角色";
	public final static String EXPREES_NOEXIST_CLIENT="该客户不存在";
	public final static String EXPIRES_ACCOUNT="账号已过期";
	public final static String DICTIONARY_ISEXIST_MSG = "该数据已存在";
	public final static String NUMBER_ISEXIST_MSG = "编号已存在";
	public final static String DATA_NOEXIST_MSG = "该数据不存在";
	public final static String DICTIONARY_ISEXIST_REPORD_MSG = "您还有未处理完成的报修单，请先完成";
	public final static String DICTIONARY_ISNOTFINISHED_REPORD_MSG = "该报修单还没处理完成，请先完成";


	public static final String Date_ERROR = "检修设备不能超出当天日期!!!!";


//	库存

	public static final String NUM_NOENOUGH_MSG = "调取数量超过当前库存数量!!!";

	//文件管理
	public static final String FILE_IS_NULL = "文件为空!!!";
	public static final String FILE_IS_TOOBIG = "上传文件规定小于100MB!!!";

}
