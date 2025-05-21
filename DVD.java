public class DVD extends Products {
    private String nameFilm;
    private String director;
    private String language;
    private String filmGenre;
    private String year;
    private String nationality;

    public DVD(String name, String spaceCode, String nameFilm, String director, String language, String filmGenre, String year, String nationality) {
        super(name, spaceCode);
        this.nameFilm = nameFilm;
        this.director = director;
        this.language = language;
        this.filmGenre = filmGenre;
        this.year = year;
        this.nationality = nationality;
    }

    @Override
    public void show_details() {
        System.out.println(this.name);
        System.out.println("Código: " + "\n" + "Título: " + this.nameFilm + "\n" + "Diretor: " + this.director + "\n" + "Gênero: " + this.filmGenre + "\n" + "Ano: " + this.year + "\n" + "Nacionalidade: " + this.nationality + "\n" + "Idioma: " + this.language + "\n");
    }

    @Override
    public String get_nome_principal() {
        return this.nameFilm;
    }
}
