package UFJF;


public class anuncios {
    private String images[] = { "images/mc.jpeg",
      "images/coca.jpg", "images/rapha.png" };
      
   private String links[] = {
      "https://www.mcdonalds.com.br/",
      "https://www.cocacola.com.br/pt/home/",
      "https://www.browniedorapha.com.br/" };
         
   private int selectedIndex = 0;

   // retorna o nome do arquivo de imagem ao anúncio atual
   public String getImage()
   {
      return images[ selectedIndex ];
   } // fim do método getImage 

   // retorna o URL ao site Web correspondente ao anúncio
   public String getLink()
   {
      return links[ selectedIndex ];
   } // fim do método getLink 

   // atualiza selectedIndex assim as próximas chamadas para getImage e
   // getLink retornam um anúncio diferente
   public void nextAd()
   {
      selectedIndex = ( selectedIndex + 1 ) % images.length;
   } // fim do método nextAd   
}
