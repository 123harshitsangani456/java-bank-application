import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Bank {
	
	static Scanner scan = new Scanner(System.in);
	static int num = 0;
	
	
	static class Account{
		static int count = 0;
		Scanner sc = new Scanner(System.in);
		static String accountNo;
		String password;
		String name;
		String mobile;
		String address;
		long balance;
		
		void createAccount() throws IOException {
			this.balance = 0;
			getData();
		}
		
		
		void getData() throws IOException {
			accountNo = "ACC_"+(++count);
			System.out.print("Enter Your First Name : ");
			String f = sc.next();
			System.out.print("Enter Your Last Name : ");
			String l = sc.next();
			name = f+" "+l;
			System.out.print("Enter Your Mobile Number : ");
			mobile = sc.next();
			System.out.print("Chhose a new Password : ");
			password = sc.next();
			System.out.print("Enter Your Address : ");
			Scanner snew = new Scanner(System.in);
			address = snew.nextLine();
			
			FileWriter fw = new FileWriter("demo.txt",true);
			BufferedWriter out = new BufferedWriter(fw);
			/*fw.write("\n");
			fw.write(accountNo);
			fw.write(" ");
			fw.write(name);
			fw.write(" ");
			fw.write(mobile);
			fw.write(" ");
			fw.write(password);
			fw.write(" ");
			fw.write(address);
			fw.write(" ");
			fw.close();*/
		}
		
		void printData() {
			System.out.println("Account Number : "+accountNo);
			System.out.println("Password : "+password);
			System.out.println("Name : "+name);
			System.out.println("Mobile Number : "+mobile);
			System.out.println("Address : "+address);
		}
		
		static void create() {
			System.out.println("\nYour Account is Created Successfully");
			System.out.println("Your New Account number : " + accountNo);
			System.out.println("\nPress Enter to Continue ...!"); 
			scan.nextLine();
		}
		@SuppressWarnings({ "static-access" })
		static void login(Account[] temp_acc) {
			System.out.println("*************** Login **************");
			System.out.println("\n\nAccount No. : ");
			String ac = scan.next();
			System.out.println("Password : ");
			String pw = scan.next();
			int flag = 0;
			int temp = 0;
			for (int i = 1; i <= num; i++) {
				if(temp_acc[i].accountNo.equals(ac) && temp_acc[i].password.equals(pw)) {
					flag = 1;
					temp = i;
					break;
				}
			}
			if(flag == 1)
			{
				temp_acc[temp].printData();
			}
			else {
				System.out.println("Khota password nakhta hai..... ***** ****");
			}
		}
		static void admin() {
			System.out.println("This is Admin Screen");
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		int ch;
		Account[] acc = new Account[20];
		do
		{			
			
			System.out.println("\n\n\n1. Create New Account");
			System.out.println("2. Login Existing Account");
			System.out.println("3. Login as Administrator");
			System.out.println("4. Exit");
			
			System.out.print("\nEnter your choice: ");
			ch = scan.nextInt();
			
			switch (ch) {
			case 1:
				num++;
				acc[num] = new Account();
				acc[num].getData();
				Account.create();
				break;
			case 2:
				
				Account.login(acc);
				break;
			case 3:
				Account.admin();
				break;
			case 4:
				System.out.println("Exited from Bank!");
				break;
			default:
				System.out.println("Wrong choice!");
				break;
			}
		}while(ch != 4);
	}
}
