public class JogoCombate {

    import java.util.Scanner;

    class Campeao {
        private String nome;
        private int ataque;
        private int armadura;
        private int vida;

        public Campeao(String nome, int ataque, int armadura, int vida) {
            this.nome = nome;
            this.ataque = ataque;
            this.armadura = armadura;
            this.vida = vida;
        }

        public void takeDamage(Campeao oponente) {
            int danoRecebido = oponente.ataque - this.armadura;
            if (danoRecebido < 1) {
                danoRecebido = 1; // Garante que pelo menos 1 de dano é recebido
            }
            this.vida = Math.max(this.vida - danoRecebido, 0); // Vida não pode ser menor que zero
        }

        public String status() {
            if (vida == 0) {
                return nome + " morreu";
            }
            return nome + " - Vida: " + vida;
        }

        public boolean estaVivo() {
            return vida > 0;
        }
    }

    public class JogoCombate {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Informações do primeiro campeão
            System.out.print("Digite o nome do primeiro campeão: ");
            String nome1 = scanner.nextLine();
            System.out.print("Digite o ataque do primeiro campeão: ");
            int ataque1 = scanner.nextInt();
            System.out.print("Digite a armadura do primeiro campeão: ");
            int armadura1 = scanner.nextInt();
            System.out.print("Digite a vida inicial do primeiro campeão: ");
            int vida1 = scanner.nextInt();

            // Informações do segundo campeão
            scanner.nextLine(); // Limpa o buffer do scanner
            System.out.print("Digite o nome do segundo campeão: ");
            String nome2 = scanner.nextLine();
            System.out.print("Digite o ataque do segundo campeão: ");
            int ataque2 = scanner.nextInt();
            System.out.print("Digite a armadura do segundo campeão: ");
            int armadura2 = scanner.nextInt();
            System.out.print("Digite a vida inicial do segundo campeão: ");
            int vida2 = scanner.nextInt();

            // Instanciação dos campeões
            Campeao campeao1 = new Campeao(nome1, ataque1, armadura1, vida1);
            Campeao campeao2 = new Campeao(nome2, ataque2, armadura2, vida2);

            // Definir quantidade de turnos
            System.out.print("Digite a quantidade de turnos para o combate: ");
            int turnos = scanner.nextInt();

            // Executar o combate
            for (int i = 1; i <= turnos; i++) {
                System.out.println("Turno " + i + ":");

                // Campeões se atacam mutuamente
                campeao1.takeDamage(campeao2);
                campeao2.takeDamage(campeao1);

                // Exibe o status de cada campeão após o turno
                System.out.println(campeao1.status());
                System.out.println(campeao2.status());

                // Verifica se algum campeão morreu e termina o combate
                if (!campeao1.estaVivo() || !campeao2.estaVivo()) {
                    break;
                }
            }

            System.out.println("FIM DO COMBATE");
            scanner.close();
        }
    }

}
