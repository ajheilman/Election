package voterecorder;
import java.util.Scanner;
public class VoteRecorder {
    public static void main(String[] args) {
        String voteAgain;
        Scanner keyboard = new Scanner(System.in);
        
        // Creates the object and sets the candidates
        mainVoteRecorder test = new mainVoteRecorder();
        test.setPresident("Annie", "Bob");
        test.setVicePresident("John", "Susan");
        
        // Writes who the candidates are for President and Vice President
        test.writeOutput();
       
        // User keeps voting until they are done
        do{
            test.getAndConfirmVotes();
            
            // Asks the use if they want to vote again
            System.out.println("Vote again? Type 'yes' if so.");
            voteAgain = keyboard.nextLine();
        } while(voteAgain.equalsIgnoreCase("yes"));
        
        // Shows who has the most votes for President and Vice President
        test.getCurrentVotePresident();
        test.getCurrentVoteVicePresident();
    }
}
