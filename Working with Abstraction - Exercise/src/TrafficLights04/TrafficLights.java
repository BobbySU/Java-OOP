package TrafficLights04;

public class TrafficLights {
    private Color color;

    public TrafficLights(Color color) {
        this.color = color;
    }

    public void ChangeColor() {
        switch (this.color) {
            case RED:
                this.color = Color.GREEN;
                break;
            case GREEN:
                this.color = Color.YELLOW;
                break;
            case YELLOW:
                this.color = Color.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return this.color.toString();
    }
}
