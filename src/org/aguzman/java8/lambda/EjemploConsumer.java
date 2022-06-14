package org.aguzman.java8.lambda;

import org.aguzman.java8.lambda.modelo.Usuario;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EjemploConsumer {
    public static void main(String[] args) {
        Consumer<Date>consumidor=fecha->{
            SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(f.format(fecha));
        };

        consumidor.accept(new Date());

        BiConsumer<String,Integer>consumidorBi=(nombre,edad)-> System.out.println(nombre+", tiene "+ edad  +" años!"  );

        consumidorBi.accept("pepe",20);

        Consumer<String>consumidor2= System.out::println;
        consumidor2.accept("Hola mundo lamda");

        List<String>nombres= Arrays.asList("andres","pepe","luz","paco");
        nombres.forEach(consumidor2);
        Usuario usuario=new Usuario();

        BiConsumer<Usuario,String> asignarNombre= Usuario::setNombre;
        asignarNombre.accept(usuario,"Andres");

        System.out.println("Nombre usuario: "+usuario.getNombre());

        Supplier<String> proveedor=()->"Hola mundo lamda suplier";

        System.out.println(proveedor.get());


    }
}
