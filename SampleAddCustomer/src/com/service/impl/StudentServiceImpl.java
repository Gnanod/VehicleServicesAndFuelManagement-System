package com.service.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.model.Student;

import com.service.StudentService;
import com.util.CommonConstants;
import com.util.DBConnection;
import com.util.QueryUtil;


public class StudentServiceImpl implements StudentService{

	public static final Logger log = Logger.getLogger(StudentServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;
	
	private PreparedStatement preparedStatement;

	
	
	 public StudentServiceImpl() {
		 	
		 connection = DBConnection.getConnection();
		 
	}
	 
	
	@Override
	public void addStudent(Student s1) {
		
//		try {
//			
//			
//		//	preparedStatement = connection.prepareStatement(QueryUtil.stringQueryByID(CommonConstants.QUERY_ID_INSERT_EMPLOYEES));
//			connection.setAutoCommit(false);
//			
//			preparedStatement.setString(1, s1.getStdIdNum());
//			preparedStatement.setString(2, s1.getStdName());
//			preparedStatement.setString(3, s1.getStdAddress());
//			preparedStatement.setString(4, s1.getStdPhone());
//			
//			preparedStatement.execute();
//			connection.commit();
//			
//
//		} catch (ClassNotFoundException | SQLException | SAXException | IOException | ParserConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}

//	private static void createStudentTable() {
//		try {
//			connection = DBConnection.getConnection();
//			statement = connection.createStatement();
//			
//			statement.executeUpdate(QueryUtil.stringQueryByID(CommonConstants.QUERY_ID_DROP_TABLE));
//			
//			statement.executeUpdate(QueryUtil.stringQueryByID(CommonConstants.QUERY_ID_CREATE_TABLE));
//
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SAXException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ParserConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public boolean addStudentSecond(Student s1)
			throws SQLException, ClassNotFoundException, SAXException, IOException, ParserConfigurationException {

		
		connection = DBConnection.getConnection();
		String sql="insert into student(studentId,studentName,address,phoneNumber)values(?,?,?,?)";
		preparedStatement =connection.prepareStatement(sql);
		//preparedStatement = connection.prepareStatement(QueryUtil.stringQueryByID(CommonConstants.QUERY_ID_INSERT_EMPLOYEES));
		connection.setAutoCommit(false);
		preparedStatement.setString(1, s1.getStdIdNum());
		preparedStatement.setString(2, s1.getStdName());
		preparedStatement.setString(3, s1.getStdAddress());
		preparedStatement.setString(4, s1.getStdPhone());
		 int res=preparedStatement.executeUpdate();
		 connection.commit();
		 return res>0;
	}


	@Override
	public ArrayList<Student> getAllStudents() throws Exception {

        Statement stm = connection.createStatement();
        String SQL = "Select * from Student ";
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<Student> brandList = new ArrayList<>();
        while(rst.next()){
            Student brand = new Student(rst.getString("studentId"),rst.getString("studentName"),rst.getString("address"),rst.getString("phoneNumber"));
            brandList.add(brand);
        }  
        return brandList;
	}


	@Override
	public ArrayList<Student> getStudentDetail(String parameter) throws Exception {
		Statement stm = connection.createStatement();
        String SQL = "Select * from Student where studentName='"+parameter+"' ";
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<Student> brandList = new ArrayList<>();
        while(rst.next()){
            Student brand = new Student(rst.getString("studentId"),rst.getString("studentName"),rst.getString("address"),rst.getString("phoneNumber"));
            brandList.add(brand);
        }  
        return brandList;
	}
		

	

	

//	@Override
//	public boolean addStudentSecond(Student s1) {
//
//		int res=0;
//		try {
//			
//			connection = DBConnection.getConnection();
//			
//			preparedStatement = connection.prepareStatement(QueryUtil.stringQueryByID(CommonConstants.QUERY_ID_INSERT_EMPLOYEES));
//			connection.setAutoCommit(false);
//			
//			preparedStatement.setString(1, s1.getStdIdNum());
//			preparedStatement.setString(2, s1.getStdName());
//			preparedStatement.setString(3, s1.getStdAddress());
//			preparedStatement.setString(4, s1.getStdPhone());
//			
//			 res=preparedStatement.executeUpdate();
//			 connection.commit();
//			
//			
//
//		} catch (ClassNotFoundException | SQLException | SAXException | IOException | ParserConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return res>0;
//	}



}
