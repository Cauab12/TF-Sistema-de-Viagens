public class Atividade {

    private int idAtividade;
    private String descricao;
    private double custoEstimado;
    private Viagem viagem;

    public Atividade(int idAtividade, String descricao, double custoEstimado, Viagem viagem) {
        this.idAtividade = idAtividade;
        this.descricao = descricao;
        this.custoEstimado = custoEstimado;
        this.viagem = viagem;
    }

    public int getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(int idAtividade) {
        this.idAtividade = idAtividade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getCustoEstimado() {
        return custoEstimado;
    }

    public void setCustoEstimado(double custoEstimado) {
        this.custoEstimado = custoEstimado;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public double calcularCustoTotal() {
        return custoEstimado;
    }

    @Override
    public String toString() {
        return  "Atividades: " + "\n" +
                "  ID da Atividade: " + idAtividade + "\n" +
                "  Descrição: " + descricao + "\n" +
                "  Custo Estimado: R$ " + String.format("%.2f", custoEstimado) + "\n" +
                "\n Viagem: \n" + viagem.toString();
    }
}

