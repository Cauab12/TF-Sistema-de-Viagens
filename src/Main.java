import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Viagem> viagens = new ArrayList<>();
    private static List<Atividade> atividades = new ArrayList<>();
    private static List<Acomodacao> acomodacoes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // limps

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
        scanner.nextLine();  // limps
        System.out.print("Digite o nome do Usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o e-mail do Usuário: ");
        String email = scanner.nextLine();

        Usuario usuario = new Usuario(id, nome, email);
        if (usuario != null) {
            usuarios.add(usuario);
            System.out.println("Usuário cadastrado com sucesso!");
        } else {
            System.out.println("Erro: E-mail já cadastrado.");
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

        // Escolher o usuário
        System.out.println("Escolha o ID do Usuário:");
        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.getId() + " - " + usuario.getNome());
        }
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); // limps

        Usuario usuario = usuarios.stream()
                .filter(u -> u.getId() == idUsuario)
                .findFirst()
                .orElse(null);

        if (usuario == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }

        Viagem viagem = new Viagem(idViagem, destino, dataInicio, dataFim, usuario);
        viagens.add(viagem);
        System.out.println("Viagem cadastrada com sucesso!");
    }

    private static void adicionarAtividade() {
        System.out.print("Digite o ID da Atividade: ");
        int idAtividade = scanner.nextInt();
        scanner.nextLine();  // Consumir a linha após o número
        System.out.print("Digite a descrição da Atividade: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite o custo estimado da Atividade: ");
        double custoEstimado = scanner.nextDouble();
        scanner.nextLine(); // limps

        // Escolher a viagem
        System.out.println("Escolha o ID da Viagem:");
        for (Viagem viagem : viagens) {
            System.out.println("ID: " + viagem.getIdViagem() + " - " + viagem.getDestino());
        }
        int idViagem = scanner.nextInt();
        scanner.nextLine(); // limps

        Viagem viagem = viagens.stream()
                .filter(v -> v.getIdViagem() == idViagem)
                .findFirst()
                .orElse(null);

        if (viagem == null) {
            System.out.println("Viagem não encontrada!");
            return;
        }

        Atividade atividade = new Atividade(idAtividade, descricao, custoEstimado, viagem);
        atividades.add(atividade);
        System.out.println("Atividade adicionada com sucesso!");
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

        // Escolher a viagem
        System.out.println("Escolha o ID da Viagem:");
        for (Viagem viagem : viagens) {
            System.out.println("ID: " + viagem.getIdViagem() + " - " + viagem.getDestino());
        }
        int idViagem = scanner.nextInt();
        scanner.nextLine(); // limps

        Viagem viagem = viagens.stream()
                .filter(v -> v.getIdViagem() == idViagem)
                .findFirst()
                .orElse(null);

        if (viagem == null) {
            System.out.println("Viagem não encontrada!");
            return;
        }

        Acomodacao acomodacao = new Acomodacao(idAcomodacao, nome, custoDiario, diasReservados, viagem);
        acomodacoes.add(acomodacao);
        System.out.println("Acomodação adicionada com sucesso!");
    }

    private static void consultarItinerario() {
        System.out.println("Escolha o ID da Viagem:");
        for (Viagem viagem : viagens) {
            System.out.println("ID: " + viagem.getIdViagem() + " - " + viagem.getDestino());
        }
        int idViagem = scanner.nextInt();
        scanner.nextLine(); // limps

        Viagem viagem = viagens.stream()
                .filter(v -> v.getIdViagem() == idViagem)
                .findFirst()
                .orElse(null);

        if (viagem == null) {
            System.out.println("Viagem não encontrada!");
            return;
        }

        System.out.println("\nItinerário de " + viagem.getDestino() + ":");
        System.out.println("Atividades:");
        atividades.stream()
                .filter(a -> a.getViagem().equals(viagem))
                .forEach(a -> System.out.println(a));
        System.out.println("Acomodações:");
        acomodacoes.stream()
                .filter(a -> a.getViagem().equals(viagem))
                .forEach(a -> System.out.println(a));
    }

    private static void calcularOrcamentoTotal() {
        System.out.println("Escolha o ID da Viagem:");
        for (Viagem viagem : viagens) {
            System.out.println("ID: " + viagem.getIdViagem() + " - " + viagem.getDestino());
        }
        int idViagem = scanner.nextInt();
        scanner.nextLine(); // limps

        Viagem viagem = viagens.stream()
                .filter(v -> v.getIdViagem() == idViagem)
                .findFirst()
                .orElse(null);

        if (viagem == null) {
            System.out.println("Viagem não encontrada!");
            return;
        }

        Orcamento orcamento = new Orcamento(viagem);
        orcamento.calcularTotal(atividades.toArray(new Atividade[0]), acomodacoes.toArray(new Acomodacao[0]));
        System.out.println(orcamento);
    }

    private static void consultarViagensPorUsuario() {
        System.out.println("Escolha o ID do Usuário:");
        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.getId() + " - " + usuario.getNome());
        }
        int idUsuario = scanner.nextInt();
        scanner.nextLine();// limps

        Usuario usuario = usuarios.stream()
                .filter(u -> u.getId() == idUsuario)
                .findFirst()
                .orElse(null);

        if (usuario == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }

        System.out.println("\nViagens de " + usuario.getNome() + ":");
        viagens.stream()
                .filter(v -> v.getUsuario().equals(usuario))
                .forEach(v -> System.out.println(v));
    }

    private static void consultarUsuarios(){
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        System.out.println("\nUsuários cadastrados:");
        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.getId() + " - Nome: " + usuario.getNome() + " - E-mail: " + usuario.getEmail());
        }
    }
}
