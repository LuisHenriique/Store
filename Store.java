    import java.util.ArrayList;
    import java.util.Scanner; // Import the Scanner class

    public class Store {

        private ArrayList<Products> products = new ArrayList<>();


        public boolean add_products_estoque(String code, int qtd) {

            for (int i = 0; i < products.size(); i++) {
                // Antes de atualizar a quantidade de um determinado produto e o seu estoque eu verifico se o produto está inserido na lista
                if (products.get(i).get_space_code().equals(code)) {
                    products.get(i).add_quantity_products(qtd); // atualizo o valor da quantidade do produto
                    return true;
                }
            }
            return false;
        }

        public boolean remove_products_estoque(String code, int qtd, int[] qtd_atual) {

            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).get_space_code().equals(code)) {
                    int aux = products.get(i).get_quantity_products() - qtd;

                    qtd_atual[0] = aux;

                    if (aux >= 0) {
                        products.get(i).remove_quantity_products(qtd);

                        return true;
                    }
                }
            }
            return false;
        }

        public boolean insert_products(Products product, String code) {

            if (products.isEmpty()) {
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

        public void count_estoque_of_each_type(int[] countCD, int[] countDVD, int[] countBooks) {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).get_name_type().equals("CD")) countCD[0] += products.get(i).get_quantity_products();
                if (products.get(i).get_name_type().equals("DVD")) countDVD[0] += products.get(i).get_quantity_products();
                if (products.get(i).get_name_type().equals("Livro"))
                    countBooks[0] += products.get(i).get_quantity_products();
            }
        }

        public void show_all_products(int countCd, int countDVD, int countBooks) {

            for (Products p : products) {
                if (p.get_name_type().equals("Livro")) {
                    p.show_details();
                    System.out.println("Quantidade: " + p.get_quantity_products());
                    System.out.println();
                }
            }
            System.out.println("Quantidade de Livros: " + countBooks);
            System.out.println();

            for (Products p : products) {
                if (p.get_name_type().equals("CD")) {
                    p.show_details();
                    System.out.println("Quantidade: " + p.get_quantity_products());
                    System.out.println();
                }
            }
            System.out.println("Quantidade de CDs: " + countCd);
            System.out.println();


            for (Products p : products) {
                if (p.get_name_type().equals("DVD")) {
                    p.show_details();
                    System.out.println("Quantidade: " + p.get_quantity_products());
                    System.out.println();
                }
            }
            System.out.println("Quantidade de DVDs: " + countDVD);
            System.out.println();
            System.out.println();


        }


        public void show_products(int indice) {
            products.get(indice).show_details();
        }


        public static void main(String[] args) {

            Store store = new Store();
            Scanner scanner = new Scanner(System.in); //Create a Scanner object

            int quantityOfProducts = 0;
            int count = 0;


            while (scanner.hasNextLine()) {
                String line = scanner.nextLine(); // Read input user;

                if (line == null || line.trim().isEmpty())
                    break; // Se a linha lida for vazia eu paro o funcionamento do programa


                String[] parts = line.split(",", -1);
                int quantidade;
                int[] indice = {0};

                switch (parts[0]) {

                    // Inserir produto
                    case "I":
                        count++;
                        // Chama a função de busca aqui para verificar antes de inserir de na lista se o produto já está la
                        switch (parts[1]) {

                            case "Livro" -> {
                                Products book = new Book(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8], parts[9]);
                                if (store.insert_products(book, parts[2])) {
                                    if(count == 1){
                                        System.out.println();
                                    }
                                    System.out.print("Operação inserir " + parts[1].toLowerCase()+": ");
                                    System.out.println(parts[2].replaceFirst("^0+(?!$)", ""));
                                    System.out.println("Operação realizada com sucesso");
                                    System.out.println();

                                } else {
                                    System.out.print("Operação inserir " + parts[1].toUpperCase() + ": ");
                                    System.out.println(parts[2].replaceFirst("^0+(?!$)", ""));
                                    System.out.print("***Erro: Código já cadastrado: ");
                                    System.out.println(parts[2].replaceFirst("^0+(?!$)", ""));

                                }
                            } case "CD" -> {
                                Products cd = new CD(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]);
                                if (store.insert_products(cd, parts[2])) {
                                    System.out.print("Operação inserir " + parts[1]+": ");
                                    System.out.println(parts[2].replaceFirst("^0+(?!$)", ""));
                                    System.out.println("Operação realizada com sucesso");
                                    System.out.println();
                                } else
                                {
                                    System.out.print("Operação inserir " + parts[1] + ": ");
                                    System.out.println(parts[2].replaceFirst("^0+(?!$)", ""));
                                    System.out.print("***Erro: Código já cadastrado: ");
                                    System.out.println(parts[2].replaceFirst("^0+(?!$)", ""));
                                }

                            }
                            case "DVD" -> {
                                Products dvd = new DVD(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8]);
                                if (store.insert_products(dvd, parts[2])) {
                                    System.out.print("Operação inserir " + parts[1]+": ");
                                    System.out.println(parts[2].replaceFirst("^0+(?!$)", ""));
                                    System.out.println("Operação realizada com sucesso");
                                    System.out.println();
                                } else {
                                    System.out.print("Operação inserir " + parts[1] + ": ");
                                    System.out.println(parts[2].replaceFirst("^0+(?!$)", ""));
                                    System.out.print("***Erro: Código já cadastrado: ");
                                    System.out.println(parts[2].replaceFirst("^0+(?!$)", ""));
                                }
                            }
                        }
                        break;

                    // Adicionar produtos ao estoque [código do produto, quantidade]
                    case "A":
                        quantidade = Integer.parseInt(parts[2].trim());
                        if (store.add_products_estoque(parts[1], quantidade)) {
                            System.out.print("Operação de compra: ");
                            System.out.println(parts[1].replaceFirst("^0+(?!$)", ""));
                            System.out.print("Operação realizada com sucesso: ");
                            System.out.println(parts[1].replaceFirst("^0+(?!$)", ""));
                        } else {
                            System.out.print("Operação de compra: ");
                            System.out.println(parts[1].replaceFirst("^0+(?!$)", ""));
                            System.out.print("***Erro: Código inexistente: ");
                            System.out.println(parts[1].replaceFirst("^0+(?!$)", ""));

                        }
                        System.out.println();
                        break;
                    //Vender produto do estoque
                    case "V":
                        quantidade = Integer.parseInt(parts[2].trim());
                        int[] qtd_atual = {0};
                        if (store.remove_products_estoque(parts[1], quantidade, qtd_atual)) {
                            System.out.print("Operação de venda: ");
                            System.out.println(parts[1].replaceFirst("^0+(?!$)", ""));
                            System.out.print("Operação realizada com sucesso: ");
                            System.out.println(parts[1].replaceFirst("^0+(?!$)", ""));

                        } else if (!store.remove_products_estoque(parts[1], quantidade, qtd_atual) && qtd_atual[0] < 0) {
                            System.out.println("Operação de venda: " + parts[1] + "\n" + "***Erro: Estoque insuficiente: " + parts[1] + " Quantidade: " + quantidade);

                        } else {

                            System.out.print("Operação de venda: ");
                            System.out.println(parts[1].replaceFirst("^0+(?!$)", ""));
                            System.out.print("***Erro: Código inexistente: ");
                            System.out.println(parts[1].replaceFirst("^0+(?!$)", ""));
                        }
                        System.out.println();


                        break;

                    // Procurar produto no estoque
                    case "P":
                        // Faço a verificação se o comando de busca é realizado como o código ou como o nome do produto
                        System.out.println("Procurando: " + parts[1]);

                        if (parts[1].charAt(0) >= 48 && parts[1].charAt(0) <= 57) { // Caso da busca pelo código
                            if (store.search_product(parts[1].trim(), null, true, indice)) {
                                System.out.println("Encontrado:");
                                store.show_products(indice[0]);
                                System.out.println();

                            } else {
                                System.out.print("Produto não encontrado: ");
                                System.out.println(parts[1].replaceFirst("^0+(?!$)", ""));
                                System.out.println();

                            }

                        } else {


                            if (store.search_product(null, parts[1], false, indice)) {
                                System.out.println("Encontrado:");
                                store.show_products(indice[0]);
                                System.out.println();

                            } else {
                                System.out.println(parts[1].replaceFirst("^0+(?!$)", ""));
                            }
                        }


                        break;
                    case "S":
                        int[] countDVD = {0};
                        int[] countCD = {0};
                        int[] countBook = {0};

                        store.count_estoque_of_each_type(countCD, countDVD, countBook);
                        System.out.println("Operação de sumarização: ");
                        store.show_all_products(countCD[0], countDVD[0], countBook[0]);


                        break;
                }

            }


        }


    }