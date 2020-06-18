/**
 *Library catalog - a simple program to ask user to enter book details and display details
 * @author 77227213_Sahaj_Bikram_Malla
 */
import java.text.DecimalFormat;
import java.util.Scanner;
public class C77227213 {

	public static void main(String[] args)
	{
		
		Scanner scan = new Scanner(System.in);
		
		//Declaring variables for array of 20
		String []Title = new String[20];
		String []Author = new String[20];
		String []Publisher = new String[20];
		int []Pages = new int[20]; 
		long []ISBN = new long[20];
		double []PriceString = new double[20]; 
		String []Price= new String[20];
		
		int count=0;
		
		System.out.println("Program will ask to enter Title, Author, Publisher, Pages, ISBN, Price of the book \n");
		System.out.println("Enter \'nomore\' when you are done entering the books \n \n");
		
		//Using for loop to enter into array 
		for (int index = 0; index < 20; index++)
		{
			
			System.out.println("Enter the Title of the book");
			Title[index]= scan.nextLine();
			
			//If the user enters nomore program will not ask to enter 
			if (Title[index].equals("nomore")) 
			{
				
				break;
			}
			
			System.out.println("Enter the Author of the "+Title[index]);
			Author[index]=scan.nextLine();
			
			System.out.println("Enter the Publisher of the "+Title[index]);
			Publisher[index]=scan.nextLine();
			
			System.out.println("Enter the Price of the "+Title[index]);
			PriceString[index]=Double.parseDouble(scan.nextLine());
			
			System.out.println("Enter the Pages of the "+Title[index]);
			Pages[index]=Integer.parseInt(scan.nextLine());
			
			System.out.println("Enter the ISBN of the "+Title[index]);
			ISBN[index]=Long.parseLong(scan.nextLine());
			count++;
		}
		
		//Formatting for 2 decimal places
 			for(int Price_index=0; Price_index < PriceString.length; Price_index++ ) 
			{
				DecimalFormat format0 = new DecimalFormat("0.00");
		        Price[Price_index]= format0.format(PriceString[Price_index]);
			}
		
		
			//Initializing the variables 
			double total_price_unformatted= 0;
			double MaxCostUnformatted= PriceString[0];
			double MinCostUnformatted= PriceString[0];
			int MaxPages= Pages[0];
			int MinPages= Pages[0];
			double AvgBookCostUnformatted= 0;
			String MaxBookName= Title[0];
			String MinBookName= Title[0];
			
			//Total number of books
			int NumberOfBooks= count;
			
			
			//Total price of the book
			for(int price_cnt= 0; price_cnt < Price.length; price_cnt++)
			{
				 total_price_unformatted +=PriceString[price_cnt];
			}
			
			//Formatting to 2 digit decimal place 
			DecimalFormat format3 = new DecimalFormat("0.00");
	        String total_price= format3.format(total_price_unformatted); 
		
			//Maximum Cost of the book
			for(int price_cnt= 0; price_cnt < Price.length; price_cnt++)
			{
				
				if(PriceString[price_cnt] > MaxCostUnformatted)
				{ 
			         MaxCostUnformatted = PriceString[price_cnt];
			         
				}
			}
			
			//Formatting to 2 digit decimal place 
			DecimalFormat format4 = new DecimalFormat("0.00");
	        String MaxCost= format4.format(MaxCostUnformatted);
			
			
			//Minimum Cost of the book
			for(int price_cnt= 0; price_cnt < count; price_cnt++)  
			{	
				if(PriceString[price_cnt] < MinCostUnformatted)
				{ 
					MinCostUnformatted =  PriceString[price_cnt];
					
				}
			}
			
			//Formatting to 2 digit decimal place 
			DecimalFormat format5= new DecimalFormat("0.00");
	        String MinCost= format5.format(MinCostUnformatted);
			
			
			//Average cost of the book
			AvgBookCostUnformatted=  total_price_unformatted / NumberOfBooks;
			
			DecimalFormat format6= new DecimalFormat("0.00");
	        String AvgBookCost= format6.format(AvgBookCostUnformatted);
			
			
			
			//Maximum pages of the book
			for(int page_cnt=0; page_cnt<Pages.length;page_cnt++)
			{
				if(Pages[page_cnt] > MaxPages)
				{ 
			         MaxPages= Pages[page_cnt];
			         MaxBookName= Title[page_cnt];
				}
				
			}
			
			//Minimum pages of the book
			for(int page_cnt=0; page_cnt<count;page_cnt++)
			{
				
					if(Pages[page_cnt] < MinPages)
					{ 
						MinPages= Pages[page_cnt];
						MinBookName= Title[page_cnt];
					}
			}		
		
		
			System.out.println("\n \n");
		
			//String formatting
		
			String format= "%1$-15s %2$-15s %3$-15s %4$-10s %5$-10s %6$-10s \n";
			System.out.format(format, "Title", "Author", "Publisher" ,"Price","Pages","ISBN");
			System.out.format(format, "=====", "======", "=========" ,"=====","=====","====");
			int Counter = 0;
			do
			{
				System.out.format(format,Title[Counter],Author[Counter],Publisher[Counter],"£"+Price[Counter],Pages[Counter],ISBN[Counter]);
				Counter++;
			}while(!Title[Counter].equals("nomore"));

			
			
			
			System.out.println("\n \n");
			
			String format2 = "%1$-20s \n";
			System.out.format(format2, "Totals");
			System.out.format(format2, "-------------------------------------------");
			System.out.println("Total number of books: " + NumberOfBooks);
			System.out.println("Total cost of books:  £" + total_price);
			System.out.println("Maximum cost of book:  £" + MaxCost);
			System.out.println("Minimum cost of book:  £" + MinCost);
			System.out.println("\'"+MaxBookName+"\'" +" has the highest number of pages: " + MaxPages);
			System.out.println("\'"+MinBookName+"\'" +" has the lowest number of pages: " + MinPages);
			System.out.println("Average cost of book: £" + AvgBookCost);		
		
	}
}
