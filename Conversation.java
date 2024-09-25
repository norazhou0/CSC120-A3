import java.util.Scanner;
import java.util.Random;

public class Conversation {

  /* Integer to store the rounds of conversation */
  public static Integer round;
  /* Scanner to scan the input */
  public static Scanner input = new Scanner(System.in);
  /* Random to  get a random number */
  public static Random random = new Random();
  /* A list of strings to store the transcript */
  public static String transcript = "";

  /**
   * Constructor
   * @param number
   */
  public Conversation(Integer number) {
    round = number;
  }

  /**
   * Get the rounds of the conversation */ 
  public void rounds() {
    System.out.println("How many rounds? ");
    // get the number of rounds from the user input
    round = input.nextInt();
    input.nextLine();
  }

  /**
   * Mirror input from the user */  
  public void mirror() {
    // create a loop for rounds
    while (round > 0) {
      String userInput = input.nextLine();
      // add user input to the transcript
      transcript += userInput + "\n";

      // create an empty string for storing user responses
      String response = "";
      // Set replacment to be false
      boolean replacement = false;
      // create a list for splitted words from the response
      String[] words = userInput.split(" ");

      // loop through each word in the list to check if it needs to be mirroed and replace
      for (int i = 0; i < words.length; i++) {
        if (words[i].equals("I")) {
          words[i] = "you";
          // turn on the replacement
          replacement = true;
        } else if (words[i].equals("me")) {
          words[i] = "you";
          replacement = true;
        } else if (words[i].equals("am")) {
          words[i] = "are";
          replacement = true;
        } else if (words[i].equals("you")) {
          words[i] = "I";
          replacement = true;
        } else if (words[i].equals("my")) {
          words[i] = "your";
          replacement = true;
        } else if (words[i].equals("your")) {
          words[i] = "my";
          replacement = true;
        }
      }

      // check if replacment was made
      if (replacement) {
        // glue words together to response and add an question mark at the end
        response = String.join(" ", words) + "?";
      } else {
        // create an array of fixed responses
        String[] fixedResponse = {
          "Okay.",
          "Yeah",
          "Mmm-hm."
        };
        // get a random index from the list
        int index = random.nextInt(fixedResponse.length);
        // get the selected response
        response = fixedResponse[index];
      }

      // print the response
      System.out.println(response);
      // add to the transcript
      transcript += response + "\n";

      // Decrement round
      round -= 1;
    }
  }
  
  public static void main(String[] arguments) {
    Conversation myConversation = new Conversation(2);
    myConversation.rounds();

    // print a short greeting to start the conversation
    System.out.println("Hi there!  What's on your mind?");
    // add to the transcript
    transcript += "Hi there!  What's on your mind?" + "\n";

    // call the mirror function to get responses
    myConversation.mirror();

    // print the ending sentence
    System.out.println("See ya!");
    // add to the transcript
    transcript += "See ya!" + "\n";

    // print the transcript
    System.out.println("\n" + "TRANSCRIPT:" + "\n" + transcript);
  }
}