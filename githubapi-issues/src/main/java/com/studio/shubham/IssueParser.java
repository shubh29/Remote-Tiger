package com.studio.shubham;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/*
 * Sources: Referred Date_FORMAT from professor Kristin Obermyer's code.
 */
public class IssueParser {
  protected static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

  public List<Issue> parseIssues(String input) {
    List<Issue> issues = null;
    Gson gson = new GsonBuilder().setDateFormat(DATE_FORMAT)
          .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
          .create();
    issues = new ArrayList<Issue>();
    Type collectionType = new TypeToken<List<Issue>>() {
        }.getType();
    issues = gson.fromJson(input, collectionType);
    return issues;
  }
}
