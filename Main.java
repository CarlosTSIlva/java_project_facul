import java.util.ArrayList;
import java.util.List;

abstract class Mensagem {
    private String conteudo;
    private String horaDoEnvio;
    private Contato destinatario;

    public Mensagem(String conteudo, String horaDoEnvio, Contato destinatario) {
        this.conteudo = conteudo;
        this.horaDoEnvio = horaDoEnvio;
        this.destinatario = destinatario;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String gethoraDoEnvio() {
        return horaDoEnvio;
    }

    public Contato getDestinatario() {
        return destinatario;
    }
}

class MensagemTexto extends Mensagem {
    public MensagemTexto(String conteudo, String horaDoEnvio, Contato destinatario) {
        super(conteudo, horaDoEnvio, destinatario);
    }
   
}



class Contato {
    private String nome;
    private String numero;

    public Contato(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }
}

class Whatsapp {
    private List<Contato> contatos;
    private List<Mensagem> mensagens;

    public Whatsapp() {
        contatos = new ArrayList<>();
        mensagens = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public void enviarMensagem(Mensagem mensagem) {
        mensagens.add(mensagem);
    }

    public void listarContatos() {
        for (Contato contato : contatos) {
            System.out.println("Nome: " + contato.getNome());
            System.out.println("Número: " + contato.getNumero());
        }
    }



    public void listarMensagens() {
        for (Mensagem mensagem : mensagens) {
            System.out.println("Conteúdo: " + mensagem.getConteudo());
            System.out.println("Hora do envio: " + mensagem.gethoraDoEnvio());
            System.out.println("Destinatário: " + mensagem.getDestinatario().getNome());
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Whatsapp whatsapp = new Whatsapp();

        Contato contato1 = new Contato("João", "123456789");
        Contato contato2 = new Contato("Maria", "987654321");

        whatsapp.adicionarContato(contato1);
        whatsapp.adicionarContato(contato2);

        Mensagem mensagem1 = new MensagemTexto("Oi, tudo bem?", "12:00", contato1);
        Mensagem mensagem2 = new MensagemTexto("Tudo ótimo, e você?", "12:01", contato2);

        whatsapp.enviarMensagem(mensagem1);
        whatsapp.enviarMensagem(mensagem2);
    }
}
