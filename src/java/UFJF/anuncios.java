/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UFJF;

/**
 *
 * @author pedro
 */
public class anuncios {
    private String images[] = { "images/f1.jpg",
      "images/met.jpg", "images/csgo.png" };
      
   private String links[] = {
      "http://www.formula1.com",
      "http://www.metallica.com",
      "http://www.counter-strike.net" };
         
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
