import java.util.HashMap;
import java.util.Scanner;

public class Kenab {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numberOfQueries = input.nextInt();
    HashMap<String,User> ipAsKeyTable = new HashMap<>();
    HashMap<String,User> usernameAsKeyTable = new HashMap<>();
    for (int i = 0; i < numberOfQueries; i++) {
      int queryType = input.nextInt();
      String[] queryParams = input.next().split(":");
      if (queryType == 1) {
        if (queryParams[1].contains("_") ||
            queryParams[1].contains("*") ||
            queryParams[1].contains("#") ||
            queryParams[1].contains("$")
        ){
          System.out.println("invalid username");
        } else {
          User newUser = new User(queryParams[0],queryParams[1]);
          ipAsKeyTable.put(newUser.getIp(),newUser);
          usernameAsKeyTable.put(newUser.getUsername(),newUser);
        }
      } else if (queryType == 2) {
        int transactionValue = Integer.parseInt(queryParams[2]);
        User sender = ipAsKeyTable.get(queryParams[0]);
        User receiver = usernameAsKeyTable.get(queryParams[1]);
        receiver.setBalance(receiver.getBalance() + transactionValue);
        sender.setBalance(sender.getBalance() - transactionValue);
      } else {
        System.out.println(ipAsKeyTable.get(queryParams[0]).getBalance());
      }
    }
  }
}
class User {
  private int balance;
  private String ip;
  private String username;

  public User(String ip,String username) {
    this.balance = 0;
    this.ip = ip;
    this.username = username;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}