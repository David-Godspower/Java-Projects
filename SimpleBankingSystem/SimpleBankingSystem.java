
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SimpleBankingSystem {
				public static void main(String [] args){
				    // declaring the scanner
								Scanner scanner = new Scanner(System.in);
								System.out.println("A Program for Simple Banking System\n\n");
						// get current time and date
						LocalDateTime currentDateTime = LocalDateTime.now();

        // Format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				    //opening outer loop
						while(true){
								System.out.println("\t\tWelcome to DavisBank\t");
						    // accept user input to enter name or exit
								System.out.println("Enter your name or type 'exit' to leave :					");
								String name = scanner.nextLine(); 
						    //check if user input exit and exit the code
										if (name.trim().equalsIgnoreCase("exit")) {
    System.out.println("Goodbye! Thanks for banking with us.");
    break;
}
						    //check if name is not less than 3 characters
						    if(name.length() < 3){
						        System.out.println("Your name must be at least three characters.\n");
						    }
						    //Check if user name are characters
						    else if(name.matches("[a-zA-Z]+")){
						        //print user name with greeting
												System.out.println("Welcome, " + name + "!\n");
						    //Declare the account_balamce
												float account_balance = 0.00f;
						    //opening inner loop
								while(true){
								    //Display the home page
								System.out.println("\n--------------------------------------------------\n\n\t\tWELCOME TO THE HOME PAGE\n\n\n----------------------- MENU ---------------------- \n| 1)Deposit\n| 2)Withdraw	\n| 3)Check balance\n| 4)Transfer\n| 5)Exit\n\tPlease Enter your choice:...");
								    //Acceptuser input for their choice
												int choice = scanner.nextInt();
										scanner.nextLine(); //clear any buffer
												switch(choice){
												    //check if user input 1
																case 1:
												    // ask for user amount to be deposited
																System.out.println("Enter the amount to be deposited(#):				");
																float amount = scanner.nextFloat();
														scanner.nextLine(); // clear  buffer
												    //check if amount to be deposited is not less than or equal to 0
																		if(amount <= 0){
																				System.out.println("You can't deposit this amount " + amount);
																}
												    //check if amount is less than 1
																else	if(amount < 1){
																				System.out.println("Amount can't be less than #1");
																}
												    //if amount is valid move on with the code
												    else{
																				System.out.println(amount + " has been deposited into your account.");
												        //add amount deposited to the current account balance
																				 account_balance += amount;
																}
																break;
												    //check if user input 2
																case 2:
												    //ask for user amount to be withdrawn
																System.out.println("Enter the amount you want to withdraw(#)				");
																float withdraw = scanner.nextFloat();
												    //variable for account remnantto see if user does not withdraw up to certain amount
																float account_remnant = account_balance - withdraw; 
														scanner.nextLine();//clear buffer
												    //check if user wants to withdraw amount less than or equal to 0  
																if(withdraw <= 0){
																				System.out.println("You can't withdraw this amount " + withdraw);
																}
												    //check if withdraw is not greater than account balance
																else	if(withdraw > account_balance){
																				System.out.println("The amount you want to withdraw is greater than your account balance");
																}
												    //check if withdraw amount is equal to account balance
												    else if((withdraw == account_balance || account_remnant < 500)){
																				System.out.println("You must have at least #500 remaining in your account.");
												}
												    //check if the account remnant is not less than #1
												    /*else if(account_remnant < 500){
																System.out.println("You must have at least #500 remaining in your account.");
												}*/
												    //if the user withdraw amount is valid move on
												    else{
																				System.out.println(withdraw + " has been successfully withdrawn from your account.");
												        //subtract withdrawn amount from the account balance 
																				account_balance -= withdraw;
															
																}
																break; 
												    //Check if user input 3
																case 3:
												        //Display the account balance
																System.out.println("Account balance =  #"  + account_balance);
																break;
												    //Check if user input 4
																case 4:
												        //Accept the recipient  account number
																System.out.println("Enter the recipient account number: ");
																String account_number = scanner.nextLine();
														//Check if the account number is equal to 10 and it contains digits
														if(account_number.length() == 10 && account_number.matches("\\d+")){
														    //Ask for the recipient bank
																				System.out.println("Choose the recipient bank:");
														    //Display the available banks
																				System.out.println("1)FirstBank\n2)AccessBank\n3)United Bank for Africa\n4)Opay\n5)Moniepoint\n6)GTBank\n7)WemaBank");
														    //Ask user to input the number the bank falls into
														    int bank_choice = scanner.nextInt();
														    // Check if user enters the right input
														    if(bank_choice <= 0 || bank_choice >=8){
														        System.out.println("You didn't input the right number.");
														        break;
														    }else{ // Accept user transfer amount
														System.out.println("Enter the amount you want to transfer to " + account_number + ": ");
														    }
														float recipient_amount = scanner.nextFloat();
														    				float account_remnant2 = account_balance - recipient_amount; 
														    // Check if transfer  amount is valid
														    //Check if transfer amount is less than #1
																if(recipient_amount < 100){
																		System.out.println("The amount you are about to transfer must not be less than #100.");
																}
														    // Check if transfer amount is greater than account balance
														    else if(recipient_amount > account_balance){
																		System.out.println("The amount you are about to transfer is greater than your account balance.");
																} else if((account_remnant2 == account_balance || account_remnant2 < 500)){
																				System.out.println("You must have at least #500 remaining in your account.");
														}
														    // If the transfer amount is valid
														    else{
																		System.out.println("Transfer Successful!");
														        //Subtract the transfer amount from the account balance
																		account_balance -= recipient_amount;
																		scanner.nextLine(); //clear buffer
														        //Ask user for receipt or not
																		System.out.println("Do you want a receipt?(yes or no)	");
														        //Accept user input and convert it to lower case
																		String receipt_choice = scanner.nextLine().toLowerCase();
														        // Check if receipt choice is yes
																		if (receipt_choice.equals("yes")){
																				System.out.println("\n");
																				switch(bank_choice){
																				    //Display for user if bank choice is 1
																				case 1:
																				System.out.println("DavisBank\t\t\tTransaction Receipt\n\t\t" +  "#"+recipient_amount+"\n\t\tSUCCESS\n\t"+ currentDateTime.format(formatter) +"\nTransaction type\t\t\tMoney Sent\nRecipient Details\t\t\t" + account_number + "\nRecipient Bank\t\t\t\tFirstBank\nSender Details\t\t\t\t" + name+ "\n\tThanks for choosing DavisBank.");
																						break;
																				    			    //Display for user if bank choice is 2
																						case 2:
																							System.out.println("DavisBank\t\t\tTransaction Receipt\n\t\t" +  "#"+recipient_amount+"\n\t\tSUCCESS\n\t"+ currentDateTime.format(formatter) +"\nTransaction type\t\t\tMoney Sent\nRecipient Details\t\t\t" + account_number + "\nRecipient Bank\t\t\t\tAccessBank\nSender Details\t\t\t\t" + name+ "\n\tThanks for choosing DavisBank.");
																						break;
																				    			    //Display for user if bank choice is 3
																						case 3: 
																														System.out.println("DavisBank\t\t\tTransaction Receipt\n\t\t" +  "#"+recipient_amount+"\n\t\tSUCCESS\n\t\t"+ currentDateTime.format(formatter) +"\nTransaction type\t\t\tMoney Sent\nRecipient Details\t\t\t" + account_number + "\nRecipient Bank\t\tUnited Bank for Africa\nSender Details\t\t\t\t" + name+ "\n\tThanks for choosing DavisBank.");
																						break;
																				    			    //Display for user if bank choice is 4
																						case 4:
																														System.out.println("DavisBank\t\t\tTransaction Receipt\n\t\t" +  "#"+recipient_amount+"\n\t\tSUCCESS\n\t\t"+ currentDateTime.format(formatter) +"\nTransaction type\t\t\tMoney Sent\nRecipient Details\t\t\t" + account_number + "\nRecipient Bank\t\t\t\tOpay\nSender Details\t\t\t\t" + name+ "\n\tThanks for choosing DavisBank.");
																						break;
																				    			    //Display for user if bank choice is 5
																						case 5:
																														System.out.println("DavisBank\t\t\tTransaction Receipt\n\t\t" +  "#"+recipient_amount+"\n\t\tSUCCESS\n\t\t"+ currentDateTime.format(formatter) +"\nTransaction type\t\t\tMoney Sent\nRecipient Details\t\t\t" + account_number + "\nRecipient Bank\t\t\t\tMoniepoint\nSender Details\t\t\t\t" + name+ "\n\tThanks for choosing DavisBank.");
																						break;
																				    			    //Display for user if bank choice is 6
																						case 6:
																														System.out.println("DavisBank\t\t\tTransaction Receipt\n\t\t" +  "#"+recipient_amount+"\n\t\tSUCCESS\n\t\t"+ currentDateTime.format(formatter) +"\nTransaction type\t\t\tMoney Sent\nRecipient Details\t\t\t" + account_number + "\nRecipient Bank\t\t\t\tGTBank\nSender Details\t\t\t\t" + name+ "\n\tThanks for choosing DavisBank.");
																						break;
																				    			    //Display for user if bank choice is 7
																						case 7:
																														System.out.println("DavisBank\t\t\tTransaction Receipt\n\t\t" +  "#"+recipient_amount+"\n\t\tSUCCESS\n\t\t"+ currentDateTime.format(formatter) +"\nTransaction type\t\t\tMoney Sent\nRecipient Details\t\t\t" + account_number + "\nRecipient Bank\t\t\t\tWemaBank\nSender Details\t\t\t\t" + name+ "\n\tThanks for choosing DavisBank.");
																						break;
																				    //If the bank choice is not valid
																						default:
																						System.out.println("Invalid Input");
																		}
																				
																		}
														        // If user receipt choice is no
														        else if (receipt_choice.equals("no")){
																				System.out.println("Thanks for banking with us.");
																		}
														            // If the user enters invalid input
														            else{
																				System.out.println("Invalid Input");
																		}
																		
																}
														}
												    // Check if the recipient account number is not equal 10 digits and contain non integers
								    else {
																		System.out.println("\nRecipient account number must contain exactly 10 digits and only numbers. ");
														scanner.nextLine();// Clear buffer
																}
														break;
														// Check if user input 5 and break the inner loop
																case 5:
    System.out.println("\nGoodbye! Thanks for banking with us.");
    break; // Breaks out of the switch case to end the inner while loop
																default:
																System.out.println("Enter valid input");
														break;
												}
										
												//Switch case end
										if(choice == 5){
										break; // Break the inner loop
}
								}
								} 
						// Check if user enters invalid name    
								else{
												System.out.println("Invalid name");
								}
								}
							// Closing outer loop
								scanner.close(); //Close scanner
				}
            }
