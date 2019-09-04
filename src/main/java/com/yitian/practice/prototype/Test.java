package com.yitian.practice.prototype;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.sf.cglib.beans.BeanCopier;

public class Test {
	private static final BeanCopier copier = BeanCopier.create(Sources.class, Target.class, false); 
	private static final int count = 10000;
	public static void main(String[] args) {
		Sources sources = buildBaseData();
		
		testManual(sources);
		testApache(sources);
		testSpring(sources);
		testCglib(sources);
	}
	public static void testManual(Sources sources) {
		long start = System.currentTimeMillis();
		for(int i = 0; i < count; i++) {
			Target t = sources.toTarget();
		}
		long end = System.currentTimeMillis();
		show("�ֹ�",(end-start));
	}
	public static void testApache(Sources sources) {
		long start = System.currentTimeMillis();
		Target t = new Target();
		try {
			for(int i = 0; i < count; i++) 
				BeanUtils.copyProperties(t, sources);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		show("apache",(end-start));
	}
	public static void testSpring(Sources sources) {
		Target t = new Target();
		long start = System.currentTimeMillis();
		for(int i = 0; i < count; i++) 
			org.springframework.beans.BeanUtils.copyProperties(sources, t);
		long end = System.currentTimeMillis();
		show("spring",(end-start));
	}
	public static void testCglib(Sources sources) {
		Target t = new Target();
		long start = System.currentTimeMillis();
		for(int i = 0; i < count; i++) 
			copier.copy(sources, t, null);
		long end = System.currentTimeMillis();
		show("cglib",(end-start));
	}
	private static Sources buildBaseData() {
		Sources data = new Sources();
		data.setChUserId("chuxjy");
		data.setOrderId("1566978876778");
		data.setCorpName("�����й�¥�����Ӷ��۾���Ӫ��");
		data.setParentCustomerId("21f059c5224d4f36857b83d14cb74df8");//����
		data.setCustomerFlag("04");
//		data.setCustomerId("");
		data.setCorpShort("short_");
		data.setCateType("201");//�������
		data.setCorpEmail("123@qq.com");//��˾ ����
		data.setCorpAddress("����·");//��˾��ַ
		data.setProvince("13");
		data.setCity("130400");
		data.setIndustryType("120");//��ҵ����
		data.setIndustry("A0123");//ͨ����ҵ����
		data.setCorpScale("03");//��ҵ��ģ
		data.setBasicAccNo("1019191888339");//��ҵ������
		data.setAuthCapital("1333333450901.00");//ע���ʱ�
		data.setBusiScope("ũҵ");//��Ӫ��Χ
		data.setCertificateNo("92350102MA2YRWWA1G");//ͳһ�������֤����
		data.setCorpCertExpiryend("20201212");
		data.setResName("����");//��������
		data.setCorpCertNo("430602200211128954");//�������֤��
		data.setCertificateExpiry("20101212");
		data.setCertificateExpiryend("20201212");//�������֤������
		data.setCorpContactNo("13838389438");//�����ֻ���
		data.setPersonEmail("1234@qq.com");//��������
		data.setPassword("132467");//��������
		
		data.setInter(data.toInter());
		return data;
	}
	private static void show(String title,long time) {
		String msg = String.format("%s��ʱ:%d;",title, time);
		System.out.println(msg);
	}
	private static void show(String title,long time,boolean equal) {
		String msg = String.format("%s��ʱ:%d;�����%s",title, time,equal);
		System.out.println(msg);
	}
}
