public class Main {
    public static void main(String[] args) {

        Usuario usuario = new Usuario(1, "João Silva", "joao.silva@email.com");
        Viagem viagem = new Viagem(101, "Paris", "2025-06-10", "2025-06-20", usuario);
        Atividade atividade = new Atividade(101, "Estacionamento", 100.0, viagem);

        System.out.println("=========== DADOS DO USUÁRIO ===========");
        System.out.println(usuario);
        System.out.println("\n=========== DADOS DA VIAGEM ===========");
        System.out.println("Viagem: \n" + viagem);
        System.out.println("\n=========== DADOS DA ATIVIDADE ===========");
        System.out.println("Atividade: \n" + atividade);
    }
}
