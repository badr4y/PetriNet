public class Arc {
    private int weight;
    protected Place place;
    protected Transition transition;

    public Arc() {
    }

    public Arc(int weight, Place place, Transition transition) {
        if (weight <0){
            this.weight = 0;
        }else{
            this.weight = weight;
        }
        this.transition = transition;
        this.place= place;
    }

    public Transition getTransition() {
        return transition;
    }

    public int getWeight() {
        return weight;
    }

    public Place getPlace() {
        return place;
    }

    public void changeWeight(int n) {
        this.weight = n;
    }

    public boolean drawable() {
        return place.getTokens() >= weight;
    }

    public void addTokens() {
        place.setTokens(place.getTokens()+ weight);
    }

    public void retrieveTokens() {
        if(place.getTokens()< weight) {
            place.setTokens(0);
        }else{
            place.setTokens(place.getTokens()- weight);
        }
    }


}
