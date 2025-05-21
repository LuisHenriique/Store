public class CD extends Products{
    private String titleAlbum;
    private String nameSinger;
    private String numbers_musics;
    private String recordCompany;
    private String year;


    public CD(String name, String spaceCode, String titleAlbum, String nameSinger , String numbers_musics , String recordCompany, String  year ) {
        super(name, spaceCode);
        this.year = year;
        this.recordCompany = recordCompany;
        this.numbers_musics = numbers_musics;
        this.nameSinger = nameSinger;
        this.titleAlbum = titleAlbum;
    }

    @Override
    public void show_details() {
        System.out.println(this.name);
        System.out.println("Código: " + "\n" + "Título: " +"\n"+ this.titleAlbum + "\n" + "Banda: " + this.nameSinger + "\n" + "Gravadora: " + this.recordCompany + "\n" + "Ano: " + this.year + "\n" + "trilhas: " + this.numbers_musics + "\n");

    }

    @Override
    public String get_nome_principal() {
        return this.nameSinger;
    }
}
