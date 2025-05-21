import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class

public class Store {

    private ArrayList<Products> products = new ArrayList<>();
    private int addEstoque = 0;


    public void add_products_estoque(String code, int qtd){
        for (int i = 0 ; i < products.size(); i++){
            // Antes de atualizar a quantidade de um determinado produto e o seu estoque eu verifico se o produto está inserido na lista
            if(products.get(i).get_space_code().equals(code)) {

            }
        }
    }

    public void remove_products_estoque(String code, int qtd){
        for(int i = 0; i < products.size();i ++){
            // Antes de atualizar a quantidade de um determinado produto e o seu estoque eu verifico se o produto está inserido na lista
            if(products.get(i).get_space_code().equals(code))

        }
    }
    public void insert_products(Products product) {
        products.add(product);
    }

    public void show_all_products() {
         // Faço a iteração por cada indice presente no arrayList e apartir de cada indice chamo a função de exibição
        for(int i = 0; i < products.size(); i++){
            products.get(i).show_details();
        }
    }

















    public static void main(String[] args) {

        Store store = new Store();
        Scanner scanner = new Scanner(System.in); //Create a Scanner object

        int quantityOfProducts = 0;



        while (scanner.hasNextLine()) {
            String line = scanner.nextLine(); // Read input user;

            if (line == null || line.trim().isEmpty())
                break; // Se a linha lida for vazia eu paro o funcionamento do programa


            String[] parts = line.split(",");
            switch (parts[0]){

                // Inserir produto
                case "I":
                    switch (parts[1]) {
                        case "Livro" -> {
                            Products book = new Book(parts[1],parts[2], parts[3], parts[4], parts[5],parts[6],parts[7],parts[8], parts[9]);
                            store.insert_products(book);
                        }
                        case "CD" -> {
                            Products cd = new CD(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]);
                            store.insert_products(cd);
                        }
                        case "DVD" -> {
                            Products dvd = new DVD(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8]);
                            store.insert_products(dvd);
                        }
                    }
                // Adicionar produtos ao estoque [código do produto, quantidade]
                case "A":
                //Vender produto do estoque
                case "V":
                // Procurar produto no estoque
                case "P":
                case "S":
                    break;
            }

        }

        store.show_all_products();


    }





}
