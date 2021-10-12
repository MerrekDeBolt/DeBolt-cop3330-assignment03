package ex44;
/*
 *  UCF COP3330 Fall 2021 Exercise 44 Solution
 *  Copyright 2021 Merrek DeBolt
 */

import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {

    public static Item createProducts()
    {
        Gson gson = new Gson();

        String jsonString = "";
        try { jsonString = new String(Files.readAllBytes(Paths.get("src/main/java/ex44/exercise44_input.json"))); }
        catch (IOException ex) { }

        return gson.fromJson(jsonString, Item.class);
    }

    public static boolean isItemNotFound(Item item, String input)
    {
        boolean itemNotFound = true;
        int index;
        for (index = 0; index < item.products.length; index++)
            if (item.products[index].name.equals(input))
            {
                itemNotFound = false;
                item.CurrentIndex = index;
                break;
            }

        return itemNotFound;
    }

    public static void main(String[] args)
    {
        Item item = createProducts();

        // Take input
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean itemNotFound = true;
        while (itemNotFound)
        {
            System.out.println("What is the product name? ");
            input = scanner.nextLine();

            itemNotFound = isItemNotFound(item, input);

            if (itemNotFound)
                System.out.println("Sorry, that product was not found in our inventory.");
            else
                System.out.println(String.format("Name: %s\nPrice: %.2f\nQuantity: %d", item.products[item.CurrentIndex].name, item.products[item.CurrentIndex].price, item.products[item.CurrentIndex].quantity));
        }
    }
}