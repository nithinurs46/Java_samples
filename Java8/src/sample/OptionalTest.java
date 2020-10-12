package sample;


import java.util.Optional; 


public class OptionalTest {
	public static void main(String[] args) {  
        String[] str = new String[10]; 
        String msgNumb = "001001";
        String aerNumb = "100100";
        String status = "01";
        String sender = "sss";
        String receiver = "rrr";
        str[0] = "11";
        Optional<String> checkNull = Optional.ofNullable(str[5]);  
        if(checkNull.isPresent()){  // check for value is present or not  
            String lowercaseString = str[5].toLowerCase();  
            System.out.print(lowercaseString);  
        }else  
            System.out.println("string value is not present");  
    }
}
