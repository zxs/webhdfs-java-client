package org.apache.hadoop.fs.http.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.hadoop.security.authentication.client.AuthenticationException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PseudoWebHDFSConnectionTest {

	static PseudoWebHDFSConnection pConn = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		pConn = new PseudoWebHDFSConnection("http://api.0.efoxconn.com:14000", "wesley", "anything");
	}
	
	@Before
	public void setUp() throws Exception {
		System.out.println(" setUp... per Test ...");
		//pConn = new PseudoWebHDFSConnection("http://api.0.efoxconn.com:14000", "wesley", "anything");
	}

	@Test
	public void getHomeDirectory() throws MalformedURLException, IOException, AuthenticationException {
		pConn.getHomeDirectory();
	}
	
	
	@Test
	public void listStatus() throws MalformedURLException, IOException, AuthenticationException {
		String path= "user/wesley";
		pConn.listStatus(path);
	}
	
	//@Test
	public void create() throws MalformedURLException, IOException, AuthenticationException {
		String path = "user/wesley/Visual_Paradigm_for_UML_Linux_NoInstall_9_0_20120418.tar.gz";
		FileInputStream is = new FileInputStream(new File("/home/wesley/Visual_Paradigm_for_UML_Linux_NoInstall_9_0_20120418.tar.gz"));
		pConn.create(path, is);
	}
	
	
	//TODO Test Other PseudoWebHDFSConnectionTest's Method

}
