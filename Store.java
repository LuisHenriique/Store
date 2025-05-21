import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class

public class Store {

    private ArrayList<Products> products = new ArrayList<>();


    public boolean add_products_estoque(String code, String qtd_user) {
        int qtd = Integer.parseInt(qtd_user);

        for (int i = 0; i < products.size(); i++) {
            // Antes de atualizar a quantidade de um determinado produto e o seu estoque eu verifico se o produto está inserido na lista
            if (products.get(i).get_space_code().equals(code)) {
                products.get(i).add_quantity_products(qtd); // atualizo o valor da quantidade do produto
                return true;
            }
        }
        return false;
    }

    public boolean remove_products_estoque(String code, String qtd_user) {
        int qtd = Integer.parseInt(qtd_user);
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).get_space_code().equals(code)) {
                if (products.get(i).remove_quantity_products(qtd)) {
                    return true;
                } else {
                    System.out.println("Operação de venda: " + code + "\n" +
                            "***Erro: Estoque insuficiente: " + code +
                            " Quantidade: " + products.get(i).get_quantity_products());
                    return false;
                }
            }
        }
        return false;
    }

    public boolean insert_products(Products product, String code) {

        if(products.isEmpty()){
            products.add(product);
            return true;
        }

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).get_space_code().equals(code)) return false;
        }

        products.add(product);
        return true;
    }


    public boolean search_product(String spaceCode, String nameProduct, boolean operationSearch, int[] indice) {
        if (operationSearch) {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).get_space_code().equals(spaceCode)) {
                    indice[0] = i;
                    return true;
                }
            }
        } else {
            for (int j = 0; j < products.size(); j++) {
                if (products.get(j).get_nome_principal().equals(nameProduct)) {
                    indice[0] = j;
                    return true;
                }
            }
        }
        return false;
    }

    public void show_all_products() {
        for (int i = 0; i < products.size(); i++) {
            products.get(i).show_details();
            System.out.println("Quantidade: " + products.get(i).get_quantity_products());
            System.out.println();  // Adiciona linha em branco entre produtos
        }
    }

    public void show_products(int indice) {
        products.get(indice).show_details();
    }


    public static void main(String[] args) {

        Store store = new Store();
        Scanner scanner = new Scanner(System.in); //Create a Scanner object

        int quantityOfProducts = 0;


        while (scanner.hasNextLine()) {
            String line = scanner.nextLine(); // Read input user;

            if (line == null || line.trim().isEmpty())
                break; // Se a linha lida for vazia eu paro o funcionamento do programa


            String[] parts = line.split(",", -1);
            String aux = null;
            switch (parts[0]) {

                // Inserir produto
                case "I":

                    // Chama a função de busca aqui para verificar antes de inserir de na lista se o produto já está la
                    switch (parts[1]) {
                        case "Livro" -> {
                           Products book = new Book(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8], parts[9]);
                            if (store.insert_products(book, parts[2])) {
                                System.out.print("Operação inserir " + parts[1] + ": " + parts[2] + "\n" + "Operação realizada com sucesso\n");
                            } else
                                System.out.println("Operação inserir " + parts[1] + ": " + parts[2] + "\n" + "***Erro: Código já cadastrado: " + parts[2]);
                        }
                        case "CD" -> {
                           Products cd = new CD(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]);
                            if (store.insert_products(cd, parts[2])) {
                                System.out.print("Operação inserir " + parts[1] + ": " + parts[2] + "\n" + "Operação realizada com sucesso\n");
                            } else
                                System.out.println("Operação inserir " + parts[1] + ": " + parts[2] + "\n" + "***Erro: Código já cadastrado: " + parts[2]);

                        }
                        case "DVD" -> {
                           Products dvd = new DVD(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8]);
                            if (store.insert_products(dvd, parts[2])) {
                                System.out.print("Operação inserir " + parts[1] + ": " + parts[2] + "\n" + "Operação realizada com sucesso\n");
                            } else
                                System.out.println("Operação inserir " + parts[1] + ": " + parts[2] + "\n" + "***Erro: Código já cadastrado: " + parts[2]);

                        }
                    }
                    System.out.println();
                    break;

                // Adicionar produtos ao estoque [código do produto, quantidade]
                case "A":
                    aux = parts[2].trim();
                    if (store.add_products_estoque(parts[1],aux))
                        System.out.println("Operação de compra: " + parts[1] + "\n" + "Operação realizada com sucesso: " + parts[1] +"\n");
                    else
                        System.out.println("Operação de compra: " + parts[1] + "\n" + "***Erro: Código inexistente: " + parts[1]+"\n");

                    break;
                    //Vender produto do estoque
                case "V":
                    aux = parts[2].trim();
                    if (store.remove_products_estoque(parts[1], parts[2]))
                        System.out.println("Operação de venda: " + parts[1] + "\n" + "Operação realizada com sucesso: " + parts[1] +"\n");
                    else
                        System.out.println("Operação de venda: " + parts[1] + "\n" + "***Erro: Código inexistente: " + parts[1]+"\n");


                    break;

                // Procurar produto no estoque
                case "P":
                    // Faço a verificação se o comando de busca é realizado como o código ou como o nome do produto
                    int[] indice = {0};
                    System.out.println("Procurando: " + parts[1]);

                    if (parts[1].charAt(0) >= 48 && parts[1].charAt(0) <= 57) { // Caso da busca pelo código
                        if (store.search_product(parts[1].trim(), null, true, indice)) {
                            System.out.println("Encontrado:");
                            store.show_products(indice[0]);

                        }else{
                            System.out.println("Produto não encontrado: "  + parts[1]);
                        }

                    } else {


                        if (store.search_product(null, parts[1], false, indice)) {
                            System.out.println("Encontrado:");
                            store.show_products(indice[0]);

                        }else{
                            System.out.println("Produto não encontrado: "  + parts[1]);
                        }
                    }


                    break;
                case "S":

                    System.out.println("Operação de sumarização:\n");
                    store.show_all_products();
                    System.out.println();
                    break;
            }

        }




    }


}
