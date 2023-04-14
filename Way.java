public class Way {
    private int depart;
    private int arrive;
    private int distance;

    public Way(int depart, int arrive, int distance) {
        this.depart = depart;
        this.arrive = arrive;
        this.distance = distance;
    }

    public int getDepart() {
        return depart;
    }

    public void setDepart(int depart) {
        this.depart = depart;
    }

    public int getArrive() {
        return arrive;
    }

    public void setArrive(int arrive) {
        this.arrive = arrive;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "(" + depart + "," + arrive + ") " + distance;
    }
    
}


