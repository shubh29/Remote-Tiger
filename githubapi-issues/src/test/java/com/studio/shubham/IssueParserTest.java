package com.studio.shubham;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.List;

/*
 * Referred dataFormat from Professor Kristin Obermyer's code.
 */
public class IssueParserTest {
  String sampleOutput;
  private static SimpleDateFormat dateFormat = new SimpleDateFormat(IssueParser.DATE_FORMAT);

  @Test
  public void testParseIssues() throws Exception {
    IssueParser issueParser = new IssueParser();
    List<Issue> issues = issueParser.parseIssues(sampleOutput);
    assertNotNull(issues);
    Issue issue0 = issues.get(0);
    assertEquals("Resolved the issue of passing date as parameter",
        issue0.getTitle());
    assertEquals("", issue0.getBody());
    assertEquals("shubh29", issue0.getUser().getLogin());
    assertEquals(null, issue0.getAssignee());
    assertEquals("open", issue0.getState());
    assertEquals("5", issue0.getNumber());
    assertEquals(dateFormat.parse("2015-02-10T20:23:39Z"), issue0.getCreatedAt());
    assertEquals(null, issue0.getClosedAt());
    assertEquals(8636836, issue0.getUser().getId());
    assertEquals(57231138, issue0.getId());
    
    Issue issue1 = issues.get(1);
    assertEquals("title", issue1.getTitle());
    assertEquals("comment3", issue1.getBody());
    assertEquals("shubh29", issue1.getUser().getLogin());
    assertEquals("shubh29", issue1.getAssignee().getLogin());
    assertEquals("open", issue1.getState());
    assertEquals(dateFormat.parse("2015-01-28T22:37:19Z"), issue1.getCreatedAt());
    assertEquals("3", issue1.getNumber());
    assertEquals(null, issue1.getClosedAt());
    assertEquals(8636836, issue1.getUser().getId());
    assertEquals(55826683, issue1.getId());
    
    Issue issue2 = issues.get(2);
    assertEquals("title", issue1.getTitle());
    assertEquals("comment2", issue2.getBody());
    assertEquals("shubh29", issue2.getUser().getLogin());
    assertEquals("shubh29", issue2.getAssignee().getLogin());
    assertEquals("open", issue2.getState());
    assertEquals(dateFormat.parse("2015-01-28T22:33:17Z"), issue2.getCreatedAt());
    assertEquals("2", issue2.getNumber());
    assertEquals(null, issue2.getClosedAt());
    assertEquals(8636836, issue2.getUser().getId()); 
    assertEquals(55826228, issue2.getId());
    
    Issue issue3 = issues.get(3);
    assertEquals("title", issue3.getTitle());
    assertEquals("comment1", issue3.getBody());
    assertEquals("shubh29", issue3.getUser().getLogin());
    assertEquals("shubh29", issue3.getAssignee().getLogin());
    assertEquals("open", issue3.getState());
    assertEquals(dateFormat.parse("2015-01-28T22:26:04Z"), issue3.getCreatedAt());
    assertEquals("1", issue3.getNumber());
    assertEquals(null, issue3.getClosedAt());
    assertEquals(8636836, issue3.getUser().getId());
    assertEquals(55826228, issue3.getId());
  }

  @Before
  public void setUp() throws Exception {
    BufferedReader bufferedReader = null;
    FileReader fileReader = null;
    try {
      String path = System.getProperty("user.dir");
      fileReader = new FileReader(path
      + "/src/sample-output.txt");
      bufferedReader = new BufferedReader(fileReader);
      StringBuffer fileContent = new StringBuffer(bufferedReader.readLine());
      while (bufferedReader.ready()) {
        fileContent.append(bufferedReader.readLine());
      }
      sampleOutput = fileContent.toString();
      System.out.println(sampleOutput);
    } catch (Exception e) {
      System.out.println("Error Message" + e.getMessage());
    } finally {
      if (bufferedReader != null) {
        bufferedReader.close();
      }
      if (fileReader != null) {
        fileReader.close();
      }
   }
  }
}
