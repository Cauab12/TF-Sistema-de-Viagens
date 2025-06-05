public class Main {

    public static void main(String[] args) {
        
        Usuario usuario = new Usuario(1, "João Silva", "joao.silva@email.com");

        System.out.println("Usuário: " + usuario);

        Viagem viagem = new Viagem(101, "Paris", "2025-06-10", "2025-06-20", usuario);

        System.out.println("Viagem: " + viagem);

        long duracao = viagem.calcularDuracao();
        System.out.println("Duração da Viagem: " + duracao + " dias");
    }
}
