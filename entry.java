public class entry implements Comparable<entry>{
    String name;
    int score;
    public entry(String name, int score)
    {
        this.name = name;
        this.score = score;
    }

    public entry(){}

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(entry other) {
        if(this.score < other.score)
        {
            return 1;
        }
        else if(this.score > other.score)
        {
            return -1;
        }
        else
        {
            return  0 - this.name.compareTo(other.getName());
        }
    }

    public String toString()
    {
        return name + " " + score;
    }
}
