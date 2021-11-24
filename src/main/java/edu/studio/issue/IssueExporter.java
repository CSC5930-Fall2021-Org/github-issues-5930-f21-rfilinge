package edu.studio.issue;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class IssueExporter {

    public static void main(String args[]) throws IOException
    {
        IssueExporter export = new IssueExporter();
        
        if(args.length==0)
        {
            System.out.println("This personal access token is invalid");

        }               
        if(export.isArgsValid(args[0])==false)
        {
            System.out.println("This personal access token is invalid");
        }
        else
        {
            String PAT = args[0];
            GitHubRestClient client = new GitHubRestClient();
            String listOfIssues = export.removeNewLines(client.getIssues(PAT));
            //added to fit issue entirely on one line, as there was an issue with newLines
            
            IssueParser parser = new IssueParser();
            List<Issue> issues = parser.parseIssues(listOfIssues);
            FileWriter myWriter = new FileWriter("src/main/resources/actual-issues.txt");
            
            for(int x=0;x<issues.size();x++)
            {
                myWriter.write(issues.get(x).toString() + "\n");
                myWriter.flush();
            }
            myWriter.close();
        }
    }

    public boolean isArgsValid(String argument) 
    {
        if(argument.isEmpty())
        {
            return false;
        }
        return true;
    }
    
    public String listOfIssues(GitHubRestClient client, String pat)
    {
        return client.getIssues(pat);
    }
    public String removeNewLines(String old)
    {
        old = old.replace("\\r\\n", "(next line)");
        return old;
    }
    
    
    
}
