import java.util.*;

public class MailMan {
    private ArrayList<Setter> mail;
    private ArrayList<Setter> hold;
    private String currentOffice;

    public MailMan(){
        mail = new ArrayList<>();
        hold = new ArrayList<>();
    }

    public void addMail(Setter del){
        mail.add(del);
    }

    public void addHold(Setter del){
        hold.add(del);
    }

    public void setMail(Setter del,int i){
        mail.set(i,del);
    }

    public void removeMail(Setter del){
        mail.remove(del);
    }

    public void setHold(Setter del,int i){
        hold.set(i,del);
    }

    public void setCurrentOffice(String currentOffice) {
        this.currentOffice = currentOffice;
    }

    public String getCurrentOffice() {
        return currentOffice;
    }

    public void displayMail(){
        for (int a=0;a<mail.size();a++)
            System.out.println(mail.get(a).getDestination());
    }

    public void displayHold(){
        for (int a=0;a<hold.size();a++)
            System.out.println(hold.get(a).getDestination());
    }

    public ArrayList<Setter> getMail() {
        return mail;
    }

    public ArrayList<Setter> getHold() {
        return hold;
    }
}
