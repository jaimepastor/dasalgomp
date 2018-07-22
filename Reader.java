import java.io.*;
import java.util.*;

public class Reader {
    private ArrayList<Setter> setting;   //Setter Class
    private MailMan man;

    public Reader(){
        setting=new ArrayList<>();    //initialize Setter Array
        man = new MailMan();

        String buffer;
        String[] column;
        try (BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/Jeff/Desktop/To Do/Map.csv"),"ISO-8859-1"))) {   //reads .csv file
            read.readLine();    //skips first line (titles etc.)
            while ((buffer = read.readLine()) != null) {    //will loop until no more lines are found
                column = buffer.split(",");     //splits data into columns by the comma
                double test = Double.parseDouble(column[3]);    //translates String value into double value
                setting.add(new Setter(column[0],column[1],column[2],test));    //initializes Setting array with .csv data
            }
        }
        catch (IOException e) {     //cancels out errors
            e.printStackTrace();
        }

        //for(int i=0;i<setting.size();i++)
        //    System.out.println(setting.get(i).getLocation());
    }

    public void mailMan(int city){
        Scanner sc = new Scanner(System.in);
        int m=0,a=0;
        String which=null;
        String address;
        switch (city){      //the values are the ranges of the cities in the .csv file
            case 1:     //manila
                which="Manila City";
                break;
            case 2:     //quezon
                which="Quezon City";
                break;
            case 3:     //makati
                which="Makati City";
                break;
            case 4:     //pasay
                which="Pasay City";
                break;
                default: System.exit(0);    //will exit the program
        }
        man.setCurrentOffice(which);
        do {
            System.out.println("How many mails are there?");
            int num = sc.nextInt();
            sc.nextLine();  //buffer line
            ArrayList<Setter> temp = new ArrayList<>();
            for (int z = 0; z < num; z++) {    //will ask z number of times for mail address
                System.out.println("Input Delivery " + (z + 1) + " : ");
                address = sc.nextLine();
                for (int c = 0; c < setting.size(); c++) {   //checks the entire list for the same address
                    if (address.equalsIgnoreCase(setting.get(c).getDestination())) {
                        temp.add(setting.get(c));
                        if (temp.get(a).getPostOffice().equalsIgnoreCase(man.getCurrentOffice())) {
                            System.out.println("1");
                            man.addMail(setting.get(c));
                            m++;
                        } else {
                            System.out.println("2");
                            man.addHold(setting.get(c));
                        }
                        a++;
                    }
                }
            }

        /*man.displayMail();
        System.out.println(" ");
        man.displayHold();
        System.out.println(" ");
        System.out.println("NEXT");
        System.out.println(" ");*/

            for (int u = 0; u < m - 1; u++) {
                for (int k = 0; k < m - u - 1; k++) {
                    if (man.getMail().get(k).getDistance() > man.getMail().get(k + 1).getDistance()) {
                        Setter move = man.getMail().get(k);
                        man.setMail(man.getMail().get(k + 1), k);
                        man.setMail(move, (k + 1));
                    }
                }
            }
            //1st batch of mails delivered
            //man.displayMail();
            man.clearMail();
            man.addAllHoldToMail(man.getHold());
            man.clearHold();
            temp.clear();
            a=0;
            m=0;

            man.displayMail();
            System.out.println("NEXT");
            man.displayHold();
            if(!(man.getMail().isEmpty()))
                man.setCurrentOffice(man.getMail().get(0).getPostOffice());
        }while(!(man.getMail().isEmpty()));
    }

    public static void main(String[] args) {
        Reader r = new Reader();
        Scanner sc = new Scanner(System.in);

        System.out.println("1 : Manila City");
        System.out.println("2 : Quezon City");
        System.out.println("3 : Makati City");
        System.out.println("4 : Pasay City");
        System.out.println("5 : Exit");
        System.out.println("Starting Location: ");
        int menu = sc.nextInt();

        r.mailMan(menu);
    }
}
