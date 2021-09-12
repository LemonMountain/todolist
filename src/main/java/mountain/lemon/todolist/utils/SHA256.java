package mountain.lemon.todolist.utils;

import java.security.MessageDigest;

public class SHA256 {
  
  public static String encrypt(String string) {
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      md.update(string.getBytes());
      byte[] bytes = md.digest();
      StringBuilder builder = new StringBuilder();
      for (byte b : bytes)
        builder.append(String.format("%02x", b));
      return builder.toString();
    }
    catch(Exception e) {
      System.out.println("비밀번호 암호화에 실패하였습니다.");
      return string;
    }
  }
}
