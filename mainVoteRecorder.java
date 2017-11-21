package voterecorder;
import java.util.Scanner;
public class mainVoteRecorder {
    private static String namePresident1;
    private static String namePresident2;
    private static String nameVicePresident1;
    private static String nameVicePresident2;
    
    private int myVotePresident;
    private int myVoteVicePresident;
    public static int votesPresident1 = 0;
    public static int votesPresident2 = 0;
    public static int votesVicePresident1 = 0;
    public static int votesVicePresident2 = 0;
    
    private boolean recordVotes = false;
    
    String voteP, voteVP;
    
    public String getPresident1(){
        return namePresident1;
    }
    
    public String getPresident2(){
        return namePresident2;
    }
    
    public String getVicePresident1(){
        return nameVicePresident1;
    }
    
    public String getVicePresident2(){
        return nameVicePresident2;
    }
    
    public void setPresident(String name1, String name2){
        namePresident1 = name1;
        namePresident2 = name2;
    }
    
    public void setVicePresident(String name1, String name2){
        nameVicePresident1 = name1;
        nameVicePresident2 = name2;
    }
    
    // First thing that displays. Shows who is running for President and Vice President
    public void writeOutput(){
        System.out.println("These two are the candidates that are running for President: ");
        System.out.println("President Candidate 1: " + namePresident1);
        System.out.println("President Candidate 2: " + namePresident2);
        System.out.println();
        System.out.println("These two are the candidates that are running for Vice President: ");
        System.out.println("Vice President Candidate 1: " + nameVicePresident1);
        System.out.println("Vice President Candidate 2: " + nameVicePresident2);
        System.out.println();
    }
    
    // Displays who won for President
    public void getCurrentVotePresident(){
        if (votesPresident1 > votesPresident2){
            System.out.println("The new President is " + getPresident1());
        }
        else if (votesPresident1 < votesPresident2){
            System.out.println("The new President is " + getPresident2());
        }
        else if (votesPresident1 == 0 && votesPresident2 == 0){
            System.out.println("No one voted for a President.");
        }
        else{
            System.out.println("The votes for President are tied.");
        }
    }
    
    // Displays who won for Vice President
    public void getCurrentVoteVicePresident(){
        if (votesVicePresident1 > votesVicePresident2){
            System.out.println("The new Vice President is " + getVicePresident1());
        }
        else if (votesVicePresident1 < votesVicePresident2){
            System.out.println("The new Vice President is " + getVicePresident2());
        }
        else if (votesVicePresident1 == 0 && votesVicePresident2 == 0){
            System.out.println("No one voted for a Vice President.");
        }
        else{
            System.out.println("The votes for Vice President are tied.");
        }
    }
    
    public void getAndConfirmVotes(){
        Scanner keyboard = new Scanner(System.in);        
        do{
            // Voting and error checking for President
            System.out.println("You are voting for the President.");
            System.out.println("Type 0 for neither candidate.");
            System.out.println("Type 1 to vote for " + getPresident1());
            System.out.println("Type 2 to vote for " + getPresident2());
            voteP = keyboard.nextLine();
            while( voteP.equals("") || voteP.matches("[A-Za-z]+") || !(voteP.equals("0")) || !(voteP.equals("1")) || !(voteP.equals("2"))   ){
                if( voteP.equals("0") || voteP.equals("1") || voteP.equals("2") ){
                    System.out.println();
                    break;
                }
                else{
                    System.out.println("You didn't type 0, 1 or 2.");
                    System.out.println("You are voting for the President.");
                    System.out.println("Type 0 for neither candidate.");
                    System.out.println("Type 1 to vote for " + getPresident1());
                    System.out.println("Type 2 to vote for " + getPresident2());
                    voteP = keyboard.nextLine();
                }
            }
            
            // Voting and error checking for Vice President
            System.out.println("You are voting for the Vice President.");
            System.out.println("Type 0 for neither candidate.");
            System.out.println("Type 1 to vote for " + getVicePresident1());
            System.out.println("Type 2 to vote for " + getVicePresident2());
            voteVP = keyboard.nextLine();
            while( voteVP.equals("") || voteVP.matches("[A-Za-z]+") || !(voteVP.equals("0")) || !(voteVP.equals("1")) || !(voteVP.equals("2"))   ){
                if( voteVP.equals("0") || voteVP.equals("1") || voteVP.equals("2") ){
                    System.out.println();
                    break;
                }
                else{
                    System.out.println("You didn't type 0, 1 or 2.");
                    System.out.println("You are voting for the Vice President.");
                    System.out.println("Type 0 for neither candidate.");
                    System.out.println("Type 1 to vote for " + getVicePresident1());
                    System.out.println("Type 2 to vote for " + getVicePresident2());
                    voteVP = keyboard.nextLine();
                }
            }
            
            // User votes (getAVote)
            getAVote(voteP, voteVP);

            // Gets user votes (getVotes)
            getVotes();

            // Confirms votes (confirmVotes)
            confirmVotes();
        } while(recordVotes == false);
        
        // Records votes (recordVotes)
        recordVotes();
    }
    
    private void getAVote(String name1, String name2){
        if(name1.equalsIgnoreCase("0")){
            myVotePresident = 0;
        }
        else if(name1.equalsIgnoreCase("1")){
            myVotePresident = 1; // Vote for Annie
        }
        else if(name1.equalsIgnoreCase("2")){
            myVotePresident = 2; // Vote for Bob
        }
        
        if(name2.equalsIgnoreCase("0")){
            myVoteVicePresident = 0;
        }
        else if(name2.equalsIgnoreCase("1")){
            myVoteVicePresident = 1; // Vote for John
        }
        else if(name2.equalsIgnoreCase("2")){
            myVoteVicePresident = 2; // Vote for Susan
        }
    }
    
    private void getVotes(){
        switch(myVotePresident){
            case 0:
                System.out.println("You didn't vote for either candidate for President.");
                break;
            case 1:
                System.out.println("You voted for " + getPresident1() + " for President.");
                break;
            case 2:
                System.out.println("You voted for " + getPresident2() + " for President.");
                break;
            default:
                System.out.println("Something went wrong.");
                System.exit(0);
        }
        
        switch(myVoteVicePresident){
            case 0:
                System.out.println("You didn't vote for either candidate for Vice President.");
                break;
            case 1:
                System.out.println("You voted for " + getVicePresident1() + " for Vice President.");
                break;
            case 2:
                System.out.println("You voted for " + getVicePresident2() + " for Vice President.");
                break;
            default:
                System.out.println("Something went wrong.");
                System.exit(0);
        }
    }
    
    private void confirmVotes(){
        String voteResponse;
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Are you happy with your vote? Type 'yes' or 'no'.");
        voteResponse = keyboard.nextLine();
            
        while ( !(voteResponse.equalsIgnoreCase("yes")) && !(voteResponse.equalsIgnoreCase("no"))   ){
            System.out.println();
            System.out.println("You didn't type 'yes' or 'no'. Please try again.");
            System.out.println("Are you happy with your vote? Type 'yes' or 'no'.");
            voteResponse = keyboard.nextLine();
        }
        
        // If user isn't happy with their vote, it will decrement their orginal vote and makes sure to diaplay a positive number or 0
        if (voteResponse.equalsIgnoreCase("no")){
            if (voteP.equals("1") && votesPresident1 > 0){ // Vote for Annie
                votesPresident1--;
            }
            if (voteP.equals("2") && votesPresident2 > 0){ // Vote for Bob
                votesPresident2--;
            }
            if (voteVP.equals("1") && votesVicePresident1 > 0){ // Vote for John
                votesVicePresident1--;
            }
            if (voteVP.equals("2") && votesVicePresident2 > 0){ // Vote for Susan
                votesVicePresident2--;
            }
            recordVotes = false;
        }
        else{
            recordVotes = true;
        }
    }
    
    // Shows how many votes each candidate has
    private void recordVotes(){
        switch(myVotePresident){
            case 0:
                break;
            case 1: // Vote for Annie
                votesPresident1++;
                break;
            case 2: // Vote for Bob
                votesPresident2++;
                break;
            default:
                System.out.println("Something went wrong.");
                System.exit(0);
        }
        
        switch(myVoteVicePresident){
            case 0:
                break;
            case 1: // Vote for John
                votesVicePresident1++;
                break;
            case 2: // Vote for Susan
                votesVicePresident2++;
                break;
            default:
                System.out.println("Something went wrong.");
                System.exit(0);
        }
        
        System.out.println("The President votes are:");
        System.out.println(getPresident1() + " has " + votesPresident1 + " votes.");
        System.out.println(getPresident2() + " has " + votesPresident2 + " votes.");
        System.out.println();
        
        System.out.println("The Vice President votes are:");
        System.out.println(getVicePresident1() + " has " + votesVicePresident1 + " votes.");
        System.out.println(getVicePresident2() + " has " + votesVicePresident2 + " votes.");
        System.out.println();
    }
}
