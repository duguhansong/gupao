package com.yitian.practice.prototype;

import java.util.Date;

public class Sources {
		private String merchId;//�̻���

		private String chUserId;//�ͻ����̻��˵��û��ţ�ȷ���̻���Ψһ��

		private String orderId;//���Ȳ�����32���ַ���������0-9����ĸ��Сдa-z��ɣ���֧�������ַ��ͺ��֡��䳤

		private String corpName;//��ҵ����

		private String parentCustomerId;//������ʶ�ϼ��ͻ���

		private String customerFlag;//01-�����̣�02-����ƽ̨+�����̣�03-����ƽ̨��04-С�̻�

		private String customerId;//�����ͻ���

		private String corpShort;//��ҵ��ƣ�Ĭ��Ϊ�ͻ�����

		private String cateType;//�����¼

		private String corpEmail;//��ҵ����

		private String corpAddress;//��ҵ��ַ

		private String province;//ʡ��

		private String city;//����

		private String industryType;//��ҵ����

		private String industry;//ͨ����ҵ����

		private String corpScale;//��ҵ��ģ

		private String basicAccNo;//��ҵ������

		private String authCapital;//��λ���֣���С����

		private String busiScope;//��Ӫ��Χ

		private String certificateNo;//ͳһ�������֤����

		private String corpCertExpiryend;//ͳһ�������֤��Ч��YYYYMMDD

		private String resName;//��������

		private String corpCertNo;//�������֤��

		private String certificateExpiry;//YYYYMMDD

		private String certificateExpiryend;//YYYYMMDD��������ЧĬ��99999999

		private String corpContactNo;//�����ֻ���

		private String personEmail;//��������

		private String bankNo;//���󿨱���
		
		private String bankAccNo;//�������˺���Ϣ�����󿨱���

		private String bankAccName;//������ͻ����Ʊ���һ�£����󿨱���

		private String bankAccAddress;//���嵽��֧�У����󿨱���

		private String password;//�黧�������룬����6λ���֣�

		private String encryptMode="00";//00-������01-RSA��Կ����.Ĭ��Ϊ00

		private String extend1;//��չ�ֶ�1
		
		private Intermediate inter;//��ʱ����

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
	        t.setPlatAccFlag("02");//�˻����--��ҵ����
	        t.setIsFirst("1");//�Ƿ��״ο�����1-�״Σ�2-����
	        t.setPlatAccType("001");//�˻�����.�״ο���001-��
	        t.setStatus("01");//����״̬--������
	        t.setCorpName(this.getCorpName());//��ҵ����
	        t.setComType("01");//��ҵ��������,01-��ҵ��02���幤�̻�--�н���ҵ����ֻ����ҵ
	        t.setSettleAccType("01");//�н���ҵ����ֻ֧�ֶԹ���
	        
	        t.setResName(this.getResName());//��������
	        t.setCorpCertNo(this.getCorpCertNo());//�������֤ ��
	        t.setCorpContactNo(this.getCorpContactNo());//�����ֻ���
//	        acct.setContactNo(this.getContactNo());//��ҵ��ϵ�绰--�н���
	        t.setBankAccNo(this.getBankAccNo());//�����˺�
	        t.setBankAccName(this.getBankAccName());//�����˻�����
	        t.setPersonEmail(this.getPersonEmail());//��������
	        t.setBusiScope(this.getBusiScope());//��Ӫ��Χ
	        t.setAuthCapital(this.getAuthCapital());//ע���ʱ�
	        t.setBasicAccNo(this.getBasicAccNo());//��ҵ������
	        t.setCorpScale(this.getCorpScale());//��ҵ��ģ
	        t.setIndustry(this.getIndustry());//ͨ����ҵ����
	        t.setIndustryType(this.getIndustryType());//��ҵ����
	        t.setCity(this.getCity());
	        t.setProvince(this.getProvince());
	        t.setCorpAddress(this.getCorpAddress());
	        t.setCorpEmail(this.getCorpEmail());
	        t.setCateType(this.getCateType());
	        t.setCorpShort(this.getCorpShort());//��ҵ���
	        
	        t.setCertificateExpiry(this.getCertificateExpiry());//�������֤��֤��
	        t.setCertificateExpiryEnd(this.getCertificateExpiryend());//�������֤������
	        t.setCertificateNo(this.getCertificateNo());//�������֤����
	        t.setBusiScope(this.getBusiScope());//��Ӫ��Χ
	        
	        
	        
	        
	        t.setBankAccAddress(this.getBankAccAddress());//����������
	        t.setBankNo(this.getBankNo());//���к�
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
			cus.setCustomerFlag(this.getCustomerFlag());//�ͻ���ʶ
			cus.setStatus("01");//�Ƿ���Ч
			cus.setMerchId(this.getMerchId());//�̻���
			cus.setParentId(this.getParentCustomerId());//���ͻ�

			cus.setCustomerLevel("1");
			cus.setCustomerName(this.getCorpName());//�̻�����
			cus.setOpenBank("ZJ");//������--�˽ӿڹ̶�Ϊ�н�
			cus.setCertType("260");//ͳһ������Ŵ���
			cus.setCertNo(this.getCorpCertNo());//֤������
			cus.setLegalName(this.getResName());//��������
			cus.setLegalPhoneNo(this.getCorpContactNo());//�����ֻ���
			cus.setLegalCertType("0");//����֤������--���֤
			cus.setLegalCertNo(this.getCorpCertNo());//�������֤��
//			cus.setPhoneNo(phoneNo);//û���ҵ���ҵ��ϵ��ʽ
			cus.setEmail(this.getCorpEmail());//��ҵ����
			cus.setShortName(this.getCorpShort());//�ͻ����
			Date now = new Date();
			cus.setCreateTime(now);
			cus.setModifyTime(now);
			cus.setOperatingProvince(this.getProvince());//��ҵ��Ӫ����ʡ
			cus.setOperatingCity(this.getCity());//��ҵ��Ӫ���ڳ���
			cus.setOperatingAddress(this.getCorpAddress());//��ҵ��Ӫ��ַ

			cus.setComName(this.getCorpName());//��ҵ����
			cus.setChkSts("02");//���ͨ��
			
			return cus;
		}		
}
