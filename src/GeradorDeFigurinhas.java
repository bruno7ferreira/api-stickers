import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class GeradorDeFigurinhas {

    // métodos
    public void cria() throws Exception {

        // fazer leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme.jpg"));

        // cria nova imagem em memoria com transparencia e tamanho novo
        int imagemLargura = imagemOriginal.getWidth();
        int imagemAltura = imagemOriginal.getHeight();
        int novaImagemAltura = imagemAltura + 200;
        BufferedImage novaImagem = new BufferedImage(imagemLargura, novaImagemAltura, BufferedImage.TRANSLUCENT);

        // cópiar a imagem original para nova imagem (em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal,null,0,0);

        // configurar a fonte
        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 100);
        graphics.setFont(fonte);

        //escrever uma frase na nova imagem
        graphics.setColor(Color.YELLOW);
        graphics.drawString("TOPZERA",370,novaImagemAltura-80);

        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));


    }

    public static void main(String[] args) throws Exception {

        GeradorDeFigurinhas geradorDeFigurinhas = new GeradorDeFigurinhas();
        geradorDeFigurinhas.cria();

        System.out.println("Arquivo gerado com sucesso!");

    }

}
