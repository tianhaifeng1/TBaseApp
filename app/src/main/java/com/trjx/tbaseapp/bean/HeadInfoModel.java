package com.trjx.tbaseapp.bean;

import com.trjx.tbaseapp.assist.DemoConstant;
import com.trjx.tlibs.bean.resp.RespBaseInfo;

public class HeadInfoModel  extends RespBaseInfo {

	/**接口调用版本号*/
	private String version = "";
	/**设备分类1:android phone  2:iPhone  3:HTML  4:program*/
//	private Integer terminal = 0;
	/**时间戳*/
	private String timestamp = "";
	/**秘钥*/
	private String sign = "";
	/**用户标识*/
//	private String token = "";

	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	@Override
	public String toString() {
		return "{version=" + version + ", terminal=" + 1
				+ ", timestamp=" + timestamp + ", sign=" + sign + ", token="
				+ DemoConstant.token + "}";
	}
	
	
}
