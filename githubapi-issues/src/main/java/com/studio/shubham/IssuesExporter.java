package com.studio.shubham;

import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class IssuesExporter {   
  private static final String URL = "/repos/Villanova-SoftwareStudio-Spring2014/" ;
  private static final String URL_END = "-private-repo/issues";
  List<Issue> issues;
  Issue issueException;
  Issue issueBug1;
  Issue issueBug2;
  String username = "";
  String password = "";
  String repoName = "";
  
  /*
   * export method to manually create issues
   */
  private void export() {
    Issue issueException = new Issue();
    issueException.setTitle("Exception");
    issueException.setId(7);
    issueException.setBody("Hi this is the a case of exception...Invalid values entered!!");
    issueException.setState("Working");
    issueException.setNumber("14");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try {
      issueException.setCreatedAt(dateFormat.parse("28-01-2015"));
      issueException.setClosedAt(dateFormat.parse("04-02-2015"));
    } catch (ParseException e1) {
      e1.printStackTrace();
    }

    Issue issueBug1 = new Issue();
    issueBug1.setTitle("Bug-1");
    issueBug1.setId(4);
    issueBug1.setBody("Hi this is a scary bug!!");
    issueBug1.setState("Need Help");
    issueBug1.setNumber("9");
    try {
      issueBug1.setCreatedAt(dateFormat.parse("28-01-2015"));
      issueBug1.setClosedAt(dateFormat.parse("02-02-2015"));
    } catch (ParseException e1) {
      e1.printStackTrace();
    }
  
    Issue issueBug2 = new Issue();
    issueBug2.setTitle("Bug-2");
    issueBug2.setId(3);
    issueBug2.setBody("Hi this is a simple bug!!");
    issueBug2.setState("Fixed");
    issueBug2.setNumber("17");
    try {
      issueBug2.setCreatedAt(dateFormat.parse("28-01-2015"));
      issueBug2.setClosedAt(dateFormat.parse("29-01-2015"));
    } catch (ParseException e1) {
      System.err.print("Caught Parse Exception");
    } 
    
    User user1 = new User();
    user1.setLogin("shubham");
    user1.setId(3);

    User user2 = new User();
    user2.setLogin("Mahajan");
    user2.setId(7);

    User user3 = new User();
    user3.setLogin("sm");
    user3.setId(4);

    issueException.setUser(user1);
    issueException.setAssignee(user1);

    issueBug1.setUser(user2);
    issueBug1.setAssignee(user2);

    issueBug2.setUser(user3);
    issueBug2.setAssignee(user3);

    issues = new ArrayList<Issue>();
    issues.add(issueException);
    issues.add(issueBug2);
    issues.add(issueBug1);
    
    for (Issue issue : issues) {
      System.out.println(issue);
    }
  }
  
  /*
   * method to take user input
   */
  public void userInput() {
    try (Scanner scanner = new Scanner(System.in);) {
      System.out.println("Enter your Username:");
      username = scanner.nextLine();
      System.out.println("Enter your Password:");
      password = scanner.next();
      System.out.println("Enter your Repository name:");
      repoName = scanner.next();
    } catch (Exception e) {
      System.err.print("Username and Password do not match!!");
    }
    
    GitHubRestClient gitHubRestClient = new GitHubRestClient();
    String jsonOpen = null;
    try {
      jsonOpen = gitHubRestClient.requestIssues(username,
        password, URL + repoName + URL_END);
    } catch (Exception e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    String jsonClosed = null;
    try {
      jsonClosed = gitHubRestClient.requestIssues(username,
        password, URL + repoName + URL_END + "?state=closed");
    } catch (Exception e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    System.out.println("Open issues are:" + jsonOpen + "\n");
    System.out.println("Closed issues are:" + jsonClosed + "\n");

    IssueParser issueParser = new IssueParser();
    ArrayList<Issue> issues = new ArrayList<Issue>();
    List<Issue> issuesClosed = new ArrayList<Issue>();
    issues = (ArrayList<Issue>) issueParser.parseIssues(jsonOpen);
    issuesClosed = issueParser.parseIssues(jsonClosed);

    System.out.println(issues);
    System.out.println(issuesClosed);

    issues.addAll(issuesClosed);
    System.out.println(issues);

    Collections.sort(issues);
    System.out.println(issues);
    
    export();
    try {
      appendToFile(issues);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    countIssues(issues);
  }
  
  /*
   * My main method
   */
  public void appendToFile(ArrayList<Issue> issues) throws Exception {
    
    try (FileWriter fileWriter = new FileWriter("issues.txt", false);) {
      String newline = System.getProperty("line.separator");
      Iterator<Issue> iterate = issues.iterator();
      while (iterate.hasNext()) {
        Issue issue = iterate.next();
        String text = issue.toString();
        System.out.println(text);
        fileWriter.write(text + newline);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } 
  }
  
  public void countIssues(ArrayList<Issue> issues) {
    int count = issues.size();
    System.out.println("Number of Issues" + count);
  }
  
  public static void main(String[] args) throws Exception {
    IssuesExporter exporter = new IssuesExporter();
    exporter.userInput();
    
    
  }

}
