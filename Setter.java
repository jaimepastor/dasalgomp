public class Setter {
    private String postOffice;
    private String location;
    private String destination;
    private double distance;

    public Setter(String post, String loc, String dest, double dist){
        postOffice=post;
        location=loc;
        destination=dest;
        distance=dist;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public String getLocation() {
        return location;
    }

    public String getDestination() {
        return destination;
    }

    public double getDistance() {
        return distance;
    }

    public void display(){
        System.out.println(postOffice+" "+location+" "+destination+" "+distance);
    }
}
