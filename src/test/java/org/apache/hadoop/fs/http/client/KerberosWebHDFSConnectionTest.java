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
		conn = new KerberosWebHDFSConnection("http://cdh4b.0.efoxconn.com:14000", "zen", "abc123");
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
		String path= "user/zen";
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
