package edu.studio.issue;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class IssueExporter {

    public static void main(String args[]) throws IOException
    {
        
        if(args.length==0 || args[0].isEmpty())
        {
            System.out.println("This personal access token is invalid");
        }
        else
        {
            String PAT = args[0];
            GitHubRestClient client = new GitHubRestClient();
            String listOfIssues = client.getIssues(PAT);
            
            IssueParser parser = new IssueParser();
            List<Issue> issues = parser.parseIssues(listOfIssues);
            
            File file = new File("src/main/resources/actual-issues.txt");
            // creates the file
            file.createNewFile();
            // creates a FileWriter Object 
            FileWriter myWriter = new FileWriter("src/main/resources/actual-issues.txt");
            
            for(int x=0;x<issues.size();x++)
            {
                System.out.println(issues.get(x).toString());
                String a = issues.get(x).toString();
                myWriter.write(issues.get(x).toString() + "\n");
                myWriter.flush();
            }
            myWriter.close();
        }
    }
}
