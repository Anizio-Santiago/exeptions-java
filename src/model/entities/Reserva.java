    package model.entities;

    import model.exceptions.DomainException;

    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.concurrent.TimeUnit;

    public class Reserva {

        private Integer numeroQuarto;
        private Date dataChegada;
        private Date dataSaida;

        private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        public Reserva(Integer numeroQuarto, Date dataChegada, Date dataSaida) {
            if(!dataSaida.after(dataChegada)){
                throw new DomainException("A data de entrada não pode ser superior a data de saida!!");
            }
            this.numeroQuarto = numeroQuarto;
            this.dataChegada = dataChegada;
            this.dataSaida = dataSaida;
        }

        public Integer getNumeroQuarto() {
            return numeroQuarto;
        }

        public void setNumeroQuarto(Integer numeroQuarto) {
            this.numeroQuarto = numeroQuarto;
        }

        public Date getDataChegada() {
            return dataChegada;
        }

        public Date getDataSaida() {
            return dataSaida;
        }

        public long duracao(){
            long diff = dataSaida.getTime() - dataChegada.getTime();
            return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
        }

        public void atualizaDatas(Date dataChegada,Date dataSaida) {
            Date now = new Date();
            if(dataChegada.before(now) || dataSaida.before(now)){
                throw new DomainException ("As datas de entrada e saida devem ser datas futuras para serem atualizadas!!!");
            }
             if(!dataSaida.after(dataChegada)){
                throw new DomainException("A data de entrada não pode ser anterior a data de saida!!");
            }
            this.dataChegada = dataChegada;
            this.dataSaida = dataSaida;
        }

        @Override
        public String toString(){
            return "Quarto "
                    + numeroQuarto
                    + ", data de chegada : "
                    + sdf.format(dataChegada)
                    + ", data de saida : "
                    + sdf.format(dataSaida)
                    +  " , "
                    + duracao()
                    +  " noites ";
        }
    }
