package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.model.Student;


public interface StudentService {


	void addStudent(Student s1);

	public boolean addStudentSecond(Student s1) throws SQLException, ClassNotFoundException, SAXException, IOException, ParserConfigurationException;

	public ArrayList<Student> getAllStudents() throws Exception;



	public ArrayList<Student> getStudentDetail(String parameter) throws Exception;

}
