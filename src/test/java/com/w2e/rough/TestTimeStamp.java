package com.w2e.rough;

import java.util.Date;

public class TestTimeStamp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date date =new Date();
		String screenShotName= date.toString().replace(":", "_").replace(" ", "_")+".jpg";
		System.out.println(screenShotName);
		

	}

}
