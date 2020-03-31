package com.yitian.practice.redis.lesson2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.text.DecimalFormat;

public class ListenServer {
/**
 * 每个字段长：267
 * date:5个
 * 修改信息：35
 * @param args
 */
	public static void main(String[] args) {
		File file = new File("F:\\tmp\\探叔\\0201.jdq");
		Charset cset = Charset.forName("gbk");
		FileInputStream finput = null;
		try{
			finput = new FileInputStream(file);
			byte[] gbchar = new byte[267];
			int eof = 0;
			int count = 0;
			int count_11111 = 0;
			finput.skip(267);
			while((eof = finput.read(gbchar))!=-1) {
				Node node = new Node(); 
				
				node.setKpa(getKpa(gbchar));//5-8 位是KPA
				node.setDate( new String(gbchar,0,5,cset));//时间:0-5位
				DecimalFormat decimalFormat=new DecimalFormat(".00");
				for(int i = 9; i < 267; i++) {
					try {
						
						System.out.println(i + "-" +decimalFormat.format(getCloumn1(gbchar)));
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				node.setCloumn1(new String(gbchar,5,4));
				node.setRemark(new String(gbchar,232,35,cset));
				System.out.println(node.toString());
				if("11111".equals(node.getDate())) {
					count_11111++;
				}
				count++;
				break;
			}
			System.out.println("单记录长:" + count +";没用的长:" + count_11111);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static int getKpa(byte[] bytes) {
	
		byte[] tmp = new byte[4];
		for(int i =0; i <4;i++) {
			tmp[i] = bytes[8-i];
		}
		return ByteBuffer.wrap(tmp).getInt();
	}
	public static float getCloumn1(byte[] bytes) {
		
		byte[] tmp = new byte[8];
		for(int i =0; i <8;i++) {
			tmp[i] = bytes[16 - i];
		}
		
		return ByteBuffer.wrap(tmp).getFloat();
	}
}
class Node{
	private int kpa;
	private String date;
	private String cloumn1;
	private String remark;
	
	public int getKpa() {
		return kpa;
	}
	public void setKpa(int kpa) {
		this.kpa = kpa;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCloumn1() {
		return cloumn1;
	}
	public void setCloumn1(String cloumn1) {
		this.cloumn1 = cloumn1;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.kpa);
		sb.append(" ").append(date);
		sb.append("  ").append(this.cloumn1);
		sb.append("  ").append(remark);
		return sb.toString();
	}

}