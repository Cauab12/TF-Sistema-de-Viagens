public class Orcamento {
    private Viagem viagem;
    private double totalGasto;

    public Orcamento(Viagem viagem) {
        this.viagem = viagem;
        this.totalGasto = 0;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public double getTotalGasto() {
        return totalGasto;
    }

    public void calcularTotal(Atividade[] atividades, Acomodacao[] acomodacoes) {
        double total = 0;
        for (Atividade a : atividades) {
            if (a.getViagem().equals(viagem)) {
                total += a.calcularCustoTotal();
            }
        }

        for (Acomodacao a : acomodacoes) {
            if (a.getViagem().equals(viagem)) {
                total += a.calcularCustoTotal();
            }
        }
        this.totalGasto = total;
    }

    @Override
    public String toString() {
        return "Orçamento da Viagem: \n" +
                viagem.toString() +
                "\nTotal Gasto: R$ " + String.format("%.2f", totalGasto) + "\n";
    }
}