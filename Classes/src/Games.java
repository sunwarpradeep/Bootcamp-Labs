public class Games {

    private String genre;
    private double price;
    private double rating;
    private String name;

    public Games(String genre, double price, double rating, String name) {
        this.genre = genre;
        this.price = price;
        this.rating = rating;
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
