import java.util.ArrayList;
import java.util.List;

abstract class Mensagem {
    private String conteudo;

    public Mensagem(String conteudo, String remetente, String destinatario) {
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }
}

class MensagemTexto extends Mensagem {
    public MensagemTexto(String conteudo, String remetente, String destinatario) {
        super(conteudo, remetente, destinatario);
    }
}

class Whatsapp {
    private List<Mensagem> mensagens;

    public Whatsapp() {
        mensagens = new ArrayList<>();
    }

    public void enviarMensagem(Mensagem mensagem) {
        mensagens.add(mensagem);
    }

}

public class Main {
    public static void main(String[] args) {
        Whatsapp whatsapp = new Whatsapp();

        Mensagem mensagem1 = new MensagemTexto("Oi, tudo bem?", "João", "Maria");
        Mensagem mensagem2 = new MensagemTexto("Tudo joia, obrigado por perguntar!", "Maria", "João");

        whatsapp.enviarMensagem(mensagem1);
        whatsapp.enviarMensagem(mensagem2);
        System.out.println("Mensagem 1: " + mensagem1.getConteudo());
        System.out.println("Mensagem 2: " + mensagem2.getConteudo());
    }
}
