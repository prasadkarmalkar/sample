package entity;

public class Book {
	int price;
	String book_id,book_name,author,sell_type,description,type,image,email;
	public Book(String book_id, int price, String book_name, String author, String sell_type, String description,
			String type, String image, String email) {
		this.book_id = book_id;
		this.price = price;
		this.book_name = book_name;
		this.author = author;
		this.sell_type = sell_type;
		this.description = description;
		this.type = type;
		this.image = image;
		this.email = email;
	}
	public Book() {}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSell_type() {
		return sell_type;
	}
	public void setSell_type(String sell_type) {
		this.sell_type = sell_type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
