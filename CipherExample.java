import java.util.Scanner;
public class CipherExample{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the plain text");
    String plainText=sc.nextLine();
    System.out.println("Enter the secret key");
    int key=sc.nextInt();
    String ceaserCipherText=ceaserCipher(plainText,key);
    System.out.println("Cipher Text is: "+ceaserCipherText);
    System.out.println("Decrypted Text for each key:");
    for(int i=0;i<=key;i++){
      String decryptedText=ceaserDecipher(ceaserCipherText,i);
      System.out.println("At key "+i+":"+decryptedText);
    }
    sc.close();
  }
  private static String ceaserCipher(String text,int key){
    StringBuilder result=new StringBuilder();
    for(char ch:text.toCharArray()){
      if(Character.isLetter(ch)){
        char base=Character.isLowerCase(ch)? 'a':'A';
        result.append((char)(((ch-base+key)%26)+base));
      }
      else{
        result.append(ch);
      }
    }
  return result.toString();
}
private static String ceaserDecipher(String text,int key){
  return ceaserCipher(text,26-key);
}
}
