{ESTA TERMINADO}
{1.- Implementar un programa que invoque a los siguientes módulos.
a. Un módulo recursivo que permita leer una secuencia de caracteres terminada en punto, los
almacene en un vector con dimensión física igual a 10 y retorne el vector.}

program punto_uno;
const
  dF=10;
type
  srVec = 0..dF;
  vecCarac = array [1..dF] of char;
  lista =^nodo;
  nodo = record
    car:char;
    sig:lista;
  end;

{procedimiento para leer una secuencia de caracteres de modo recursivo}
procedure leerSecCarac (var v:vecCarac; var dL:srVec);
var
  c:char;
begin
  if (dL<dF) then begin
    writeln('ingrese caracteres');
    readln(c);
    if (dL<dF) and (c<>'.') then begin
      dL:=dL+1;
      v[dL]:=c;
      leerSecCarac(v,dL);
    end;
  end; 
end;

{b. Un módulo que reciba el vector generado en a) e imprima el contenido del vector.}
procedure imprimirVector (v:vecCarac; dL:srVec);
var
  i:srVec;
begin
  for i:=1 to dL do
    writeln(v[i]);
end;

{c. Un módulo recursivo que reciba el vector generado en a) e imprima el contenido del vector}
procedure imprimirVecRecursivo (v:vecCarac; dL:srVec; aux:srVec);
begin
  if (dL<>0) then
    if (aux<=dL)then begin
      writeln(v[aux]);
      aux:=aux+1;
      imprimirVecRecursivo(v,dL,aux);
    end;
end;

{d. Un módulo recursivo que permita leer una secuencia de caracteres terminada en punto y
retorne la cantidad de caracteres leídos. El programa debe informar el valor retornado.}
procedure leeryContarCar (var cant:integer);
var
  car:char;
begin
  writeln('Ingrese un caracter');
  readln(car);
  if (car<>'.') then begin
   cant:=cant+1;
   leeryContarCar(cant);
  end
  else 
   writeln ('Cantidad de caracteres leidos: ',cant);
end;

{e. Un módulo recursivo que permita leer una secuencia de caracteres terminada en punto y
retorne una lista con los caracteres leídos.}
procedure leerListaRecursiva (var pI:lista);
var
  nuevo:lista;
  aux:char;
begin
  writeln('Ingrese un caracter');
  readln(aux);
  if (aux<>'.') then begin
    new(nuevo);
    nuevo^.car:=aux;
    nuevo^.sig:=nil;
    if (pI=nil) then begin
      pI:=nuevo;
    end
    else begin
      nuevo^.sig:=pI;
      pI:=nuevo;
    end;
    leerListaRecursiva(pI);
  end;
end;

{g. Implemente un módulo recursivo que reciba la lista generada en e) e imprima los valores de
la lista en orden inverso al que están almacenados.}
procedure impLista(pI:lista);
begin
  if (pI<>nil) then begin
    writeln(pI^.car);
    pI:=pI^.sig;
    impLista(pI);
  end;
end;

{f. Un módulo recursivo que reciba la lista generada en e) e imprima los valores de la lista en el
mismo orden que están almacenados.}
procedure listaEnOrden(pI:lista; var pInv:lista);
var 
  nuevo:lista;
begin
  if (pI<>nil) then begin
    new(nuevo);
    nuevo^.car:=pI^.car;
    nuevo^.sig:=nil;
    if (pInv=nil) then
      pInv:=nuevo
    else begin 
      nuevo^.sig:=pInv;
      pInv:=nuevo;
    end;
  pI:=pI^.sig;
  listaEnOrden(pI,pInv)
  end;
end;
  
{PROGRAMA PRINCIPAL}  
var
  v:vecCarac;
  dL,aux:srVec;
  cant:integer;
  pI,pInv:lista;
begin
  dL:=0;
  leerSecCarac(v,dL);
  writeln('Vector:');
  imprimirVector(v,dL);
  writeln('Vector recursivo:');
  aux:=1;
  imprimirVecRecursivo(v,dL,aux);
  cant:=0;
  leeryContarCar(cant);
  pI:=nil;
  leerListaRecursiva(pI);
  writeln('Lista Recursiva en orden:');
  pInv:=nil;
  listaEnOrden(pI,pInv);
  impLista(pInv);
  writeln('Lista Recursiva inversa:');
  impLista(pI);
end.

