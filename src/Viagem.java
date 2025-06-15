public class Viagem {

    private int idViagem;
    private String destino;
    private String dataInicio;
    private String dataFim;
    private Usuario usuario;

    public Viagem(int idViagem, String destino, String dataInicio, String dataFim, Usuario usuario) {
        this.idViagem = idViagem;
        this.destino = destino;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.usuario = usuario;
    }

    public int getIdViagem() {
        return idViagem;
    }

    public void setIdViagem(int idViagem) {
        this.idViagem = idViagem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int calcularDuracao() {
        String[] partesInicio = dataInicio.split("-");
        String[] partesFim = dataFim.split("-");

        int diaInicio = Integer.parseInt(partesInicio[2]);
        int mesInicio = Integer.parseInt(partesInicio[1]);
        int anoInicio = Integer.parseInt(partesInicio[0]);

        int diaFim = Integer.parseInt(partesFim[2]);
        int mesFim = Integer.parseInt(partesFim[1]);
        int anoFim = Integer.parseInt(partesFim[0]);

        // Cálculo aproximado da quantidade total de dias
        int totalDiasInicio = diaInicio + (mesInicio * 30) + (anoInicio * 365);
        int totalDiasFim = diaFim + (mesFim * 30) + (anoFim * 365);

        return totalDiasFim - totalDiasInicio + 1; // +1 para incluir o dia final
    }

    @Override
    public String toString() {
        return  "  ID da Viagem: " + idViagem + "\n" +
                "  Destino: " + destino + "\n" +
                "  Data de Início: " + dataInicio + "\n" +
                "  Data de Fim: " + dataFim + "\n" +
                "  Duração: " + calcularDuracao() + " dias\n" +
                " \n " + usuario;
    }
}
