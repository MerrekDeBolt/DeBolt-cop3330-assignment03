package ex43;
/*
 *  UCF COP3330 Fall 2021 Exercise 43 Solution
 *  Copyright 2021 Merrek DeBolt
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void createWebsite(Website website)
    {
        // Make folders
        File siteDir;
        siteDir = new File("src/main/java/ex43/website/" + website.SiteName);
        siteDir.mkdirs();
        System.out.println("Created " + siteDir.getPath());

        // Create index.html
        siteDir = new File("src/main/java/ex43/website/" + website.SiteName + "/index.html");
        try
        {
            siteDir.createNewFile();
            FileWriter writer = new FileWriter(siteDir.getAbsoluteFile());
            writer.write("<html><head><meta name=\"author\" content=\"" + website.Author + "\"></meta><title>" + website.SiteName + "</title></head></html>");
            writer.close();
            System.out.println("Created " + siteDir.getPath());
        }
        catch (IOException ex) { System.out.println("index.html not created"); }

        // Create js folder
        if (website.JavaScript)
        {
            siteDir = new File("src/main/java/ex43/website/" + website.SiteName + "/js");
            siteDir.mkdirs();
            System.out.println("Created " + siteDir.getPath());
        }

        // Create css folder
        if (website.CSS)
        {
            siteDir = new File("src/main/java/ex43/website/" + website.SiteName + "/css");
            siteDir.mkdirs();
            System.out.println("Created " + siteDir.getPath());
        }
    }

    public static void main(String[] args)
    {
        // Take input
        String siteName, author, javaScript, CSS;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Site name: ");
        siteName = scanner.nextLine();
        System.out.println("Author: ");
        author = scanner.nextLine();
        System.out.println("Do you want a folder for JavaScript? ");
        javaScript = scanner.nextLine();
        System.out.println("Do you want a folder for CSS? ");
        CSS = scanner.nextLine();

        Website website = new Website(siteName, author, javaScript, CSS);
        createWebsite(website);
    }
}