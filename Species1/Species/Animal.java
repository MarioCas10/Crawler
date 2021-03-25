package Species;    //En este apartado creo una carpeta con el nombre Species el cual me archivara todas las clases a excepcion del Main.

public class Animal extends LivingBeing implements Define{      //Clase animal, el cual envuelve a todas las clases que estan por debajo de esta.

    //Atributos
    Animal mario;
    String name;
    int legs; 
    static int contador = 0; 
    static int contador2 = 0; 
    String text = "[";
    boolean S;          //Atributo bulenao
    boolean P;          //Atributo buleano

    //Constructor
    public Animal(String n) throws Exception{                                       //Creo un constructor publico Animael el cual me lanza una excepcion.    
        if(n == null || n ==""){                                                    //En donde si la variable n es igual a vacio, que me diga que el animal necesita un nombre.                  
            throw new Exception("The Animal needs a Name.");
        }else{                                                                      //Sino simplemente que me imprima el numero de cirscuntanceas creadas con el nombre del animal.
            name = n;
            contador++;                                                                  
            System.out.println("Number of Animal instances created: "+contador);
        }
    }

    //Metodos
    public void define(){
        System.out.println("- As a ANIMAL, I'm a multicellular organism. ");       //Este metodo proviene de la clase define, tal como su nombre lo indica.
    }                                                                              //El cual imprime en todos los animales de las diferentes clases.
    
    public void legs(){
        System.out.println("As an ANIMAL, I don't know how many legs I have.");    //En la instancea Numero: 6 se crea este metodo de legs, el cual no sabe cuantas patas pueda tener el animal.
    }                                                                              //Ya que todos los animales en no poseen 4 patas.

    public void beBorn(){                
        S = true;                  //El metodo me devuleve la variable S de tipo boleean ya anteriormente creada, que sea de tipo verdadera.
    }
    
    public void setLegs(int legs) throws Exception{      //El metodo setLegs, funciona para asignar un valor inicial a un atributo, además el Setter nunca retorna nada ya que es tipo void
        if(legs < 0){                                    //En este caso estoy asignando un valor inicial el cual es tipo legs.
            throw new Exception("Error, legs can't be negative.");      //En este apartado dentro de legs, controlo los errores en donde luego lo llamo en las demas clases, el cual si algun animal tiene patas negativas, de resultado Error.
        }else{
            this.legs = legs;                                           //En dado caso que no se detecte algun error, el programa imprimira de manera correcta.
        }                     
    }
    
    public int getLegs(){               //El metodo getLegs, funciona para devolver el metodo asignado por el atributo anterior. 
        return legs;
    }
    
    public boolean pair(Animal x) throws Exception{                   //Este metodo, como se nota, funciona para emparejarme los animales, el cual funciona de manera booleana.
        System.out.println("I'm not sure ...");      //El cual si no logra emparejar las mismas especies, da el mensaje que se puede ver a la izquierda.
        return false;
    }

    public String toString(){                                               //El metodo toString se utiliza para convertir a String cualquier objeto Java, es decir, a una cadena de texto.
        return text += "Name="+name+ "]"+"[Legs="+legs+"]"+ " ANIMAL";      //Aqui me imprime de manera de cadena de texto el cual toma desde la clase animal hasta las clases que tenga por debajo y va añadiendo los textos cuaando llame al metodo. 
    }

}


