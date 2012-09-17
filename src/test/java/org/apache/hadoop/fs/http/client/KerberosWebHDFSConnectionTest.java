package org.apache.hadoop.fs.http.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.hadoop.security.authentication.client.AuthenticationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KerberosWebHDFSConnectionTest {
	KerberosWebHDFSConnection conn = null;
	@Before
	public void setUp() throws Exception {
		conn = new KerberosWebHDFSConnection("http://cdh4b.0.efoxconn.com:14000", "fUcacfba0f0c29445d8284096097f925e1", "pea6e2d22-6e00-4101-b0d0-584765f3ed68");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getHomeDirectory() throws MalformedURLException, IOException, AuthenticationException {
		
		String json = conn.getHomeDirectory();
		System.out.println(json);
	}
	
	@Test
	public void listStatus() throws MalformedURLException, IOException, AuthenticationException {
		String path= "user/fUcacfba0f0c29445d8284096097f925e1";
		String json = conn.listStatus(path);
		System.out.println(json);
	}
	
	//@Test
	public void open() throws MalformedURLException, IOException, AuthenticationException {
		String path="user/zen/在TMSBG南京軟件部總結的資料.7z.001";
		FileOutputStream os = new  FileOutputStream(new File("/tmp/downloadfromhdfs.file"));
		String json = conn.open(path, os);
		System.out.println(json);
	}
	
	
	//@Test
	public void create() throws MalformedURLException, IOException, AuthenticationException {
		FileInputStream is = new FileInputStream(new File("/tmp/downloadfromhdfs.file"));
		String path="user/zen/newupload.file"; 
		String json = conn.create(path, is);
		System.out.println(json);
	}
	
	//@Test
	public void delete() throws MalformedURLException, IOException, AuthenticationException {
		String path="user/zen/bigfile.tar.gz-new"; 
		String json = conn.delete(path);
		System.out.println(json);
	}
	
	//TODO Test Other KerberosWebHDFSConnectionTest's Method

}
