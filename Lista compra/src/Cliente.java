import java.util.Scanner;

public class Cliente {
	
	private Lista list;

	public static void addItem()
	{ 
		System.out.println();
		System.out.println("enter in the name of your item");
		Scanner keyboard = new Scanner(System.in);
		String ItemName = keyboard.nextLine();

		System.out.println("enter in the price of your item");
		double ItemPrice = keyboard.nextDouble();

		System.out.println("enter in the Qty of your item");
		int ItemQty = keyboard.nextInt();

		Objeto Item = new Objeto(ItemName, ItemPrice,
				ItemQty);
		list.add(Item);
		System.out.println("Item Added");
	}

}
