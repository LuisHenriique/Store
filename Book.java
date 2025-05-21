public class Book extends Products {

    private String nameBook;
    private String author;
    private String publisher;
    private String year;
    private String edition;
    private String pages;
    private String language;


    public Book(String name, String  spaceCode, String nameBook, String author, String publisher, String year, String edition, String pages, String language) {
        super(name, spaceCode);
        this.nameBook = nameBook;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.edition = edition;
        this.pages = pages;
        this.language = language;


    }

    @Override
    public void show_details() {
        System.out.println(name +"\n"+ "Código: "+ this.spaceCode +"\n"+"Título: " +this.nameBook + "\n" +"Autor: " + this.author +"\n"+ "Editora: " + this.publisher +"\n"+"Edition:" + this.edition +"\n"+ "Ano: " + this.year +"\n" + "Páginas: " + this.pages +"\n"+ "Idioma: " + this.language +"\n");
    }

    @Override
    public String get_nome_principal() {
        return this.nameBook;
    }
}
