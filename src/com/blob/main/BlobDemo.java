package com.blob.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.blob.model.JobProfile;
import com.blob.util.HibernateUtil;

public class BlobDemo {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		byte[] picture = null;
		char[] bio = null;
		
//			Blob
			try(FileInputStream fis = new FileInputStream("pet.jpg")){
				picture = new byte[(int)fis.available()];
				fis.read(picture);
				
//				Clob
			File f = new File("Object methods in Jav.txt");
			try(FileReader reader = new FileReader(f)){
				bio = new char[(int)f.length()];
				reader.read(bio);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		
		try {
			session = HibernateUtil.getSession();
			if(session!=null) {
				transaction = session.beginTransaction();
				if(transaction!=null) {
					JobProfile profile = new JobProfile();
					profile.setName("Sowmya");
					profile.setPhoto(picture);
					profile.setResume(bio);
					profile.setActive(true);
					Integer idValue = (Integer)session.save(profile);
					System.out.println("Record saved with id :: "+ idValue);
					flag = true;
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			flag= false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
		if(flag) {
			transaction.commit();
		}else
		{
			transaction.rollback();
		}
		HibernateUtil.closeSession(session);
	}

}
}