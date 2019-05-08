package com.model;

public class Student {
		private String stdIdNum;
		private String stdName;
		private String stdAddress;
		private String stdPhone;
		
		
		public Student() {
			this.stdIdNum = null;
			this.stdName =  null;
			this.stdAddress =  null;
			this.stdPhone =  null;
		}
		public Student(String stdIdNum, String stdName, String stdAddress, String stdPhone) {
			super();
			this.stdIdNum = stdIdNum;
			this.stdName = stdName;
			this.stdAddress = stdAddress;
			this.stdPhone = stdPhone;
		}
		public String getStdIdNum() {
			return stdIdNum;
		}
		public void setStdIdNum(String stdIdNum) {
			this.stdIdNum = stdIdNum;
		}
		public String getStdName() {
			return stdName;
		}
		public void setStdName(String stdName) {
			this.stdName = stdName;
		}
		public String getStdAddress() {
			return stdAddress;
		}
		public void setStdAddress(String stdAddress) {
			this.stdAddress = stdAddress;
		}
		public String getStdPhone() {
			return stdPhone;
		}
		public void setStdPhone(String stdPhone) {
			this.stdPhone = stdPhone;
		}
		
}
