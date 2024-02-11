import java.util.*;

class Customer{
    String name,ph_no;
    int cus_id;
    static  ArrayList<Customer> customer = new ArrayList<Customer>();
    static int cuid=1;
    static  HashMap<Integer,Customer> cus = new HashMap<Integer,Customer>();

    static void customer_creation(){
        Customer c = new Customer();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name: ");
        c.name=in.nextLine();
        System.out.println("Enter your phone number: ");
        c.ph_no= in.nextLine();
        c.cus_id=cuid;
       // Customer c = new Customer(name,ph_no,cuid);
        cus.put(cuid++,c);
        customer.add(c);
        System.out.println("Customer added successfully");
    }

    static void display_customer()
    {
        for(int i=0;i<cus.size();i++)
        {
            Customer c = customer.get(i);
            System.out.println(c.name);
            System.out.println(c.ph_no);
            System.out.println(c.cus_id);
        }
    }

    static void find_cus(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the cus id: ");
        int val = in.nextInt()-1;
        Customer c = (customer.get(val));
        System.out.println(c.cus_id);
        System.out.println(c.name);
        System.out.println(c.ph_no);
    }
}

class Item{
    static int itid=1;
    static ArrayList<Item> item = new ArrayList<Item>();
    static HashMap<Integer,Item> itm = new HashMap<Integer,Item>();
    int item_id,itm_qua,itm_cost;
    String itm_name;

    Item(String name,int qua,int cost,int id)
    {
        this.itm_name=name;
        this.itm_qua=qua;
        this.itm_cost=cost;
        this.item_id=id;
    }

    static void item_creation()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the item name: ");
        String name = in.nextLine();
        System.out.println("Enter the quantity: ");
        int qua = in.nextInt();
        System.out.println("Enter the cost of the item: ");
        int cost = in.nextInt();
        Item i = new Item(name,qua,cost,itid);
        item.add(i);
        itm.put(itid++,i);
        System.out.println("Item added successfully");
    }

    static void display_item()
    {

        for(int i=0;i< itm.size();i++)
        {
            Item j = item.get(i);
            System.out.println(j.itm_name);
            System.out.println(j.item_id);
            System.out.println(j.itm_qua);
            System.out.println(j.itm_cost);
        }
    }
}

class Bill{
    static ArrayList<Bill> bill = new ArrayList<Bill>();
    static int bid =0;
    int cus_id,no_of_itm,bill_id;
    ArrayList<Bill_list> bill_list = new ArrayList<Bill_list>();
    class Bill_list{
        int item_id,item_qua;
    }

//    void bill_creation()
//    {
//        Scanner in = new Scanner(System.in);
//        System.out.println("Enter the customer id: ");
//        this.cus_id=in.nextInt();
//        System.out.println("Enter the no of buying products: ");
//        this.no_of_itm=in.nextInt();
//        this.bill_id=bid+1;
//        for(int i=0;i<no_of_itm;i++)
//        {
//          System.out.println("Enetr the item id: ");
//          Bill_list tempBillData = new Bill_list();
//          tempBillData.item_id = in.nextInt();
//          tempBillData.item_qua = in.nextInt();
//          this.bill_list.add(tempBillData);
//        }
//        bid++;
//       System.out.println("BIll created successfully");
//    }

    void bill_creation()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the customer id: ");
        this.cus_id = in.nextInt();
        System.out.println("Enter the no of items: ");
        this.no_of_itm=in.nextInt();
        this.bill_id=bid+1;
        for(int i=0;i<this.no_of_itm;i++)
        {
            Bill_list obj = new Bill_list();
            System.out.println("Enter the item id: ");
            obj.item_id=in.nextInt();
            System.out.println("Enter the item quantity: ");
            obj.item_qua=in.nextInt();
            this.bill_list.add(obj);
        }
        bid++;
    }
    static void dispaly_bill(){
        for(int i=0;i< bill.size();i++)
        {
            Bill b = bill.get(i);
            System.out.println("customer id "+b.cus_id);
            System.out.println("bill id "+b.bill_id);
            for(int j=0;j<b.no_of_itm;j++)
            {
                Bill_list bl =b.bill_list.get(j);
                System.out.println("item id "+bl.item_id);
                System.out.println("item quantity "+bl.item_qua);
                System.out.println("item name: "+Item.item.get(bl.item_id-1).itm_name);
            }
        }
    }
    static void search_bill()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the bill id: ");
        int v=in.nextInt()-1;
        Bill b = bill.get(v);
        System.out.println("The bill id is: "+b.bill_id);
        System.out.println("The customer id is: "+b.cus_id);
        for(int i=0;i<b.no_of_itm;i++)
        {
            Bill_list bl = b.bill_list.get(i);
            System.out.println("Item id: "+bl.item_id);
            System.out.println("Item name: "+Item.item.get(bl.item_id-1).itm_name);
            System.out.println("Item qua: "+bl.item_qua);
        }
    }
}

//class Purchase{
//    int item_id,item_qua,item_price,total;
//
//    static void printBill()
//}
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true)
        {
            System.out.println(" 1 Create Customer\n 2 Display Customer\n 3 Search Customer\n 4 Create Item\n 5 Display Item");
            int n = in.nextInt();
            switch (n)
            {
                case 1:{
                    Customer.customer_creation();
                    break;
                }
                case 2:{
                    Customer.display_customer();
                    break;
                }
                case 3:{
                    Customer.find_cus();
                    break;
                }
                case 4:{
                    Item.item_creation();
                    break;
                }
                case 5:{
                    Item.display_item();
                    break;
                }
                case 6:{
                    Bill.bill.add(Bill.bid,new Bill());
                    Bill.bill.get(Bill.bid).bill_creation();
                    break;
                }
                case 7:{
                    Bill.dispaly_bill();
                    break;
                }
                case 8:{
                    Bill.search_bill();
                    break;
                }
            }
        }
    }
}