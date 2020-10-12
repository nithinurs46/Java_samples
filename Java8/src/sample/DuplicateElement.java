package sample;


public class DuplicateElement {  
    public static void main(String[] args) {      
          
        //Initialize array   
        int [] arr = new int [] {1, 2, 3, 4, 2, 7, 8, 8, 3};   
        int size = arr.length;
        int[] arrayNew = new int[size];
        //Searches for duplicate element 
        int dupCount = 0;
        for(int i = 0; i < arr.length; i++) {  
            for(int j = i + 1; j < arr.length; j++) {  
                if(arr[i] == arr[j]) {
                    //System.out.println(arr[j]); 
                    dupCount++;
                } else {
                	arrayNew[i] = arr[i];
                }
            }  
        }  
        
        System.out.println("dup count:"+DistinctList(arr));
    }  
    
    public static int DistinctList(int[] arr) {
    	int dupCount = 0;
        for(int i = 0; i < arr.length; i++) {  
            for(int j = i + 1; j < arr.length; j++) {  
                if(arr[i] == arr[j]) {
                    System.out.println(arr[j]); 
                    dupCount++;
                } 
            }  
        } 
        return dupCount;
      }
}  