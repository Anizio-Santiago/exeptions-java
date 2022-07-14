    package application;

    import model.entities.Reserva;
    import model.exceptions.DomainException;

    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.Scanner;


    public class Program {
        public static void main(String[] args ) {
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            try {
                    System.out.print("informe um numero do quarto: ");
                    int numeroQuarto = sc.nextInt();
                    System.out.print("informe a data de entrada (dd/MM/yyyy) ");
                    Date dataEntrada = sdf.parse(sc.next());
                    System.out.print("informe a data de saida (dd/MM/yyyy) ");
                    Date dataSaida = sdf.parse(sc.next());

                    Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);

                    System.out.println("Reserva : " + reserva);
                    System.out.println();
                    System.out.println("Atualize os dados da reserva: ");
                    System.out.print("informe um numero do quarto: ");
                    numeroQuarto = sc.nextInt();
                    System.out.print("informe a data de entrada (dd/MM/yyyy) ");
                    dataEntrada = sdf.parse(sc.next());
                    System.out.print("informe a data de saida (dd/MM/yyyy) ");
                    dataSaida = sdf.parse(sc.next());

                    reserva.atualizaDatas(dataEntrada, dataSaida);
                    System.out.println("Reserva atualizada : " + reserva);
            }
            catch(ParseException e){
                System.out.println("Formato da data esta invalido!!");
            }

            catch (DomainException e){
                System.out.println("Argurmento errado!!!" + e.getMessage());
            }
            catch (RuntimeException e){
                System.out.println("Erro inesperado!!!");
            }
            sc.close();
        }
    }
