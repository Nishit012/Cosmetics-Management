import java.util.Scanner;

class CosmeticStore 
{
    static final int MAX_PRODUCTS = 100;
    static String[] products = new String[MAX_PRODUCTS];
    static int[] quantities = new int[MAX_PRODUCTS];
    static int[] price = new int[MAX_PRODUCTS];
    static int count = 5;
	Scanner sc=new Scanner(System.in);

    void initProducts() 
	{
        products[0] = "face wash";
        quantities[0] = 100;
		price[0]=120;
        products[1] = "hair spray";
        quantities[1] = 250;
		price[1]=80;
        products[2] = "face pack";
        quantities[2] = 180;
		price[2]=50;
        products[3] = "hair gel";
        quantities[3] = 60;
		price[3]=70;
        products[4] = "lipsticks";
        quantities[4] = 90;
		price[4]=40;
    }

    void displayMenu() 
	{
        System.out.println("Select an option:");
        System.out.println("1. List available cosmetics");
        System.out.println("2. Add cosmetic details");
        System.out.println("3. Delete cosmetic details");
        System.out.println("4. Update cosmetic details");
        System.out.println("5. Exit");
    }

    void listProducts() 
	{
        System.out.println("\nPRODUCT NAME\tQUANTITY\tPRICE($)");
        for (int i = 0; i < count; i++) 
		{
            System.out.println(products[i] + "\t" + quantities[i]+"\t\t"+price[i]);
        }
        System.out.println();
    }

    void addProduct() 
	{
        if (count >= MAX_PRODUCTS) 
		{
            System.out.println("Sorry, the maximum number of products has been reached.");
            return;
        }

        System.out.print("\nEnter the product name: ");
        String productName = sc.nextLine();

        System.out.print("Enter the product quantity: ");
        int productQuantity = sc.nextInt();
        sc.nextLine();
		System.out.print("Enter the product PRICE($): ");
        int productprice = sc.nextInt();

        products[count] = productName;
        quantities[count] = productQuantity;
        price[count] = productprice;
        count++;

        System.out.println(productName + " added successfully!");
    }

    void removeProduct() 
	{
        System.out.print("\nEnter the product name: ");
        String productName = sc.nextLine();

        int index = findProductIndex(productName);

        if (index == -1) 
		{
            System.out.println(productName + " not found!");
            return;
        }

        for (int i = index; i < count - 1; i++) 
		{
            products[i] = products[i + 1];
            quantities[i] = quantities[i + 1];
            price[i] = price[i + 1];
        }

        count--;

        System.out.println(productName + " removed successfully!");
    }
	
	int findProductIndex(String productName) 
	{
        for (int i = 0; i < count; i++) 
		{
            if (products[i].equals(productName)) 
			{
                return i;
            }
        }

        return -1;
    }

    void updateQuantity() 
	{
        System.out.print("\nEnter the product name: ");
        String productName = sc.nextLine();

        int index = findProductIndex(productName);

        if (index == -1) 
		{
            System.out.println(productName + " not found!");
            return;
        }

        System.out.print("Enter the new quantity: ");
        int newQuantity = sc.nextInt();
        sc.nextLine();
        quantities[index] = newQuantity;
		
		System.out.print("Enter the new price: ");
        int newprice = sc.nextInt();
        sc.nextLine();
        price[index] = newprice;

        System.out.println(productName + " quantity updated successfully!");
    }
  }
  
class main_cosmetic
{
    public  static void main(String[] args) 
	{
		CosmeticStore c=new CosmeticStore();
        Scanner sc = new Scanner(System.in);
        c.initProducts();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("               COSMETIC STORE                 ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();

        while (true) 
		{
            c.displayMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) 
			{
                case 1:
                    c.listProducts();
                    break;
                case 2:
                    c.addProduct();
                    break;
                case 3:
                    c.removeProduct();
                    break;
                case 4:
                    c.updateQuantity();
                    break;
                case 5:
                    System.out.println("Thank you for visiting the Cosmetic Store!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}





