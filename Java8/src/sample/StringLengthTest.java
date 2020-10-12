package sample;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StringLengthTest {

	
	public static void main(String[] args) {
		try {
			String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\00004545\\Desktop\\sampleData.txt")));
			int length = getStringByteSizeByWidth(content, 392);
			System.out.println(length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static int getStringByteSizeByWidth(String value, int width) {
		int wlength = 0;
		int stringsize = 0;
		for (int i = 0; i < value.length(); i++) {
			String strchar = value.substring(i,i+1);
            byte[] bytstr = new byte[0];
            try {
                bytstr = strchar.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                bytstr = value.getBytes();
            }
            if (wlength + bytstr.length > width) {
				if (bytstr.length == 2 && wlength + bytstr.length == width+1) {
					stringsize++;
				}
				wlength = bytstr.length;
			} else {
				wlength += bytstr.length;
			}
			stringsize+=bytstr.length;
		}
		return stringsize;
	}
	
}
