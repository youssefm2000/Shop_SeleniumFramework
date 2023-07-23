package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class DataReader {

	public String ffirstname,llastname,eemail,pphonenum,ppassword,cconFirmapass;
	   
	public void Reader() throws FileNotFoundException, IOException, ParseException {
		
		String path =System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.json";
		File srcfile = new File(path);
		JSONParser parser = new JSONParser();
		JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcfile));
		
		for(Object yobject : jarray) {
			
			JSONObject person = (JSONObject) yobject;
			
			ffirstname=(String) person.get("firstname");
			llastname=(String) person.get("lastname");
			eemail=(String) person.get("email");
			pphonenum= (String) person.get("phonenumber");
			ppassword=(String) person.get("password");
			cconFirmapass=(String) person.get("confirmpassword");

		}
		
		
	}
	
	
}
