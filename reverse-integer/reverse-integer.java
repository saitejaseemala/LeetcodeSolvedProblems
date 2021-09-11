class Solution {
    public int reverse(int x) {
    
        int rem=0,rev=0;        
        boolean pos=x>=0;
        int xLstDig=x%10; //hold the last digit for 32-bit constraint check
        int noOfPlaces=1; //calculate the number of places to find the 1st digit 
                     //of reversed number for 32-bit constraint check
    
         if(!pos){
             x=x*(-1); //convert to a postive number
        }

         while(x>0){
            
             rem=x%10;
             rev=rev*10+rem;
             x=x/10;
             noOfPlaces=(x!=0)?noOfPlaces*10:noOfPlaces;//keep it limited to 1 place less
        }
    
       int revFstDig=rev/noOfPlaces; //hold first digit of reversed number
    
       if(!pos)
          revFstDig=(-1)*revFstDig;

     if(revFstDig!=xLstDig) //if digits exceeds 32 bit then first and last will not bE same.
        return 0;
    
    return pos?rev:rev*(-1);
}
}