package googleLeetCodeKit.interview.process;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
  import java.util.HashSet;
  import java.util.Set;

//https://leetcode.com/explore/featured/card/google/67/sql-2/3044/
@Slf4j
public class UniqueEmailAddresses {
  private String normalize(String email) {
    String[] parts = email.split("@");
    String[] localNameParts = parts[0].split("\\+");
    String localName = localNameParts[0].replace(".", "");
    System.out.println(localName);
    return localName + "@" + parts[1];
  }

  public int numUniqueEmails(String[] emails) {
    Set<String> normalizedEmails = new HashSet<>();
    for (String email: emails) {
      normalizedEmails.add(normalize(email));
    }
    return normalizedEmails.size();
  }

  @Test
  public void run() {
    String[] emails = {"bob@xyz.us.com", "bob@xyz.com", "bob.marley@xyz.com", "bob.+lennon@xyz.com"};
    System.out.println("Answer: " + numUniqueEmails(emails));
  }
}
