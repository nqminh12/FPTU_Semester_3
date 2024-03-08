/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Object.Fruit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author Fpt
 */
public class Manager {

    ArrayList<Fruit> listFruit = new ArrayList<>();
    Hashtable<ArrayList<String>, List<Fruit>> viewOrder = new Hashtable<>();
    Hashtable<ArrayList<String>, List<Fruit>> viewOrderBufer = new Hashtable<>();
    ArrayList<Double> listTotal = new ArrayList<>();
    ArrayList<String> listId = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    
    private static int dem = 1;

    public void createFruit() {
        Manager smm = new Manager();
        while (true) {
            int flag = 0;
            String id = "";
            do {                
                System.out.println("Input fruit's id:");
                id = sc.nextLine().trim();
                char[] arr = id.toCharArray();
                if (id.charAt(0) == '-') {
                    System.err.println("Please input again!");
                    continue;
                }

                if (id.isEmpty()) {
                    System.err.println("Input can not be empty!");
                    continue;
                }

                if (check(id, listFruit) == null) {
                    break;
                }else {
                    flag = 1;
                    String name = Validation.getString("Input fruit's name: ");
                    if (!listFruit.get(listFruit.indexOf(check(id, listFruit))).getName().equalsIgnoreCase(name)) {
                        System.out.println("Wrong fruit'name of that id");
                        break;
                    }
                    double price = Validation.getDouble("Input fruit's price: ");
                    if (listFruit.get(listFruit.indexOf(check(id, listFruit))).getPrice() != price) {
                        System.out.println("Wrong fruit'price of that id");
                        break;
                    }
                    String origin = Validation.getString("Input fruit's origin: ");
                    if (!listFruit.get(listFruit.indexOf(check(id, listFruit))).getOrigin().equalsIgnoreCase(origin)) {
                        System.out.println("Wrong fruit'origin of that id");
                        break;
                    }

                    String option = Validation.getYN("Your id is exist! Do you want to update quantity!");
                    if (option.equalsIgnoreCase("N")) {
                        break;
                    } else {
                        System.out.println("Your old quantity: " + listFruit.get(listFruit.indexOf(check(id, listFruit))).getQuantity());
                        int newquantity = Validation.getQuantity("Enter the new quantity: ");
                        listFruit.get(listFruit.indexOf(check(id, listFruit))).setQuantity(newquantity);

                    }
                    
                    break;
                }
            } while (true);
            if (flag == 1) {
                break;
            } else {
                String name = Validation.getString("Input fruit's name: ");
                int quantity = Validation.getQuantity("Input fruit's quantity: ");
                double price = Validation.getDouble("Input fruit's price: ");
            String origin = Validation.getString("Input fruit's origin: ");
            listFruit.add(new Fruit(id, name, quantity, price, origin));

            String s = Validation.getYN("Do you want to continue (Y/N)? ");
            if (s.equalsIgnoreCase("Y")) {
                continue;
            } else {
                break;
            }
            }
            

        }
    }
    
    public static Fruit check(String id, ArrayList<Fruit> listFruit){
        for (Fruit o : listFruit) {
            if(id.equals(o.getId())){
                return o;
            }
        }
        return null;
    }
    
    
    
    

    public void buy() {
        ArrayList<Fruit> listBuy = new ArrayList<>();
        if(listFruit.isEmpty()){
            System.out.println("THERE IS NO FRUIT TO ORDER!");
            return;
        }

        while (true) {
            // in ra danh sách
            int count = 0;
            System.out.println("List of Fruit:");
            System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
            for (Fruit o : listFruit) {
                count++;
                System.out.printf("%-6s%-13s%-17s%-18s%-5s", "", count, o.getName(), o.getOrigin(), o.getPrice() + "$");
                System.out.println("");
            }

            int item = Validation.getInt("Select item: ", 1, listFruit.size());
            Fruit itemSelect = listFruit.get(item - 1);
            System.out.println("You selected: " + itemSelect.getName());
            
            int quantity;
            String ss = "";
            do {                
                quantity = Validation.getInt("Please input quantity:", 0, itemSelect.getQuantity());
                if(quantity == 0){
                    ss = Validation.getYN("Your quantity is 0! do you want to re-input![Y-N]");
                }
                
            } while (ss.equalsIgnoreCase("Y"));
            if(ss.equalsIgnoreCase("n")){
                break;
            }
            Fruit eachBuy = new Fruit(itemSelect.getId(), itemSelect.getName(), quantity, itemSelect.getPrice(), itemSelect.getOrigin());
            listBuy.add(eachBuy);
            listFruit.get(item - 1).setQuantity(listFruit.get(item - 1).getQuantity() - quantity);
            
            if (listFruit.get(item - 1).getQuantity() == 0) {
                listFruit.remove(item - 1);
            }

            if (listFruit.isEmpty()) {
                System.out.println("There is no more fruit to order!");
                System.out.println("Product | Quantity | Price | Amount");
                int counts = 0;
                double totals = 0;
                for (Fruit o : listBuy) {
                    counts++;
                    int qs = o.getQuantity();
                    double ps = o.getPrice();
                    System.out.printf("%-13s%-10s%-8s%-5s", o.getName(), qs, ps + "$", (ps * qs) + "$");
                    System.out.println("");
                    totals += (ps * qs);
                }

                System.out.println("Total: " + totals + "$");
                String name = Validation.getString("Input your name: ");
                ArrayList<String> namae = new ArrayList<>();
                namae.add(dem + "");
                namae.add(totals + "");
                namae.add(name);
                listTotal.add(totals);
                viewOrder.put(namae, listBuy);
                dem++;
                break;
            } else {
                String s = Validation.getYN("Do you want to continue (Y/N).");
                if (s.equalsIgnoreCase("Y")) {
                    continue;
                } else {
                    count = 0;
                    double total = 0;
                    System.out.println("Product | Quantity | Price | Amount");
                    for (Fruit o : listBuy) {
                        count++;
                        int q = o.getQuantity();
                        double p = o.getPrice();
                        System.out.printf("%-13s%-10s%-8s%-5s", o.getName(), q, p + "$", (p * q) + "$");
                        System.out.println("");
                        total += (p * q);
                    }

                    System.out.println("Total: " + total + "$");
                    String name = Validation.getString("Input your name: ");
                    ArrayList<String> namae = new ArrayList<>();
                    namae.add(dem + "");
                    namae.add(total + "");
                    namae.add(name);
                    listTotal.add(total);
                    viewOrder.put(namae, listBuy);
                    dem++;
                    break;
                }
            }

        }

    }

    public void view() {
        if (viewOrder.isEmpty()) {
            System.out.println("THERE IS NO ORDER TO SHOW!");
        }
        viewOrderBufer.putAll(viewOrder);

        Collections.sort(listTotal, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o2.compareTo(o1);
            }
        });

        for (Double i : listTotal) {
            for (Map.Entry<ArrayList<String>, List<Fruit>> entry : viewOrderBufer.entrySet()) {
                ArrayList<String> key = entry.getKey();
                List<Fruit> value = entry.getValue();
                if (Double.parseDouble(key.get(1)) == i) {
                    int count = 0;
                    double total = 0;
                    System.out.println("");
                    System.out.println("Customer: " + key.get(2));
                    System.out.println("Product | Quantity | Price | Amount");
                    for (Fruit o : viewOrder.get(key)) {
                        count++;
                        int q = o.getQuantity();
                        double p = o.getPrice();
                        System.out.printf("%s%-11s%-10s%-8s%-5s", count + ".", o.getName(), q, p + "$", (p * q) + "$");
                        total += (p * q);
                        System.out.println("");
                    }
                    System.out.println("Total : " + total + "$");
                    System.out.println("");
                    viewOrderBufer.remove(key);
                    break;
                } else {
                    continue;
                }
                
            }
        }
        
    }
    

}
