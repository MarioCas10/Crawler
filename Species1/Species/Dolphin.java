package Species;                        //En este apartado creo una carpeta con el nombre Species el cual me archivara todas las clases a excepcion del Main.
public class Dolphin extends Mammal {   //El extends lo utlizo en cada clase de forma que todos esten entrelazados, desde los de abajo hasta el main.

    //Constructor 
    public Dolphin(String Dolphin) throws Exception{       //En este apartado creo un constrcutor el cual me lanza una excepcion.
        super(Dolphin);                                    //Luego declaro el String Dolphin como super y compruebo con try y un catch.
        try{
            setLegs(4);                                    //En donde si el animal no tiene patas (en el caso que el animal si tenga patas), de como resultado Error.

        }catch(Exception E){
            System.out.println(E.getMessage());            //De manera que funciona el setLegs o el getLegs, el getMessage tiene el mismo proposito el cual es presentar el mensaje.
        }                                                  //Se puede probar cambiando los numeros dentro del parentesis y cuando lo pruebe en el terminal se puede ver el erroe que sale.
    }                                                      //Este se controla desde Animal.

    //Metodos 
    public void define(){                                                       //En este aparatado creo un metodo de tipo void, en donde luego defino un contador nuevamente.
        contador2++;
        System.out.println("[Number of calls to define: "+contador2+"]");       //El cual solo me devuelve un mesanje de las clases creadas, en donde añado el contador y en el terminal da com resultado un numero.
        System.out.println("My name is "+name+".");                             //De igual forma imprimo un mensaje con el nombre del animal.
        super.define();                                                         //Luego llamo al super para seguir introduciendo el siguiente comentario en la cadena de la misma clase.
        System.out.println("- As DOLPHIN, I live in the water.");               //El cual se añade con la clase animal y luego Mamifero.
    }

    public String toString(){              //Como se menciono antes continuo con el metodo toString.
        super.toString();                  //El cual se guarda en el super.
        return text += ".DOLPHIN";         //Seguido por el mensaje que he añadido.
    }
}

