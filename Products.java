public class Products {
    protected String name;
    protected String  spaceCode;
    protected String category;
    protected int quantityProducts = 0;

    public Products(String name, String spaceCode){
    this.name = name;
    this.spaceCode = spaceCode;
    }

    // função responsável por atualizar a variável quantityProducts, ou seja, a quantidade do respectivo produto
    public void add_quantity_products(int qtd){
        this.quantityProducts += qtd;
    }

    public void remove_quantity_products(int qtd){
            this.quantityProducts -= qtd; // this.quantityProducts = this.quantity - qtd;
    }

    public int get_quantity_products(){
        return this.quantityProducts;
    }
    public void show_details(){

    }

    // retorna o "nome principal", seja título, nome, etc.
    public String get_nome_principal(){
        return null;
    }


    public String get_space_code() {
        return spaceCode;
    }

    public String get_name_type(){
        return this.name;
    }

}
