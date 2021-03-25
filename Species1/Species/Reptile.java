package Species;                           //En este apartado creo una carpeta con el nombre Species el cual me archivara todas las clases a excepcion del Main.
public class Reptile extends Animal{       //El extends lo utlizo en cada clase de forma que todos esten entrelazados, desde los de abajo hasta el main.
 
    //Constructor
    public Reptile(String nombre) throws Exception{     //Creo un constructor el cual me lanze una excepcion de tipo publica.
        super(nombre);                                  //En donde aclaro la variable String name como super. 
    }

    //Metodos
    public void define(){                                                                       //En este apartado añado el metodo publico define.
        super.define();                                                                         //En donde se guarda en el super.define 
        System.out.println("- As a REPTILE, I'm a vertebrate with four-limbed ancestors.");     //Luego que se imprima el mesaje cuando la instancea este creada.
    }
    
    public void layAnEgg(){                         //Creo un metodo void el cual me devuelve un comentario, solo para los reptiles, el cual es si ah dejado un huevo.
        if (S == true){                             // En donde si es verdad que el Animal ha dejado el huevo.
        System.out.println(text+" -> lay an egg");  //Me imprima este mensaje.
        }
    }

    public String toString(){           //Luego de igual forma llamo el toString.
        super.toString();               //Donde se archiva en el super.
        return text += ".REPTILE";      //Y se guarda en la cadena de texto. 
    }
    
}

