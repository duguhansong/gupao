package com.yitian.practice.prototype;

import java.util.Date;

public class Sources {
		private String merchId;//商户号

		private String chUserId;//客户在商户端的用户号，确保商户端唯一；

		private String orderId;//长度不大于32个字符，由数字0-9，字母大小写a-z组成，不支持特殊字符和汉字。变长

		private String corpName;//企业名称

		private String parentCustomerId;//开户标识上级客户号

		private String customerFlag;//01-代理商，02-交易平台+代理商，03-交易平台，04-小商户

		private String customerId;//开户客户号

		private String corpShort;//企业简称，默认为客户名称

		private String cateType;//详见附录

		private String corpEmail;//企业邮箱

		private String corpAddress;//企业地址

		private String province;//省份

		private String city;//城市

		private String industryType;//行业代码

		private String industry;//通用行业代码

		private String corpScale;//企业规模

		private String basicAccNo;//企业基本户

		private String authCapital;//单位：分，无小数点

		private String busiScope;//经营范围

		private String certificateNo;//统一社会信用证代码

		private String corpCertExpiryend;//统一社会信用证有效期YYYYMMDD

		private String resName;//法人姓名

		private String corpCertNo;//法人身份证号

		private String certificateExpiry;//YYYYMMDD

		private String certificateExpiryend;//YYYYMMDD，长期有效默认99999999

		private String corpContactNo;//法人手机号

		private String personEmail;//法人邮箱

		private String bankNo;//若绑卡必填
		
		private String bankAccNo;//绑定银行账号信息；若绑卡必填

		private String bankAccName;//必须与客户名称保持一致，若绑卡必填

		private String bankAccAddress;//具体到分支行；若绑卡必填

		private String password;//虚户交易密码，长度6位数字；

		private String encryptMode="00";//00-不加密01-RSA公钥加密.默认为00

		private String extend1;//扩展字段1
		
		private Intermediate inter;//临时对象

		public String getMerchId() {
			return merchId;
		}

		public void setMerchId(String merchId) {
			this.merchId = merchId;
		}

		public String getChUserId() {
			return chUserId;
		}

		public void setChUserId(String chUserId) {
			this.chUserId = chUserId;
		}

		public String getOrderId() {
			return orderId;
		}

		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}

		public String getCorpName() {
			return corpName;
		}

		public void setCorpName(String corpName) {
			this.corpName = corpName;
		}

		public String getParentCustomerId() {
			return parentCustomerId;
		}

		public void setParentCustomerId(String parentCustomerId) {
			this.parentCustomerId = parentCustomerId;
		}

		public String getCustomerFlag() {
			return customerFlag;
		}

		public void setCustomerFlag(String customerFlag) {
			this.customerFlag = customerFlag;
		}

		public String getCustomerId() {
			return customerId;
		}

		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}

		public String getCorpShort() {
			return corpShort;
		}

		public void setCorpShort(String corpShort) {
			this.corpShort = corpShort;
		}

		public String getCateType() {
			return cateType;
		}

		public void setCateType(String cateType) {
			this.cateType = cateType;
		}

		public String getCorpEmail() {
			return corpEmail;
		}

		public void setCorpEmail(String corpEmail) {
			this.corpEmail = corpEmail;
		}

		public String getCorpAddress() {
			return corpAddress;
		}

		public void setCorpAddress(String corpAddress) {
			this.corpAddress = corpAddress;
		}

		public String getProvince() {
			return province;
		}

		public void setProvince(String province) {
			this.province = province;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getIndustryType() {
			return industryType;
		}

		public void setIndustryType(String industryType) {
			this.industryType = industryType;
		}

		public String getIndustry() {
			return industry;
		}

		public void setIndustry(String industry) {
			this.industry = industry;
		}

		public String getCorpScale() {
			return corpScale;
		}

		public void setCorpScale(String corpScale) {
			this.corpScale = corpScale;
		}

		public String getBasicAccNo() {
			return basicAccNo;
		}

		public void setBasicAccNo(String basicAccNo) {
			this.basicAccNo = basicAccNo;
		}

		public String getAuthCapital() {
			return authCapital;
		}

		public void setAuthCapital(String authCapital) {
			this.authCapital = authCapital;
		}

		public String getBusiScope() {
			return busiScope;
		}

		public void setBusiScope(String busiScope) {
			this.busiScope = busiScope;
		}

		public String getCertificateNo() {
			return certificateNo;
		}

		public void setCertificateNo(String certificateNo) {
			this.certificateNo = certificateNo;
		}

		public String getCorpCertExpiryend() {
			return corpCertExpiryend;
		}

		public void setCorpCertExpiryend(String corpCertExpiryend) {
			this.corpCertExpiryend = corpCertExpiryend;
		}

		public String getResName() {
			return resName;
		}

		public void setResName(String resName) {
			this.resName = resName;
		}

		public String getCorpCertNo() {
			return corpCertNo;
		}

		public void setCorpCertNo(String corpCertNo) {
			this.corpCertNo = corpCertNo;
		}

		public String getCertificateExpiry() {
			return certificateExpiry;
		}

		public void setCertificateExpiry(String certificateExpiry) {
			this.certificateExpiry = certificateExpiry;
		}

		public String getCertificateExpiryend() {
			return certificateExpiryend;
		}

		public void setCertificateExpiryend(String certificateExpiryend) {
			this.certificateExpiryend = certificateExpiryend;
		}

		public String getCorpContactNo() {
			return corpContactNo;
		}

		public void setCorpContactNo(String corpContactNo) {
			this.corpContactNo = corpContactNo;
		}

		public String getPersonEmail() {
			return personEmail;
		}

		public void setPersonEmail(String personEmail) {
			this.personEmail = personEmail;
		}

		public String getBankNo() {
			return bankNo;
		}

		public void setBankNo(String bankNo) {
			this.bankNo = bankNo;
		}

		public String getBankAccNo() {
			return bankAccNo;
		}

		public void setBankAccNo(String bankAccNo) {
			this.bankAccNo = bankAccNo;
		}

		public String getBankAccName() {
			return bankAccName;
		}

		public void setBankAccName(String bankAccName) {
			this.bankAccName = bankAccName;
		}

		public String getBankAccAddress() {
			return bankAccAddress;
		}

		public void setBankAccAddress(String bankAccAddress) {
			this.bankAccAddress = bankAccAddress;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEncryptMode() {
			return encryptMode;
		}

		public void setEncryptMode(String encryptMode) {
			this.encryptMode = encryptMode;
		}

		public String getExtend1() {
			return extend1;
		}

		public void setExtend1(String extend1) {
			this.extend1 = extend1;
		}
		
		public Intermediate getInter() {
			return inter;
		}

		public void setInter(Intermediate inter) {
			this.inter = inter;
		}

		public Target toTarget() {
			Target t = new Target();
	        t.setCustomerFlag(this.getCustomerFlag());
	        t.setCustomerId(this.getCustomerId());
	        t.setParentCustomerId(this.getParentCustomerId());
	        t.setUserId(this.getChUserId());
	        t.setPlatAccFlag("02");//账户类别--企业开户
	        t.setIsFirst("1");//是否首次开户，1-首次，2-二次
	        t.setPlatAccType("001");//账户类型.首次开户001-余额户
	        t.setStatus("01");//开户状态--处理中
	        t.setCorpName(this.getCorpName());//企业名称
	        t.setComType("01");//企业主体类型,01-企业，02个体工商户--中金企业开户只有企业
	        t.setSettleAccType("01");//中金企业开户只支持对公绑卡
	        
	        t.setResName(this.getResName());//法人姓名
	        t.setCorpCertNo(this.getCorpCertNo());//法人身份证 号
	        t.setCorpContactNo(this.getCorpContactNo());//法人手机号
//	        acct.setContactNo(this.getContactNo());//企业联系电话--中金无
	        t.setBankAccNo(this.getBankAccNo());//银行账号
	        t.setBankAccName(this.getBankAccName());//银行账户名称
	        t.setPersonEmail(this.getPersonEmail());//法人邮箱
	        t.setBusiScope(this.getBusiScope());//经营范围
	        t.setAuthCapital(this.getAuthCapital());//注册资本
	        t.setBasicAccNo(this.getBasicAccNo());//企业基本户
	        t.setCorpScale(this.getCorpScale());//企业规模
	        t.setIndustry(this.getIndustry());//通用行业代码
	        t.setIndustryType(this.getIndustryType());//行业代码
	        t.setCity(this.getCity());
	        t.setProvince(this.getProvince());
	        t.setCorpAddress(this.getCorpAddress());
	        t.setCorpEmail(this.getCorpEmail());
	        t.setCateType(this.getCateType());
	        t.setCorpShort(this.getCorpShort());//企业简称
	        
	        t.setCertificateExpiry(this.getCertificateExpiry());//法人身份证发证日
	        t.setCertificateExpiryEnd(this.getCertificateExpiryend());//法人身份证到期日
	        t.setCertificateNo(this.getCertificateNo());//社会信用证代码
	        t.setBusiScope(this.getBusiScope());//经营范围
	        
	        
	        
	        
	        t.setBankAccAddress(this.getBankAccAddress());//开户行名称
	        t.setBankNo(this.getBankNo());//联行号
	        t.setPassword(this.getPassword());
	        t.setExtend1(this.getExtend1());
	        Date now = new Date();
	        t.setCreateTime(now);
	        t.setUpdateTime(now);
	        return t;
		}
		public Intermediate toInter() {
			Intermediate cus = new Intermediate();
			cus.setCustomerId(customerId);
			cus.setCustomerType("01");
			cus.setCustomerFlag(this.getCustomerFlag());//客户标识
			cus.setStatus("01");//是否有效
			cus.setMerchId(this.getMerchId());//商户号
			cus.setParentId(this.getParentCustomerId());//父客户

			cus.setCustomerLevel("1");
			cus.setCustomerName(this.getCorpName());//商户名称
			cus.setOpenBank("ZJ");//开户行--此接口固定为中金
			cus.setCertType("260");//统一社会征信代码
			cus.setCertNo(this.getCorpCertNo());//证件号码
			cus.setLegalName(this.getResName());//法人姓名
			cus.setLegalPhoneNo(this.getCorpContactNo());//法人手机号
			cus.setLegalCertType("0");//法人证件类型--身份证
			cus.setLegalCertNo(this.getCorpCertNo());//法人身份证号
//			cus.setPhoneNo(phoneNo);//没有找到企业联系方式
			cus.setEmail(this.getCorpEmail());//企业邮箱
			cus.setShortName(this.getCorpShort());//客户简称
			Date now = new Date();
			cus.setCreateTime(now);
			cus.setModifyTime(now);
			cus.setOperatingProvince(this.getProvince());//企业经营所在省
			cus.setOperatingCity(this.getCity());//企业经营所在城市
			cus.setOperatingAddress(this.getCorpAddress());//企业经营地址

			cus.setComName(this.getCorpName());//企业名称
			cus.setChkSts("02");//审核通过
			
			return cus;
		}		
}
