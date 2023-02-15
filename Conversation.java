import java.util.Scanner;

class Conversation {
  public static void main(String[] arguments) {
    //construct mirrored words and canned reponses
    String[] PremadeResponses={"Mmm-hm.","Interesting!","Oh really?","I'm glad to hear that! Can u tell me more about it?","Wow"};
    Scanner userInput = new Scanner(System.in);
    
    //ask for user input
    System.out.println("How many rounds do you wanna play?:");
    int rounds = userInput.nextInt();
    userInput.nextLine();


    //create empty array for transcript
    String[] transcript=new String[rounds*2+1];

    //start conversation and store first sentence into transcript
    transcript[0]="Hi there! What's on your mind?";
    System.out.println(transcript[0]);

    /**
     * replace words in user input
     */
    for (int i=0;i<rounds;i++){
      String user = userInput.nextLine();
      String mirrored;
      String changed_words = user.replace("I ","you ");
      changed_words = changed_words.replace("i ","you");
      changed_words = changed_words.replace(" me","you");
      changed_words = changed_words.replace("Me ","you");
      changed_words = changed_words.replace(" am ","are");
      changed_words = changed_words.replace("Am ","are");
      changed_words = changed_words.replace(" my ","your");
      changed_words = changed_words.replace("My ","your");
      changed_words = changed_words.replace(" your ","my");
      changed_words = changed_words.replace("Your ","my");
      changed_words = changed_words.replace(" you"," I");
      changed_words = changed_words.replace("You ","I");
      changed_words = changed_words.replace("I am ","You're ");
      changed_words = changed_words.replace("I'm ","You're ");

      //if changed words are different from original user input, then changed=mirrored, else choose random canned phrase
      if(!changed_words.equals(user)){
        mirrored =changed_words;
      } else{
      //random number generator idea comes from https://stackoverflow.com/a/363732
        mirrored=PremadeResponses[(int)(Math.random() * ((4 - 0) + 1))];
      }
      System.out.println(mirrored);
      
      //store coversations into transcript
      //index of odd number are always user input, and index of even number are mirrored response.
      transcript[2*i+1]=user;
      transcript[2*i+2]=mirrored;
    }
  System.out.println("Bye see you next time!");
  System.out.println(" ");
  System.out.println("Transcript:");

for(int i=0;i<transcript.length;i++){
    System.out.println(transcript[i]);
  }
  }
}
