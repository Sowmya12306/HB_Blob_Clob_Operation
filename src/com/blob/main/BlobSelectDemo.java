package com.blob.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.blob.model.JobProfile;
import com.blob.util.HibernateUtil;

public class BlobSelectDemo {

	public static void main(String[] args) {
		Session session = null;
		boolean flag = false;
		JobProfile profile = null;
		int id = 1;
		FileOutputStream fos = null;
		FileWriter fw= null;
		try {
			session = HibernateUtil.getSession();
			if(session!=null) {
				profile = session.get(JobProfile.class, id);
				if(profile!=null) {
					fos = new FileOutputStream("store/photo.jpg");   // Stream is for byte data
					fos.write(profile.getPhoto());
					
					fw = new FileWriter("store/resume.txt");
					fw.write(profile.getResume());
					
					fos.flush();
					fw.flush();
					System.out.println("Lob's are retrieved");
					System.out.println(profile);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			flag= false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
		HibernateUtil.closeSession(session);
	}

}
}