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
    private static int dem = 1;

    public void createFruit() {
        while (true) {
            String id = Validation.getID("Input fruit's id: ", listFruit);
            String name = Validation.getString("Input fruit's name: ");
            int quantity = Validation.getInt("Input fruit's quantity: ", 0, 1000);
            double price = Validation.getDouble("Input fruit's price: ", 0, 1000);
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

    public void buy() {
        ArrayList<Fruit> listBuy = new ArrayList<>();
        if(listFruit.isEmpty()){
            System.err.println("There is no Fruit to order!");
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
            int quantity = Validation.getInt("Please input quantity:", 0, itemSelect.getQuantity());
            Fruit eachBuy = new Fruit(itemSelect.getId(), itemSelect.getName(), quantity, itemSelect.getPrice(), itemSelect.getOrigin());
            listBuy.add(eachBuy);
            listFruit.get(item - 1).setQuantity(listFruit.get(item - 1).getQuantity() - quantity);
            if (listFruit.get(item - 1).getQuantity() == 0) {
                listFruit.remove(item - 1);
            }

            if (listFruit.isEmpty()) {
                System.err.println("There is no more fruit to order!");
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
            } else {
                String s = Validation.getYN("Do you want to order now (Y/N).");
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
            System.err.println("There is no order to show!");
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
                    viewOrderBufer.remove(key);
                    break;
                } else {
                    continue;
                }

            }
        }
    }

}
