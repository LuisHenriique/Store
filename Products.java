public class Products {
    protected String name;
    protected String  spaceCode;
    protected String category;
    protected int quantityProducts = 0;

    public Products(String name, String spaceCode){
    this.name = name;
    this.spaceCode = spaceCode;
    }

    // função responsável por atualizar a variável quantityProducts, ou seja a quantidade do de peças do produto

    public void add_quantity_products(int qtd){
        this.quantityProducts += qtd;
    }

    public boolean remove_quantity_products(int qtd){
        if(qtd > this.quantityProducts){
            return false;
        }
        else{
            this.quantityProducts -= qtd; // this.quantityProducts = this.quantity - qtd;
        }
    }
    public void show_details() {

    }

    public String get_space_code() {
        return spaceCode;
    }


}
