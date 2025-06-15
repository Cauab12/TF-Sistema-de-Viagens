public class Acomodacao {

    private int idAcomodacao;
    private String nome;
    private double custoDiario;
    private int diasReservados;
    private Viagem viagem;

    public Acomodacao(int idAcomodacao, String nome, double custoDiario, int diasReservados, Viagem viagem) {
        this.idAcomodacao = idAcomodacao;
        this.nome = nome;
        this.custoDiario = custoDiario;
        this.diasReservados = diasReservados;
        this.viagem = viagem;
    }

    public int getIdAcomodacao() {
        return idAcomodacao;
    }

    public void setIdAcomodacao(int idAcomodacao) {
        this.idAcomodacao = idAcomodacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCustoDiario() {
        return custoDiario;
    }

    public void setCustoDiario(double custoDiario) {
        this.custoDiario = custoDiario;
    }

    public int getDiasReservados() {
        return diasReservados;
    }

    public void setDiasReservados(int diasReservados) {
        this.diasReservados = diasReservados;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public double calcularCustoTotal() {
        return custoDiario * diasReservados;
    }

    @Override
    public String toString() {
        return  "  ID da Acomodacao: " + idAcomodacao + "\n" +
                "  Nome: " + nome + "\n" +
                "  Custo Diario: " + custoDiario + "\n" +
                "  Dias Reservados: " + diasReservados + "\n" +
                " \n Viagem: \n" + viagem;
    }
}
