package assignment_2;
import java.util.Scanner;
 class Guesser{
	int guessNumber;
	Scanner sc=new Scanner(System.in);
	int guessNumber(int range) {
		System.out.println("Guess the number in range of 1 to "+range);
		guessNumber=sc.nextInt();
		if(guessNumber>=1 && guessNumber<=range)
			return guessNumber;
		else {
			System.out.println("Enter correct number! Try Again");	
			System.exit(0);
			return 0;
		}	
	}
}
class Player{
	Scanner sc=new Scanner(System.in);
	int[] guessNumber(int range,int numPlayers) {
		int []pGuess=new int[numPlayers];
		for(int i=0;i<numPlayers;i++) {
			System.out.println("Player "+(i+1)+" guess the number in range 1 to " +range);
			pGuess[i]=sc.nextInt();
			if(pGuess[i]>=1 && pGuess[i]<=range) {
				continue;
			}
			else {
				System.out.println("Enter correct number! Try Again");	
				System.exit(0);
			}
		}
		return pGuess;
	}
	int[] guessNumber(int range,int [] win) {	
		int []pGuess=new int[win.length];
		for(int i=0;i<win.length;i++) {
			System.out.println("Player "+(win[i]+1)+" guess the numberin range 1 to " +range);
			pGuess[i]=sc.nextInt();
			if(pGuess[i]>=1 && pGuess[i]<=range) {
				continue;
			}
			else {
				System.out.println("Enter correct number! Try Again");	
				System.exit(0);
			}
		}
		return pGuess;
	}
}
class Umpire{
	int guessNumber;
	int range,numPlayers;
	int []pGuess;
	Scanner sc=new Scanner(System.in);
	void collectNumGuesser() {
		Guesser g=new Guesser();
		System.out.println("Enter range of guess number");
		range=sc.nextInt();
		guessNumber=g.guessNumber(range);
	}
	void collectNumPlayer(int [] win) {
		Player p=new Player();
		pGuess=p.guessNumber(range, win);
	}
	void collectNumPlayer() {
		Player p=new Player();
		System.out.println("Enter no of players");
		numPlayers=sc.nextInt();
		pGuess=p.guessNumber(range, numPlayers);
	}
	void compare2(int []win2) {
		int i=0,j=0,size=0;
		for( i=0;i<pGuess.length;i++) {
			if(pGuess[i]==guessNumber)
				size++;	
		}
		int [] win=new int[size];
		for(i=0,j=0;i<pGuess.length;i++) {
			if(pGuess[i]==guessNumber) {
				win[j]=i;
				j++;
			}	
		}
		if(size==0)
			System.out.println("Game lost! Try again");
		else if(size==win2.length)
			System.out.println("Game Tied All players guessed correctly. Try again");
		else  {
			for(int ele: win) {
				for(int k=0;k<win2.length;k++) {
					if(ele==k) {
						System.out.println("Player "+(win2[k]+1)+" won the game");
						break;
					}
				}
			}
		}
	}
	void compare() {
		int i=0,j=0,size=0;
		for( i=0;i<numPlayers;i++) {
			if(pGuess[i]==guessNumber)
				size++;	
		}
		int [] win=new int[size];
		for(i=0,j=0;i<numPlayers;i++) {
			if(pGuess[i]==guessNumber) {
				win[j]=i;
				j++;
			}	
		}
		if(size==0)
			System.out.println("Game lost! Try again");
		else if(size==numPlayers)
			System.out.println("Game Tied All players guessed correctly. Try again");
		else if(size==1) {
			for( i=0;i<size;i++) {
				System.out.println("Player "+(win[i]+1)+" won the game");
			}
		}
		else {
			for( i=0;i<size;i++) {
				System.out.println("Player "+(win[i]+1)+" won ");
			}
			System.out.println("------------------ Round 2 -----------------------");
			int win2[];
			Umpire u=new Umpire();
			u.collectNumGuesser();
			u.collectNumPlayer(win);
			u.compare2(win);
		}
	}
}
public class Game {
	public static void main(String[] args) {
		Umpire u=new Umpire();
		u.collectNumGuesser();
		u.collectNumPlayer();
		u.compare();
	}
}
