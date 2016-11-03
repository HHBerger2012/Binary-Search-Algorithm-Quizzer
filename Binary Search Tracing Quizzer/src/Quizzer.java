import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
public class Quizzer extends JFrame
	{
		private static final long serialVersionUID=1L;
		static JFrame frame=new JFrame();
		static int choice;
		static int randNum;
		static int number;
		static int left;
		static int right;
		static int mid;
		static int target;
		static int counter=0;
		static int questionCounter=0;
		static ArrayList<Integer> ints = new ArrayList<Integer>();
		public static void main(String[] args)
			{
				runner();
			}
		public static void runner()
		{
			intro();
			takeInts();
		}
		public static void intro()
		{
			System.out.println("Input the integers you want to use");
			System.out.println();
			System.out.println("Make sure they are between 1 and 20");
			System.out.println();
			System.out.println("Then type a -1 when you are done");		
		}
		public static void takeInts()
		{
			ints.removeAll(ints);
			boolean cont = true;
			Scanner sc = new Scanner (System.in);
			while (cont)
				{	
					int num = sc.nextInt();
					if (num<=20 && num>-1)
						{
							ints.add(num);
						}
					if (num==-1)
						{
							cont=false;
							printArray();
						}
					if (num<=-2||num>=21)
						{
							System.out.println("That is not in our range.");
						}
				}
		}
		public static void printArray()
		{
			try{Thread.sleep(800);}catch(InterruptedException e){e.printStackTrace();}
			System.out.println("Here is your Array of ints");
			try{Thread.sleep(800);}catch(InterruptedException e){e.printStackTrace();}
			Collections.sort(ints);
			for (int a: ints)
				{
					System.out.print(a+" ");
					try{Thread.sleep(250);}catch(InterruptedException e){e.printStackTrace();}
				}
			System.out.println();
			randNum = (int)(Math.random()*ints.size()-1);
			number = ints.get(randNum);
			try{Thread.sleep(800);}catch(InterruptedException e){e.printStackTrace();}
			System.out.println("Your target number is "+number);
			binarySearch();
		}
		public static void binarySearch()
		{
			int pass=0;
			target=number;
			left=0;
			right=ints.size()-1;
			while (left<=right)
				{
					pass++;
					mid = (left+right)/2;
					try{Thread.sleep(200);}catch(InterruptedException e){e.printStackTrace();}
					System.out.println("Pass Number "+pass);
					try{Thread.sleep(200);}catch(InterruptedException e){e.printStackTrace();}
					doLeft();
					try{Thread.sleep(200);}catch(InterruptedException e){e.printStackTrace();}
					doRight();
					try{Thread.sleep(200);}catch(InterruptedException e){e.printStackTrace();}
					doMid();
					try{Thread.sleep(200);}catch(InterruptedException e){e.printStackTrace();}
					doGetMid();
					
					if (target == ints.get(mid))
						{
							
						}
					if (target<ints.get(mid))
						{
							right=mid-1;
						}
					else
						{
							left=mid+1;
						}
				}
		}
		public static void doLeft()
		{
			try{Thread.sleep(800);}catch(InterruptedException e){e.printStackTrace();}
			System.out.println("Left: ");
			Scanner sc2 = new Scanner(System.in);
			int userLeft = sc2.nextInt();
			if (userLeft==left)
				{
					System.out.println("Correct");
					counter++;
					questionCounter++;
				}
			else
				{
					System.out.println("That's not right");
					System.out.println("The Correct Answer is: "+left);
					questionCounter++;
				}
		}
			public static void doRight()
			{
			try{Thread.sleep(800);}catch(InterruptedException e){e.printStackTrace();}
			System.out.println("Right: ");
			Scanner sc3 = new Scanner(System.in);
			int userRight = sc3.nextInt();
			if (userRight==right)
				{
					System.out.println("Correct");
					counter++;
					questionCounter++;
				}
			else
				{
					System.out.println("That's not right");
					System.out.println("The Correct Answer is: "+right);
					questionCounter++;
				}
			}
			public static void doMid()
			{
			try{Thread.sleep(800);}catch(InterruptedException e){e.printStackTrace();}
			System.out.println("Middle: ");
			Scanner sc4 = new Scanner(System.in);
			int userMiddle = sc4.nextInt();
			if (userMiddle==mid)
				{
					System.out.println("Correct");
					counter++;
					questionCounter++;
				}
			else
				{
					System.out.println("That's not right");
					System.out.println("The Correct Answer is: "+mid);
					questionCounter++;
				}
			}
			public static void doGetMid()
			{
			try{Thread.sleep(800);}catch(InterruptedException e){e.printStackTrace();}
			System.out.println("array.get(Middle): ");
			Scanner sc5 = new Scanner(System.in);
			int userGetMiddle = sc5.nextInt();
			if (userGetMiddle==ints.get(mid))
				{
					System.out.println("Correct");
					counter++;
					questionCounter++;
					if (ints.get(mid)==target)
						{
							try{Thread.sleep(500);}catch(InterruptedException e){e.printStackTrace();}
							System.out.println("Good Work! You're done");
							try{Thread.sleep(500);}catch(InterruptedException e){e.printStackTrace();}
							System.out.println("You got a "+counter+" out of "+questionCounter);
							try{Thread.sleep(500);}catch(InterruptedException e){e.printStackTrace();}
							Object[] options = {"Yes", "No"};
							choice = JOptionPane.showOptionDialog(null, 
								"Would You Like to do Another Question?",
								"Binary Search Algorithm",
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE, 
								null,
								options, 
								options[1]);
								switch(choice)
								{
									case 0:
											{
												runner();
												break;
											}
									case 1:
											{
												
												break;
											}
								}
						}
				}
			else
				{
					System.out.println("That's not right");
					System.out.println("The Correct Answer is: "+ints.get(mid));
					questionCounter++;
					try{Thread.sleep(500);}catch(InterruptedException e){e.printStackTrace();}
					System.out.println("You got a "+counter+" out of "+questionCounter);
					try{Thread.sleep(500);}catch(InterruptedException e){e.printStackTrace();}
					Object[] options = {"Yes", "No"};
					choice = JOptionPane.showOptionDialog(null, 
						"Would You Like to do Another Question?",
						"Binary Search Algorithm",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, 
						null,
						options, 
						options[1]);
						switch(choice)
						{
							case 0:
									{
										
										runner();
										break;
									}
							case 1:
									{
										
										break;
									}
						}
				}
			}		
	}