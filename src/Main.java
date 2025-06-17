import java.util.Scanner;

public class Main {

    private static Usuario[] usuarios = new Usuario[10];
    private static Viagem[] viagens = new Viagem[10];
    private static Atividade[] atividades = new Atividade[10];
    private static Acomodacao[] acomodacoes = new Acomodacao[10];

    private static int usuariosCount = 0;
    private static int viagensCount = 0;
    private static int atividadesCount = 0;
    private static int acomodacoesCount = 0;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    cadastrarViagem();
                    break;
                case 3:
                    adicionarAtividade();
                    break;
                case 4:
                    adicionarAcomodacao();
                    break;
                case 5:
                    consultarItinerario();
                    break;
                case 6:
                    calcularOrcamentoTotal();
                    break;
                case 7:
                    consultarViagensPorUsuario();
                    break;
                case 8:
                    consultarUsuarios();
                    break;
                case 9:
                    System.out.println("Saindo do programa...");
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1 - Cadastrar Usuário");
        System.out.println("2 - Cadastrar Viagem");
        System.out.println("3 - Adicionar Atividade");
        System.out.println("4 - Adicionar Acomodação");
        System.out.println("5 - Consultar Itinerário");
        System.out.println("6 - Calcular Orçamento Total");
        System.out.println("7 - Consultar Viagens por Usuário");
        System.out.println("8 - Consultar Usuários Cadastrados");
        System.out.println("9 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarUsuario() {
        System.out.print("Digite o ID do Usuário: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o nome do Usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o e-mail do Usuário: ");
        String email = scanner.nextLine();

        boolean emailExistente = false;
        for (int i = 0; i < usuariosCount; i++) {
            if (usuarios[i].getEmail().equals(email)) {
                emailExistente = true;
                break;
            }
        }

        if (emailExistente) {
            System.out.println("Erro: E-mail já cadastrado.");
        } else {
            boolean idExistente = false;
            for (int i = 0; i < usuariosCount; i++) {
                if (usuarios[i].getId() == id) {
                    idExistente = true;
                    break;
                }
            }

            if (idExistente) {
                System.out.println("Erro: ID já cadastrado.");
            } else {
                if (usuariosCount < usuarios.length) {
                    usuarios[usuariosCount++] = new Usuario(id, nome, email);
                    System.out.println("Usuário cadastrado com sucesso!");
                } else {
                    System.out.println("Erro: Limite de usuários atingido.");
                }
            }
        }
    }

    private static void cadastrarViagem() {
        System.out.print("Digite o ID da Viagem: ");
        int idViagem = scanner.nextInt();
        scanner.nextLine(); // limps
        System.out.print("Digite o destino da Viagem: ");
        String destino = scanner.nextLine();
        System.out.print("Digite a data de início da viagem (yyyy-mm-dd): ");
        String dataInicio = scanner.nextLine();
        System.out.print("Digite a data de fim da viagem (yyyy-mm-dd): ");
        String dataFim = scanner.nextLine();


        System.out.println("Escolha o ID do Usuário:");
        for (int i = 0; i < usuariosCount; i++) {
            System.out.println("ID: " + usuarios[i].getId() + " - " + usuarios[i].getNome());
        }
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); // limps

        Usuario usuario = null;
        for (int i = 0; i < usuariosCount; i++) {
            if (usuarios[i].getId() == idUsuario) {
                usuario = usuarios[i];
                break;
            }
        }

        if (usuario == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }

        if (viagensCount < viagens.length) {
            viagens[viagensCount++] = new Viagem(idViagem, destino, dataInicio, dataFim, usuario);
            System.out.println("Viagem cadastrada com sucesso!");
        } else {
            System.out.println("Erro: Limite de viagens atingido.");
        }
    }

    private static void adicionarAtividade() {
        System.out.print("Digite o ID da Atividade: ");
        int idAtividade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite a descrição da Atividade: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite o custo estimado da Atividade: ");
        double custoEstimado = scanner.nextDouble();
        scanner.nextLine(); // limps

        System.out.println("Escolha o ID da Viagem:");
        for (int i = 0; i < viagensCount; i++) {
            System.out.println("ID: " + viagens[i].getIdViagem() + " - " + viagens[i].getDestino());
        }
        int idViagem = scanner.nextInt();
        scanner.nextLine(); // limps

        Viagem viagem = null;
        for (int i = 0; i < viagensCount; i++) {
            if (viagens[i].getIdViagem() == idViagem) {
                viagem = viagens[i];
                break;
            }
        }

        if (viagem == null) {
            System.out.println("Viagem não encontrada!");
            return;
        }

        if (atividadesCount < atividades.length) {
            atividades[atividadesCount++] = new Atividade(idAtividade, descricao, custoEstimado, viagem);
            System.out.println("Atividade adicionada com sucesso!");
        } else {
            System.out.println("Erro: Limite de atividades atingido.");
        }
    }

    private static void adicionarAcomodacao() {
        System.out.print("Digite o ID da Acomodação: ");
        int idAcomodacao = scanner.nextInt();
        scanner.nextLine(); // limps
        System.out.print("Digite o nome da Acomodação: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o custo diário da Acomodação: ");
        double custoDiario = scanner.nextDouble();
        System.out.print("Digite o número de dias reservados: ");
        int diasReservados = scanner.nextInt();
        scanner.nextLine(); // limps

        System.out.println("Escolha o ID da Viagem:");
        for (int i = 0; i < viagensCount; i++) {
            System.out.println("ID: " + viagens[i].getIdViagem() + " - " + viagens[i].getDestino());
        }
        int idViagem = scanner.nextInt();
        scanner.nextLine(); // limps

        Viagem viagem = null;
        for (int i = 0; i < viagensCount; i++) {
            if (viagens[i].getIdViagem() == idViagem) {
                viagem = viagens[i];
                break;
            }
        }

        if (viagem == null) {
            System.out.println("Viagem não encontrada!");
            return;
        }

        if (acomodacoesCount < acomodacoes.length) {
            acomodacoes[acomodacoesCount++] = new Acomodacao(idAcomodacao, nome, custoDiario, diasReservados, viagem);
            System.out.println("Acomodação adicionada com sucesso!");
        } else {
            System.out.println("Erro: Limite de acomodações atingido.");
        }
    }

    private static void consultarItinerario() {
        System.out.println("Escolha o ID da Viagem:");
        for (int i = 0; i < viagensCount; i++) {
            System.out.println("ID: " + viagens[i].getIdViagem() + " - " + viagens[i].getDestino());
        }
        int idViagem = scanner.nextInt();
        scanner.nextLine();

        Viagem viagem = null;
        for (int i = 0; i < viagensCount; i++) {
            if (viagens[i].getIdViagem() == idViagem) {
                viagem = viagens[i];
                break;
            }
        }

        if (viagem == null) {
            System.out.println("Viagem não encontrada!");
            return;
        }

        System.out.println("\nItinerário de " + viagem.getDestino() + ":");


        boolean encontrouAtividade = false;
        for (int i = 0; i < atividadesCount; i++) {
            if (atividades[i].getViagem().equals(viagem)) {
                System.out.println(atividades[i]);
                encontrouAtividade = true;
            }
        }
        if (!encontrouAtividade) {
            System.out.println("Nenhuma atividade encontrada para essa viagem.");
        }


        boolean encontrouAcomodacao = false;
        for (int i = 0; i < acomodacoesCount; i++) {
            if (acomodacoes[i].getViagem().equals(viagem)) {
                System.out.println(acomodacoes[i]);
                encontrouAcomodacao = true;
            }
        }
        if (!encontrouAcomodacao) {
            System.out.println("Nenhuma acomodação encontrada para essa viagem.");
        }
    }


    private static void calcularOrcamentoTotal() {
        System.out.println("Escolha o ID da Viagem:");
        for (int i = 0; i < viagensCount; i++) {
            System.out.println("ID: " + viagens[i].getIdViagem() + " - " + viagens[i].getDestino());
        }
        int idViagem = scanner.nextInt();
        scanner.nextLine();

        Viagem viagem = null;
        for (int i = 0; i < viagensCount; i++) {
            if (viagens[i].getIdViagem() == idViagem) {
                viagem = viagens[i];
                break;
            }
        }

        if (viagem == null) {
            System.out.println("Viagem não encontrada!");
            return;
        }

        double totalAtividades = 0;
        double totalAcomodacoes = 0;


        for (int i = 0; i < atividadesCount; i++) {
            if (atividades[i].getViagem().equals(viagem)) {
                totalAtividades += atividades[i].calcularCustoTotal();
            }
        }


        for (int i = 0; i < acomodacoesCount; i++) {
            if (acomodacoes[i].getViagem().equals(viagem)) {
                totalAcomodacoes += acomodacoes[i].calcularCustoTotal();
            }
        }

        double totalGasto = totalAtividades + totalAcomodacoes;

        System.out.println("Orçamento da Viagem: ");
        System.out.println("  Destino: " + viagem.getDestino());
        System.out.println("  Total em Atividades: R$ " + String.format("%.2f", totalAtividades));
        System.out.println("  Total em Acomodações: R$ " + String.format("%.2f", totalAcomodacoes));
        System.out.println("  Total Gasto: R$ " + String.format("%.2f", totalGasto));
    }


    private static void consultarViagensPorUsuario() {
        System.out.println("Escolha o ID do Usuário:");
        for (int i = 0; i < usuariosCount; i++) {
            System.out.println("ID: " + usuarios[i].getId() + " - " + usuarios[i].getNome());
        }
        int idUsuario = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario = null;
        for (int i = 0; i < usuariosCount; i++) {
            if (usuarios[i].getId() == idUsuario) {
                usuario = usuarios[i];
                break;
            }
        }

        if (usuario == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }

        System.out.println("\nViagens de " + usuario.getNome() + ":");
        boolean encontrouViagem = false;
        for (int i = 0; i < viagensCount; i++) {
            if (viagens[i].getUsuario().equals(usuario)) {
                System.out.println(viagens[i]);
                encontrouViagem = true;
            }
        }
        if (!encontrouViagem) {
            System.out.println("Nenhuma viagem encontrada para esse usuário.");
        }
    }


    private static void consultarUsuarios() {
        if (usuariosCount == 0) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        System.out.println("\nUsuários cadastrados:");
        for (int i = 0; i < usuariosCount; i++) {
            System.out.println("ID: " + usuarios[i].getId() + " - Nome: " + usuarios[i].getNome() + " - E-mail: " + usuarios[i].getEmail());
        }
    }
}
