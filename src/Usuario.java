public class Usuario {

    private int id;
    private String nome;
    private String email;
    private static String emailRegistrado;

    public Usuario(int id, String nome, String email) {
        if (emailRegistrado != null && emailRegistrado.equals(email)) {
            System.out.println("Erro: E-mail já cadastrado.");
        } else {
            this.id = id;
            this.nome = nome;
            this.email = email;
            emailRegistrado = email;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuário:\n" +
                "  ID: " + id + "\n" +
                "  Nome: " + nome + "\n" +
                "  Email: " + email;
    }
}
