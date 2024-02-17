{3.- Netflix ha publicado la lista de películas que estarán disponibles durante el mes de
diciembre de 2022. De cada película se conoce: código de película, código de género (1: acción,
2: aventura, 3: drama, 4: suspenso, 5: comedia, 6: bélico, 7: documental y 8: terror) y puntaje
promedio otorgado por las críticas.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:
a. Lea los datos de películas, los almacene por orden de llegada y agrupados por código de
género, y retorne en una estructura de datos adecuada. La lectura finaliza cuando se lee el
código de la película -1.}

program puntoTres;
const
  cantGeneros=8;
type
  subGen = 1..cantGeneros; {subrango de generos}
  pelicula = record {registro pelicula}
    codPeli: integer;
    codGen: subGen; {8 generos de peliculas}
    puntaje: integer;
  end;
  lista=^nodo;     {lista de peliculas}
  nodo = record
    pel:pelicula;
    sig:lista;
  end;
  vCod = array [subGen] of lista;  {vector de listas de peliculas (por genero)}
  vPunt = array [subGen] of pelicula;  {vector de mejores peliculas de cada genero}

{Voy a crear un vector de listas, guardando listas de películas por género}
{procedimiento para iniciar el vector de listas}
procedure iniciarLista(var v:vCod);
var 
  i:subGen;
begin
  for i:=1 to cantGeneros do
    new(v[i]);
end;

{procedimiento para leer cada pelicula}  
procedure leerPelicula (var p:pelicula);
begin
  writeln ('Ingresar codigo de pelicula, genero (1 a 8) y puntaje');
  read (p.codPeli);
  if (p.codPeli <> -1) then begin
    read (p.codGen);
    read (p.puntaje);
  end;
end;

{procedimiento para leer la lista de peliculas y ordenarlas segun su genero en un vector
* de listas, cada genero dentro del vector tiene su lista de peliculas}
procedure leerLista(var v:vCod);
var
  nuevaP:lista;
begin
  new(nuevaP);
  leerPelicula(nuevaP^.pel);
  nuevaP^.sig := nil;
  while (nuevaP^.pel.codPeli<>-1) do begin
    if (v[nuevaP^.pel.codGen] = nil) then
      v[nuevaP^.pel.codGen]:=nuevaP
    else begin
      nuevaP^.sig := v[nuevaP^.pel.codGen];
      v[nuevaP^.pel.codGen] := nuevaP;
    end;
    leerPelicula(nuevaP^.pel);
    nuevaP^.sig := nil;
  end;
end;  
  
{b. Genere y retorne en un vector, para cada género, el código de película con mayor puntaje
obtenido entre todas las críticas, a partir de la estructura generada en a)..}
{Voy a suponer que todos los géneros tienen al menos una película.}
{procedimiento para guardarme la película de mayor puntaje de cada genero}
procedure pelisMayorPuntaje(v:vCod; var vP:vPunt);
var
  pelAct:pelicula;
  i:subGen;
begin
  for i := 1 to cantGeneros do begin
      pelAct:= v[i]^.pel;
    while (v[i] <> nil) do begin
      if (pelAct.puntaje < v[i]^.pel.puntaje) then 
        pelAct:= v[i]^.pel;
      v[i]:=v[i]^.sig;
    end;
    vP[i] := pelAct;
  end;
end;

{c. Ordene los elementos del vector generado en b) por puntaje utilizando alguno de los dos
métodos vistos en la teoría.}
procedure ordenseleccion (var v:vPunt);
var
  i,j,pos:subGen;
  aux:pelicula;
begin
  for i := 1 to (cantGeneros-1) do begin
    pos:=i;
    for j := (i+1) to cantGeneros do
      if (v[pos].puntaje < v[j].puntaje) then {ordeno de mayor a menor}
        pos:=j;
    aux:= v[pos];
    v[pos]:=v[i];
    v[i]:=aux;
  end;
end;

{d. Muestre el código de película con mayor puntaje y el código de película con menor puntaje,
del vector obtenido en el punto c).}
procedure mostrarPelis (v:vPunt);
begin
  writeln ('Pelicula con mayor puntaje', v[1].codPeli);
  writeln ('Pelicula con menor puntaje', v[8].codPeli);
end;

{TESTEO DE DATOS: IMPRIMIR VECTOR DE LISTAS}
procedure testeo_uno(v:vCod);
var
  i:subGen;
begin
  for i := 1 to cantGeneros do
    while (v[i]<>nil) do begin
      writeln(v[i]^.pel.codPeli);
      writeln(v[i]^.pel.codGen);
      writeln(v[i]^.pel.puntaje); 
      v[i]:=v[i]^.sig;
    end;
end;   
{-------------}

var
  v:vCod;
  vP:vPunt;
begin
  iniciarLista (v);
  leerLista (v);
  {TESTEO DE DATOS: IMPRIMIR VECTOR DE LISTAS}
  testeo_uno(v);
  {-------------}
  pelisMayorPuntaje (v,vP);
  ordenseleccion (vP);
  mostrarPelis (vP);
end.
