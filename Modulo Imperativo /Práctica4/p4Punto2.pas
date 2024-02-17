{2. Una biblioteca nos ha encargado procesar la información de los préstamos realizados
durante el año 2021. De cada préstamo se conoce el ISBN del libro, el número de socio, día
y mes del préstamo y cantidad de días prestados. Implementar un programa con:
a. Un módulo que lea préstamos y retorne 2 estructuras de datos con la información de
los préstamos. La lectura de los préstamos finaliza con ISBN -1. Las estructuras deben
ser eficientes para buscar por ISBN}

program puntoDos;
type
  srDia = 1..31;
  srMes = 1..12;
  fechas = record
    dia:srDia;
    mes:srMes;
  end;
  prestamo = record
    isbn:integer;
    numSocio:integer;
    fech:fechas;
    cantDias:integer;
  end;
  arbolUno = ^nodoUno;
  nodoUno = record
    dato:prestamo;
    hI:arbolUno;
    hD:arbolUno;
  end;
  prestamoDos = record
    numSocio:integer;
    fech:fechas;
    cantDias:integer;
  end;
  listaPrestamos = ^nodoPrestamo;
  nodoPrestamo = record
    dato:prestamoDos;
    sig:listaPrestamos;
  end;
  prestamoISBN = record
    isbn:integer;
    lisP:listaPrestamos;
  end;
  arbolDos = ^nodoDos;
  nodoDos = record
    dato:prestamoISBN;
    hI:arbolDos;
    hD:arbolDos;
  end;

{procedimiento para leer un nuevo prestamo}  
procedure leerPrestamo(var p:prestamo);
begin
  read(p.isbn);
  if (p.isbn<>-1) then begin
    read(p.numSocio);
    read(p.fech.dia);
    read(p.fech.mes);
    read(p.cantDias);
  end;
end;

{i. En una estructura cada préstamo debe estar en un nodo.}
{procedimiento que agrega un nuevo nodo al arbol}
procedure agregar(var a:arbolUno;p:prestamo); 
var
  nuevo:arbolUno;
begin
  if (a=nil) then begin
    new(nuevo);
    nuevo^.dato:=p;
    nuevo^.hI:=nil;
    nuevo^.hD:=nil;
    a:=nuevo;
  end
  else if (nuevo^.dato.isbn<=a^.dato.isbn) then
    agregar(a^.hI,p)
  else
    agregar(a^.hD,p);
end;

{procedimiento que llama a un modulo que lee un prestamo y luego carga el prestamo en el arbol}
procedure cargarArbolUno (var a:arbolUno);
var
  aux:prestamo;
begin
  leerPrestamo(aux);
  if (aux.isbn<>-1) then begin
    agregar(a,aux);
    cargarArbolUno(a);
  end;
end;

{ii. En otra estructura, cada nodo debe contener todos los préstamos realizados al ISBN.
(prestar atención sobre los datos que se almacenan).}
{procedimiento para crear el prestamo sin ISBN (el dato del puntero de lista)}
procedure crearDatoDeLista(p:prestamo;var datoP:prestamoDos);
begin
  datoP.numSocio:= p.numSocio;
  datoP.fech:= p.fech;
  datoP.cantDias:= p.cantDias;
end;

{procedimiento que agrega un nuevo puntero a la lista de prestamos para un mismo ISBN}
procedure nuevoPunteroEnLista(var l:listaPrestamos ;p:prestamoDos);
var
  aux:listaPrestamos;
begin
  new(aux);
  aux^.dato:=p;
  aux^.sig:=nil;
  if (l=nil)then
    l:=aux
  else begin
    aux^.sig:=l;
    l:=aux;
  end;
end;

{el modulo agrega un nuevo nodo si el ISBN no se cargo previamente, sino, llama un modulo
* para agregar un nuevo puntero a la lista de prestamos para el isbn y sino busca la posicion}
procedure agregarArbolDos(var a:arbolDos; p:prestamoDos; isbn:integer);
var
  nuevo:arbolDos;
begin
  if (a=nil) then begin
    new(nuevo);
    nuevo^.dato.isbn:=isbn;
    nuevo^.dato.lisP:=nil;
    nuevoPunteroEnLista(nuevo^.dato.lisP,p);
    nuevo^.hI:=nil;
    nuevo^.hD:=nil;
    a:=nuevo;
  end
  else if (a^.dato.isbn=isbn)then
    nuevoPunteroEnLista(a^.dato.lisP,p)
  else if (isbn<a^.dato.isbn)then
    agregarArbolDos(a^.hI,p,isbn)
  else
    agregarArbolDos(a^.hD,p,isbn);
end;

{procedimiento que llama a un modulo que lee un prestamo y luego carga el prestamo en el arbol
* teniendo en cuenta si el ISBN ya existe en el arbol}
procedure cargarArbolDos(var a:arbolDos);
var
  aux:prestamo;
  datoP:prestamoDos;
begin
  leerPrestamo(aux); {mismo modulo que uso en arbol uno}
  if (aux.isbn<>-1) then begin
    crearDatoDeLista(aux,datoP);
    agregarArbolDos(a,datoP,aux.isbn);
    cargarArbolDos(a);
  end;
end;

{b. Un módulo recursivo que reciba la estructura generada en i. y retorne el ISBN más
grande.}
function mayorISBN(a:arbolUno):integer;
begin
  if (a^.hD=nil) then
    mayorISBN:=a^.dato.isbn
  else
    mayorISBN(a^.hD);    
end;
{c. Un módulo recursivo que reciba la estructura generada en ii. y retorne el ISBN más
pequeño.}
function menorISBN(a:arbolDos):integer;
begin
  if (a^.hI=nil) then
    menorISBN:=a^.dato.isbn
  else
    menorISBN(a^.hI);    
end;

{d. Un módulo recursivo que reciba la estructura generada en i. y un número de socio. El
módulo debe retornar la cantidad de préstamos realizados a dicho socio.}


{e. Un módulo recursivo que reciba la estructura generada en ii. y un número de socio. El
módulo debe retornar la cantidad de préstamos realizados a dicho socio.}

{f. Un módulo que reciba la estructura generada en i. y retorne una nueva estructura
ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
que se prestó.}

{g. Un módulo que reciba la estructura generada en ii. y retorne una nueva estructura
ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
que se prestó.}

{h. Un módulo recursivo que reciba la estructura generada en h. y muestre su contenido.}

{i. Un módulo recursivo que reciba la estructura generada en i. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos).}

{j. Un módulo recursivo que reciba la estructura generada en ii. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos).}


var
  aUno:arbolUno;
  aDos:arbolDos;
begin
  aUno:=nil;
  aDos:=nil; 
  cargarArbolUno(aUno);
  cargarArbolDos(aDos);
  writeln('Mayor ISBN',mayorISBN(aUno));
  writeln('Menor ISBN',menorISBN(aDos));  
end.
